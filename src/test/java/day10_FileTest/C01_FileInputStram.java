package day10_FileTest;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileInputStram {
    @Test
public void test01() throws FileNotFoundException {
        String dosyaYolu= "C:\\desktop\\meryemin yazı defteri.DOCX";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        /*
        File testlerinde genellikle dowloads a indirilecek
         bir dosyanın indirildiğinde test etmek ve ya masaüstündeki
         bir dosyanın web e yüklendiğini test etmek isteriz.
            Ancak herkesin bilgisayarının ismi kullanıcı isimleri gibi farklılıklar
            olacağından testler tek bir bilgisayarda çalışacak gibi yazılmak zorunda kalınır.

        Bu karışıklığın önüne gecebilmek için java 2 basit kod bloğu sunmuş
         */

        System.out.println(System.getProperty("user.dir"));



        System.out.println(System.getProperty("user.home"));

        // kullanicinin temel path'ini verir.
        // /Users/ahmetbulutluoz
        // Masaustune gitmek istersek
        // C:\Users\90530 + /Desktop eklememiz yeterlidir
        // Downloads'a gitmek istersek
        // C:\Users\90530 + /Downloads eklememiz yeterlidir
        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde
        // olustururuz

        String dinamikDosyaYolu=System.getProperty("user.home" +" /meryemin yazı defteri.DOCX");
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
