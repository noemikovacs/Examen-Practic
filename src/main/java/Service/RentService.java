package Service;

import Domain.Rent;
import Repository.IRepository;
import Repository.RepositoryException;

import java.util.List;

public class RentService {

    private IRepository rentRepository;
    private IRepository carRepository;

    /**
     *
     * @param rentRepository
     */
    public RentService(IRepository rentRepository, IRepository carRepository) {

        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    /**
     * add a rent
     * @param id
     * @param idCar
     * @param nrOfDays
     * @param kmUsed
     */

    //String id, int idCar, int nrOfDays, int kmUsed
    public void add (String id, String idCar, int nrOfDays, int kmUsed){
        Rent rent = new Rent(id,idCar,nrOfDays,kmUsed);
        if(carRepository.findByID(rent.getIdCar()).getId().equals(idCar)){

            rentRepository.uspert(rent);

        } else {
            throw new RepositoryException("The given ID car is not exists! Add a valid car ID");
        }

    }

    /**
     * delete an element by id
     * @param id
     */
    public void delete (String id){
        rentRepository.remove(id);

    }

    /**
     * Get all the elements
     * @return
     */
    public List<Rent> getAll() {
        return rentRepository.getAll();
    }
}
