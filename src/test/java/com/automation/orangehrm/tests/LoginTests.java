package com.automation.orangehrm.tests;

import com.automation.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LoginTests extends BaseTest{

    LoginPage loginPage;

    @Test()
    public void loginTest(){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput("Admin");
        loginPage.passwordInput("admin123");
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.dashboardGetText(), "Dashboard", "Login was not successful");

    }

    @Test(dataProvider = "loginValues")
    public void loginNegativeTest(String username, String password){
        loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.loginPageGetText(), "Login", "User is not on the login Page");

        loginPage.usernameInput(username);
        loginPage.passwordInput(password);
        loginPage.clickSubmitButton();

        Assert.assertEquals(loginPage.errorMessage(), "Invalid credentials", "Login was not successful");

    }


@DataProvider(name = "loginValues")
    public Object [][] loginData(){
        return new Object[][] {
                {"Surujini", "admin123"},
                {"Admin", "kdjut"},
                {"Surujini", "1hj27g"}
        };
}


}
