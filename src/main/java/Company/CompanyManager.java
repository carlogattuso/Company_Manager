package Company;

import java.util.List;

public interface CompanyManager {

    int getSize();

    void addEmployee(String id, String name, double salary, String id_manager, String type) throws TypeNotFoundException, ManagerNotFoundException;

    void addManager(String id, String name, double salary);

    void addSell(String id_vendor, double amount) throws VendorNotFoundException;

    //List<Employee> findAllOrderBySalary();
    //List<Employee> findAllOrderByName();
    List<Employee> findAllByManager(String id_manager);
    Employee findById(String id);
}