
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class ExcelController{
    @FXML private TableView<ExcelRow> tableview;
    @FXML private TableColumn<ExcelRow, String> id_column;
    @FXML private TableColumn<ExcelRow, LocalDate> date_column;
    @FXML private TableColumn<ExcelRow,String> location_column;
    @FXML private TableColumn<ExcelRow,String> species_column;
    @FXML private TableColumn<ExcelRow,String> latin_column;

    @FXML
    public void initialize() {
        id_column.setCellValueFactory(data -> data.getValue().idProperty());
        date_column.setCellValueFactory(data -> data.getValue().dateProperty());
        location_column.setCellValueFactory(data -> data.getValue().locationProperty());
        species_column.setCellValueFactory(data -> data.getValue().speciesProperty());
        latin_column.setCellValueFactory(data -> data.getValue().latinProperty());

        // Load Excel once into cache
        ExcelInitial results = new ExcelInitial();
        results.load("C:/Users/alvia/Documents/Elanco Challenge/TickData/src/main/resources/Tick Sightings.xlsx");

        // Show all rows initially
        tableview.setItems(FXCollections.observableArrayList(results.getResults()));
    }

}
