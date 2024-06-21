package com.marsair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBDD {
    private WebDriver driver;

    @FindBy(id="departing")
    public WebElement departing;

    @FindBy(id="returning")
    public WebElement returning;

    @FindBy(id = "search")
    private WebElement searchButton;

    @FindBy(id = "result")
    private WebElement resultMessage;

    @FindBy(id = "promoCode")
    private WebElement promoCodeField;

    @FindBy(id = "promoMessage")
    private WebElement promoMessage;

    public HomePageBDD(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDeparture(String departure) {
        departing.sendKeys(departure);
    }

    public void enterReturn(String returnDate) {
        returning.sendKeys(returnDate);
    }

    public void enterPromoCode(String promoCode) {
        promoCodeField.sendKeys(promoCode);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public String getPromoMessage() {
        return promoMessage.getText();
    }
}
