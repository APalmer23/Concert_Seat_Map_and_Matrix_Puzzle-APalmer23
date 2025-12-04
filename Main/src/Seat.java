public class Seat {
    private boolean sold;
    private String type;
    private double price;
    Seat(boolean s, String t, double p){
        sold=s;
        type=t;
        price=p;
    }
    public boolean isSold() {
        return sold;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
