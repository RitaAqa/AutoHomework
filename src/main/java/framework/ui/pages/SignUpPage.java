package framework.ui.pages;

import framework.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By confirmPassword = By.id("sign-up-form--confirm-password");


    public boolean isSignUpPageDisplayed() {
        return isElementDisplayed(confirmPassword);
    }
}
