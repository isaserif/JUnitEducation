package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    static WebDriver driver;
    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
      //  driver.close();
    }
    @Test
    public void test(){
        // a. Verilen web sayfasına gidin.
        //     https://facebook.com
        driver.get("https://facebook.com");
        // b. Cookies’i kabul edin varsa
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
    }


}
