package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'" + menu + "')]"));


    }

    @Test
    public void verifyPageNavigation() {
        List<String> topmenus = new ArrayList<>();
        topmenus.add("Computers");
        topmenus.add("Electronics");
        topmenus.add("Apparel");
        topmenus.add("Digital downloads");
        topmenus.add("Books");
        topmenus.add("Jewelry");
        topmenus.add("Gift Cards");

        for (int i = 0; i < topmenus.size(); i++) {
            selectMenu(topmenus.get(i));
            String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'" + topmenus.get(i) + "')]"));
            Assert.assertEquals("Menu not found", topmenus.get(i), actualMessage);

        }


    }@After
public void tearDown() {
        closeBrowser();
}
}