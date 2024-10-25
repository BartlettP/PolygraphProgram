package edu.au.cpsc.module7;

import javafx.beans.property.*;

import java.time.LocalDate;

public class PolygraphDetailModel {
    private final StringProperty nameProperty = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> testDateProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<ScheduledPolygraph.TestResult> testResultProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<ScheduledPolygraph.TestType> testTypeProperty = new SimpleObjectProperty<>();

    private final BooleanProperty modifiedProperty = new SimpleBooleanProperty();
    private final BooleanProperty newProperty = new SimpleBooleanProperty();

    public PolygraphDetailModel() {
        nameProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        testDateProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        testResultProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        testTypeProperty.addListener((observable, oldValue, newValue) -> setModified(true));
    }

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public ObjectProperty<LocalDate> testDateProperty() {
        return testDateProperty;
    }

    public ObjectProperty<ScheduledPolygraph.TestResult> testResultProperty() {
        return testResultProperty;
    }
    public ObjectProperty<ScheduledPolygraph.TestType> testTypeProperty() {
        return testTypeProperty;
    }

    public String getName() {
        return nameProperty.get();
    }

    public LocalDate getTestDate() {
        return testDateProperty.get();
    }

    public ScheduledPolygraph.TestResult getTestResult() {
        return testResultProperty.get();
    }
    public ScheduledPolygraph.TestType getTestType() {
        return testTypeProperty.get();
    }
    // Value setters
    public void setName(String name) {
        nameProperty.set(name);
    }

    public void setTestDate(LocalDate date) {
        testDateProperty.set(date);
    }

    public void setTestResult(ScheduledPolygraph.TestResult result) {
        testResultProperty.set(result);
    }
    public void setTestType(ScheduledPolygraph.TestType type) {
        testTypeProperty.set(type);
    }
    public boolean isModified() {
        return modifiedProperty.get();
    }

    public void setModified(boolean modified) {
        modifiedProperty.set(modified);
    }

    public boolean isNew() {
        return newProperty.get();
    }

    public void setNew(boolean isNew) {
        newProperty.set(isNew);
    }

    public BooleanProperty modifiedProperty() {
        return modifiedProperty;
    }

    public BooleanProperty newProperty() {
        return newProperty;
    }
}