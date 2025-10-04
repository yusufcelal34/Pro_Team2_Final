@yusuf41
Feature: Courses menu submenus in Dashboard Sidebar (Student)
  As a logged-in student
  I want to navigate and manage Courses submenus
  So that I can verify visibility, invoices, learning pages, reviews and favorites

  @tc01
  Scenario: TC01 - Verify that the Courses submenu is visible and accessible
    Given The user accesses the homepage with the relevant URL (sixth)
    When The user clicks Sign In and logs in with valid student credentials (sixth)
    And The user clicks the Courses submenu in the Dashboard Sidebar (sixth)
    Then The Courses submenu should be visible and accessible (sixth)
    And log out exit


  @tc02
  Scenario: TC02 - Verify My Purchases, My Reviews, Favorites visibility
    Given The user accesses the homepage with the relevant URL (sixth)
    When The user clicks Sign In and logs in with valid student credentials (sixth)
    And The user clicks the Courses submenu in the Dashboard Sidebar (seventh)
    Then The My Purchases, My Reviews and Favorites submenus should be visible and accessible (seventh)
    And The user clicks the Sign Out button (seventh)

  @tc03
  Scenario: TC03 - Verify Invoice submenu works
    Given The user accesses the homepage with the relevant URL (sixth)
    When The user clicks Sign In and logs in with valid student credentials (sixth)
    And The user clicks the Courses submenu in the Control Panel Sidebar (eighth)
    And The user clicks the My Purchases submenu (eighth)
    And The user verifies the presence of Learning page, Join, Invoice and Feedback panes (eighth)
    When The user clicks the Invoice submenu (eighth)
    And The user clicks the Sign Out button (seventh)

  @tc04
  Scenario: TC04 - Verify Learning page submenu works
    Given The user accesses the homepage with the relevant URL (sixth)
    When The user clicks Sign In and logs in with valid student credentials (sixth)
    And The user clicks the Courses submenu in the Control Panel Sidebar (ninth)
    And The user clicks the My Purchases submenu (ninth)
    And The user verifies the presence of Learning page, Join, Invoice and Feedback panes (ninth)
    When The user clicks the Learning page submenu (ninth)
    Then The Learning page should be displayed successfully (ninth)
    And The user clicks the Log Out button (ninth)

  @tc41-05
  Scenario: TC05 - Remove from Favorites and verify deletion
    Given The user accesses the homepage with the relevant URL (sixth)
    When The user clicks Sign In and logs in with valid student credentials (sixth)
    And The user clicks the Courses submenu in the Control Panel Sidebar (tenth)
    And The user clicks the Favorites submenu (tenth)
    Then The selected course should be visible under Favorite Courses heading (tenth)
    And The user verifies the presence of the Remove menu (tenth)
    When The user clicks the Remove submenu (tenth)
    Then The Courses submenu should be visible and accessible (sixth)
    And log out exit
