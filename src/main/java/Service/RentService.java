package Service;

import Domain.Rent;
import Repository.IRepository;

import java.util.List;

public class RentService {

    private IRepository rentRepository;

    /**
     *
     * @param rentRepository
     */
    public RentService(IRepository rentRepository) {
        this.rentRepository = rentRepository;
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
        rentRepository.uspert(rent);
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
