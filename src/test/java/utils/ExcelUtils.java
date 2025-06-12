package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static String getExpectedText(String elementKey) {
        String filePath = "src/test/resources/TestData.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (keyCell != null && keyCell.getStringCellValue().equalsIgnoreCase(elementKey)) {
                    return valueCell.getStringCellValue();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel: " + e.getMessage());
        }

        return null;
    }
}
