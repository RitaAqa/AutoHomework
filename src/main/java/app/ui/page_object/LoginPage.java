package app.ui.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By doNotShowAgainBtn = By.cssSelector(".css-taqdkb");
    private final By userNameInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("signInButton");
    private final By loginErrorLabel = By.id("message-id");
    private final By signUpBtn = By.partialLinkText("Sign Up");

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
