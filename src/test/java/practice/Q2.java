package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilies.TestBase;

import static org.junit.Assert.*;

public class Q2<mexicoLinkTest> extends TestBase {
    @Before
    public  void beforTest(){
        //  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
    }
   @Test
    public   void titleTest() {
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String actualSayfaTitle = driver.getTitle();
        String expectedSayfaTitle = "Best";
        assertTrue(actualSayfaTitle.contains(expectedSayfaTitle));
    }
   @Test
   public void logoTest() {
//  Ayrica Relative Locator kullanarak;
//  logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
       WebElement helloLogoElement= driver.findElement(By.xpath("//div[text()='Hello!']"));
       WebElement bestBuylogoElement = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloLogoElement));
       assertTrue("BestBuy Logosu görünmüyor",bestBuylogoElement.isDisplayed());
   }
   @Test
  public void   mexicoLinkTest(){
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
       WebElement uniteLogoElement= driver.findElement(By.xpath("(//img[@Alt='United States'])[1]"));
       WebElement mexicoLinkElement=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(uniteLogoElement));
       assertTrue("mexico link elementi görünmüyor",mexicoLinkElement.isDisplayed());
}}