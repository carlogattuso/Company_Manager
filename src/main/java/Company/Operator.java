package Company;

public class Operator extends Employee {

    private String id_manager;

    public Operator(String id, String name, double salary, String id_manager) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.id_manager = id_manager;
    }

    @Override
    public void updateSalary(double base_salary) {
        this.salary = base_salary;
    }

    public String getId_manager() {
        return id_manager;
    }

    public void setId_manager(String id_manager) {
        this.id_manager = id_manager;
    }
}
