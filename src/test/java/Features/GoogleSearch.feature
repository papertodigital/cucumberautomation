Feature: I want to write tests for google search functionality

  Scenario Outline: Validate google search functionality for a given keyword
    Given user is on google homepage
    When user enter <search> keyword
    And click search button
    Then all the search results should be displayed

    Examples: 
      | search   |
      | facebook |
      | yahoo    |
