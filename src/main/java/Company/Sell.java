package Company;

public class Sell {

    private static int sell_count = 0;
    private int id;
    private String id_vendor;
    private Double amount;

    public Sell(String id_vendor, Double amount) {
        this.id = sell_count++;
        this.id_vendor = id_vendor;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(String id_vendor) {
        this.id_vendor = id_vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}