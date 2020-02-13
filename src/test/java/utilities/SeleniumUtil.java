package utilities;

import java.util.TreeMap;

public class SeleniumUtil {
    public static void pause(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
