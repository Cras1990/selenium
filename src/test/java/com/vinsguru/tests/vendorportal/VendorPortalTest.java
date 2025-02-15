package com.vinsguru.tests.vendorportal;

import com.vinsguru.pages.vendorportal.DashboardPage;
import com.vinsguru.pages.vendorportal.LoginPage;
import com.vinsguru.tests.vendorportal.model.VendorPortalTestData;
import com.vinsguru.tests.AbstractTest;
import com.vinsguru.util.Config;
import com.vinsguru.util.Constants;
import com.vinsguru.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath){
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);
    }

    @Test
    public void loginTest(){
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());

    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest(){

        Assert.assertTrue(dashboardPage.isAt());

        //finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarningElement(),testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarningElement(),testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMarginElement(),testData.profitMargins());
        Assert.assertEquals(dashboardPage.getAvailableInventoryElement(),testData.availableInventory());

        // order history search
        dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashboardPage.getResultsCount(), testData.searchResultCount());

        //logout
        dashboardPage.logout();

    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest(){
        Assert.assertTrue(loginPage.isAt());
    }

}
