package Service;

import Domain.MyClass;
import Repository.IRepository;
import Repository.InMemoryRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyClassService {

    //private InMemoryRepository myClassRepository;
    private IRepository myClassRepository;

    public MyClassService(IRepository myClassRepository) {
        this.myClassRepository = myClassRepository;
    }

    /**
     * add a new element
     * @param id
     * @param name
     * @param date
     * @param duration
     * @param startDate
     */

    //String id, name, date, duration,startDate;
    public void add(String id, String name, String date, String duration, String startDate){
        MyClass mc = new MyClass(id,name,date, duration, startDate);
        myClassRepository.uspert(mc);
    }

    /**
     * delete an element
     * @param id
     */

    public void delete(String id){
        myClassRepository.remove(id);
    }

    /**
     *
     * @return a list with all element
     */
    public List<MyClass> getAll() {
        return myClassRepository.getAll();
    }




}
