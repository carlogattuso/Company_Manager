import Company.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class Scenario_2_Tests {

    CompanyManagerImplementation cm = new CompanyManagerImplementation();

    @Before
    public void Initialize() throws TypeNotFoundException, ManagerNotFoundException {
        cm.addManager("2292828X", "Carlo", 5000);
        cm.addManager("4795783F", "Mario", 5000);

        cm.addEmployee("2933456C", "Juan", 2000, "2292828X", "vendor");
        cm.addEmployee("4987436B", "Pedro", 2000, "2292828X", "vendor");
        cm.addEmployee("6472938R", "Jose", 2000, "4795783F", "vendor");
        cm.addEmployee("2738453A", "María", 2000, "4795783F", "vendor");

        cm.addEmployee("3764357S", "Diego", 1200, "2292828X", "operator");
        cm.addEmployee("1093847P", "Ernesto", 1200, "4795783F", "operator");
    }

    @Test(expected = TypeNotFoundException.class)
    public void TypeNotFoundExceptionTest() throws TypeNotFoundException, ManagerNotFoundException {
        cm.addEmployee("3764357S", "Felipe", 1200, "2292828X", "null");
    }
    @Test(expected = ManagerNotFoundException.class)
    public void ManagerNotFoundExceptionTest() throws TypeNotFoundException, ManagerNotFoundException {
        cm.addEmployee("3764357S", "Antonio", 1200, "null", "operator");
    }
    @Test
    public void getEmployeesTest() {
        Manager found = (Manager) cm.findById("2292828X");
        Assert.assertEquals(3,found.getListSize());
    }
    @Test
    public void addSellTest() throws VendorNotFoundException {
        cm.addSell("2933456C",400);
        Vendor v = (Vendor) cm.findById("2933456C");
        Assert.assertEquals(1, v.getSellsSize());
    }
    @Test(expected = VendorNotFoundException.class)
    public void VendorNotFoundExceptionTest() throws  VendorNotFoundException {
        cm.addSell("null",200);
    }
}
