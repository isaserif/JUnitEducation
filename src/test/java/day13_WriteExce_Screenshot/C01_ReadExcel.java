package day13_WriteExce_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test

    public void test01() throws IOException {
        // excel dosyaları bilgisayarımızda olduğu için
        // Javada FileInputStream class i yardımıyla ulaşıyoruz
        String dosyaYolu="src/test/java/day12_WebTables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));
        // satır ve sutun bilgisini parametre olarak alıp
        //o hücredeki bilgiyi yazdıran bir method oluşturalım
        dataYazdir(25,2);
        dataYazdir(14,3);
    }
    private void dataYazdir(int satir,int sutun) throws IOException {
        String dosyaYolu="src/test/java/day12_WebTables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));
    }
}
