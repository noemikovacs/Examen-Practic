package Domain;

public class Car extends Entity {

    private String Model;
    private double km, pricePerDay;

    /**
     * Constructor
     * @param id
     * @param model
     * @param km
     * @param pricePerDay
     */
    public Car(String id, String model, double km, double pricePerDay) {
        super(id);
        Model = model;
        this.km = km;
        this.pricePerDay = pricePerDay;
    }

    //getters and setter

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    //to string function
    @Override
    public String toString() {
        return "Car{" +
                "Model='" + Model + '\'' +
                ", km=" + km +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
