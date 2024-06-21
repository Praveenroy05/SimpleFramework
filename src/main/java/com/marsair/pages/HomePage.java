package com.marsair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    WebDriverWait wait ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(id="departing")
    public WebElement departing;

    @FindBy(id="returning")
    public WebElement returning;
    private By departureField = By.id("departing");
    private By returnField = By.id("returning");
    private By searchButton = By.xpath("//input[@type='submit']");
    public By successMessage = By.xpath("//p[text()='Seats available!']");
    private By promoCodeField = By.id("promotional_code");
    private By promoMessage = By.xpath("//p[@class='promo_code']");

    public By failedMessage = By.xpath("//p[contains(text(),'Unfortunately')]");




    public void enterDeparture(String value) throws InterruptedException {
        WebElement departureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(departureField));
        Select select= new Select(departing);
        select.selectByValue(value);
    }

    public void enterReturn(String returnDate) {
        WebElement returningElement = wait.until(ExpectedConditions.visibilityOfElementLocated(returnField));

        Select select = new Select(returningElement);
        select.selectByValue(returnDate);
    }

    public void enterPromoCode(String promoCode) {
        driver.findElement(promoCodeField).sendKeys(promoCode);
    }

    public void clickSearch() {
        WebElement departureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));

        driver.findElement(searchButton).click();
    }

    public String getResultMessage(By element) {
        WebElement departureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public String getPromoMessage() {
        WebElement departureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(promoMessage));
        return driver.findElement(promoMessage).getText();
    }
}
