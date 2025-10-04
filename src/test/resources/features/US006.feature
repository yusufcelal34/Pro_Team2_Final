Feature: US-006 As a user, I would like to be able to log in with the email and password I registered with the site.


  Scenario: TC-001 Verify the visibility of the "Latest bundles" heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Latest bundles" heading
    Then The user verifies that the "Latest bundles" heading is visible


  Scenario: TC-002 Verify the basic information displayed on a course card under the “Latest bundles” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Latest bundles" heading
    Then The user verifies that the price, duration, date, and instructor information are displayed on the course cards.


  Scenario: TC-003 Verify that clicking a course card under the “Latest bundles” heading in the homepage body redirects to the relevant course detail page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Latest bundles" heading
    When The user clicks the card
    Then The user verifies that the URL has changed


  Scenario: TC-004 Verify the visibility of the “Upcoming Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Upcoming Courses" heading
    Then The user verifies that the "Upcoming Courses" heading is visible


  Scenario: TC-005 Verify the basic information displayed on a course card under the “Upcoming Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Upcoming Courses" heading
    Then The user verifies that the price, duration, date, and instructor information are displayed on the course cards.


  Scenario: TC-006 Verify that clicking a course card under the “Upcoming Courses” heading in the homepage body redirects to the relevant course detail page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Upcoming Courses" heading
    When The user clicks the card
    Then The user verifies that the URL has changed


  Scenario: TC-007 Verify the visibility of the “Trending Categories” heading and category cards in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Trending Categories" heading
    Then The user verifies that the "Trending Categories" heading is visible


  Scenario: TC-008 Verify a category card under the “Trending Categories” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Trending Categories" heading
    Then The user verify card visibility


  Scenario: TC-009 Verify that clicking a category card under the “Trending Categories” heading in the homepage body redirects to the relevant category page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Trending Categories" heading
    When The user clicks the card
    Then The user verifies that the URL has changed


  Scenario: TC-010 Verify the visibility of the “Bestselling Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Bestselling Courses" heading
    Then The user verifies that the "Bestselling Courses" heading is visible


  Scenario: TC-011 Verify the basic information displayed on a course card under the “Bestselling Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Bestselling Courses" heading
    Then The user verifies that the price, duration, date, and instructor information are displayed on the course cards.


  Scenario: TC-012 Verify that clicking a course card under the “Bestselling Courses” heading in the homepage body redirects to the relevant course detail page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Bestselling Courses" heading
    When The user clicks the card
    Then The user verifies that the URL has changed


  Scenario: TC-013 Verify the visibility of the “Free Courses” heading in the homepage body.
    Given The user goes to the homepage URL
    When The user scrolls to the "Free Courses" heading
    Then The user verifies that the "Free Courses" heading is visible


  Scenario: TC-014 Verify the basic information displayed on a course card under the “Free Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Free Courses" heading
    Then The user verifies that the price, duration, date, and instructor information are displayed on the course cards.


  Scenario: TC-015 Verify that clicking a course card under the “Free Courses” heading in the homepage body redirects to the relevant course detail page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Free Courses" heading
    When The user clicks the card
    Then The user verifies that the URL has changed


  Scenario: TC-016 Verify the visibility of the “Discounted Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Discounted Courses" heading
    Then The user verifies that the "Discounted Courses" heading is visible


  Scenario: TC-017 Verify the basic information displayed on a course card under the “Discounted Courses” heading in the homepage body.

    Given The user goes to the homepage URL
    When The user scrolls to the "Discounted Courses" heading
    Then The user verifies that the price, duration, date, and instructor information are displayed on the course cards.


  Scenario: Scenario: TC-018  Verify that clicking a course card under the “Discounted Courses” heading in the homepage body redirects to the relevant course detail page.

    Given The user goes to the homepage URL
    When The user scrolls to the "Discounted Courses" heading
    When The user clicks the card
    Then The user verifies that the URL has changed