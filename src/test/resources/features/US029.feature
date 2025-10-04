Feature: Marketing Management
  As a registered user
  I want to manage discounts and promotions
  So that I can offer and use marketing campaigns effectively
  Background:
    Given The user on the homepage "url"

@enes1
  Scenario: Marketing menu and links are visible/active (AC-1)
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    When the user opens the Marketing section in the Sidebar
    Then the user should see the links "Discounts" and "Promotions"
    And each link should be clickable on the page

  @enes2
  Scenario: Discounts - create a new course discount (AC-2)
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    When The user navigates to "Marketing" → "Discounts"
    And The user clicks the "Create" button
    Then The user should not see any courses in the course selection field
    And The user should see a message "No discount is available"
    And No discount record should be created

  @enes3
  Scenario: Promotions - plans are listed and selectable (AC-3)
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    When the user navigates to "Marketing" → Promotions
    Then promotion plans should be displayed as cards or list with name and price and conditions
    And the user should be able to select a plan (via select, radio button, checkbox)

  @enes4
  Scenario: Promotions - a plan cannot be purchased without selecting a course
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    Given The user clicks the Promotions page
    When The user selects a promotion plan
    And The user clicks "Register" or "Subscribe" or "Activate"
    Then The user should see a warning message "Select a course"
    And The plan should not be saved or appear under My Subscriptions