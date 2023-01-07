package day13_WriteExce_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.io.IOException;

import static org.junit.Assert.*;

public class C05_IstenenElemetSS extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // Nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // Sonuclarin nutella icerdigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        assertTrue(actualAramaSonucu.contains(expectedKelime));
        // arama sonuc elementinin screenshot'ini cekin

        ReusableMethods.elementSSCek(aramaSonucElementi);
    }




}
