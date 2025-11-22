import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDate;


public class ExcelInitial{
    private final List<ExcelRow> results = new ArrayList<>();
    public void load(String path)
    {
        Set<String> done = new HashSet<>();

        try (FileInputStream stream = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(wb))
            {
                Sheet sheet = workbook.getSheetAt(0);

                for(Row row : sheet)
                {
                    if(row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) || row.getCell(3) || row.getCell(4))
                    {
                        continue;
                    }

                    else
                    {
                        String id = row.getCell(0).getStringCellValue();
                        String date = row.getCell(1).getLocalDateCellValue();
                        String location = row.getCell(2).getStringCellValue();
                        String species = row.getCell(3).getStringCellValue();
                        String latin_name = row.getCell(4).getStringCellValue();
                    }

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

        public List<RowData> getResults() {
            return results;
        }
    
}