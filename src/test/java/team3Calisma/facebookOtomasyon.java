package team3Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class facebookOtomasyon {
    static WebDriver driver;
    //1- Ayarları yapınız
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.close();
    }

        @Test
    public void login(){

        driver.get("https://www.facebook.com/");
   WebElement loginButton= driver.findElement(By.xpath("//input[@id='email']"));
   loginButton.sendKeys("0530 842 84 03");

            WebElement passwordButton= driver.findElement(By.xpath("//input[@type='password']"));
            passwordButton.sendKeys("123qweasdzxc");

            driver.findElement(By.xpath("//button[@name='login']")).click();


        }




}
