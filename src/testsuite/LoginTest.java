package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*abc@gmail.com
    admin123*/
public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //find login link and click
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("error message", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the login link
        WebElement loginLink1 = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink1.click();
        //enter valid email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc@gmail.com");
        //enter valid password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("admin123");
        //click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        //comparing actual and expected result
        String expectedMessage = "Log out";
        String actualMessage = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        WebElement loginlink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginlink.click();
        //Enter invalid username
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abcd@gmail.com");
        //enter valid password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("1234");
        //click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        //comparing actual and expected result
        String expectedMessage ="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("error", expectedMessage,actualMessage);
        }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
