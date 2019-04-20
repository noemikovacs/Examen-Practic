package Service;


import Domain.Car;
import Domain.Entity;
import Domain.Rent;
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
    private IRepository rentRepository;

    public CarService(IRepository carRepository, IRepository rentRepository) {

        this.carRepository = carRepository;
        this.rentRepository = rentRepository;
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


    public double getKm(String id) {
        int sumKM = 0;
        Car car = new Car("a", "a", 0,0);
        car  = (Car)carRepository.findByID(id);
        sumKM = (int)car.getKm();
        for (Object rent : rentRepository.getAll()){
            Rent rent1 = (Rent)rent;
            if(rent1.getIdCar().equals(id)){
                sumKM = sumKM + rent1.getKmUsed();
            }
        }
        return sumKM;
    }

}
