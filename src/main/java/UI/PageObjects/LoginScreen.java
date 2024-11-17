package UI.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {

    private WebDriver driver;

    private By emailTextBox = By.xpath("//input[@id='email']");
    private By passworTextBox = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//button[@id='submit']");
    private By signUpButton = By.xpath("//button[@id='signup']");

    public LoginScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailId(String emailid){
        driver.findElement(emailTextBox).isDisplayed();
        driver.findElement(emailTextBox).click();
        driver.findElement(emailTextBox).sendKeys(emailid);
    }

    public void enterPassword(String password) {
        driver.findElement(passworTextBox).isDisplayed();
        driver.findElement(passworTextBox).click();
        driver.findElement(passworTextBox).sendKeys(password);

    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButton).isDisplayed();
        driver.findElement(submitButton).click();
    }

    public boolean isSignUpButtonPresent() {
        return driver.findElement(signUpButton).isDisplayed();
    }

    public boolean isSubmitButtonPresent() {
        return driver.findElement(submitButton).isDisplayed();
    }
}
