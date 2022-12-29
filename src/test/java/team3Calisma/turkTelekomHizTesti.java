package team3Calisma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class turkTelekomHizTesti {
static WebDriver driver;
static     Actions action;
//1- Ayarları yapınız
@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@AfterClass
    public static void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.close();
}
@Test
    public void test1() throws InterruptedException {

    driver.get("https://hiztesti.turktelekom.com.tr/");

    WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@width='100%']"));

    driver.switchTo().frame(iframeElementi);

    driver.findElement(By.xpath("//span[text()='Başlat']")).click();
    Thread.sleep(40000);

   String dowlandTexti= driver.findElement(By.xpath("(//div[@class='number monochrome-primary'])[3]")).getText();
  double dowlantInt=Double.parseDouble(dowlandTexti);
  int expectedHiz=10;
  Assert.assertTrue("hız 10 in altındadır",dowlantInt>=expectedHiz);

    driver.switchTo().defaultContent();
    System.out.println("dışarda");
}
}
