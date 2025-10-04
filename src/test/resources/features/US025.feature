Feature:Quiz Management
  As a registered user
  I want to have a page where I can create and manage quizzes
  So that I can prepare and track exams effectively

  Background:
    Given The user on the homepage "url"

@enes
  Scenario: Quizzes links are visible & clickable in the Sidebar (AC-1)
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And the user is on the Dashboard page
    When the user looks at the Sidebar under the Quizzes section
    Then the user should see links "New Quiz", "List", "Results", "My Results", "Not Participated"
    And each link should be clickable


  Scenario: Create a basic quiz
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    When User clicks the New Quiz link
    And User enters Quiz Title and Pass Mark
    And User saves the quiz
    And the new quiz should be visible in the quiz list


  Scenario: Add a Multiple Choice question
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And The user clicks the New Quiz page
    When The user clicks "Add a Multiple Choice"
    And The user enters "Question Title", "Grade", "Correct Answer" and  "Answer title"
    And The user saves the question
    Then The question should be visible in the questions list


  Scenario: Add a Descriptive (open-ended) question
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And The user clicks the List page
    When The user clicks Add a Descriptive
    And The user enters "Question Title", "Grade", "Description Correct Answer"
    And The user saves the descriptive
    Then The question should be visible in the descriptive list


  Scenario: List quizzes with statistics, filter, edit, and delete
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And The user clicks the Quizzes List page
    When The user views the statistics widgets
    And The user applies a filter
    And The user edits a quiz
    And The user deletes a quiz with confirmation
    Then The statistics should be visible



  Scenario: Results page shows no records when no student has taken the quiz
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And The user clicks the Results page
    When The user views the statistics
    And The user applies a filter on results
    Then The user should see a message "No results found" or an empty list
    And The user should still see the statistics and filters displayed


  Scenario: My Results page shows no records when no quiz has been taken
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And The user clicks the My Results page
    When The user views the results statistics
    And The user applies a result filter
    Then The user should see a message "No results found" or an empty list in my result page
    And The user should still see the statistics and filters displayed in my result page


  Scenario: Not Participated quizzes with Start & Course Page
    Given the user navigates to the login page
    And the user enters valid credentials and logs in
    And the user clicks the Not Participated page
    When the user applies a filter in the Not Participated page
    Then the user should see a message No quizzes found or an empty list




