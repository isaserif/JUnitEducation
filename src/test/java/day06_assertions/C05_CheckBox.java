package day06_assertions;

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
import java.util.List;

public class C05_CheckBox {
//  Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    static WebDriver driver;
    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  a. Verilen web sayfasına gidin.
        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.close();
    }
@Test
    public void test_01(){
    //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
    WebElement checkBox1=  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkBox2=  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    //  c. Checkbox1 seçili değilse onay kutusunu tıklayın ve seçili olduğunu test edin

    if (!checkBox1.isSelected()){
        checkBox1.click();
    }
    Assert.assertTrue(checkBox1.isSelected());
    //  d. Checkbox2 seçili değilse onay kutusunu tıklayın ve seçili olduğunu test edin
if (!checkBox2.isSelected()){
    checkBox2.click();
}
    Assert.assertTrue(checkBox2.isSelected());




}






}

