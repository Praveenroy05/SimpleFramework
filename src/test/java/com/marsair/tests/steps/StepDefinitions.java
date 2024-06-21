package com.marsair.tests.steps;

import com.marsair.pages.HomePageBDD;
import com.marsair.tests.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions extends BaseTest {
    private WebDriver driver;
    private HomePageBDD homePage;

    @Before
    public void setUp() {
        driver = initializeWebDriver();
        homePage = new HomePageBDD(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the MarsAir home page")
    public void i_am_on_the_marsair_home_page() {
        driver.get("https://google.com"); // Replace with actual MarsAir application URL
        // Replace with actual MarsAir application URL
    }

    @When("I enter {string} into the departure field")
    public void i_enter_into_the_departure_field(String departure) {
        homePage.enterDeparture(departure);
    }

    @When("I enter {string} into the return field")
    public void i_enter_into_the_return_field(String returnDate) {
        homePage.enterReturn(returnDate);
    }

    @When("I enter {string} into the promotional code field")
    public void i_enter_into_the_promotional_code_field(String promoCode) {
        homePage.enterPromoCode(promoCode);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        homePage.clickSearch();
    }

    @Then("I should see a message indicating whether seats are available")
    public void i_should_see_a_message_indicating_whether_seats_are_available() {
        String result = homePage.getResultMessage();
        Assert.assertTrue(result.contains("Seats available!") || result.contains("Sorry, there are no more seats available."));
    }

    @Then("I should see a promotional message indicating a {int}% discount")
    public void i_should_see_a_promotional_message_indicating_a_discount(Integer discount) {
        String promoMessage = homePage.getPromoMessage();
        Assert.assertTrue(promoMessage.contains("Promotional code used: " + discount + "% discount!") ||
                promoMessage.contains("Sorry, code is not valid"));
    }

    @Then("I should see a message indicating the schedule is not possible")
    public void i_should_see_a_message_indicating_the_schedule_is_not_possible() {
        String result = homePage.getResultMessage();
        Assert.assertTrue(result.contains("Unfortunately, this schedule is not possible. Please try again."));
    }





}
