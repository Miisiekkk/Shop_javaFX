package sample.Controller;

/**
 * Created by misiek on 2017-03-20.
 */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.Product;
import sample.Model.ProductType;

public class ProductEditController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField countField;

    @FXML
    private CheckBox productInFridgeCheckBox;

    @FXML
    private ComboBox<ProductType> productTypeComboBox;


    private Stage dialogStage;
    private Product product;
    private boolean okClicked = false;


    //initialization
    @FXML
    private void initialize(){

    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product product){
        this.product = product;

        nameField.setText(product.getName());
        countField.setText(Integer.toString(product.getProductCount()));
        productInFridgeCheckBox.setSelected(product.isDoesProductNeedsFridge());
        productTypeComboBox.getItems().setAll(ProductType.values()); //to będzie źle
        productTypeComboBox.setValue(product.getProductType());
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            product.setName(nameField.getText());
            product.setProductCount(Integer.parseInt(countField.getText()));
            product.setDoesProductNeedsFridge(productInFridgeCheckBox.isSelected());
            product.setProductType(productTypeComboBox.getValue());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }


    private boolean isInputValid(){
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0){
            errorMessage += "Błędna nazwa produktu\n";
        }
        if (countField.getText() == null || countField.getText().length() == 0){
            errorMessage += "Błędna liczba produktów\n";
        } else {
            try {
                Integer.parseInt(countField.getText());
            } catch (NumberFormatException e){
                errorMessage += "Błędna liczba produktów\n";
            }
        }
        if (productTypeComboBox.getValue() == null){
            errorMessage += "Nie zaznaczono typu\n";
        }
        if (errorMessage.length() == 0)
            return true;
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Błędne dane!");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}