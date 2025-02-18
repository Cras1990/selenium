package com.vinsguru.pages.flightreservation;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement confirmationSection;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton));
        return this.goToFlightsSearchButton.isDisplayed();
    }

    public void goToFlightsSearch(){
        this.goToFlightsSearchButton.click();
    }

    public String getFirstName(){
        return this.confirmationSection.getText();
    }


}
