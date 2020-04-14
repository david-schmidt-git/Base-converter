package baseconverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXMLDocument Controller of FXML project
 * 
 * @author David
 */

public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<Integer> inputComboBox;
    @FXML
    private ComboBox<Integer> outputComboBox;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField outputTextField;
    @FXML
    private Label inputLabel;
    @FXML
    private Label outputLabel;
    @FXML
    private Button convertButton;
    @FXML
    private TextArea errorTextArea;
    @FXML
    private Button inputButton;
    
    /**
     * Writes the <i>text</i> parameter as text
     * on the {@link TextArea} of this class.
     * 
     * @param text The text that is to be written to the {@link TextArea}
     * @see TextArea
     */
    public void writeError(String text) {
        errorTextArea.setText(text);
    }

    /**
     * Handler method for the {@link inputButton}.
     * Sets the {@link inputTextField} text to the current {@link outputTextField} text.
     * Then clears both {@link outputTextField} and {@link errorTextArea}.
     * 
     * @see TextField
     * @see TextArea
     */
    @FXML
    private void handleInputButton() {
        inputTextField.setText(outputTextField.getText());
        outputTextField.clear();
        errorTextArea.clear();
    }

    /**
    * Handler method for the {@link convertButton}.
    * Tries to get {@link inputTextField}, {@link inputComboBox} and {@link outputComboBox} values,
    * then calls <i>BaseConverter.convertBetweenBases</i> with all three parameters.
    * 
    * @see TextField
    * @see TextArea
    */
    @FXML
    private void handleConvertButton() {

        errorTextArea.clear();

        String value = inputTextField.getText();
        int fromBase;
        int toBase;

        try {
            fromBase = inputComboBox.getValue();
        } catch (NullPointerException e) {
            fromBase = Integer.parseInt(inputComboBox.getPromptText());
        }

        try {
            toBase = outputComboBox.getValue();
        } catch (NullPointerException e) {
            toBase = Integer.parseInt(outputComboBox.getPromptText());
        }

        String returnValue = "ERROR";
        try {
            returnValue = Convert.convertBetweenBases(value, fromBase, toBase);
        } catch (CustomException e) {
            writeError(e.getLocalizedMessage());
        }
        outputTextField.setText(returnValue.toUpperCase());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Integer> bases = new ArrayList<>();
        for (int i = 2; i <= 16; i++) {
            bases.add(i);
        }
        inputComboBox.setItems(FXCollections.observableArrayList(bases));
        outputComboBox.setItems(FXCollections.observableArrayList(bases));

    }

}
