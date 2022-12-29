package utilies;

public class ReusableMethods {


    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye* 1000L);
        } catch (InterruptedException e) {

        }
    }
}
