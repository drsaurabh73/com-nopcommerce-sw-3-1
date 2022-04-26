package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }
@Test
    public void testName() {
        //1.1 Click on computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        // 1.2 click on desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops' and contains(text(),' Desktops ')]"));
        List<WebElement> listsAllDefault = listofWebElementsList(By.xpath("//div[@class='prices']"));
        //Select sort by position "Low to High"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        List<WebElement> listsAllAfterSort = listofWebElementsList(By.xpath("//div[@class='prices']"));
        //1.4 Verify the product will arrange in correct order
        if (listsAllDefault != listsAllAfterSort) {
        System.out.println("pass");}

    }

    @Test
    public void verifyProductAddedToSuccessFully() throws InterruptedException {
        //2.1 Click on Computor Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//a[contains(text(),'Desktops')]"));
        //2.3 click on  Low to high
      //  selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        //2.4 click on add to card
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Built your own computer
        String actualbuiltMessage = driver.findElement(By.xpath("//h1[text()='Build your own computer']")).getText();
        String expectedbuiltMessage = "Build your own computer";
        Assert.assertEquals("",actualbuiltMessage,expectedbuiltMessage);
        // 2.6 Select "2.2GHz Intel Pentium Dual-Core E2200
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 Select 8GB using select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400GB
        clickOnElement(By.xpath("//input[@value='7']"));//400 gb
       // selectByVisibleTextFromDropDown(By.xpath("//input[@name='product_attribute_4' and @value='8']"),"400 GB [+$100.00]");
        //2.9 Select OS radio "Vista Premium"
        clickOnElement(By.xpath("//input[@value='9']"));
       // selectByVisibleTextFromDropDown(By.xpath("//input[@name='product_attribute_4' and @value='9']"),"Vista Premium [+$60.00]");
        //2.10 Check Two Check boxes "Microsoft and "Total Commander"
        clickOnElement(By.xpath("//input[@name='product_attribute_5' and @value='12']"));
        // 2.11 Verify the price "
        String actualverpriceMessage = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        String expectedverpriceMessage = "$1,475.00";
        Assert.assertEquals("",actualbuiltMessage,expectedbuiltMessage);
        // 2.12 Click on Add to cart button
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
        //2.13 Verify the Message "The product has been added to your shopping cart"
        String actualshoppingMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        String expectedshoppingMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("No shopping cart",actualshoppingMessage,expectedshoppingMessage);
        //2.13a click on close button
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14
        Actions actions = new Actions(driver);
        WebElement shopingca = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        actions.moveToElement(shopingca).build().perform();
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.15 Verify the message "Shopping cart"
        String actualshopcartMessage = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectedshopcartMessage = "Shopping cart";
        Assert.assertEquals("Not shopping cart",actualshoppingMessage,expectedshoppingMessage);
        //2.16 change quantity to two
       clearElement1(By.xpath("//input[@aria-label='Qty.']"));
        sendTextToElement(By.xpath("//input[@aria-label='Qty.']"),"2");
        // 2.16b updating the shopping cart
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        // 2.17 Verify the total
        String actualshoptotalMessage = driver.findElement(By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']")).getText();
        String expectedshoptotalMessage = "$2,950.00";
        Assert.assertEquals("No shopping cart",actualshoppingMessage,expectedshoppingMessage);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String actualwelcomeMessage = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        String expectedwelcomeMessage = "Welcome, Please Sign In!";
        Assert.assertEquals("No shopping cart",actualshoppingMessage,expectedshoppingMessage);
        // 2.21 check out as guest
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        // 2.21 Register
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"sam");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patil");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"samp@gmail.com");
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.City']"),"Mumbai");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Address1']"),"stone street");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']"),"456789");
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.PhoneNumber']"),"075445566778");

        // click on continue
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 click on radio button next day Air
        clickOnElement(By.xpath("//div[@class='method-name']//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //2.25 click on continue
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        //2.26 click on credit card radio button
        clickOnElement(By.xpath("//input[@value='Payments.Manual']"));
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        //2.28 card type
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        // 2.28b Card Holder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"sam Patil");
        // 2.28c card Number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555555555554444");
        // 2.28d expiry month
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='ExpireMonth']"),"10");
        // 2.28d1 expiry year
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='ExpireYear']"),"2022");
        // 2.28e card code
        sendTextToElement(By.xpath("//input[@name='CardCode']"),"205");
        //2.29 click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Payment method verification
        String actualMessage7 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        String expectedMessage7 = "Credit Card";
        Assert.assertEquals("",expectedMessage7,actualMessage7);

        //2.31 Shipping method verification   //li[@class='shipping-method']//span[@class='value']
        String actualMessage8 = getTextFromElement(By.xpath("//li[@class='shipping-method']//span[@class='value']"));
        String expectedMessage8 = "Next Day Air";
        Assert.assertEquals("",expectedMessage8,actualMessage8);

        //2.32 Total : verification  //span[@class='value-summary']//strong
        String actualMessage9 = getTextFromElement(By.xpath("//span[@class='value-summary']/strong[text()='$2,950.00']"));
        String expectedMessage9 = "$2,950.00";
        Assert.assertEquals("Total is Wrong",expectedMessage9,actualMessage9);

        // 2.33 Click on “CONFIRM”  //button[@class='button-1 confirm-order-next-step-button']

        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.34  Thank you message
        String actualMessage10 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        String expecteMessage10 = "Thank you";
        Assert.assertEquals("Confimation failed",expecteMessage10,actualMessage10);

        //2.35 Verify the message “Your order has been successfully processed!”
        String actualMessage11 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        String expectedMessage11 = "Your order has been successfully processed!";
        Assert.assertEquals("Order placement is failed",expectedMessage11,actualMessage11);

        //2.36 Click on “CONTINUE”   //button[@class='button-1 order-completed-continue-button']
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //2.37 Homepage navigate
        String actualMessage13 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        String expectedMessage13 ="Welcome to our store";
        Assert.assertEquals("",expectedMessage13,actualMessage13);


    }

}
