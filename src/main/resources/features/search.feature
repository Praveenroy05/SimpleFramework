Feature: Basic Search flow

  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Scenario: Search for available flights
    Given I am on the MarsAir home page
    When I enter "July 2023" into the departure field
    And I enter "December 2023" into the return field
    And I click the search button
    Then I should see a message indicating whether seats are available
