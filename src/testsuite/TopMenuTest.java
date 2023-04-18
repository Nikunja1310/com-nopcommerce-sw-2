package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[@href='/computers' and text()='Computers ']")).click();


        WebElement actualElement = driver.findElement(By.xpath("//h1[text()='Computers']"));        //Verify text = COMPUTERs
        String actualText = actualElement.getText();                                 //Actual = .getText();
        String expectedText = "Computers";                                           //Expected

        Assert.assertEquals("Computers Text is displayed correctly, no error", actualElement, expectedText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Electronics']")).getText();
        String expectedText = "Electronics";

        Assert.assertEquals("Electronic Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        String expectedText = "Apparel";

        Assert.assertEquals("Apparel Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }

    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        String expectedText = "Digital downloads";

        Assert.assertEquals("Digital downloads Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }

    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        String expectedText = "Books";

        Assert.assertEquals("Books Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        String expectedText = "Jewelry";

        Assert.assertEquals("Jewelry Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).click();  //Find and click on the Electronics

        //Try Finding Element and Also using .getTExt(); in same line with STRING
        String actualText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        String expectedText = "Gift Cards";

        Assert.assertEquals("Gift Cards Text is displayed correctly, no error", expectedText, actualText); // Matches hence no error
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}