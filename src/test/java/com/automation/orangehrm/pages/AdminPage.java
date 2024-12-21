package com.automation.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAdminLink(){
        By adminLinkBy = By.xpath("//*[text()='Admin']");
        WebElement adminLink = driver.findElement(adminLinkBy);

        adminLink.click();

    }

    public void searchUsernameInput(String input){
        By searchUsernameInputBy = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
        WebElement searchUsernameInput = driver.findElement(searchUsernameInputBy);

        searchUsernameInput.sendKeys(input);
    }

    public void clickOnSearchSubmitButton(){
        By searchSubmitButtonBY = By.xpath( "//button[@type='submit']");
        WebElement searchSubmitButton = driver.findElement(searchSubmitButtonBY);;

        searchSubmitButton.click();
    }

    public String getUsernameResults(){
        By usernameReesultsBY = By.xpath( "(//div[@class='oxd-table-cell oxd-padding-cell'])[2]");
        WebElement usernameResults = driver.findElement(usernameReesultsBY);;

        return usernameResults.getText();
    }

    public void selectUserRoles(String roles){
        By selectUserRolesBy = By.xpath( "(//div[@class='oxd-select-text-input'])[1]");
        WebElement selectUserRoles = driver.findElement(selectUserRolesBy);

        Select select = new Select(selectUserRoles);
        select.selectByValue(roles);
    }

}
