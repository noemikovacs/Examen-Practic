package Repository;

import Domain.Car;
import Domain.MyClassValException;
import Domain.MyClassValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository  {

    private Map<String, Car> storage = new HashMap<>();
    private MyClassValidator validator;

    /**
     * validate an element
     * @param validator
     */

    public InMemoryRepository(MyClassValidator validator){
        this.validator = validator;
    }

    /**
     * add a new element
     * @param car
     * @throws MyClassValException
     */
    public void add(Car car) throws MyClassValException {
        if(storage.containsKey(car.getId())){
            throw new RepositoryException("An element with this ID is already exists");
        }
        validator.validate(car);
        storage.put(car.getId(),car);
    }

    /**
     * remove an element
     * @param id
     * @throws MyClassValException
     */
    public void remove (String  id) throws MyClassValException {
        if (!storage.containsKey(id)) {
            throw new RepositoryException("There is no element with the given id to remove");
        }
        storage.remove(id);
    }

    /**
     *
     * @param id
     * @return the element by id
     */

    public Car findById(String id) {
        return storage.get(id);
    }


    /**
     *
     * @return list with all element
     */

    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }


}
