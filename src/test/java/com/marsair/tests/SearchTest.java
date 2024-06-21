package com.marsair.tests;

import com.marsair.pages.BasePage;
import com.marsair.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test(priority = 0)
    public void testBasicSearchFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.enterDeparture("0");
        homePage.enterReturn("5");
        homePage.clickSearch();
        String result = homePage.getResultMessage(homePage.successMessage);
        Assert.assertTrue(result.contains("Seats available!") || result.contains("Sorry, there are no more seats available."));
    }

    @Test(priority = 1)
    public void testPromotionalCodes() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.enterDeparture("0");
        homePage.enterReturn("5");
        homePage.enterPromoCode("AF3-FJK-418");
        homePage.clickSearch();
        String promoMessage = homePage.getPromoMessage();
        Assert.assertTrue(promoMessage.contains("Promotional code AF3-FJK-418 used: 30% discount!") ||
                promoMessage.contains("Sorry, code AF3-FJK-418 is not valid"));
    }

    @Test(priority = 2)
    public void testInvalidReturnDates() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.enterDeparture("0");
        homePage.enterReturn("1");
        homePage.clickSearch();
        String result = homePage.getResultMessage(homePage.failedMessage);
        Assert.assertTrue(result.contains("Unfortunately, this schedule is not possible. Please try again."));
    }

    @Test(priority = 3)
    public void testHomePageLink() {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = basePage.goToHomePage();
        Assert.assertNotNull(homePage);
    }
}
