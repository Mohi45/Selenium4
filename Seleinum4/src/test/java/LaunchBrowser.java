import Base.DriverSetUp;
import Base.Helpers;
import Base.Utilities;
import org.Pages.ElementsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.util.Random;

public class LaunchBrowser {

    ElementsPage elementsPage=new ElementsPage();

    @Test
    public void clickOnElements(){
        elementsPage.clickOnElementsButton();
        elementsPage.clickOnTexBox();
        elementsPage.enterDetails();
    }


}
