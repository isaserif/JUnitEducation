package day10_FileTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.ReusableMethods;
import utilies.TestBase;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    @Test

    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/download adresine gidin
        driver.get("https://the-internet.herokuapp.com/download");
        //3- New Doc 11-05-2022 11.44.jpg dosyasını indirin
      // driver.findElement(By.xpath("//a[text()='New Doc 11-05-2022 11.44.jpg']")).click();
        ReusableMethods.bekle(5);
        //4- Dosyanın başarıyla indirilip indirilmediğini test edin
        // Test için öncelikle dosyanın indirildiğinde dosyaYolu ne olacak bunu oluşturmalıyız
        String dosyaYolu =System.getProperty("user.home") + "/Dowloads/New Doc 11-05-2022 11.44.jpg";
        // Bir dosyanın bilgisayarımızda var olduğunu test etmek için
        //java daki files class ından yardım alacağız.
        ReusableMethods.bekle(2);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02(){
        // Masaüstünde Merhabajava.text dosyası olduğunu test edin
    String dosyaYolu2=System.getProperty("user.home")+"Yeni Text Document.txt";
        System.out.println(dosyaYolu2);
    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));


    }






}
