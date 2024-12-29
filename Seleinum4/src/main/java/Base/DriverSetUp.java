package Base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverSetUp extends Utilities {
    public static WebDriver driver;

    public WebDriver getDriver() {
        cleanDirecotry();
        String browser=readProperty("browser");
        switch (browser){
            case "chrome":
                ChromeOptions options= new ChromeOptions();
                options.addArguments("--start-maximized");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver=new ChromeDriver(options);
                driver.get(readProperty("url"));
        }
        return driver;
    }

@AfterTest
    public void tearDown(){
        driver.close();
    }
}
