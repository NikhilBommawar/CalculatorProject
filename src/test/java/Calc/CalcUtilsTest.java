package Calc;

import CalcUtils.Calc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalcUtilsTest {

    @Test
    public void testCalcUtil() throws Exception {
        try {
            int count = 0;
            String path = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\Calc input.xlsx";
            // Reading file from local directory
            FileInputStream file = new FileInputStream(new File(path));

            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            System.out.println("Printing cell values ........");

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                System.out.println("input " + row.getCell(0));
                System.out.println("expected " + row.getCell(1));

                float result = new Calc().calculate(String.valueOf(row.getCell(0)));

                System.out.println("actual " + String.valueOf(row.getCell(1)));

                assertEquals(Float.parseFloat(String.valueOf(row.getCell(1))), result);


                count += 1;

                if (count > 3) {
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testEvaluate() throws ServletException, IOException {
        String path = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\Evaluate Test.xlsx";
        // Reading file from local directory
        FileInputStream file = new FileInputStream(new File(path));

        // Create Workbook instance holding reference to
        // .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        System.out.println("Printing cell values ........");

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();


            System.out.println("expected " + row.getCell(3));

            float result = new Calc().evaluate(Float.parseFloat(String.valueOf(row.getCell(0))),
                    Float.parseFloat(String.valueOf(row.getCell(1))),
                    String.valueOf(row.getCell(2)));

            System.out.println("actual " + result);

            assertEquals(Float.parseFloat(String.valueOf(row.getCell(3))), result);

        }


    }
}