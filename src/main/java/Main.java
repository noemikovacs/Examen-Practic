import Domain.*;
import Repository.IRepository;
import Repository.JsonFileRepository;

import Service.CarService;
import Service.RentService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller controller =  fxmlLoader.getController();

            IValidator<Car> myClassValidator = new MyClassValidator();
            //InMemoryRepository repository = new InMemoryRepository(validator);
            IValidator<Rent> secClassValidator = new SecondClassValidator();

            IRepository<Car> myClassRepository = new JsonFileRepository<>(myClassValidator, "myClass.json",Car.class);
            IRepository<Rent> secondClassIRepository = new JsonFileRepository<>(secClassValidator,"secondClass.json",Rent.class);

            CarService service = new CarService(myClassRepository);
            RentService secService = new RentService(secondClassIRepository, myClassRepository);

            //service.add("52","test","20.11.2013","2h","11");
            //service.add("2","test1","28.11.2018", "5h","15");

            controller.setService(service);
            controller.setSecService(secService);


            primaryStage.setTitle("Car rent manager");
            primaryStage.setScene(new Scene(root, 650, 500));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }

}
