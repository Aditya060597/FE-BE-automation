package test;

import UI.PageObjects.LoginScreen;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    //Username : test2@fake.com
    //Password : myNewPassword
    private static WebDriver driver;
    static LoginScreen loginScreen;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishw\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        loginScreen = new LoginScreen(driver);
        driver.get("https://admin.closebynearme.com");
    }
    @Test
    public void loginPage(){
        loginScreen.enterEmailId("test2@fake.com");
        loginScreen.enterPassword("myNewPassword");
        Assert.assertTrue(loginScreen.isSubmitButtonPresent());
        Assert.assertTrue(loginScreen.isSignUpButtonPresent());
        loginScreen.clickOnSubmitButton();
    }
}
