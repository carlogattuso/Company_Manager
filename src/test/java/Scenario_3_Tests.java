import Company.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class Scenario_3_Tests {

    CompanyManagerImplementation cm = new CompanyManagerImplementation(5);

    @Before
    public void Initialize() throws TypeNotFoundException, ManagerNotFoundException, ListFullException, VendorNotFoundException{
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addManager("4795783F", "Mario", 5000);

        cm.addEmployee("2933456C", "Juan", 2000, "2292828X", "vendor");
        cm.addEmployee("4987436B", "Pedro", 2000, "2292828X", "vendor");

        cm.addEmployee("3764357S", "Diego", 1200, "2292828X", "operator");

        cm.addSell("4987436B", 200);
        cm.addSell("4987436B", 500);
        cm.addSell("4987436B", 700);
        cm.addSell("4987436B", 400);

        cm.addSell("2933456C", 1000);
        cm.addSell("2933456C", 100);
        cm.addSell("2933456C", 450);
        cm.addSell("2933456C", 320);
    }
    @Test(expected = ListFullException.class)
    public void ListFullExceptionTest() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
        cm.addEmployee("2988429F", "Francisco", 2000, "2292828X", "vendor");
    }
    @Test
    public void UpdateSalaryTest() {
        Manager m = (Manager) cm.findById("2292828X");
        Vendor v = (Vendor) cm.findById("4987436B");
        Vendor v2 = (Vendor) cm.findById("2933456C");
        Operator o = (Operator) cm.findById("3764357S");
        m.UpdateSalary(5000);
        v.UpdateSalary(2000);
        v2.UpdateSalary(2000);
        o.UpdateSalary(1200);
        Assert.assertEquals(Double.valueOf(5036.7), m.getSalary());
        Assert.assertEquals(Double.valueOf(2180), v.getSalary());
        Assert.assertEquals(Double.valueOf(2187), v2.getSalary());
        Assert.assertEquals(Double.valueOf(1200), o.getSalary());
    }
    @Test
    public void FindAllOrderByNameTest() {
        List<Employee> list;
        list = cm.findAllOrderByName();
        Assert.assertEquals("Carlo",list.get(0).getName());
        Assert.assertEquals("Diego",list.get(1).getName());
        Assert.assertEquals("Juan",list.get(2).getName());
        Assert.assertEquals("Mario",list.get(3).getName());
        Assert.assertEquals("Pedro",list.get(4).getName());
    }
    @Test
    public void FindAllOrderBySalaryTest() {
        List<Employee> list;
        list = cm.findAllOrderBySalary();
        Assert.assertEquals("Carlo",list.get(0).getName());
        Assert.assertEquals("Mario",list.get(1).getName());
        Assert.assertEquals("Pedro",list.get(2).getName());
        Assert.assertEquals("Juan",list.get(3).getName());
        Assert.assertEquals("Diego",list.get(4).getName());
    }
}
