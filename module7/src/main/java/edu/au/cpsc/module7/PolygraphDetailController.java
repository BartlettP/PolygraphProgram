package edu.au.cpsc.module7;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PolygraphDetailController {
    @FXML
    private DatePicker testedDatePicker;
    @FXML
    private ChoiceBox resultChoiceBox;
    @FXML
    private ChoiceBox testChoiceBox;

    @FXML
    private TextField nameTextField;
    private PolygraphDetailModel model;
    public void initialize() {
        resultChoiceBox.setItems(FXCollections.observableArrayList(ScheduledPolygraph.TestResult.values()));
        testChoiceBox.setItems(FXCollections.observableArrayList(ScheduledPolygraph.TestType.values()));
        model = new PolygraphDetailModel();
        nameTextField.textProperty().bindBidirectional(model.nameProperty());
        testedDatePicker.valueProperty().bindBidirectional(model.testDateProperty());
        resultChoiceBox.valueProperty().bindBidirectional(model.testResultProperty());
        testChoiceBox.valueProperty().bindBidirectional(model.testTypeProperty());
    }
    public PolygraphDetailModel getModel() { return model; }

    public void showPolygraph(ScheduledPolygraph polygraph) {
        if (polygraph == null) {
            model.setName("");
            model.setTestDate(null);
            model.setTestResult(null);
            model.setTestType(null);
            model.setModified(false);
            model.setNew(true);
            clearErrorStyles();
            return;
        }
            model.setName(polygraph.getPatientName());
            model.setTestDate(polygraph.getScheduledTest());
            model.setTestResult(polygraph.getTestResult());
            model.setTestType(polygraph.getTestType());
            model.setModified(false);
            model.setNew(false);
            clearErrorStyles();
        }




    public boolean updatePolygraph(ScheduledPolygraph polygraph) throws IOException {
        if (!validate()) return false;
        polygraph.setPatientName(model.getName());
        polygraph.setScheduledTest(model.getTestDate());
        polygraph.setTestResult(model.getTestResult());
        polygraph.setTestType(model.getTestType());
        return true;
    }

    private boolean validate() throws IOException {
        boolean result = true;
        result = validateFieldNotEmpty(nameTextField);
        if (testedDatePicker.getValue() == null) {
            testedDatePicker.getStyleClass().add("error");
            result = false;
        } else {
            testedDatePicker.getStyleClass().remove("error");
        }
        if (resultChoiceBox.getValue() == null) {
            resultChoiceBox.getStyleClass().add("error");
            result = false;
        } else {
            resultChoiceBox.getStyleClass().remove("error");
        }
        if (testChoiceBox.getValue() == null) {
            testChoiceBox.getStyleClass().add("error");
            result = false;
        } else {
            testChoiceBox.getStyleClass().remove("error");
        }
        if (!result) {
            PolygraphErrorWindow.show();
        }
        return result;
    }

    private boolean validateFieldNotEmpty(TextField field) {
        if (field.getText().trim().length() == 0) {
            field.getStyleClass().add("error");
            return false;
        }
        return true;
    }
    @FXML
    protected void designatorKeyTyped(){
        nameTextField.getStyleClass().remove("error");}
    @FXML
    protected void datePicked() {
        testedDatePicker.getStyleClass().remove("error");}
    @FXML
    protected void resultPicked() {
        resultChoiceBox.getStyleClass().remove("error");
    }
    @FXML
    protected void testPicked() {
        testChoiceBox.getStyleClass().remove("error");
    }


    private void clearErrorStyles() {
        nameTextField.getStyleClass().remove("error");

    }
}



