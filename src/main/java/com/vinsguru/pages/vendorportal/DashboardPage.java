package com.vinsguru.pages.vendorportal;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePictureElement;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal > div > div > div.modal-footer > a")
    private WebElement modelLogoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningElement));
        return this.monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarningElement() {
        return monthlyEarningElement.getText();
    }

    public String getAnnualEarningElement() {
        return annualEarningElement.getText();
    }

    public String getProfitMarginElement() {
        return profitMarginElement.getText();
    }

    public String getAvailableInventoryElement() {
        return availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword){
        this.searchInput.sendKeys(keyword);
    }

    public int getResultsCount(){
        String resultText = this.searchResultsCountElement.getText();
        String[] arr = resultText.split(" ");
        int count = Integer.parseInt(arr[5]);
        logger.info("Results count: {}", count);
        return count;
    }

    public void logout(){
        this.userProfilePictureElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.modelLogoutButton));
        this.modelLogoutButton.click();
    }
}
