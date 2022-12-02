@AuthenticationScenarios
Feature: Authentication

  Background: Browser has already navigated to the Loan Application Website
    Given The browser has navigated to the loan application homepage


  @Smoke @HighPriority
  Scenario Outline: Inputting username and Password
    Given The browser has navigated to the login page via the loginlogout button
    When A valid "<User>" and "<Password>" is entered
    Then the browser will login with the details provided

    Examples:
      | User  | Password |
      | user  | password |
      | admin | password |

  @HighPriority
  Scenario: User logs out
    Given A user has logged in
    When A user clicks logout
    Then The user will be logged out

  @HighPriority
  Scenario Outline: A user that has not logged in is redirected
    When A user clicks a "<Page>" that requires them to be logged in
    Then The user will be redirected to the log in page

    Examples:
      | Page             |
      | Loan Application |
      | Admin            |

  @HighPriority @current
  Scenario Outline: Access is denied to certain webpages for certain users
    When "<Users>" clicks on "<Pages>" they are not allowed to access
    Then access is denied

    Examples:
      | Users | Pages
      | user  | Admin            |
      | admin | Loan Application |
