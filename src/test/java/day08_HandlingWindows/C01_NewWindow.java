package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda yeni bir özellik geldi

    Istersek kontrollü olarak driver için yeni bir window ve ya tab oluşturabiliriz
    Bu durumda driver imiz da otomatik  olarak yeni sayfaya geçmiş oluruz.

    Testin ilerleyen aşamalarında yeniden eski sayfalara dönüş görevi varsa
    o sayfada iken o sayfanın window Handle değeri alınıp kaydedilir.

    driver.switchTo().window(istenenSyfanınWindowHandleDegeri)
    kodu ile o sayfaya geciş yapılır.
     */

static WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@After
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}




@Test
    public void test01() throws InterruptedException {
    driver.get("https://www.amazon.com");
    Thread.sleep(3000);

    // Testin ilerleyen aşamalarında yeniden amazon sayfasına dönmek gerekiyorsa
    // amazon sayfasında iken bu window handle değerini alıp kaydetmeliyiz
    String ilkSayfaDegeri= driver.getWindowHandle();

    // Yeni bir tab da wisequarter.com gidin ve gittiğinizi test edin

   driver.switchTo().newWindow(WindowType.TAB);
   driver.get("https://www.wisequarter.com");

   String actualUrl= driver.getCurrentUrl();
   String expectedKelime="wisequarter";
    Assert.assertTrue(actualUrl.contains(expectedKelime));
    Thread.sleep(3000);

    // wisequarter testini yaptıktan sonra
    // yeniden amazon un açık olduğu  tab a geçin
    // ve amazon anasayfasının açık olduğunu test edin

    driver.switchTo().window(ilkSayfaDegeri);
    actualUrl= driver.getCurrentUrl();
    expectedKelime="amazon";
    Assert.assertTrue(actualUrl.contains(expectedKelime));
    Thread.sleep(3000);




    }



}
