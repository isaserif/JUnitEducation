package team3Calisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.util.Set;

public class windowHandle extends TestBase {

 @Test
    public void test01() throws InterruptedException {

     //● Amazon anasayfa adresine gidin.
     driver.get("https://www.amazon.com");

     //● Sayfa’nin window handle degerini String bir degiskene atayin
     String amazonHandle= driver.getWindowHandle();
     //● Sayfa title’nin “Amazon” icerdigini test edin
     String expectedAmazonTitleKelime="Amazon";
     String actualAmazonTitle=driver.getTitle();
     Assert.assertTrue(actualAmazonTitle.contains(expectedAmazonTitleKelime));

     //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
     driver.switchTo().newWindow(WindowType.TAB);
     driver.get("https://www.wisequarter.com");
     String wiseHandle= driver.getWindowHandle();
     //● Sayfa title’nin “wisequarter” icerdigini test edin
     String expectedWisequarterTitle="Wise Quarter";
     String actualWisequarterTitle=driver.getTitle();

     Assert.assertTrue(actualWisequarterTitle.contains(expectedWisequarterTitle));

     //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
     driver.switchTo().newWindow(WindowType.WINDOW);
     driver.get("https://www.walmart.com");
     String walmartHandle= driver.getWindowHandle();
     //● Sayfa title’nin “Walmart” icerdigini test edin
     String expectedWalmartTitle="Walmart";
     String actualWalmartTitle=driver.getTitle();
     Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));
     //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
    driver.switchTo().window(amazonHandle);
     ReusableMethods.bekle(3);
     String expectedAmazonUrl="https://www.amazon.com/";
     String actualAmazonUrl= driver.getCurrentUrl();
     Assert.assertEquals("url uyuşmuyor",expectedAmazonUrl,actualAmazonUrl);
 }
}
