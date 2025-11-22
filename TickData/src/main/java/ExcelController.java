import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.collections.ObservableList;

// Class which interacts directly with main.fxml

public class ExcelController{
    @FXML private TableView<ExcelRow> tableview;
    @FXML private TableColumn<ExcelRow, String> id_column;
    @FXML private TableColumn<ExcelRow, LocalDate> date_column;
    @FXML private TableColumn<ExcelRow,String> location_column;
    @FXML private TableColumn<ExcelRow,String> species_column;
    @FXML private TableColumn<ExcelRow,String> latin_column;

    @FXML private TextField location_textField;
    @FXML private DatePicker startdate_DatePicker;
    @FXML private DatePicker enddate_DatePicker;

    private FilteredList<ExcelRow> filtered;

    @FXML
    public void initialize() {
        // Matching the excel columns to what will be displayed later in table view.
        id_column.setCellValueFactory(data -> data.getValue().idProperty());
        date_column.setCellValueFactory(data -> data.getValue().dateProperty());
        location_column.setCellValueFactory(data -> data.getValue().locationProperty());
        species_column.setCellValueFactory(data -> data.getValue().speciesProperty());
        latin_column.setCellValueFactory(data -> data.getValue().latinNameProperty());

        // loading initial data
        ExcelInitial results = new ExcelInitial();
        results.load("C:/Users/alvia/Documents/Elanco Challenge/TickData/src/main/resources/Tick Sightings.xlsx");

        // observable list will let UI know when items are removed or added
        ObservableList<ExcelRow> data = FXCollections.observableArrayList(results.getResults());
        //initially shows all rows
        filtered = new FilteredList<>(data, p -> true);
        // sorts the data
        SortedList<ExcelRow> sorted = new SortedList<>(filtered);
        //when the user clicks on a column header the order in which the data is sorted swaps
        sorted.comparatorProperty().bind(tableview.comparatorProperty());
        // applying data to table view
        tableview.setItems(sorted);

        // if these elements have data entered in them filtering is triggered

        location_textField.textProperty().addListener((observable,old_value,new_value) -> filtering());
        startdate_DatePicker.valueProperty().addListener((observable,old_value,new_value) -> filtering());
        enddate_DatePicker.valueProperty().addListener((observable,old_value,new_value) -> filtering());

    }

    private void filtering()
    {
        String user_location = location_textField.getText().toLowerCase();
        LocalDate start = startdate_DatePicker.getValue();
        LocalDate end = enddate_DatePicker.getValue();

        filtered.setPredicate(row ->{
            boolean valid_location = true;
            // checking if location column matches with user input
            valid_location = row.getLocation().toLowerCase().contains(user_location);

            // checks if date column is within user input
            boolean valid_date = true;
            if (start != null && row.getDate().isBefore(start)) {
                valid_date = false;
            }
            if (end != null && row.getDate().isAfter(end)) {
                valid_date = false;
            }
            return valid_location && valid_date;
        });
    }



}
