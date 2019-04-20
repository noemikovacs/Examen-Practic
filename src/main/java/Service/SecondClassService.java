package Service;

import Domain.SecondClass;
import Repository.IRepository;

import java.util.List;

public class SecondClassService {

    private IRepository secondClassRepository;

    /**
     * constructor
     * @param secondClassRepository
     */
    public SecondClassService(IRepository secondClassRepository) {
        this.secondClassRepository = secondClassRepository;
    }

    /**
     * add a new element
     * @param id
     * @param name
     * @param price
     */
    public void add (String id, String name, double price){
        SecondClass sc = new SecondClass(id,name,price);
        secondClassRepository.uspert(sc);
    }

    /**
     * delete an element by id
     * @param id
     */
    public void delete (String id){
        secondClassRepository.remove(id);

    }

    /**
     * Get all the elements
     * @return
     */
    public List<SecondClass> getAll() {
        return secondClassRepository.getAll();
    }
}
