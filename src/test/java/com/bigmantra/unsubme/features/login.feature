@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Login to gmail
    Given I want to navigate to gmail page
    And I enter username and password
    When I click signin
    Then I am logged into gmail 
    And I should see my inbox page
