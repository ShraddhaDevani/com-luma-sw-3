package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ManTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        mouseHover(By.xpath("//a[@id='ui-id-5']"));
        //Mouse Hover on Bottoms
        Thread.sleep(2000);
        mouseHover(By.xpath("//a[@id='ui-id-18']"));
        //Click on Pants
        Thread.sleep(1000);
        mouseHoverAndClick(By.id("ui-id-23"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverAndClick(By.xpath("//main[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span"));
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String text = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Invalid text", "You added Cronus Yoga Pant to your shopping cart.", text);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text ‘Shopping Cart.’
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Invalid text", "Shopping Cart", actualText);
        //Verify the product name ‘Cronus Yoga Pant’
        String actualProductName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Cronus Yoga Pant", actualProductName);
        //Verify the product size ‘32’
        String actualProductSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("32", actualProductSize);
        //Verify the product colour ‘Black’
        String actualProductColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Black", actualProductColour);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


