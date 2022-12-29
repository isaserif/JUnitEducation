package team3Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class comOtomasyon {
    //1- j unityapısını kurunuz;
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

    //2- urlTest01() methodu oluşturup  https://segron.com/contact-us/ adresine gidiniz
    @Test
    public void urlTest01() {
        driver.get(" https://segron.com/contact-us/");
        //a) actuallyUrl =
        //expectedUrl =https://segron.com/contact-us/ eşit olduğun test ediniz
        String expectedUrl = "https://segron.com/contact-us/";
        String actuallyUrl = driver.getCurrentUrl();

        Assert.assertEquals("expectedurl actuallyurl eşit değildir", expectedUrl, actuallyUrl);
        // b) Site title nin "SEGRON" içerdiğini doğrulayınız
        String expectdKelime = "SEGRON";
        String actuallyTitle = driver.getTitle();

        Assert.assertTrue(actuallyTitle.contains(expectdKelime));

    }

    @Test
    public void writeUs() {

        //c) "Write us" yazısının görünürlüğünü test ediniz
        WebElement writeElementYazisi = driver.findElement(By.xpath("//span[text()='Write us']"));

        Assert.assertTrue(writeElementYazisi.isDisplayed());
    }

    //3- mailSend02() methodu olusturunuz
    // sırası ile istenen biligileri doldurunuz.
    @Test
    public void mailSend() {
        driver.findElement(By.xpath("//a[@class='_brlbs-btn _brlbs-btn-accept-all _brlbs-cursor']")).click();

        WebElement adElementi = driver.findElement(By.xpath("(//input[@name='name-1'])[1]"));
        adElementi.sendKeys("meryem");
        WebElement soyadElementi = driver.findElement(By.xpath("(//input[@name='name-2'])[1]"));
        soyadElementi.sendKeys("şerif");
        WebElement sirketadElementi = driver.findElement(By.xpath("(//input[@name='name-3'])[1]"));
        sirketadElementi.sendKeys("wisequarter");
        WebElement sirketSiteElementi = driver.findElement(By.xpath("(//input[@name='name-4'])[1]"));
        sirketSiteElementi.sendKeys("www.wisequarter.com");
        WebElement sirketMailElementi = driver.findElement(By.xpath("(//input[@name='email-1'])[1]"));
        sirketMailElementi.sendKeys("wisegmail.com");
        WebElement sirketTelefonElementi = driver.findElement(By.xpath("(//input[@name='phone-1'])[1]"));
    }
}
