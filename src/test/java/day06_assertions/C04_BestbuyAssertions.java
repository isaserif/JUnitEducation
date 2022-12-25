package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1) Bir class oluşturun: BestBuyAssertions
public class C04_BestbuyAssertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    // olusturarak asagidaki testleri yapin

    @Test
    public void urlTest() {

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("url eşit değil", actualUrl, expectedUrl);
    }
    // -titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest() {
        String notExpectedKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse("Başlık Rest içeriyor", actualTitle.contains(notExpectedKelime));
    }
    // - logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void logoTest() {
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("bestBuy logosu görünmüyor", bestBuyLogo.isDisplayed());
    }
    // - FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test
    public void FrancaisLinkTest() {
        WebElement fransizcaLinkin = driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue("fransızca linki görünmüyor", fransizcaLinkin.isDisplayed());
    }


}





