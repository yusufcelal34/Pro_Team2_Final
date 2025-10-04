@erkan87
Feature: [US_24] - "As a user, I want to be able to view and select courses opened by organizations in the home page body section.

  Scenario: [US_24]-[TC_MEET_001] Successful Login and Verification of the Meetings Menu
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user verifies that My reservations, Requests, Settings are listed in the Meetings drop-down menu
      | My reservation |
      | Request        |
      | Settings       |




  Scenario: [US_24]-[TC_MEET_002]
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the "My reservation"
    Then The user verifies that they have been redirected to the "Meeting statistics" page
    And The user verifies that the Open meetings, Total meetings, Active hours heading is visible on the Meeting statistics page
      | Open meetings  |
      | Total meetings |
      | Active hours   |


  Scenario: [US_24]-[TC_MEET_003]
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Request
    And The user verifies that the Pending meetings, Total meetings, Sales amount, Active hours heading is visible on the Meeting statistics page
      | Pending meetings  |
      | Total meetings    |
      | Sales amount      |
      | Active hours      |


  Scenario: [US_24]-[TC_MEET_004]
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Settings
    And The user verifies that the In-person meetings Group meeting, Save heading and button are visible on the Meeting timesheet page


  Scenario: [US_24]-[TC_MEET_007]
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Settings
    And The user enters numerical value 120 data in the "Amount" text box field
    And The user enters numerical value data in the Discount rate (%) text box field


  Scenario: [US_24]-[TC_MEET_008]
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Settings Kategori
    And The user clicks on the Available for in person meetings radio button under the in person meeting heading
    Then The user verifies that the Hourly Price text box field has been opened
    And The user clicks on the Available for group meetings radio button under the group meeting heading
    Then The user verifies that the Minimum Students text box field has been opened



  Scenario: [US_24]-[TC_MEET_005] User Creates and Saves a New Timesheet Entry via Meeting Settings
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Settings
    And the user clicks on the three dots under the Actions column of the Monday row
    And the user clicks the Add Time button
    And the user selects the Modal Window field time picker to be uc
    And the user enters alphabetical data in the Description text box field
    And The user clicks the Save button


  Scenario: [US_24]-[TC_MEET_006] User Creates and Saves a New Timesheet Entry via Meeting Settings
    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And The user clicks on the "Login" button
    And The user enters the data "erkanbinici87@gmail.com" in the "Username" field
    When The user clicks on the Login_BTN button
    Then The user verifies that they are redirected to the "Dashboard" page
    And The user clicks on the Dashboard sidebar "Meetings" drop-down menu on the left of the screen
    And The user clicks on the Settings
    And the user clicks on the three dots under the Actions column of the Monday row
    And the user clicks the Add Time button
    And the user selects the Modal Window field time picker to be uc
    And the user clicks on the AM PM radio button
    And the user enters alphabetical data in the Description text box field
    And The user clicks the Save button








