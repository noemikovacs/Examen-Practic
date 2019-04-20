package UI;

import Service.CarService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class KMCarAddController {

    @FXML
    public Spinner spnId;
    public TextField txtKm;

    public Button btnCalKMClass;
    public Button btnCancel;

    private CarService service;

    public void setService(CarService service){
        this.service = service;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnCalcClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            double km = service.getKm(id);
            txtKm.setText(String.valueOf((km)));

            //btnCancelClick(actionEvent);


        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

}
