/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f19l11exercise;

import facade.Facade;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import laundry_facade.LaundryMachine;
import laundry_facade.LaundrySingleton;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class FXMLDocumentController implements Initializable {

    private Facade facade;

    //Array assignment
    @FXML
    private TextField sizeTF, maxTF, divisorTF;
    @FXML
    private Button fillArrayBtn, fillUniqueArrayBtn, sumOfDivisorBtn;
    @FXML
    private TextArea resultTA;

    //Laundry assignment
    @FXML
    private ToggleGroup wash;
    @FXML
    private RadioButton radio1, radio2, radio3;
    @FXML
    private TextField inputTF, outputTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new Facade();
        fillArrayBtn.setOnAction(event -> {
            try {
                resultTA.appendText(Arrays.toString(facade.fillArray(Integer.parseInt(sizeTF.getText()), Integer.parseInt(maxTF.getText()))) + "\n");
            } catch (NumberFormatException e) {
                resultTA.appendText("Invalid size of max input!\n");
            }
        });

        fillUniqueArrayBtn.setOnAction(event -> {
            try {
                resultTA.appendText(Arrays.toString(facade.fillUniqueArray(Integer.parseInt(sizeTF.getText()), Integer.parseInt(maxTF.getText()))) + "\n");
            } catch (NullPointerException | NumberFormatException e) {
                resultTA.appendText("Invalid size of max input!\n");
            }
        });

        sumOfDivisorBtn.setOnAction(event -> {
            try {
                resultTA.appendText(String.valueOf(facade.sumOfDivisors(Integer.parseInt(divisorTF.getText()))) + "\n");
            } catch (NumberFormatException e) {
                resultTA.appendText("Invalid divisor input!\n");
            } catch (NullPointerException e) {
                resultTA.appendText("Array not initialized\n");
            }
        });

        LaundrySingleton.getInstance().buildLaundry();
        wash.selectedToggleProperty().addListener(listener -> updateLaundryOut());
        inputTF.textProperty().addListener(listener -> updateLaundryOut());
    }

    private void updateLaundryOut() {
        try {
            int input = Integer.parseInt(inputTF.getText());
            int machineIndex = wash.getSelectedToggle() == radio1 ? 0 : wash.getSelectedToggle() == radio2 ? 1 : 2;
            LaundryMachine machine = LaundrySingleton.getInstance().getMachine(machineIndex);
            outputTF.setText(machine.getProgName(input) + ": " + machine.getPrice(input));
        } catch (NumberFormatException | NullPointerException e) {
            outputTF.setText("Error");
        }
    }

}
