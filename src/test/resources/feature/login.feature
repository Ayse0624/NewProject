Feature: login
  @valid
  Scenario: user should be login url
    Given user already on the dashboard page
    When click login icon
    Then successfully

    @invalid
    Scenario: user should not be login with wrong userName And Password
      Given user already on the dashboard page
      When enter wrong username and password
      Then user can not be login Wrong Masage is displayed


