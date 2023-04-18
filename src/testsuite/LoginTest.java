package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. LoginTest
 * 2. TopMenuTest
 * 3. RegisterTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 * * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 * * click on the ‘Login’ link
 * * Enter valid username
 * * Enter valid password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Log out’ text is display
 * 3. verifyTheErrorMessage
 * * click on the ‘Login’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */
public class LoginTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click =Login link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //Verify  text So assign a String reference var = ‘Welcome, Please Sign In!’
        String expectedMessage = "Welcome, Please Sign In!";

        //find X-path for Welcome
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        //Write  .getText(); Ref String Actual message
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on =  Login link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Enter valid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nikki.sen13@gmail.com");
        // Enter valid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Nikki123");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit' and @class='button-1 login-button']")).click();

        // Verify the ‘Log out’ text is display
        WebElement actualElement = driver.findElement(By.xpath("//a[text()='Log out']"));
        String actualText = actualElement.getText(); // Actual
        String expectedText = "Log out";    // Expected
        Assert.assertEquals("User not Login Successfully", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click = Loginlink
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nikssen13@gmail.co");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Nik");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();

        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’

        String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        //Compare
        Assert.assertEquals("Message not displayed correctly", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}