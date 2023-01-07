package practice;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import static org.junit.Assert.*;

public class Q3 extends TestBase {
    static Actions actions;
     static Faker faker=new Faker();

    @Before
    public void urlTest(){
    // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
    @Test
    public void pageDogrulama() {
//3. Verify that home page is visible successfully
        WebElement automationExerciseElement= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        assertTrue(automationExerciseElement.isDisplayed());

    }
    @Test
    public void contactUsClick() {
//4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@style='color: orange;']")).click();
//5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        assertTrue(getInTouch.isDisplayed());
    }

        @Test
    public void mesajTest() {
        actions=new Actions(driver);
        String mesajim="merhabalar nasılsınız";
//6. Enter name, email, subject and message
         driver.findElement(By.xpath("(//div[@class='form-group col-md-6'])[1]")).click();
            actions.sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys("mesajım")
                    .sendKeys(Keys.TAB)
                    .sendKeys(mesajim).perform();

        }
//7. Upload file
//8. Click 'Submit' button
//9. Click OK button
//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//11. Click 'Home' button and verify that landed to home page successfully
//




}
