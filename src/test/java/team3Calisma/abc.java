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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class abc {
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown() {
        driver.close();
    }
    @Test
    public void test1() {
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement usernameElementi = driver.findElement(By.id("user_login"));
        usernameElementi.sendKeys("username");
        //4. Password kutusuna “password.” yazin
        WebElement passElementi = driver.findElement(By.id("user_password"));
        passElementi.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencydropdown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currencydropdown);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2000");
        //10. “US Dollars” in secilmedigini test edin
        WebElement secim$ = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse("seçili dolarlar", secim$.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        WebElement atama = driver.findElement(By.id("alert_content"));
        String atamaStr = atama.getText();
        String expectedKelime = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(atamaStr, expectedKelime);

    }
}
