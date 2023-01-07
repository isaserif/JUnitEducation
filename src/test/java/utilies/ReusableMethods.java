package utilies;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {


    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver) {
        //1- TakeScreenSHOT Objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2-Resmi son olarak kaydedeceğimiz dosyayı oluştur.
        //her resim çektiğinde üst üste kaydetmemesi için
        // resim dosya yoluna tarih ve saat içeren bir ek yapalım

        LocalDateTime ltd = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String tarih = ltd.format(dtf);
        String dosyaYolu = "target/ekranResimleri/tumEkranScreenShot" + tarih + ".jpg";
        File tumSayfaScrenShot = new File(dosyaYolu);

        //3- tss objesikullanarak ekran görüntüsü alıp gecici dosyaya kaydet
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4- geciciDosyayi Ana dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScrenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void elementSSCek(WebElement element) {

        // 1- screenshot alacagimiz elementi locate et
        // 2- kaydedecegimiz dosyayi olustur
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/istenenElementSS" + tarih + ".jpeg";

        File elementSS = new File(dosyaYolu);
        // 3- gecici dosyayi olusturup, element uzerinden screenshot yapalim

        File gecici = element.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici, elementSS);
        } catch (IOException e) {

        }
    }
}