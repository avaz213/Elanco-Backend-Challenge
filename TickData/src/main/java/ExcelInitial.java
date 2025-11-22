import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class ExcelInitial{
    private final List<ExcelRow> results = new ArrayList<>();
    public void load(String path)
    {
        Set<String> done = new HashSet<>();

        try (FileInputStream stream = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(stream))
            {
                Sheet sheet = wb.getSheetAt(0);

                for(Row row : sheet)
                {
                    if(row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null || row.getCell(3) == null|| row.getCell(4) == null)
                    {
                        continue;
                    }

                    String id = row.getCell(0).getStringCellValue();
                    LocalDate date = row.getCell(1).getLocalDateTimeCellValue().toLocalDate();
                    String location = row.getCell(2).getStringCellValue();
                    String species = row.getCell(3).getStringCellValue();
                    String latin_name = row.getCell(4).getStringCellValue();

                    String key = id + "|" + date + "|" + location + "|" + species + "|" + latin_name;

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

        public List<ExcelRow> getResults() {
            return results;
        }
    
}