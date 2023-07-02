Feature: Register Flow Feature Test Suite

  Scenario: Access the Account page after the successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When registration form is completed with valid random data
    And the privacy toggle is enabled
    And continue button is clicked
    Then the new page url contains "register&language" keyword

  Scenario: User remains on the Register when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When registration form is completed with valid random data
    And the privacy toggle is enabled
    Then the new page url contains "register&language=en-gb" keyword