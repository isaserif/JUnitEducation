package day08_HandlingWindows;

import org.junit.Test;
import utilies.ReusableMethods;
import utilies.TestBase;

public class C04_TaseBaseIlkTest extends TestBase {
@Test
public void test01(){
    driver.get("https://www.amazon.com");

   ReusableMethods.bekle(3);
}



}
