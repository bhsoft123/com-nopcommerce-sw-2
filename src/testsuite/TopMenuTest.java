package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    //different methods to navigate to Top Menu selection and to compare text
    public void userShouldNavigateToComputerPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        String expectedText = "Computers";
        String actualText =driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).getText();
        Assert.assertEquals("error", expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
        String expectedText="Electronics";
        String actualText = driver.findElement(By.xpath("//a[text()='Electronics ']")).getText();
        Assert.assertEquals("Error", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//a[text()='Apparel ']")).click();
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//a[text()='Apparel ']")).getText();
        Assert.assertEquals("Error",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//a[text()='Digital downloads ']")).click();
        String expectedText = "Digital downloads";
        String actualText= driver.findElement(By.xpath("//a[text()='Digital downloads ']")).getText();
        Assert.assertEquals("Error", expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//a[text()='Books ']")).click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//a[text()='Books ']")).getText();
        Assert.assertEquals("Error", expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//a[text()='Jewelry ']")).click();
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//a[text()='Jewelry ']")).getText();
        Assert.assertEquals("Error",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).getText();
        Assert.assertEquals("Error", expectedText,actualText);
    }
@After
    public void teardown(){
        closeBrowser();
}
}
