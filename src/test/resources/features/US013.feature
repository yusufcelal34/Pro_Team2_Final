
@nihad2

Feature: Nihad Steps Feature


  Scenario: Navigate and verify homepage cards
    Given I am on the homepage
    When I should see the "Certificate Validation" card
    And I should click the "Certificate Validation" card
    Then I should be redirected to the "Certificate Validation" page

  Scenario: Verify products page search functionality
    Given I am on the Products page
    Then the search textbox should be visible and enabled
    Then the search button should be visible and enabled
