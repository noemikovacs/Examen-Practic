package Service;


import Domain.Car;
import Repository.IRepository;
import Repository.InMemoryRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarService {

    //private InMemoryRepository myClassRepository;
    private IRepository carRepository;

    public CarService(IRepository carRepository) {

        this.carRepository = carRepository;
    }

    /**
     * add a car
     * @param id
     * @param model
     * @param km
     * @param pricePerDay
     */

    //String id, String model, double km, double pricePerDay
    public void add(String id, String model, double km, double pricePerDay){
        Car car = new Car(id,model,km, pricePerDay);
        carRepository.uspert(car);
    }
    //String id, String model, double km, double pricePerDay

    /**
     * delete an element
     * @param id
     */

    public void delete(String id){
        carRepository.remove(id);
    }

    /**
     *
     * @return a list with all element
     */
    public List<Car> getAll() {
        return carRepository.getAll();
    }




}
