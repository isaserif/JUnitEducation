package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class CO2_DragAndDrop extends TestBase {
    @Test
    public void test(){
    //1- https://demoqa.com/droppable adresine gidelim
    driver.get("https://demoqa.com/droppable");
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement drogMeElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drogMeElement,dropHereElement).perform();

    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String droppedYaziElement=driver.findElement(By.tagName("p")).getText();
       Assert.assertEquals(droppedYaziElement,"Dropped!");
}
}