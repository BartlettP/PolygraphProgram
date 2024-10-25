package edu.au.cpsc.module7;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;

import java.io.IOException;


public class PolygraphScheduleController {
    @FXML
    private Button updateButton, newButton, deleteButton;

    @FXML
    private MenuItem updateMenuItem, newMenuItem, deleteMenuItem;

    @FXML
    private PolygraphTableController tableViewController;
    @FXML
    private PolygraphDetailController detailViewController;
    @FXML
    private ScheduledPolygraph polygraphBeingEdited;
    private boolean polygraphBeingEditedIsNew;


    public void initialize() {
        tableViewController.showPolygraphs(Db.getDataBase().getScheduledPolygraphs());
        tableViewController.onPolygraphSelectionChanged(
                event -> showPolygraph(event.getSelectedPolygraph()));
        updateButton.disableProperty().bind(detailViewController.getModel().modifiedProperty().not());
        updateMenuItem.disableProperty().bind(detailViewController.getModel().modifiedProperty().not());
        newButton.disableProperty().bind(detailViewController.getModel().modifiedProperty()
                .or(detailViewController.getModel().newProperty()));
        newMenuItem.disableProperty().bind(detailViewController.getModel().modifiedProperty()
                .or(detailViewController.getModel().newProperty()));
        deleteButton.disableProperty().bind(detailViewController.getModel().modifiedProperty()
                .or(detailViewController.getModel().newProperty()));
        deleteMenuItem.disableProperty().bind(detailViewController.getModel().modifiedProperty()
                .or(detailViewController.getModel().newProperty()));
        showPolygraph(null);
    }
    private void showPolygraph(ScheduledPolygraph polygraph) {
        detailViewController.showPolygraph(polygraph);
        polygraphBeingEdited = polygraph == null ? new ScheduledPolygraph() : polygraph;
        polygraphBeingEditedIsNew = polygraph == null;
        String buttonLabel = polygraphBeingEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
    }
    @FXML
    protected void updateButtonAction() throws IOException {
       if(!detailViewController.updatePolygraph(polygraphBeingEdited))
       return;
        if (polygraphBeingEditedIsNew) {
            Db.getDataBase().addScheduledPolygraph(polygraphBeingEdited);
        } else {
            Db.getDataBase().updateScheduledPolygraph(polygraphBeingEdited);
        }
        Db.saveDatabase();
        tableViewController.showPolygraphs(Db.getDataBase().getScheduledPolygraphs());
        tableViewController.select(polygraphBeingEdited);
    }
    @FXML
    protected void newButtonAction() {
        tableViewController.select(null);
    }
    @FXML
    protected void deleteButtonAction() {
        if (polygraphBeingEditedIsNew) {
            tableViewController.select(null);
        } else {
            Db.getDataBase().removeScheduledPolygraph(polygraphBeingEdited);
            Db.saveDatabase();
            tableViewController.showPolygraphs(Db.getDataBase().getScheduledPolygraphs());
        }
    }

    @FXML
    protected void updateMenuAction() throws IOException {
        updateButtonAction();
    }

    @FXML
    protected void newMenuAction() {
        newButtonAction();
    }

    @FXML
    protected void deleteMenuAction() {
        deleteButtonAction();
    }

    @FXML
    protected void closeMenuAction() {
        Platform.exit();
    }
    @FXML
    protected void printAction() {
        System.out.println("Not functional yet. Would print table.");
    }
}