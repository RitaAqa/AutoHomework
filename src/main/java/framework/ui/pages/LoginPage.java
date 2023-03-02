package framework.ui.pages;

import framework.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By doNotShowAgainBtn = By.cssSelector(".css-owseqk");
    private final By userNameInput = By.id("sign-in-form--email");
    private final By passwordInput = By.id("sign-in-form--password");
    private final By loginBtn = By.id("sign-in-form--submit");
    private final By loginErrorLabel = By.className("MuiAlert-message");
    private final By signUpBtn = By.partialLinkText("Create an account");

    public void clickDoNotShowAgainBtn() {
        click(doNotShowAgainBtn);
    }
    public void login(String username, String password) {
        enterText(userNameInput, username);
        enterText(passwordInput, password);
        click(loginBtn);
    }

    public void navigateToSignUpPage() {
        click(signUpBtn);
    }

    public boolean isLoginFailed() {
        return isElementDisplayed(loginErrorLabel);
    }
}
