package Domain;

import Repository.InMemoryRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClassValidator implements IValidator<Car> {

    /**
     * Validate a car object
     * @param mc
     * @throws MyClassValException
     */

    public void validate(Car mc) throws MyClassValException {

        if (mc.getModel().isEmpty()) {
            throw new MyClassValException("Invalid!");
        }

    }
}
