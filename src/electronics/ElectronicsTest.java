package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.sql.Timestamp;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/\n";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() {

        Actions actions = new Actions(driver);
        // Electronic ------> Mouse
        WebElement electroincs = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //Mouse Hover on electronics and click on cellphones
        actions.moveToElement(electroincs).build().perform();
        actions.moveToElement(cellphone).click().build().perform();
        //verify the actual and expected results
       String actualtextMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        String expectedMessage = "Cell phones";
        Assert.assertEquals("Text is not cell phone",actualtextMessage,expectedMessage);


    }@Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
       // 2.1 Mouse Hover on Electronics tab
        Actions actions = new Actions(driver);
        // Electronic ------> Mouse
        WebElement electroincs = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //2.2 Mouse Hover on electronics and click on cellphones
        actions.moveToElement(electroincs).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(cellphone).click().build().perform();
        //2.3 verify the actual and expected results
        String actualtextMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        String expectedMessage = "Cell phones";
        Assert.assertEquals("Text is not cell phone",actualtextMessage,expectedMessage);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        Thread.sleep(3000);
        //2.5 click on the text Nokia Lumia 1020
        clickOnElement(By.xpath("//h2[@class='product-title']//a[text()='Nokia Lumia 1020']"));
        //2.6 Verify the text Nokia Lumia 1020
        String actualMessage = driver.findElement(By.xpath("//h1[text()='Nokia Lumia 1020']")).getText();
        String expectedTextMessage ="Nokia Lumia 1020";
       Assert.assertEquals("Incorrect phone name",actualMessage,expectedTextMessage);
       //2.7 Verify the Price $349.00
        String actualpriceMessage = driver.findElement(By.xpath("//span[@id='price-value-20']")).getText();
        String expectedpriceMessage = "$349.00";
        Assert.assertEquals("Incorrect phone price", actualMessage, expectedTextMessage);
        //2.7 Change quantity to two update the cart

        WebElement quantity = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        Thread.sleep(3000);

        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));


        // verify the message the product has been added to the cart
        String actualcartMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        String expectedcartMessage ="The product has been added to your shopping cart";
        Assert.assertEquals("Not added to cart",actualcartMessage,expectedcartMessage);
        // close the message bar
        clickOnElement(By.xpath("//span[@title='Close']"));


       WebElement shopingca = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        actions.moveToElement(shopingca).build().perform();
       Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        String actualqty = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        String expectedqtyMessage= "2";
        Assert.assertEquals("not correct qty",expectedqtyMessage,actualqty);

        // verify the Total $698.00
        String actualtotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        String expectedtotal = "$698.00";
        Assert.assertEquals("value not matching",actualtotal,expectedtotal);
        // click on checkbox of term and condtion
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the text "Welcome Please sign In!"
        String actualWecometext = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        String expectedtext ="Welcome, Please Sign In!";
        Assert.assertEquals("Welcome not received",actualWecometext,expectedtext);
        //2.18 click on register
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 verify the text register
        String actualtextRegister = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        String expectRegister = "Register";
        Assert.assertEquals("not registered",actualtextRegister,expectRegister);
        //2.20 Fill the mandatory field
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Sam");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patil");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String emailAddress = "sam"+timestamp.getTime()+"@domain.com";


        sendTextToElement(By.xpath("//input[@type='email' and @name='Email']"),emailAddress);
        sendTextToElement(By.xpath("//input[@id='Password']"),"123456");
        sendTextToElement(By.xpath("//input[@name='ConfirmPassword']"),"123456");
        // 2.21 click on register button
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.22 Verify this message "your registration complete
        String actualtestRegister = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        String expecttestRegister = "Your registration completed";
        Assert.assertEquals("not registered",actualtestRegister,expecttestRegister);
        //2.23 click on continue
        clickOnElement(By.xpath("//a[text()='Continue']"));
        // 2.24 Verify the text shopping cart
        String actualshoppingcartRegister = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        Thread.sleep(3000);
        String expectshoppingcartRegister = "Shopping cart";
        Assert.assertEquals("not registered",actualshoppingcartRegister,expectshoppingcartRegister);
        // 2.25 click on checkbox of I agree the terms
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26 click on checkout
        clickOnElement(By.xpath("//button[@value='checkout']"));
        //2.27 Fill the Mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"sam");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patil");
      //  sendTextToElement(By.xpath("//input[@name='BillingNewAddress.LastName']"));

       sendTextToElement(By.xpath("//input[@name='BillingNewAddress.LastName']"),emailAddress);



       // sendTextToElement(By.xpath("//input[@name='BillingNewAddress.LastName']"),"spatil@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.City']"),"Mumbai");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Chota chatri");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"456789");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"075445566778");

        //2.28 click on continue
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 click on ratio button
        clickOnElement(By.xpath("//input[@value='2nd Day Air___Shipping.FixedByWeightByTotal']"));
        //2.30 click on continue
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        //2.31 Select Radio button credit card
        clickOnElement(By.xpath("//input[@value='Payments.Manual']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        // 2.32 Select Visa from select credit card dropdown
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='CreditCardType']"),"Visa");
        // 2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@name='CardholderName']"),"sam");
        sendTextToElement(By.xpath("//input[@name='CardNumber']"),"4012888888881881");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2022");
       sendTextToElement(By.xpath("//input[@id='CardCode']"),"205");
        // 2.34 click on "continue checkout"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
       // clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.35 verify the check out
        String actualpaymentRegister = driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText();
        String expectedpaymentRegister = "Checkout";
        Assert.assertEquals("no payment",expectedpaymentRegister,actualpaymentRegister);
        //2.36 verify the Shipping method
        String actualshoppingRegister = driver.findElement(By.xpath("//li[@class='shipping-method']//span[@class='value']")).getText();
        String expectedshoppingRegister = "2nd Day Air";
        Assert.assertEquals("no payment",expectedshoppingRegister,actualshoppingRegister);
        //2.37 verify the Total
        String expectedTotalRegister = "$698.00";
        String actualTotalRegister = driver.findElement(By.xpath("//span[@class='value-summary']/strong[text()='$698.00']")).getText();

        Assert.assertEquals("no payment",expectedTotalRegister,actualTotalRegister);
        // 2.38 click on confirm
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // 2.39 Your order has been successfully processed!
        String actualyourorderRegister = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
        String expectedYourorderRegister = "Your order has been successfully processed!";
        Assert.assertEquals("no payment",expectedYourorderRegister,actualyourorderRegister);
        //2.40 Click on continue
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.41 Verify Welcome to our store - navigate to Homepage
        String actualMessage10 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        String expectedMessage10 = "Welcome to our store";
        Assert.assertEquals("Not on the welcome Home page", expectedMessage10,actualMessage10);
        //2.42 Click on log out
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.43 Verify the URL
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals("Incorrect URL",baseUrl,currentUrl);



    }
    public void tearDown() {
        closeBrowser();
    }

}
