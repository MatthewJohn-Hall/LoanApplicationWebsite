package StepDefinition;

import Pages.LoanApplicationHomePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static StepDefinition.Hooks.driverFactory;

public class MyStepdefs {

    private static LoanApplicationHomePage loanApplicationHomePage;
    private static LoginPage loginPage;
    public static WebDriver driver = driverFactory.getDriver();



    /**------------------Constructor----------------*/
    public MyStepdefs() {
        loanApplicationHomePage = new LoanApplicationHomePage(driver);
        loginPage = new LoginPage(driver);
    }


    /**------------------Variables----------------*/
    private String user;
    private List<Map<String,String>> userDeniedPages;

    /**------------------Page URL & Navigation Givens----------------*/
    @Given("The browser has navigated to the loan application homepage")
    public void theBrowserHasNavigatedToTheLoanApplicationWebpage() {
        loanApplicationHomePage.navDriver("http://35.178.110.62:8080/");

    }
    @Given("The browser has navigated to the login page via a the login/logout button")
    public void theBrowserHasNavigatedToTheLoginPage() {
        loanApplicationHomePage.navDriver("http://35.178.110.62:8080/login");
    }

    @Given("The browser has navigated to the login page via the loginlogout button")
    public void theBrowserHasNavigatedToTheLoginPageViaATheLoginLogoutButton() {
        loanApplicationHomePage.clickLogInLogOutPage();
    }

    /**------------------Information Input Givens----------------*/
    @Given("A user has logged in")
    public void aUserHasLoggedIn() {
        loanApplicationHomePage.clickLogInLogOutPage();
        loginPage.fillUserNameTextBox("user");
        loginPage.fillPasswordTextBox("password");
        loginPage.clickSignIn();
    }

    @Given("A specific type of user is denied access to certain pages")
    public void aSpecificTypeOfUserIsDeniedAccessToCertainPages(DataTable table) {
        userDeniedPages = table.asMaps();
    }



    /**------------------Action Whens----------------*/
    @When("A valid {string} and {string} is entered")
    public void aValidUserNameAndPasswordIsEntered(String userName, String password) {
        user = userName;
        loginPage.fillUserNameTextBox(userName);
        loginPage.fillPasswordTextBox(password);
        loginPage.clickSignIn();
    }

    @When("A user clicks logout")
    public void aUserClicksLogout() {
        loanApplicationHomePage.clickLogInLogOutPage();
    }

    @When("A user clicks a {string} that requires them to be logged in")
    public void aUserClicksAThatRequiresThemToBeLoggedIn(String pageDesired) {
        loanApplicationHomePage.chooseAPageToClickOn(pageDesired);
    }


    /**------------------Thens----------------*/

    @Then("the browser will login with the details provided")
    public void theBrowserWillLoginWithTheDetailsProvided() {
        Assertions.assertEquals(user, loanApplicationHomePage.getCurrentLoggedInUser());
    }

    @Then("The user will be logged out")
    public void theUserWillBeLoggedOut() {
        Assertions.assertEquals("none", loanApplicationHomePage.getCurrentLoggedInUser());
    }

    @Then("The user will be redirected to the log in page")
    public void theUserWillBeRedirectedToTheLogInPage() {
        Assertions.assertEquals("Please Sign In", loginPage.getPleaseSignInTitle());
    }


}
