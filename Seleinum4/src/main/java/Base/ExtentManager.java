package Base;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeSuite;

import javax.imageio.ImageIO;

public class ExtentManager extends DriverSetUp{
    public static String screenshotName;
    @BeforeSuite
    public static ExtentReports createInstance(String fileName) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        ExtentReports extent = new ExtentReports();
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Release No", "01");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Automation Code By", "Mohit Kumar");

        return extent;
    }


    public static void captureScreenshot() throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot)driver;

        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedImage resizedImage=resizeImageWithGraphics2D(originalImage,600,800);
        ImageIO.write(resizedImage, "png", src);
        try
        {
            Date d = new Date();
            screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
            FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
            System.out.println("Successfully captured a screenshot");
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
    public static BufferedImage resizeImageWithGraphics2D(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();

        // Set RenderingHint for better quality
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();

        return resizedImage;
    }
}
