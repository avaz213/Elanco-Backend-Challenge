import java.time.LocalDate;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

// Class represents structure of every row of data that will be displayed

public class ExcelRow {
    // All columns are defined
    private final StringProperty id;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty location;
    private final StringProperty species;
    private final StringProperty latinName;

    public ExcelRow(String id, LocalDate date, String location, String species, String latinName)
    {
        this.id = new SimpleStringProperty(id);
        this.date = new SimpleObjectProperty<>(date);
        this.location = new SimpleStringProperty(location);
        this.species = new SimpleStringProperty(species);
        this.latinName = new SimpleStringProperty(latinName);
    }

    // Returns the property object in the column which is used to bind values to UI elements

    public StringProperty idProperty()
    {
        return id;
    }

    public ObjectProperty<LocalDate> dateProperty()
    {
        return date;
    }

    public StringProperty locationProperty()
    {
        return location;
    }

    public StringProperty speciesProperty()
    {
        return species;
    }

    public StringProperty latinNameProperty()
    {
        return latinName;
    }

    // Returns the actual value in the column

    public String getID()
    {
        return id.get();
    }

    public LocalDate getDate()
    {
        return date.get();
    }

    public String getLocation()
    {
        return location.get();
    }

    public String getSpecies()
    {
        return species.get();
    }

    public String getLatinName()
    {
        return latinName.get();
    }
}
