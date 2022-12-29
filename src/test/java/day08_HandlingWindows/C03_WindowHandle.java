package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {
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
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWHD = driver.getWindowHandle();
// elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        // Tüm sayfaların hadles değerlerini alalım
        Set<String> tumSayfalarinWHD = driver.getWindowHandles();
        String ikinciSayfaWHD = "";
        for (String eachWHD : tumSayfalarinWHD
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
// yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String ecpectedIkinciSayfaText = "Elemental Selenium";
        String actualIkinciSayfaText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("ikinci sayfa yazısı doğru değil", ecpectedIkinciSayfaText, actualIkinciSayfaText);
// ilk sayfaya geri donup sayfadaki yazinin
        driver.switchTo().window(ilkSayfaWHD);
// "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        String actualIlkSayfaText = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedIlkSaydaText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals("ilk sayfa yazısı doğru değil", expectedIlkSaydaText, actualIlkSayfaText);
    }
}