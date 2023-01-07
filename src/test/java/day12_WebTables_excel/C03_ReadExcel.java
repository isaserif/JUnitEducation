package day12_WebTables_excel;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day12_WebTables_excel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String beklenenStringHucre=    workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(beklenenStringHucre);
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualBaskent=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent="Kabil";
        Assert.assertEquals(expectedBaskent, actualBaskent);
        //- Satir sayisini bulalim
        System.out.println("Satır sayısı: "+(workbook.getSheet("Sayfa1").getLastRowNum()+1));
        //- Fiziki olarak kullanilan satir sayisini bulun
        // Bunun için sayfa 2deki son satır indexi ni ve fiziki olarak kullanılan satır sayısını yazdıralım
        System.out.println("2. sayfadaki son satır indexi: "+workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // Ulke ismi ingilizce ===> key, geriye kalan 3 bilgi ise birlestirilerek value olsun
        Map<String,String>ulkelerMap=new TreeMap<>();
        int soSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";
        for (int i = 0; i < soSatirIndexi; i++) {

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

          value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);
        }
        System.out.println(ulkelerMap);
    }
}
