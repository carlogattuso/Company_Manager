package Company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        CompanyManager cm = new CompanyManagerImplementation();

        int i = cm.getSize();

        cm.addManager("2292828X", "Carlo", 5000);
        cm.addManager("4795783F", "Mario", 5000);

        cm.addEmployee("2933456C", "Juan", 2000, "2292828X", "vendor");
        cm.addEmployee("4987436B", "Pedro", 2000, "2292828X", "vendor");
        cm.addEmployee("6472938R", "Jose", 2000, "4795783F", "vendor");
        cm.addEmployee("2738453A", "María", 2000, "4795783F", "vendor");

        cm.addEmployee("3764357S", "Diego", 1200, "2292828X", "operator");
        cm.addEmployee("1093847P", "Ernesto", 1200, "4795783F", "operator");

        cm.addSell("2933456C", 300);
        cm.addSell("2933456C", 300);
        cm.addSell("2933456C", 300);
        cm.addSell("2933456C", 300);

        cm.addSell("4987436B", 200);
        cm.addSell("4987436B", 500);

        cm.addSell("6472938R", 2000);
        cm.addSell("6472938R", 100);
        cm.addSell("6472938R", 200);

        cm.addSell("2738453A", 900);

        Employee e;

        String id;
        String name;
        Double salary;
        String id_manager;

        e = cm.findById("2292828X");
        Manager m = (Manager) e;
        id = e.getId();
        name = e.getName();
        salary = e.getSalary();

        e = cm.findById("4987436B");
        Vendor v = (Vendor) e;
        id = e.getId();
        name = e.getName();
        salary = e.getSalary();
        id_manager = ((Vendor) e).getId_manager();

        e = cm.findById("3764357S");
        Operator o = (Operator) e;
        id = e.getId();
        name = e.getName();
        salary = e.getSalary();
        id_manager = ((Operator) e).getId_manager();

        e = cm.findById("2292828X");
        e.UpdateSalary(5000);
        e = cm.findById("4795783F");
        e.UpdateSalary(5000);
        e = cm.findById("2933456C");
        e.UpdateSalary(2000);
        e = cm.findById("4987436B");
        e.UpdateSalary(2000);
        e = cm.findById("6472938R");
        e.UpdateSalary(2000);
        e = cm.findById("2738453A");
        e.UpdateSalary(2000);
        e = cm.findById("3764357S");
        e.UpdateSalary(1200);
        e = cm.findById("1093847P");
        e.UpdateSalary(1200);

        List<Employee> employees = cm.findAllByManager("2292828X");
    }
}