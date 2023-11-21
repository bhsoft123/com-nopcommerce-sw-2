package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //find Register element
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //compare actual and expected text
        String exptectedText = "Register";
        String actualText = driver.findElement(By.xpath("//a[@class='ico-register']")).getText();
        Assert.assertEquals("Error",exptectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //find Register element
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //find and click on male or female radio button
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='M']"));
        radio1.click();
        //find Firstname element and enter Firstname
        driver.findElement(By.id("FirstName")).sendKeys("abcd");
        //find Lastname element and enter Lastname
        driver.findElement(By.id("LastName")).sendKeys("efg");
        //find DOB element and select DOB
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("January");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1990");
        //Random number generator to generate different email address combination
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        //find Email element and enter randomly generated email each time execution is done
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc" +randomInt+ "@gmail.com");
        //find Company element and enter Company name
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("xyz corp ltd");
        //find Newletter checkbox and click on it
        driver.findElement(By.id("Newsletter")).click();
        //find Password element and enter password
        driver.findElement(By.id("Password")).sendKeys("admin123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("admin123");
        //find Register Button element and click on it
        driver.findElement(By.id("register-button")).click();
    }
    @After
    public void teardown(){
        closeBrowser();
    }

}
