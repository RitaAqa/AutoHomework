package app.ui.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By confirmPassword = By.id("confirm_password");


    public boolean isSignUpPageDisplayed() {
        return isElementDisplayed(confirmPassword);
    }
}
