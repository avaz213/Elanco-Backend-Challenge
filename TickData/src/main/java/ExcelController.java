
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ExcelController{
    @FXML private TableView<ExcelRow> tableview;
    @FXML private TableColumn<ExcelRow, String> id_column;
    @FXML private TableColumn<ExcelRow, LocalDate> date_column;
    @FXML private TableColumn<ExcelRow,String> location_column;
    @FXML private TableColumn<ExcelRow,String> species_column;
    @FXML private TableColum<ExcelRow,String> latin_column;

    @FXML
    public void initialize() {
        id_column.setCellValueFactory(data -> data.getValue().IDProperty().asObject());
        nameCol.setCellValueFactory(data -> data.getValue().dateProperty());
        statusCol.setCellValueFactory(data -> data.getValue().statusProperty());
        dateCol.setCellValueFactory(data -> data.getValue().dateProperty());

        // Load Excel once into cache
        excelCache.load("C:/Users/alvia/Documents/Elanco Challenge/TickData/src/main/resources/Tick Sightings.xlsx");

        // Show all rows initially
        tableView.setItems(FXCollections.observableArrayList(ExcelInitial.getCache()));
    }

}
