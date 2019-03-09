import Company.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class Scenario_1_Tests {

    CompanyManager cm = new CompanyManagerImplementation();

    @Test
    public void AddManagerTest(){
        cm.addManager("2292828X", "Carlo", 5000);
        Assert.assertEquals(1,cm.getSize());
    }

    @Test
    public void AddVendorTest() throws TypeNotFoundException, ManagerNotFoundException {
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addEmployee("2933456C", "Juan", 2000, "2292828X", "vendor");
        Assert.assertEquals(2,cm.getSize());
    }
    @Test
    public void AddOperatorTest() throws TypeNotFoundException, ManagerNotFoundException {
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addEmployee("3764357S", "Diego", 1200, "2292828X", "operator");
        Assert.assertEquals(2,cm.getSize());
    }
    @Test
    public void FindByIdTest(){
        Manager expected = new Manager("2292828X", "Carlo", 5000);
        cm.addManager("2292828X", "Carlo", 5000);
        Manager found = (Manager) cm.findById("2292828X");
        Assert.assertEquals(expected.getId(),found.getId());
    }
}
