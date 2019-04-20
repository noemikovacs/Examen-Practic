package UI;

import Service.CarService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.awt.*;

public class MyClassAddController {

    @FXML
    public Spinner spnId;
    public TextField txtModel;
    public TextField txtKm;
    public TextField txtPricePerDay;

    public Button btnAddMyClass;
    public Button btnCancel;

    private CarService service;

    public void setService(CarService service){
        this.service = service;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
//String id, String model, double km, double pricePerDay
    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String model = txtModel.getText();
            Double km = Double.parseDouble(txtKm.getText());
            Double pricePerDay =Double.parseDouble(txtPricePerDay.getText());


            service.add(id,model,km,pricePerDay);
            btnCancelClick(actionEvent);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

}
