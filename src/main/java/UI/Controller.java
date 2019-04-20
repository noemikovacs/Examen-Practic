package UI;

import Domain.Car;
import Domain.Rent;
import Service.CarService;
import Service.RentService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

//String id, String model, double km, double pricePerDay

    public TableView tableViewMyClass;
    public TableColumn tableColumnId;
    public TableColumn tableColumnModel;
    public TableColumn tableColumnKm;
    public TableColumn tableColumnPricePerDay;


    public Button btnMedAdd;
    public Button btnMedDelete;

    public CarService service;


//String id, String idCar, int nrOfDays, int kmUsed
    public TableView tableViewSecondClass;
    public TableColumn tableColumnSecId;
    public TableColumn tableColumnSecIdCar;
    public TableColumn tableColumnSecNrOfDays;
    public TableColumn tableColumnSecKmUsed;

    public Button btnSecAdd;
    public Button btnSecDelete;

    public RentService secService;


    private ObservableList<Car> mc = FXCollections.observableArrayList();
    private ObservableList<Rent> sc = FXCollections.observableArrayList();

    public void setService(CarService service){

        this.service = service;

    }

    public void setSecService(RentService secService){

        this.secService = secService;
    }


    @FXML
    private void initialize(){

        Platform.runLater(() ->{
            mc.addAll(service.getAll());
            tableViewMyClass.setItems(mc);
        });
        Platform.runLater(() ->{
            sc.addAll(secService.getAll());
            tableViewSecondClass.setItems(sc);
        });
    }

    public void btnMyClassAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/MyClassAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add Car");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MyClassAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            mc.clear();
            mc.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnSecondClassAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/SecondClassAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add Rent");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            SecondClassController controller = fxmlLoader.getController();
            controller.setSecService(secService);
            stage.showAndWait();
            sc.clear();
            sc.addAll(secService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnMyClassDeleteClick(ActionEvent actionEvent) {
        Car selected = (Car) tableViewMyClass.getSelectionModel().getSelectedItem();
        if (selected != null ) {
            try {
                service.delete(selected.getId());
                mc.clear();
                mc.addAll(service.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }

    public void btnSecondClassDeleteClick(ActionEvent actionEvent) {
        Rent selected = (Rent)tableViewSecondClass.getSelectionModel().getSelectedItem();
        if (selected != null ) {
            try {
                secService.delete(selected.getId());
                sc.clear();
                sc.addAll(secService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }
}
