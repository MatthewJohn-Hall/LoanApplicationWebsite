package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    /**------------------Constructor----------------*/
    public LoginPage(WebDriver c) {
        super(c);
    }

    /**------------------Variables----------------*/
    private static String URL = "http://35.178.110.62:8080/login";


    /**------------------Statics----------------*/
    private static final By USER_NAME_TEXT_BOX = By.xpath("//input[@name='username']");
    private static final By PASSWORD_TEXT_BOX = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@type='submit']");
    private static final By LOG_IN_WEB_LINK = By.xpath("//a[@href='/logout']");
    private static final By PLEASE_SIGN_IN_TITLE = By.xpath("//h1");

    /**------------------click Methods----------------*/
    public void clickSignIn(){
        genericClick(SIGN_IN_BUTTON);
    }
    public void clickLoginLogOut(){
        genericClick(LOG_IN_WEB_LINK);
    }

    /**------------------Enter Text Methods----------------*/
    public void fillUserNameTextBox(String userNameInput){
        fillTextBox(USER_NAME_TEXT_BOX, userNameInput);
    }
    public void fillPasswordTextBox(String passwordInput){
        fillTextBox(PASSWORD_TEXT_BOX, passwordInput);
    }

    /**------------------Information retrievals methods----------------*/
    public String getPleaseSignInTitle (){
        return driver.findElement(PLEASE_SIGN_IN_TITLE).getText();
    }


}
