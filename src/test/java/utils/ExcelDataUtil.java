package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelDataUtil {

    // this is a utility class for handling Excel data
    // it contains methods to read data from Excel files
    // and to write data to Excel files
    // it also contains methods to format data for Excel
    // it is used by the test cases to read and write data
    // it is also used by the data providers to read and write data
    // it is also used by the testng.xml file to read and write data



    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell cell;

    private static XSSFRow row;
    public static String getExcelData(String filePath, String sheetName) {
        // code to read data from Excel file
        String[][] data = null;
        try {

            //open the Excel ile
            FileInputStream excelFile = new FileInputStream(filePath);

            //access the required est data sheet
             ExcelWBook = new XSSFWorkbook(excelFile);

             //get the sheet name in the Excel work book
            ExcelWSheet = ExcelWBook.getSheet(sheetName);

            //get the first row
            System.out.println("Testcase occur first in "+getFirstRow("Testcase"));





        }
        catch (Exception e){
            System.out.println(e);
        }






        return "data"; // placeholder for actual data
    }

    public static int getFirstRow(String testcase){
        Iterator<Row> rowIterator = ExcelWSheet.iterator();

        while(rowIterator.hasNext()){
            row = (XSSFRow) rowIterator.next();
        }

        Iterator<Cell> cellIterator = row.iterator();

        while (cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            if (cell.getStringCellValue().equalsIgnoreCase(testcase)){
                //jump to next row
                //row = (XSSFRow) rowIterator.next();
                return  row.getRowNum();
            }
        }

        return 0;
    }
    public static String getCellData(int rowNum , int colNum) throws Exception{

        String data = null;

        try {
            cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
            if (cell.getCellType() != CellType.STRING){
                return data;
            }
            else {
                data = cell.getStringCellValue();
                return data;
            }
        }catch (Exception e){
            System.out.println(e);
        }



        return data;

    }
}
