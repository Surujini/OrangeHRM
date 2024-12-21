package com.automation.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String loginPageGetText(){
        By loginPageBy = By.xpath("//h5");
        WebElement loginPage = driver.findElement(loginPageBy);

        return loginPage.getText();
    }

    public void usernameInput(String usernameInput){
        By usernameBy = By.xpath("//input[@name='username']");
        WebElement username = driver.findElement(usernameBy);

        username.sendKeys(usernameInput);
    }

    public void passwordInput(String passwordInput){
        By passwordBy = By.xpath("//input[@name='password']");
        WebElement password = driver.findElement(passwordBy);

        password.sendKeys(passwordInput);
    }

    public void clickSubmitButton(){
        By submitBy = By.xpath("//button[@type='submit']");
        WebElement submit = driver.findElement(submitBy);

        submit.click();
    }

    public String dashboardGetText(){
        By dashboardBy = By.xpath("//h6");
        WebElement dashboard = driver.findElement(dashboardBy);

        return dashboard.getText();
    }

    public String errorMessage(){
        By errorMessageBy = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
        WebElement errorMessage = driver.findElement(errorMessageBy);

        return errorMessage.getText();
    }


}
