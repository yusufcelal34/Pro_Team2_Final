@eda5
Feature: As a visitor, I would like to have easy links on the top bar of the home page so that
  I can easily navigate around the site.

  @eda
  Scenario: [TC_01] Verifying the visibility of header section links

    Given the user goes to the homepage
    Then The user verifies that the links in the header section are visible.
      | Categories     |
      | Home           |
      | Courses        |
      | Instructors    |
      | Store          |
      | Blog           |


  @eda2
  Scenario: [TC_02] Verifying the accessibility of header section links

    Given the user goes to the homepage
    Then The user verifies that the links in the header section are accessible.
      | Categories     |
      | Home           |
      | Courses        |
      | Instructors    |
      | Store          |
      | Blog           |

  @eda3
    Scenario Outline: Verify filtering icons for selected category
      Given the user goes to the homepage
      When the user clicks on the Categories link
      And the user selects the "<Category>" category
      Then the user verifies that the filtering icons are visible and active on the page
        | Upcoming      |
        | Free          |
        | Discount      |
        | Download      |
        | Newest        |
        | Type          |
        | More Actions  |

      Examples:
        | Category       |
        | Development    |
        | Business       |
        | Marketing      |
        | Lifestyle      |
        | Health Fitness |
        | Web Design     |
        | Syber Security |
        | Testing        |

  @eda4
  Scenario: [TC_03] Verify that the filters are visible and active on each of the Courses, Instructors, and Store pages.
    Given the user goes to the homepage
    When the user clicks on the Courses link
    Then the user verifies that the filtering icons are visible and active on Courses
      | Upcoming      |
      | Free          |
      | Discount      |
      | Download      |
      | Newest        |
      | Type          |
      | More Actions  |

    When the user clicks on the Instructors link
    Then the user verifies that the filtering icons are visible and active on Instructors
      | Available for Meetings |
      | Free Meetings          |
      | Discount               |
      | Sort by                |

    When the user clicks on the Store link
    Then the user verifies that the filtering icons are visible and active on Store
      | Free          |
      | Free Shipping |
      | Discount      |
      | Sort by       |
      | Type          |
      | Options       |


  Scenario: [TC_04] The site logo, cart, notifications and search box should be visible and functional
    Given the user goes to the homepage
    And The user verifies that the elements is visible
      | InstuLearn Logo     |
      | Navbar Shoping Cart |
      | Search              |
    And The user verifies that the elements is active
      | InstuLearn Logo     |
      | Navbar Shoping Cart |
      | Search              |
    Then the user verifies that the homepage is refreshed

  @eda6
  Scenario: [TC_05] The Start Learning icon, Login and Register links should be visible and navigate correctly
    Given the user goes to the homepage
    And the user verifies that the Start Learning icon is visible
    When the user clicks on the Start Learning icon
    Then the user verifies that the related page is opened
    And the user verifies that the Login link is visible
    When the user clicks on the Login link
    Then the user verifies that the Login page is opened
    And the user verifies that the Register link is visible
    When the user clicks on the Register link
    Then the user verifies that the Register page is opened



