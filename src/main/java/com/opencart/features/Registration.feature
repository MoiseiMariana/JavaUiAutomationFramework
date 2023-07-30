Feature: Register Flow Feature Test Suite

  @Regression @Smoke
  Scenario: Access the Account page after the successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When registration form is completed with valid random data
    And the privacy toggle is enabled
    And continue button is clicked
    Then the current url contains the following keyword: "account"

  Scenario: User remains on the Register Page when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When registration form is completed with valid random data
    And the privacy toggle is enabled
    Then the current url contains the following keyword: "account"

  @Regression
  Scenario: User remains on the Register Page when privacy conditions are not accepted during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When registration form is completed with valid random data
    And continue button is clicked
    Then the current url contains the following keyword: "account"

  @run
  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> date
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form nis completed with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | random      |
      | password  | Random      |
    When continue button is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | attribute  | firstName                          | lastName                           |
      | First Name | Sjhsfjdfjkskfksfkklflflfljjjjkklgf | random                             |
      | Last Name  | random                             | Sjhsfjdfjkskfksfkklflflfljjjjkklgf |
