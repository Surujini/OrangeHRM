package com.automation.orangehrm.tests;

import com.automation.orangehrm.pages.AdminPage;
import com.automation.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTests extends BaseTest{


    LoginPage loginPage;
    AdminPage adminPage;

    public void startTest(){
        loginPage.usernameInput("Admin");
        loginPage.passwordInput("admin123");
        loginPage.clickSubmitButton();
        adminPage.clickAdminLink();
    }

    @Test
    public void usernameSearchTest(){
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);

        startTest();

        adminPage.searchUsernameInput("Admin");
        adminPage.clickOnSearchSubmitButton();

        Assert.assertEquals(adminPage.getUsernameResults(), "Admin", "Username Results is incorrect");
    }

    @Test
    public void userRoleTest(){
        adminPage = new AdminPage(driver);

        startTest();

        adminPage.selectUserRoles("ESS");
    }



}
