Feature: Login to Swag labs

  @smoke
  Scenario Outline: Login to Swag labs using page factory approach
    Given user is on swaglabs login page
    When user enter "<username>" and "<password>" as credentials
    And user click on Login button
    Then user redirects to swaglabs homepage

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  @regression
  Scenario Outline: Logout from the application
    Given user is on swaglabs login page
    When user enter "<username>" and "<password>" as credentials
    And user click on Login button
    Then user redirects to swaglabs homepage
    When user click on logout button
    Then login page will be displayed

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce1 |