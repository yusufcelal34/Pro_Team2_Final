Feature: US-003 As a visitor, I would like to have an area in the body section of the homepage where I can search for suitable trainings for myself.

  Scenario: TC-001 Verify the visibility of the main heading in the homepage body.

    Given The user goes to the homepage URL
    When The user verifies the visibility of the body section heading "Transform Your Future with InstuLearn..."


  Scenario: TC-002 Verify the visibility of the search box in the homepage body and its placeholder text

    Given The user goes to the homepage URL
    When The user views the search box in the body section
    Then The user verifies that the placeholder text in the search box is "Search courses and instructors..."


  Scenario: TC-003 Verify text input in the homepage body search box

    Given The user goes to the homepage URL
    When The user types "sdet" into the search box
    Then The user verifies that the text in the search box is "sdet"


  Scenario: TC-004 Verify that a search is performed when text is entered in the homepage search box and the Enter key is pressed

    Given The user goes to the homepage URL
    When The user types "sdet" into the search box and presses Enter
    Then The user verifies that the URL has changed


  Scenario: TC-005 Verify the visibility of the Search button in the homepage body

    Given The user goes to the homepage URL
    When The user verifies that the search button on the homepage is visible


  Scenario: TC-006 Verify that a search is performed when using the Search button in the homepage search box

    Given The user goes to the homepage URL
    When The user types "sdet" into the search box
    When The user clicks the search button
    Then The user verifies that the URL has changed