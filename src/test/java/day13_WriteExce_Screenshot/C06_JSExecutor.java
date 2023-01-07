package day13_WriteExce_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBase;

public class C06_JSExecutor extends TestBase {

    @Test
    public void test01() {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // sell linkine JS executor kullanarak click yapin
        WebElement sellLinki = driver.findElement(By.xpath("//a[text()='Sell']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", sellLinki);

        jse.executeScript("alert('Bu is bu kadar')");
        ReusableMethods.bekle(3);
    }
}
