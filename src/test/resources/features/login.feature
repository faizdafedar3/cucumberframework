Feature: Login functionality

  Background:
    Given user is on login page

  Scenario Outline: Valid user login
    When user enters username "<username>" and password "<password>"
    And clicks on login button
    Then user should be logged in successfully

    Examples:
      | username                  | password      |
      | standard_user              | secret_sauce  |
      | problem_user               | secret_sauce  |

  Scenario Outline: Invalid user login
    When user enters username "<username>" and password "<password>"
    And clicks on login button
    Then error message should be displayed

    Examples:
      | username        | password      |
      | wrong_user      | secret_sauce  |
      | standard_user   | wrong_pass    |
