@erkan87
Feature: US_32 User Login and Profile Navigation

@002
  Scenario: Successful Login and Redirection to Profile Page via Hover

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    And The user clicks on the instulearn logo
    And the user hovers over the username at the top of the screen
    And The user confirms that they have been redirected to the Follow buton


  Scenario: Successful Login and Redirection to Profile Page via Sidebar

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    And the user sees the "My Profile" button in the Dashboard sidebar on the left of the screen and clicks on it
    And the user confirms that they have been redirected to the Follow button


  Scenario: Successful Login and Redirection to Profile Page via Sidebar

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    And the user sees the "My Profile" button in the Dashboard sidebar on the left of the screen and clicks on it
    And the user confirms that they have been redirected to the ERKAN IMG


  Scenario: Login and Verification of Meeting Statistics Headings

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    And the user sees the "My Profile" button in the Dashboard sidebar on the left of the screen and clicks on it
    And the user confirms that they have been redirected to the Follow button
    And the Students Courses Reviews Meetings heading are visible
      | Students |
      | Courses  |
      | Reviews  |
      | Meetings |


  Scenario: Successful Login and Verification of Detailed Profile Headings

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    And the user sees the "My Profile" button in the Dashboard sidebar on the left of the screen and clicks on it
    And the user confirms that they have been redirected to the Follow button
    And the user confirms that the About Courses Instructors Articles Badges Reserve a meeting heading are visible
      | About             |
      | Courses           |
      | Instructors       |
      | Articles          |
      | Badges            |
      | Reserve a meeting |




