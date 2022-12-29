package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C02_WindowHandles {
    static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        String ilkSayfaWHD= driver.getWindowHandle();
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualSayfaText=driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        String expectedText="Opening a new window";
        Assert.assertEquals("sayfa texti doğru değil",actualSayfaText, expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualSayfaTitle=driver.getTitle();
        String expectedSayfaTitle="The Internet";
        Assert.assertEquals("sayfa başlığı dogru degil",expectedSayfaTitle, actualSayfaTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(3000);

        //● tüm sayfaların handle değerini alıyoruz
        Set<String> handleDegerlerListesi=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD:handleDegerlerListesi
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String actualYeniSayfaTitle=driver.getTitle();
        String expectedYeniSayfaTitle="New Window";
        Assert.assertEquals("yeni sayfanın başlığı dogru değil",expectedYeniSayfaTitle,actualYeniSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualYeniSayfaTexti=driver.findElement(By.xpath("//div[@class='example']")).getText();
        System.out.println(actualYeniSayfaTexti);
        String expectedYeniSayfaTexti="New Window";
        Assert.assertEquals("yeni sayfa texti doğru değil",expectedYeniSayfaTexti,actualYeniSayfaTexti);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
         actualSayfaTitle=driver.getTitle();
         expectedSayfaTitle="New Window";
        Assert.assertEquals("sayfa başlığı dogru degil",expectedSayfaTitle, actualSayfaTitle);

    }
}