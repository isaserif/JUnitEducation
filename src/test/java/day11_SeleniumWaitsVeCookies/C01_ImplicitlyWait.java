package day11_SeleniumWaitsVeCookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {


    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Selenium 4 e kadar 15 saniyeyi belirtmek için
        //Timous class indan saniye tanımlıyorduk
        // Slenium 4 den sonra Duration.ofSeconds(15) oldu




    }
}