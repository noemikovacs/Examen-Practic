package Domain;

public class Rent extends Entity {

    private String idCar;
    private int nrOfDays, kmUsed;

    public Rent(String id, String idCar, int nrOfDays, int kmUsed) {
        super(id);
        this.idCar = idCar;
        this.nrOfDays = nrOfDays;
        this.kmUsed = kmUsed;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }

    public int getKmUsed() {
        return kmUsed;
    }

    public void setKmUsed(int kmUsed) {
        this.kmUsed = kmUsed;
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "idCar=" + idCar +
                ", nrOfDays=" + nrOfDays +
                ", kmUsed=" + kmUsed +
                '}';
    }
}
