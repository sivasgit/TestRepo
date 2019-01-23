package screenShot;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListerner.class)
public class ScreenShot extends Base {

    @BeforeMethod
    public void setUp(){
        initialization();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void loginTest(){
        Assert.assertEquals(false,true);
    }
    @Test
    public void contactTest(){
        Assert.assertEquals(false,true);
    }@Test
    public void clickTest(){
        Assert.assertEquals(false,true);
    }


    }

