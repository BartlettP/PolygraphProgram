package edu.au.cpsc.module7;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class PolygraphTableController {
    @FXML
    private PolygraphDetailController polygraphDetailController;
    @FXML
    private TableView<ScheduledPolygraph> polygraphTableView;

    @FXML
    private TableColumn<ScheduledPolygraph, String> nameColumn;
    @FXML
    private TableColumn<ScheduledPolygraph, LocalDate> dateColumn;
    @FXML
    private TableColumn<ScheduledPolygraph, ScheduledPolygraph.TestResult> resultColumn;
    @FXML
    private TableColumn<ScheduledPolygraph, LocalDate> nextDateColumn;
    @FXML
    private TableColumn<ScheduledPolygraph, ScheduledPolygraph.TestType> typeColumn;

    public void initialize() {
    nameColumn.setCellValueFactory(new PropertyValueFactory<ScheduledPolygraph, String>("patientName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ScheduledPolygraph, LocalDate>("scheduledTest"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<ScheduledPolygraph, ScheduledPolygraph.TestResult>("testResult"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<ScheduledPolygraph, ScheduledPolygraph.TestType>("testType"));
        nextDateColumn.setCellValueFactory(new PropertyValueFactory<ScheduledPolygraph, LocalDate>("nextTest"));
    polygraphTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());

    }
    public void showPolygraphs(List<ScheduledPolygraph> polygraphs) {
        SortedList<ScheduledPolygraph> sortedList = new SortedList<>(FXCollections.observableList(polygraphs));
        polygraphTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(polygraphTableView.comparatorProperty());
        polygraphTableView.refresh();
    }
    public void onPolygraphSelectionChanged(EventHandler<PolygraphTableEvent> handler) {
        polygraphTableView.addEventHandler(PolygraphTableEvent.POLYGRAPH_SELECTED, handler);
    }
    private void tableSelectionChanged() {
        ScheduledPolygraph selectedFlight = polygraphTableView.getSelectionModel().getSelectedItem();
        PolygraphTableEvent event = new PolygraphTableEvent(PolygraphTableEvent.POLYGRAPH_SELECTED, selectedFlight);
        polygraphTableView.fireEvent(event);
    }
    public ScheduledPolygraph getSelectedPolygraph() {
        return polygraphTableView.getSelectionModel().getSelectedItem();
    }
    public void select(ScheduledPolygraph polygraph) {
        polygraphTableView.getSelectionModel().select(polygraph);
    }

    public static class PolygraphTableEvent extends Event {
        public static final EventType<PolygraphTableEvent> ANY = new EventType<>(Event.ANY, "ANY");
        public static final EventType<PolygraphTableEvent> POLYGRAPH_SELECTED = new EventType<>(ANY, "POLYGRAPH_SELECTED");

        private ScheduledPolygraph selectedPolygraph;
        public PolygraphTableEvent(EventType<? extends Event> eventType, ScheduledPolygraph selectedPolygraph) {
        super(eventType);
        this.selectedPolygraph = selectedPolygraph;
        }
        public ScheduledPolygraph getSelectedPolygraph() {
            return selectedPolygraph;
        }
        }
    }


