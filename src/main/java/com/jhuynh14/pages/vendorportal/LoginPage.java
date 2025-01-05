package com.jhuynh14.pages.vendorportal;

import com.jhuynh14.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id="username")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="customCheck")
    private WebElement rememberMeCheckbox;

    @FindBy(id="login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        return this.loginButton.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public void login(String name, String password){
        this.enterUsername(name);
        this.enterPassword(password);
        this.login();
    }

    public void enterUsername(String name){
        this.usernameInput.sendKeys(name);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void login(){
        this.loginButton.click();
    }
}
