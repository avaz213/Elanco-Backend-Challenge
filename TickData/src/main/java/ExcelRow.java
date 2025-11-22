import java.time.LocalDate;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;


public class ExcelRow {
    private final StringProperty id;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty location;
    private final StringProperty species;
    private final StringProperty latin_name;

    public ExcelRow(String id, LocalDate date, String location, String species, String latin_name)
    {
        this.id = new SimpleStringProperty(id);
        this.date = new SimpleObjectProperty<>(date);
        this.location = new SimpleStringProperty(location);
        this.species = new SimpleStringProperty(species);
        this.latin_name = new SimpleStringProperty(latin_name);
    }

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

    public StringProperty latinProperty()
    {
        return latin_name;
    }

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

    public String getLatin()
    {
        return latin_name.get();
    }
}
