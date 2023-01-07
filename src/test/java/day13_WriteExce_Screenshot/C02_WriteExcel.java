package day13_WriteExce_Screenshot;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test01() throws IOException {
    // excel dosyasından kopyaladığımız workbook objesi üzerinde
    //değişiklik yapabiliriz.
        String dosyaYolu="src/test/java/day12_WebTables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        // 5. sutun olarak nufus başlığı ile bir sutun oluşturalım
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        // 3. Satırdaki nufusbilgisini 1.500000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(5).setCellValue("1500000");
        // 7. satırdaki nufus bilgisini 3000000 yapalım
        workbook.getSheet("Sayfa1").getRow(6).createCell(5).setCellValue("300000");
        // yaptığımız değişiklikler kopya workbook üzerinde
        // bu değişiklikleri excel dosyasına kaydetmek için
        // FileoutPutStream objesi oluşturalım
        FileOutputStream fos= new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        // EXCELL ACIKKEN ÇALIŞTIRMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        workbook.close();
        fis.close();
        fos.close();

    }
}
