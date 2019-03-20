import Company.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CompanyManagerTestScenario1 {

    private CompanyManager cm = null;

    @Before
    public void initialize () {
        this.cm = new CompanyManagerImplementation();
    }

    @After
    public void tearDown () { this.cm = null; }

    @Test
    public void addManagerTest(){
        cm.addManager("2292828X", "Carlo", 5000);
        Assert.assertEquals(1,cm.getSize());
    }

    @Test
    public void findByIdTest(){
        Manager expected = new Manager("2292828X", "Carlo", 5000);
        cm.addManager("2292828X", "Carlo", 5000);
        Manager found = (Manager) cm.findById("2292828X");
        Assert.assertEquals(expected.getId(),found.getId());
    }

    @Test
    public void instanceOfManagerTest(){
        cm.addManager("2292828X", "Carlo", 5000);
        Assert.assertTrue(cm.findById("2292828X") instanceof Manager);
    }

    @Test
    public void addVendorTest() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addEmployee("2933456C", "Juan", 2000, "2292828X", "vendor");
        Assert.assertTrue(cm.findById("2933456C") instanceof Vendor);
        Assert.assertEquals(2,cm.getSize());
    }

    @Test
    public void addOperatorTest() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addEmployee("3764357S", "Diego", 1200, "2292828X", "operator");
        Assert.assertTrue(cm.findById("3764357S") instanceof Operator);
        Assert.assertEquals(2,cm.getSize());
    }
}
