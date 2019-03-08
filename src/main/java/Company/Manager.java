package Company;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> employees;

    public void AddEmployee(Employee e){
        this.employees.add(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Manager(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employees = new ArrayList<Employee>();
    }

    @Override
    public void UpdateSalary(double base_salary) {

        double sell_amount = 0;
        double bonus;

        for(Employee employee: employees){
            if(employee instanceof Vendor){
                List<Sell> sells = ((Vendor) employee).getSells();
                for(Sell sell : sells){
                    sell_amount += sell.getAmount();
                }
            }
        }

        bonus = sell_amount/100;

        this.salary = base_salary + bonus;
    }
}
