Feature: The user should be able to log in to the site using the email and password they registered with.

  @edaa
  Scenario: [TC_01] Accessibility test from the Home Page to the Login Page
    Given the user goes to the homepage
    When Verify that the login button is visible and enabled in the top bar of the home page.
    Then Click the login link.
    And Verify that the Login page is displayed.

  @edaa2
  Scenario: [TC_02] Login page usability test
    Given the user goes to the homepage
    When Click the login link.
    Then the related image should be visible on the left side of the page
    And the text Log in to your account should be visible on the right side
    And the email field should be visible and enabled
    And the password field should be visible and enabled

  @edaa3
  Scenario: [TC_03] Accessibility test for navigating to the Forgot Password page from the Login page
    Given the user goes to the homepage
    When Click the login link.
    When Click the login buton.
    Then verify that the text Forgot your password? is visible on the right side of the Login page
    When the user clicks on the Forgot your password? link
    Then verify that the Forgot Password page is opened

  @edaa4
  Scenario: [TC_04] Accessibility test from the Login page to the Register page
    Given the user goes to the homepage
    When Click the login link.
    And the user verifies that the Register link is visible
    When the user clicks on the Register link
    Then the user verifies that the Register page is opened

  @edaa5
  Scenario: [TC_05] Negative login test with valid email and invalid password
    Given the user goes to the homepage
    When Click the login link.
    When the user enters a valid email in the email field
    And the user enters an invalid password in the password field
    When Click the login buton.
    Then the system should not allow the user to log in
    And an error message should be displayed

  @edaa6
  Scenario: [TC_06] Negative login test with invalid email and valid password
    Given the user goes to the homepage
    When Click the login link.
    When the user enters an invalid email in the email field
    And the user enters a valid password in the password field
    When Click the login buton.
    Then the system should not allow the user to log in
    And an error message should be displayed for email

  @edaa7
  Scenario: [TC_07] Positive login test with registered credentials
    Given the user goes to the homepage
    When Click the login link.
    When the user enters a registered email in the email field
    And the user enters a registered password in the password field
    When Click the login buton.
    Then the Dashboard page should be displayed
