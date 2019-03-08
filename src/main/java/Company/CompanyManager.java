package Company;

import java.util.List;

public interface CompanyManager {

    void addEmployee(String id, String name, double salary, String id_manager, String type);

    void addManager(String id, String name, double salary);

    void addSell(String id_vendor, double amount);

    //List<Employee> findAllOrderBySalary();
    //List<Employee> findAllOrderByName();
    List<Employee> findAllByManager(String id_manager);
    Employee findById(String id);
}