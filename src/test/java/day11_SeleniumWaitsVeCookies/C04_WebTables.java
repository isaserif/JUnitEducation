package day11_SeleniumWaitsVeCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01() {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        WebElement tumbody = driver.findElement(By.xpath("//tbody"));

        //4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> satirlarListsi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10, satirlarListsi.size());

        //5.Tum satirlari yazdirin
        for (WebElement eachRow : satirlarListsi
        ) {
            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> ucuncuSatirListesi = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals("satır satısı 13 değil", 13, ucuncuSatirListesi.size());
        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunElemetleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("***********************");
        for (WebElement eachElenet : besinciSutunElemetleri
        ) {
            System.out.println(eachElenet.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi döndüren bir method olusturun

        WebElement istenenDataElementi = getElement(5, 7);

        System.out.println(istenenDataElementi.getText());

        ReusableMethods.bekle(3);
    }

    private WebElement getElement(int satir, int sutun) {

        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";


        return driver.findElement(By.xpath(dinamikXpath));
    }
}
