import Company.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class Scenario_2_Tests {

    private CompanyManagerImplementation cm = new CompanyManagerImplementation();

    @Before
    public void Initialize() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
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
    public void TypeNotFoundExceptionTest() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
        cm.addEmployee("3891028D", "Felipe", 1200, "2292828X", "null");
    }
    @Test(expected = ManagerNotFoundException.class)
    public void ManagerNotFoundExceptionTest1() throws TypeNotFoundException, ManagerNotFoundException, ListFullException {
        cm.addEmployee("1002937H", "Antonio", 1200, "null", "operator");
    }
    @Test(expected = ManagerNotFoundException.class)
    public void ManagerNotFoundExceptionTest2() throws ManagerNotFoundException, ListEmployeesEmptyException {
        List<Employee> list = cm.findAllByManager("null");
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
    @Test
    public void FindAllByManagerTest() throws ManagerNotFoundException, ListEmployeesEmptyException {
        List<Employee> list;
        list = cm.findAllByManager("2292828X");
        Assert.assertEquals(3,list.size());
    }
    @Test (expected = ListEmployeesEmptyException.class)
    public void ListEmployeesEmptyException () throws ManagerNotFoundException, ListEmployeesEmptyException {
        cm.addManager("1002937H", "Antonio", 1200);
        List <Employee> list = cm.findAllByManager("1002937H");
    }
}
