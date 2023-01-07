package day13_WriteExce_Screenshot;

import org.junit.Test;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.io.IOException;

import static org.junit.Assert.*;

public class C04_TakeSSSTumSayfa extends TestBase {

    @Test

    public void test01() throws IOException {

      // wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");
      // ana sayfaya gittiğinizi test edin
        String expectedTitleKelime="Wise";
        String actualTitle= driver.getTitle();
        assertTrue(actualTitle.contains(expectedTitleKelime));
      // tüm sayfa screenshot alın

        ReusableMethods.tumSayfaScreenshotCek(driver);

    }

}
