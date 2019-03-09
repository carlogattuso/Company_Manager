package Company;

import java.util.HashMap;
import java.util.List;

public class CompanyManagerImplementation implements CompanyManager {

    HashMap<String, Employee> employees;

    public int getSize(){
        return employees.size();
    }

    public CompanyManagerImplementation() { this.employees = new HashMap<String, Employee>(); }

    public void addSell(String id_vendor, double amount) throws VendorNotFoundException {
        Vendor v = (Vendor) findById(id_vendor);
        if(v!=null){
            Sell s = new Sell(id_vendor,amount);
            v.addSell(s);
        }
        else throw new VendorNotFoundException("Vendor not found");
    }

    public void addEmployee(String id, String name, double salary, String id_manager, String type) throws TypeNotFoundException, ManagerNotFoundException{
        if(type.equals("vendor")||type.equals("Vendor")){
            Manager m = (Manager) findById(id_manager);
            if(m!=null){
                Employee e = new Vendor(id,name,salary,id_manager);
                this.employees.put (e.getId(), e);
                m.AddEmployeeToManager(e);
            }
            else throw new ManagerNotFoundException("Manager not found");
        }
        else if (type.equals("operator")||type.equals("Operator")){
            Manager m = (Manager) findById(id_manager);
            if(m!=null){
                Employee e = new Operator(id,name,salary,id_manager);
                this.employees.put (e.getId(), e);
                m.AddEmployeeToManager(e);
            }
            else throw new ManagerNotFoundException("Manager not found");
        }
        else throw new TypeNotFoundException("Employee type not available, it should be vendor or operator");
    }

    public void addManager(String id, String name, double salary) {
        Employee e = new Manager(id,name,salary);
        this.employees.put (e.getId(), e);
    }

    public Employee findById(String id) {
        Employee e = this.employees.get(id);
        return e;
    }

    public Manager findManagerById(String id_manager){
        Manager m = (Manager) this.employees.get(id_manager);
        return m;
    }

    public List<Employee> findAllByManager(String idManager) {
        Employee e = this.employees.get(idManager);
        Manager manager;
        List<Employee> res = null;

        if ((e != null) && e instanceof Manager) {
            manager = (Manager)e;
            res = manager.getEmployees();
        }

        return res;
    }
}
