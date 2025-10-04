Feature: Subscribe Now Text Visibility

  @ramazan
  Scenario: There should be a link to the dashboard page on the homepage


    Given user goes to "instulearnUrl"
    Given user waits 2 seconds
    Then user clicks the login button in the Header
    And user write "emailRamazan" in email textBox
    And user write "passWordRamazan" in passWord texBox
    Then user clicks the login button under emailTextBox
    Then page should display  dasboard Menu

    @rekare
    Scenario: Courses, Meetings, Quizzes, Certificates, Financial, Support, Notifications, Settings,
    Log Out links should be visible and active in the sidebar on the dashboard

      Given user goes to "instuLearnUrl"
      Then user waits 2 seconds
      Then user clicks the login button in the Header
      And user write "emailRamazan" in email textBox
      And user write "passWordRamazan" in passWord texBox
      And user clicks the login button under emailTextBox
      And user click all link under the dashBoard Menu

      Scenario: View All Events Link should be visible and active on the Dashboard page to view all events

        Given user goes to "instuLearn"
        Then user waits 1 seconds
        Then user clicks the login button in the Header
        Then user write "emailRamazan" in email textBox
        And user write "passWordRamazan" in passWord texBox
        And user clicks the login button under emailTextBox
        Then The user verifies that View All Events Link is visible

        Scenario: Dashboard body bölümünde Account Balance,Purchased Courses,Meetings,Support
        Messages,Comments linkleri görünür ve aktif olmalı.

          Given user goes to "instuLearn"
          Then user waits 1 seconds
          Then user clicks the login button in the Header
          Then user write "emailRamazan" in email textBox
          And user write "passWordRamazan" in passWord texBox
          And user scrolls the page until LoginButton_Under_emailandPassword
          And user waits 2 seconds
          And user clicks the login button under emailTextBox
          Then The user verifies that the links under View All Events Links are visible and enable.
            | Purchased Courses   |
            | Meetings            |
            | Support             |
            | Comments            |
            | Account Balance     |






Scenario: Current ads and detailed information should be displayed on the Ad Board.

  Given user goes to "instuLearn"
  Then user waits 1 seconds
  Then user clicks the login button in the Header
  Then user write "emailRamazan" in email textBox
  And user write "passWordRamazan" in passWord texBox
  And user scrolls the page until LoginButton_Under_emailandPassword
  And user waits 2 seconds
  And user clicks the login button under emailTextBox
  And The user confirms that current job postings and detailed information

Scenario: Monthly learning table should be displayed.

  Given user goes to "instuLearn"
  Then user waits 1 seconds
  Then user clicks the login button in the Header
  Then user write "emailRamazan" in email textBox
  And user write "passWordRamazan" in passWord texBox
  And user scrolls the page until LoginButton_Under_emailandPassword
  And user waits 2 seconds
  And user clicks the login button under emailTextBox
  And User verifies that the monthly learning table is displayed




