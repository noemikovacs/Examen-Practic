package Domain;


public class SecondClassValidator implements IValidator <Rent> {

    @Override
    public void validate(Rent rent) {

        if(rent.getIdCar().isEmpty()){
            throw new SecondClassExc("The ID car is not valid!");
        }


    }
}
