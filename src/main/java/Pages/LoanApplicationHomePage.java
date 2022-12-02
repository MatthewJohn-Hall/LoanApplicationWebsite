package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanApplicationHomePage extends BasePage {

    /**------------------Constructor----------------*/
    public LoanApplicationHomePage(WebDriver driver) {
        super(driver);
    }

    /**------------------Variables----------------*/
    private static String URL = "http://35.178.110.62:8080/";

    /**------------------Statics----------------*/
    private static final By LOAN_APPLICATION_PAGE_WEB_LINK = By.xpath("//a[@href='/application']");
    private static final By ADMIN_PAGE_WEB_LINK = By.xpath("//a[@href='/admin']");
    private static final By SEARCH_PAGE_WEB_LINK = By.xpath("//a[@href='/search']");
    private static final By ABOUT_PAGE_WEB_LINK = By.xpath("//a[@href='/about']");
    private static final By LOG_IN_WEB_LINK = By.xpath("//a[@href='/logout']");
    private static final By CURRENT_LOGGED_IN_USER = By.xpath("//span[contains(text(), 'Logged user')]");


    /**------------------URL Navigation Method----------------*/
    public void navDriver(String url){
        driver.get(url);
    }



    /**------------------click Methods----------------*/
    public void clickLoanApplicationPage(){
        genericClick(LOAN_APPLICATION_PAGE_WEB_LINK);
    }
    public void clickLoanAdminPage(){
        genericClick(ADMIN_PAGE_WEB_LINK);
    }
    public void clickLoanSearchPage(){
        genericClick(SEARCH_PAGE_WEB_LINK);
    }
    public void clickLoanAboutPage(){
        genericClick(ABOUT_PAGE_WEB_LINK);
    }
    public void clickLogInLogOutPage(){
        genericClick(LOG_IN_WEB_LINK);
    }

    /**------------------get Methods----------------*/
    public String getCurrentLoggedInUser (){
        String currentUser = driver.findElement(CURRENT_LOGGED_IN_USER).getText().split(": ")[1].split(" ")[0];

        if( currentUser.equals("|"))
            return "none";
        return currentUser;
    }

    public void chooseAPageToClickOn(String desiredPage){
        switch(desiredPage){
            case "Loan Application":
                clickLoanApplicationPage();
                break;
            case "Admin":
                clickLoanAdminPage();
                break;
            case "Search":
                clickLoanSearchPage();
                break;
            case "About":
                clickLoanAboutPage();
                break;
            case "Log in or out":
                clickLogInLogOutPage();
                break;
        }
    }


}
