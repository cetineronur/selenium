package tests.day20;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(4);
        Cell cell = row.getCell(2);
        System.out.println(cell);
        //indexi 4 olan satirdaki, indexi 2 olan hucrenin Andorra oldugunu test edin

        String expectedData="Andorra";
        Assert.assertEquals(cell.toString(),expectedData);

        //5.indexteki satirin, 3.indexteki hucre bilgisini yazdiralim.
        row =sheet.getRow(5);
        cell= row.getCell(3);
        System.out.println(cell);
    }
}
