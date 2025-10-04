Feature: US-023 I would like to have a page where I can create and manage a course package as a registered user

  Scenario: TC-001 Verify that the New link under Course Bundles in the Dashboard sidebar is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    Then The login screen is displayed
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    Then The user verifies that they have logged in
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page


  Scenario: TC-002 Verify that the required fields in the Basic Information form can be completed on the New Course page and that you can proceed with the Next button.

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page

    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    And user waits 10 seconds
    Then The user verifies that they have moved to the next step



  Scenario: TC-003 Verify that the Next button is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step


  Scenario: TC-004 Verify that the Previous button is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the "Previous" button
    And user waits 3 seconds
    Then The user verifies that they are redirected to the related page


  Scenario: TC-005 Verify that the Send for Review button is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    And user waits 3 seconds
    When The user fills the Description field
    When The user clicks the "Send for Review" button


  Scenario: TC-006 Verify that the Save as Draft button is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Save as Draft" button
    And user waits 5 seconds
    Then The user verifies the "My Bundles" title is visible


  Scenario: TC-007 Verify that the Delete button is visible and clickable

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the "Delete" button
    And user waits 3 seconds
    When The user confirms the deletion
    And user waits 3 seconds
    Then The user verifies the "My Bundles" title is visible


  Scenario: TC-008 Verify that the Extra Information form can be completed and that you can proceed to the next step with Next

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    And user waits 3 seconds
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    And user waits 3 seconds
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step





  Scenario: TC-009 Verify that the payment form can be completed in the Pricing step

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    And user waits 3 seconds
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    And user waits 3 seconds
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When clicks on the price option
    And user waits 3 seconds
    Then enters a price
    And user waits 5 seconds



  Scenario: TC-010 Verify that a pricing plan can be created via New Plan and appears in the list

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    And user waits 3 seconds
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    And user waits 3 seconds
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When clicks the New Plan button
    And user waits 3 seconds
    When fills in the Title field
    And user waits 3 seconds
    When fills in the Discount field
    And user waits 3 seconds
    When clicks on the start date field
    And user waits 3 seconds
    Then selects a date from the date picker
    And user waits 3 seconds
    When clicks the Apply button
    When clicks on the end date field
    Then selects a end date from the date picker
    When clicks the Apply button
    When clicks the Save button
    Then verifies that the new plan is created



  Scenario: TC-011 Verify that course content can be created under the Content section

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    And user waits 3 seconds
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    And user waits 3 seconds
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the Add Course button
    And user waits 3 seconds
    Then The user sees the "Add a new course to bundle" heading
    And user waits 3 seconds
    When The user clicks the course selection dropdown
    And user waits 3 seconds
    When The user selects the "Meta Social Media Marketing" course
    And user waits 3 seconds
    When The user clicks the Save button
    And user waits 3 seconds
    Then The user verifies that it was created



  Scenario: TC-012 Verify that an optional FAQ new item can be added under Frequently Asked Questions (FAQ)

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the New FAQ button
    Then The user sees the New FAQ heading
    When The user fills in the Title field
    And The user fills in the Answer box
    And user waits 3 seconds
    And The user clicks the Save button
    And user waits 3 seconds


  Scenario: TC-013 Verify that a message can be written and sent in Message to reviewer

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the Message to reviewer button
    Then The user sees the Message to reviewer heading
    When The user fills in the message box
    And user waits 3 seconds


  Scenario: TC-014 Verify that the ‘I agree with terms & rules’ checkbox is visible and functional, and that after agreeing the created course bundle appears in the list

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    When The user clicks the "Course Bundles" link
    When The user clicks the "New" button
    Then The user verifies that they are redirected to the related page
    When The user fills the title field
    When The user clicks the "Thumbnail" field
    Then The user uploads an image
    When The user clicks the "Cover Image" field
    Then The user uploads an image
    When The user fills the Description field
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the Category menu
    Then The user selects "Digital Marketing" from the dropdown
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    When The user clicks the "Next" button
    Then The user verifies that they have moved to the next step
    And user waits 3 seconds
    When The user clicks the Message to reviewer button
    Then The user sees the Message to reviewer heading
    When The user fills in the message box
    And user waits 3 seconds
    When the user toggles the "I agree with terms & rules" switch
    And user waits 3 seconds
    Then the user sees it is enabled
    And user waits 3 seconds
    When The user clicks the "Send for Review" button
    And user waits 3 seconds
    Then the user verifies the course bundle appears in the list


  Scenario: TC-015 In the Dashboard sidebar, under the ‘Course Bundles’ menu, the ‘My Bundles’ link should be visible and active

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    Then The login screen is displayed
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    Then The user verifies that they have logged in
    When The user clicks the "Course Bundles" link
    When The user clicks the "My Bundles" button
    Then the user verifies the course bundle appears in the list
    And user waits 3 seconds

  @aysnr
  Scenario: TC-016 Verify that after clicking My Bundles, the page lists course bundles and that relevant actions (view/edit/delete) can be performed on a selected bundle

    Given The user goes to the homepage URL
    When The user clicks the "Login" button in the homepage header
    Then The login screen is displayed
    When The user enters the "emailAysenur" address
    And The user enters the "passwordAysenur"
    When The user clicks the Login button
    Then The user verifies that they have logged in
    When The user clicks the "Course Bundles" link
    When The user clicks the "My Bundles" button
    Then the user verifies the course bundle appears in the list
    And user waits 3 seconds
    When The user clicks the three-dots menu
    Then The user verifies that the list has opened
    When The user clicks the Edit button
    When The user verifies that they are redirected to the related page
    When The user clicks the "My Bundles" button
    When The user clicks the three-dots menu
    Then The user verifies that the list has opened
    When the user clicks Delete
    When The user confirms the deletion
    And user waits 3 seconds

