package DataProviders;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelDataDemo {

    ExcelDataDemo(){

    }

    static XSSFWorkbook workbook;
    static XSSFSheet sheet = null;
    public static void main(String[] args) {


        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/biswajitsahoo/Documents/My Project/My workspace/seleniumframeworkdesign/src/test/java/TestData/TestData.xlsx");

            workbook = new XSSFWorkbook(fileInputStream);

            int totalSheets = workbook.getNumberOfSheets();
            //System.out.println(totalSheets);

            for (int i = 0; i < totalSheets; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
                    sheet = workbook.getSheetAt(i);
                }
            }

            // now we are in sheet , we want to iterate each row


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRow(String data){
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();// jumping to first row

        System.out.println("I am in row number "+ firstRow.getRowNum());

        //how to iterate all the columns of the first row
        Iterator<Cell> cellIterator = firstRow.cellIterator();

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getStringCellValue().equalsIgnoreCase("Testcase")){
                //now you are in desired cell/col
                cell.getColumnIndex();
                cell.getStringCellValue();

            }

        }
        return 0;
    }

}
