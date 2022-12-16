package org.piskurov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.piskurov.model.states.Stats;

import java.io.IOException;

public class Controller {
    public ChoiceBox<String> RaceCB;
    public ChoiceBox<String> ClassCB;
    
    public TextField NameF;
    public TextField StrengthF;
    public TextField DexterityF;
    public TextField ConstitutionF;
    public TextField IntelligenceF;
    public TextField WisdomF;
    public TextField CharismaF;


    public Button RevertB;
    public Button GenerateB;
    public Button SaveB;

    private Model model;


    public void initialize() {
        ObservableList<String> races = FXCollections.observableArrayList("Dwarf", "Human");
        RaceCB.setItems(races);
        RaceCB.setValue("Dwarf");

        ObservableList<String> classes = FXCollections.observableArrayList("Bard", "Barbarian");
        ClassCB.setItems(classes);
        ClassCB.setValue("Bard");

        model = new Model();
    }

    public void revertButtonClick(MouseEvent mouseEvent) {

        try {
            model.revertCharacter();
            showAttributes();
        } catch (IllegalArgumentException e) {
            showError(
                    "The previous state does not exist",
                    "Most likely you have not yet had time to generate a character at least once"
            );
        }
    }

    public void generateButtonClick(MouseEvent mouseEvent) {

        if (NameF.getText().equals("")) {
            showError(
                    "Field \"Name\" is empty",
                    "To generate a character, the \"Name\" field cannot be empty"
            );
            return;
        }

        model.generateCharacter(NameF.getText(), RaceCB.getValue(), ClassCB.getValue());

        showAttributes();

    }

    public void saveButtonClick(MouseEvent mouseEvent) {

        try {
            model.saveCharacter();
            showInfo(
                    "The file \"character.json\" has been saved",
                    "The save was successful"
            );
        } catch (IOException e) {
            showError(
                    "I can't save the file.",
                    "Exception" + e.getMessage()
            );
        } catch (IllegalArgumentException e) {
            showError(
                    "There is nothing to keep",
                    "Most likely you have not yet had time to generate a character at least once"
            );
        }
    }

    private void showAttributes() {

        RaceCB.setValue(model.getCurrentCharacter().getCharacterRace().getName());
        ClassCB.setValue(model.getCurrentCharacter().getCharacterClass().getName());
        NameF.setText(model.getCurrentCharacter().getName());

        Stats attr = model.getCurrentCharacter().getAttributes();

        StrengthF.setText(Integer.toString(attr.getStrength()));
        DexterityF.setText(Integer.toString(attr.getDexterity()));
        ConstitutionF.setText(Integer.toString(attr.getConstitution()));
        IntelligenceF.setText(Integer.toString(attr.getIntelligence()));
        WisdomF.setText(Integer.toString(attr.getWisdom()));
        CharismaF.setText(Integer.toString(attr.getCharisma()));
    }

    private void showError(String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private void showInfo(String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
