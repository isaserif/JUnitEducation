package day12_WebTables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        // dosya yolunu oluşturalım
        String dosyaYolu="src/test/java/day12_WebTables_excel/ulkeler.xlsx";
        //fileInputStream objesi oluşturup parametre olarak dosya yolunu yazalım
        FileInputStream fis = new FileInputStream(dosyaYolu);
        // Kod alanımızda excel in bir kopyasnı oluşturup
        // tum bilgileri ona kopyalayacağız
        Workbook workbook= WorkbookFactory.create(fis);

        // workbook içerisinde birden fazla sayfa olabilir
        //istediğimiz sayfa ya gidelim
        Sheet sheet=workbook.getSheet("Sayfa1");
        // Angolayı yazdırmak istediğimiz için . satıra gidelim
        Row row=sheet.getRow(5);
        // 5. satırın 2. index indeki datayı alalım
        Cell cell=row.getCell(2);
        System.out.println(cell);// Angola

    }
}
