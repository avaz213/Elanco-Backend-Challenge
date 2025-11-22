import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDateTime;

// Class which will display data from excel file
public class ExcelInitial{
    private final List<ExcelRow> results = new ArrayList<>();
    public void load(String path)
    {
        Set<String> done = new HashSet<>();

        // try with will close resources
        // opens excel file
        try (FileInputStream stream = new FileInputStream(path);
            // reading excel file from previous stream
            Workbook wb = new XSSFWorkbook(stream))
            {
                Sheet sheet = wb.getSheetAt(0);

                for(Row row : sheet)
                {
                    // checking if the row is a header or if there are incomplete entries
                    if(row.getRowNum() == 0 || row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null || row.getCell(3) == null|| row.getCell(4) == null)
                    {
                        continue;
                    }

                    // accessing data in each cell
                    String id = row.getCell(0).getStringCellValue();
                    Cell date_cell = row.getCell(1);          
                    String dateString = row.getCell(1).getStringCellValue();
                    LocalDate date = LocalDateTime.parse(dateString).toLocalDate();
                    String location = row.getCell(2).getStringCellValue();
                    String species = row.getCell(3).getStringCellValue();
                    String latin_name = row.getCell(4).getStringCellValue();

                    String key = id + "|" + date + "|" + location + "|" + species + "|" + latin_name;

                    // checking if the row is a duplicate
                    if (done.add(key))
                    {
                        results.add(new ExcelRow(id,date,location,species,latin_name));
                    }
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }

        // returning processed data
        public List<ExcelRow> getResults() {
            return results;
        }
}