package UI;


import Service.RentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondClassController {
    @FXML
    public Spinner spnId;
    public TextField txtIdCar;
    public TextField txtNrOfDays;
    public TextField txtKmUsed;

    public Button btnCancel;
    private RentService secService;

    public void setSecService(RentService secService){
        this.secService = secService;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    //String id, String idCar, int nrOfDays, int kmUsed
    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String idCar = txtIdCar.getText();
            int nrOfDays = Integer.parseInt(txtNrOfDays.getText());
            int kmUsed = Integer.parseInt(txtKmUsed.getText());



            secService.add(id,idCar,nrOfDays,kmUsed);
            btnCancelClick(actionEvent);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}
