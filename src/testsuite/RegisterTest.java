package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        String expectedText = "Register";
        Assert.assertEquals("Register text Matches, no error found", expectedText, actualText);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[starts-with(@class,'ico-r')]")).click();       //* click on the ‘Register’ link -starts with method
        driver.findElement(By.xpath("//input[contains(@type,'radio') and (@id='gender-female')]")).click();     //Select gender radio button
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Niks");  //Enter name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Senjalia");  //Enter name

        //Select BD
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("13");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("October");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1991");

        //Email
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("nikkisen13@gmail.com");
        //Password
        driver.findElement(By.xpath("//input[@name='Password' or @data-val-regex='<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters</li></ul>']")).sendKeys("Niks123");
        //Confirm
        driver.findElement(By.xpath("//input[starts-with(@id,'ConfirmPassword')]")).sendKeys("Niks123");
        //Click on register
        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();

        //* Verify the text 'Your registration completed’

        String actualText = driver.findElement(By.xpath("//div[contains(@class,'res') and  text()='Your registration completed']")).getText();
        String expectedText = "Your registration completed";
        Assert.assertEquals("Verified, no error",expectedText,actualText);//compare

    }

    @After
    public void tearDown(){
    closeBrowser();
    }
}
