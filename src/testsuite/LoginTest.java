package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
/*
userShouldNavigateToLoginPageSuccessfully *
click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
 */

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    /*
    verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
or password.'
     */

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("Prime123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("prime123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class ='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}
