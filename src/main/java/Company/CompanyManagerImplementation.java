package Company;

import java.util.HashMap;
import java.util.List;

public class CompanyManagerImplementation implements CompanyManager {

    HashMap<String, Employee> employees;

    public int getSize(){
        return employees.size();
    }

    public CompanyManagerImplementation() { this.employees = new HashMap<String, Employee>(); }

    public void addSell(String id_vendor, double amount) {
        Sell s = new Sell(id_vendor,amount);
        Vendor v = (Vendor) findById(id_vendor);
        List<Sell> sells = v.getSells();
        sells.add(s);
        v.setSells(sells);
    }

    public void addEmployee(String id, String name, double salary, String id_manager, String type) {
        if(type.equals("vendor")||type.equals("Vendor")){
            Employee e = new Vendor(id,name,salary,id_manager);
            this.employees.put (e.getId(), e);
            Manager m = (Manager) findById(id_manager);
            m.AddEmployee(e);
        }
        else if (type.equals("operator")||type.equals("Operator")){
            Employee e = new Operator(id,name,salary,id_manager);
            this.employees.put (e.getId(), e);
            Manager m = (Manager) findById(id_manager);
            m.AddEmployee(e);
        }
        else {
            //TypeNotFoundException
        }
    }

    public void addManager(String id, String name, double salary) {
        Employee e = new Manager(id,name,salary);
        this.employees.put (e.getId(), e);
    }

    public Employee findById(String id) {
        Employee e = this.employees.get(id);
        return e;
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
