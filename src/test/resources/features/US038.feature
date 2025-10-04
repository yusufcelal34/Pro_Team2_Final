@yusuf38
Feature: Logout Functionality Tests
  As a registered instructor
  I want to safely log out of the site
  So that I can ensure session security

  @tc01
  Scenario: TC01 - User logs out safely
    Given The user accesses the homepage with the relevant URL (first)
    When The user clicks Login and logs in with valid instructor credentials (first)
    And The user scrolls down the page (first)
    Then The Log Out link at the bottom of the left menu should be visible and clickable (first)

  @tc02
  Scenario: TC02 - Verify Log Out link visibility on Control Panel
    Given The user accesses the homepage with the relevant URL (second)
    When The user clicks Login and logs in with valid instructor credentials (second)
    And The user scrolls up the page (second)
    Then The Log Out link at the up of the right menu should be visible and clickable (second)

  @tc03
  Scenario: TC03 - Verify Log Out link functionality
    Given The user accesses the homepage with the relevant URL (third)
    When The user clicks Login and logs in with valid instructor credentials (third)
    And The user scrolls down the page (third)
    And The user clicks the Log Out link at the bottom of the left menu (third)
    Then The Log In button in the down left corner should be displayed (third)

  @tc04
  Scenario: TC04 - Verify exit link visibility via profile icon
    Given The user accesses the homepage with the relevant URL (fourth)
    When The user clicks Sign In and logs in with valid instructor credentials (fourth)
    And The user clicks the Home button in the header (fourth)
    And The user clicks the profile icon in the upper right corner (fourth)
    Then The exit link should be visible and clickable in the dropdown menu (fourth)

  @tc05
  Scenario: TC05 - Verify exit link functionality via profile icon
    Given The user accesses the homepage with the relevant URL (fifth)
    When The user clicks Sign In and logs in with valid instructor credentials (fifth)
    And The user clicks the Home button in the header (fifth)
    And The user clicks the profile icon in the upper right corner (fifth)
    And The user clicks the Log Out link in the dropdown menu (fifth)
    Then The Log In button in the upper right corner should be displayed (fifth)

