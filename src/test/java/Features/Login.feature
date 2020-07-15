Feature: I want to login and navigate to homepage
  

  
  Scenario: Login and navigate to homepage
    Given A user is on login page
    When user enters username and passowrd
    And click login nutton
    Then user should navigate to homepage