Feature: As a user, I want a page where I can take action when I forget my password

  @edaaa
  Scenario: [TC_01] The "Forgot your password?" link should be visible and active on the Login page
    Given the user goes to the homepage
    And Click the login link.
    Then verify that the text Forgot your password? is visible on the right side of the Login page

  @edaaa2
  Scenario: [TC_02] The "Password Recovery" text should be visible on the Forgot Password page
    Given the user goes to the homepage
    When Click the login link.
    Then verify that the text Forgot your password? is visible on the right side of the Login page
    When the user clicks on the Forgot your password? link
    Then the user should see the Password Recovery heading

  @edaaa3
  Scenario: [TC_03] The email text box should be visible and active. When a registered email is entered, a successful password reset message should be displayed.
    Given the user goes to the homepage
    When Click the login link.
    Then verify that the text Forgot your password? is visible on the right side of the Login page
    When the user clicks on the Forgot your password? link
    Then verify that the Forgot Password page is opened
    And the user enters a valid email address
    And the user clicks on the Reset Password button
    Then the user should see a confirmation message on the Forgot Password page

  @edaaa4
  Scenario: [TC_04] The "Reset Password" button should be visible and active
    Given the user goes to the homepage
    When Click the login link.
    When the user clicks on the Forgot your password? link
    Then verify that the Forgot Password page is opened
    Then the user should see the Reset Password button

  @edaaa5
  Scenario: [TC_05] The user should be able to navigate from the Forgot Password page back to the Login page
    Given the user goes to the homepage
    When Click the login link.
    When the user clicks on the Forgot your password? link
    Then verify that the Forgot Password page is opened
    When Click the login link.