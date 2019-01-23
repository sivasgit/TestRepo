package screenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Base {
    public static WebDriver driver;
    public static void initialization(){
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
       // driver.findElement(By.xpath("//a[contains(text(),'Gamail')]")).click();
    }
    public void failed(String methodName) throws IOException {
        File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("J:\\ScreenshotTest\\src\\test\\java\\"
                +"errorpics\\"+methodName+
                "_"+".jpg"));
    }
}
