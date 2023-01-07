package day10_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBase;

public class C03_FileUpload extends TestBase {
@Test
    public void test01(){
//2. https://the-internet.herokuapp.com/upload adresine gidelim
    driver.get("https://the-internet.herokuapp.com/upload");
//3. chooseFile butonuna basalim
//4. Yuklemek istediginiz dosyayi secelim.

    /*
    Bu görevi yapabilmek için chooseFile butonuna basıldığında
    acılan bilgisayarımızdaki file dosyalarını click yapabilmemiz gerekir.
    ancak selenium bilgisayarımızdaki dosyaları click yapamaz.


      bunun yerine söyle bir çözüm üretilmiş

      1- chooseFile butonunu locate edin
      2- upload edilecek dosyanın dosya yolunu oluşturun
      3- choseFile butonuna sendKeys ile dosya yolunu gönderin
     */
WebElement chooseFileButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));

String dosyaYolu="C:\\desktop\\meryem.txt";
chooseFileButonu.sendKeys(dosyaYolu);


//5. Upload butonuna basalim.
    driver.findElement(By.id("file-submit")).click();
//6. “File Uploaded!” textinin goruntulendigini test edelim.
    WebElement fileUpdateElementi=driver.findElement(By.id("uploaded-files"));
ReusableMethods.bekle(3);
  Assert.assertTrue(fileUpdateElementi.isDisplayed());


}}
