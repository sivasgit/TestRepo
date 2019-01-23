package dateTimePicker;


    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class MultiDateDateTimePicker {

        private String demosite = "http://spicejet.com";
                //"http://jqueryui.com/resources/demos/datepicker/other-months.html";

        WebDriver browser;
        WebDriverWait wait;

        @BeforeTest
        public void startTest() {

            // Launch the demo site to handle date time picker.
            System.setProperty("webdriver.gecko.driver","C:\\Driver\\geckodriver.exe");
            browser = new FirefoxDriver();
            browser.manage().window().maximize();
            browser.navigate().to(demosite);
        }

        @Test
        public void jQueryCalendarMultipleMonths() throws InterruptedException {

            // Start the date time picker demo website.
            browser.navigate().to(demosite);

            // click to open the date time picker calendar.
            WebElement calElement = browser.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
            calElement.click();

            // Provide the day of the month to select the date.
            SelectDayFromMultiDateCalendar("3");
        }

        // Function to select the day of month in the date picker.
        public void SelectDayFromMultiDateCalendar(String day)
                throws InterruptedException {

            // We are using a special XPath style to select the day of current
            // month.
            // It will ignore the previous or next month day and pick the correct
            // one.
            By calendarXpath = By
                    .xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
                            + day + "']");
            browser.findElement(calendarXpath).click();

            // Intentional pause for 2 seconds.
            Thread.sleep(3000);
        }

        @AfterTest
        public void endTest() {
            browser.quit();
        }
    }
   // You can test the above code by creating a project in Eclipse and adding the above file. If you want to learn it from scratch, then read tutorials from the Selenium Webdriver Tutorials section on our blog.



/*2- How To Handle JQuery Date Time Picker Control In An IFRAME?
    jQuery data picker is quite popular among large no. of websites who use it to improve their user experience. It’s also very common when you need to handle the date time picker in an IFRAME.

    So, we are taking on this problem in the below example. Here, the date picker appears in an IFRAME, so you need to switch to the frame first before hitting any Webdriver command. After that, you click on the date picker to open the calendar. Then, you loop through the array of date values to spot the expected date and click to select it.

    At the end of the test, there is a little trick given which sets the -ve Y-coordinates and scrolls the page in the upward direction.

    Sample Code – Handle JQuery Date Time Picker In IFRAME.
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class jQueryDateTimePicker {

        private String demosite = "http://jqueryui.com/datepicker/";

        WebDriver browser;
        WebDriverWait wait;

        @BeforeTest
        public void startTest() {

            // Launch the demo site to handle date time picker.
            browser = new FirefoxDriver();
            browser.manage().window().maximize();
            wait = new WebDriverWait(browser, 5);
        }

        @Test
        public void SelectDateFromJQueryCalendar() throws InterruptedException {

            // Start the date time picker demo website.
            browser.navigate().to(demosite);

            // click to open the date time picker calendar.
            WebElement frameElement = browser.findElement(By
                    .className("demo-frame"));
            browser.switchTo().frame(frameElement);

            By dtp = By.xpath(".//*[@id='datepicker']");
            wait.until(ExpectedConditions.presenceOfElementLocated(dtp));
            browser.findElement(dtp).click();

            // Provide the day of the month to select the date.
            HandleJQueryDateTimePicker("22");
        }

        // Function to select the day of the month in the date picker.
        public void HandleJQueryDateTimePicker(String day)
                throws InterruptedException {

            wait.until(ExpectedConditions.presenceOfElementLocated(By
                    .id("ui-datepicker-div")));
            WebElement table = browser.findElement(By
                    .className("ui-datepicker-calendar"));
            System.out.println("JQuery Calendar Dates");

            List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
            for (WebElement row : tableRows) {
                List<WebElement> cells = row.findElements(By.xpath("td"));

                for (WebElement cell : cells) {
                    if (cell.getText().equals(day)) {
                        browser.findElement(By.linkText(day)).click();
                    }
                }
            }

            // Switch back to the default screen again and scroll up by using
            // the negative y-coordinates.
            browser.switchTo().defaultContent();
            ((JavascriptExecutor) browser).executeScript("scroll(0, -250);");

            // Intentional pause for 2 seconds.
            Thread.sleep(2000);
        }

        @AfterTest
        public void endTest() {
            browser.quit();
        }
    }*/
//}
