package Company;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends Employee {

    private String id_manager;

    private List <Sell> sells;

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(List<Sell> sells) {
        this.sells = sells;
    }

    public Vendor(String id, String name, double salary, String id_manager) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.id_manager = id_manager;
        this.sells = new ArrayList<Sell>();
    }

    @Override
    public void UpdateSalary(double base_salary) {

        double sell_amount = 0;
        double bonus;

        for(Sell sell : sells){
            sell_amount += sell.getAmount();
        }

        bonus = sell_amount*10/100;

        this.salary = base_salary + bonus;
    }

    public String getId_manager() {
        return id_manager;
    }

    public void setId_manager(String id_manager) {
        this.id_manager = id_manager;
    }
}