package Company;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import java.util.*;

public class CompanyManagerImplementation implements CompanyManager{

    private HashMap<String, Employee> employees;
    private int MAX_size;

    public int getSize(){
        return employees.size();
    }

    public CompanyManagerImplementation() { this.employees = new HashMap<String, Employee>(); }

    public CompanyManagerImplementation(int MAX) {
        this.employees = new HashMap<>(MAX);
        this.MAX_size = MAX;
    }

    public void addSell(String id_vendor, double amount) throws VendorNotFoundException {
        Employee v = findById(id_vendor);
        if(v!=null && v instanceof Vendor){
            Sell s = new Sell(id_vendor,amount);
            ((Vendor) v).addSell(s);
        }
        else throw new VendorNotFoundException("Vendor not found");
    }

    public void addEmployee(String id, String name, double salary, String id_manager, String type) throws TypeNotFoundException, ManagerNotFoundException, ListFullException{
        if(employees.size()==MAX_size) throw new ListFullException("List of employees is full");
        else {
            if (type.equals("vendor") || type.equals("Vendor")) {
                Manager m = (Manager) findById(id_manager);
                if (m != null) {
                    Employee e = new Vendor(id, name, salary, id_manager);
                    this.employees.put(e.getId(), e);
                    m.AddEmployeeToManager(e);
                } else throw new ManagerNotFoundException("Manager not found");
            } else if (type.equals("operator") || type.equals("Operator")) {
                Manager m = (Manager) findById(id_manager);
                if (m != null) {
                    Employee e = new Operator(id, name, salary, id_manager);
                    this.employees.put(e.getId(), e);
                    m.AddEmployeeToManager(e);
                } else throw new ManagerNotFoundException("Manager not found");
            } else throw new TypeNotFoundException("Employee type not available, it should be vendor or operator");
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

    public List<Employee> findAllByManager(String idManager) throws ManagerNotFoundException, ListEmployeesEmptyException {
        Employee e = this.employees.get(idManager);
        List<Employee> res;

        if ((e != null) && e instanceof Manager) {
            Manager manager = (Manager)e;
            res = manager.getEmployees();
            if(res.size()==0) throw new ListEmployeesEmptyException("This manager does not have employees");
            else return res;
        }
        else throw new ManagerNotFoundException("Manager not found");
    }

    public List<Employee> findAllOrderByName(){
        List<Employee> list = new ArrayList<>();
        Set<String> stringSet = this.employees.keySet();
        for(String set: stringSet){
            list.add(this.employees.get(set));
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public List<Employee> findAllOrderBySalary() {
        List<Employee> list = new ArrayList<>();
        Set<String> stringSet = this.employees.keySet();
        for(String set: stringSet){
            list.add(this.employees.get(set));
        }
        Collections.sort(list, (one, other) -> {
            return other.getSalary().compareTo(one.getSalary());
        });
        return list;
    }
}
