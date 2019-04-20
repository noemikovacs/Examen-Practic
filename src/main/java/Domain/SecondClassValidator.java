package Domain;


public class SecondClassValidator implements IValidator <Rent> {

    /**
     * validate a rent object
     * @param rent
     */
    @Override
    public void validate(Rent rent) {

        if(rent.getIdCar().isEmpty()){
            throw new SecondClassExc("The ID car is not valid!");
        }


    }
}
