package Domain;

public class SecondClass extends Entity {

    private String name;
    private double price;

    public SecondClass(String id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
