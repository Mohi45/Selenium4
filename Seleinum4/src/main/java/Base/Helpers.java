package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helpers extends DriverSetUp {
    protected static void logMsg(String message) {
        Reporter.log(getCurrentTime() + " " + message, true);
    }
    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd] [HH:mm:ss:SSS]");
        Date dt = new Date();
        return dateFormat.format(dt);
    }

    public void scrollDown(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public String getRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
