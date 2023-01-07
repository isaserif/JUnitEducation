package team3Calisma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.ReusableMethods;
import utilies.TestBase;

import static org.junit.Assert.*;

public class kiwicom_Junit extends TestBase {
   static Select select;
    @Test
    public void test01() {
        //   https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");
        // Cookies i reddedin
       driver.findElement(By.xpath("//button[@aria-label='Kapat']")).click();
        // Kayfa basliginin "kiwi" icerdigini test edin
        String expectedKelime="Kiwi";
        String actualTitle=driver.getTitle();
        assertTrue(actualTitle.contains(expectedKelime));

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        // Sectiginiz dil ve para birimini dogrulayin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveIconContainer__" +
                "StyledButtonPrimitiveIconContainer-sc-8rx3cv-0 fxbcmo'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='CountryFlag__StyledShadow-sc-ltfn8f-2 jxwlrI'])[2]")).click();
        WebElement dropdownDil= driver.findElement(By.xpath("//select[@*='LanguageSelect']"));
        WebElement dropdownPara=driver.findElement(By.xpath("//select[@*='CurrencySelect']"));

        select=new Select(dropdownDil);
        select.selectByVisibleText("Türkçe");
        
        select=new Select(dropdownPara);
        select.selectByVisibleText("Turkish lira - TRY");


        driver.findElement(By.xpath("//div[text()='Kaydet ve devam et']")).click();
        // Ucus secenegi olarak tek yon secelim
        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

        ReusableMethods.bekle(3);

    }
}
