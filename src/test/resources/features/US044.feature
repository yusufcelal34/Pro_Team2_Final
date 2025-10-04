
@nihad44
Feature: Certificates section in Dashboard sidebar


Scenario: Verify Certificates links in Dashboard sidebar

Given I am on the homepage
And I am login
    And  filter shouldbe visible
And Ensure the links "Achievements", "Certificate Validation", and "Completion Certificates" appear and are enabled under Certificates in the Dashboard sidebar.





@nihad441
  Scenario: Viewing achievements and navigating to certificate validation

    Given I am on the homepage
    And I am login
    When I click on the "Achievements" link
    Then my achievements statistics information should be visible on the page

    When I click on the dashboard "Certificate Validation" link
    Then I should be redirected to the certificate validation page

  @nihad7
  Scenario: result

    Given I am on the homepage
    And I am login
    Then I click on certificateamd Completion Certificates then  enter data
    When I select "2025-10-02" as the From date
    And I select date as the To date
    And I select Meta Social Media Marketing as the course