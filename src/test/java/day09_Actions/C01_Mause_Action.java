package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;
import java.util.Set;
public class C01_Mause_Action extends TestBase {
    @Test
    public void test() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get(" https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions =new Actions(driver);
        WebElement ciziliAlanWebElement= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlanWebElement).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAllertYazisi="You selected a context menu";
        String actualAllertYazisi=   driver.switchTo().alert().getText();
        Assert.assertEquals("",expectedAllertYazisi,actualAllertYazisi);
        //5- Tamam diyerek alert’i kapatalim
        ReusableMethods.bekle(2);
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
       // 2.SAYFANIN HANDLE DEĞERİNİ BULMALIYIZ
        Set<String> ikiSayfaWHDSeti=    driver.getWindowHandles();
        String ikinciSayafaWHD="";
        for (String eachWHD:ikiSayfaWHDSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayafaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayafaWHD);
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualYeniSayfaTexti=driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
        String expectedYeniSayfaTexti="Elemental Selenium";
        Assert.assertEquals("Yeni sayfa texti yanlış",expectedYeniSayfaTexti, actualYeniSayfaTexti);
        ReusableMethods.bekle(5);

    }
}