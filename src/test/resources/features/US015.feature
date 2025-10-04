@erkan87
Feature: US_15

Scenario: [US_015] - [TC-ORG-001]: Verify Organizations Section Visibility

  Given the user navigates to the homepage "https://qa.instulearn.com/"
  When the "Organizations" heading is displayed
  Then the subtitle text "#Greatest education organizations are here to help you" should be displayed
  And the "All Organizations" button should be displayed


Scenario: [US_015] - [TC-ORG-002]: Verify Organizations Slider and Card Interaction

  Given the user navigates to the homepage "https://qa.instulearn.com/"
  And the "Organizations" heading is displayed
  When the horizontal slider band containing at least 4 organization cards is displayed
  And the user verifies the navigation dots (or arrow buttons) below the slider
  And the user clicks on the "Affogato Media" card displayed in the list
  Then the user is directed to the organization details page
  And the user clicks the back button to return to the homepage

  Scenario: [US_015] - [TC-ORG-003]: Verify Organizations All Cards

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And the "Organizations" heading is displayed
    When the horizontal slider band containing at least 4 organization cards is displayed
    And User views the Card logo and Text information located within the Slider area
      | King Card Logo     |
      | King Card Text     |
      | Owosso Card Logo   |
      | Owosso Card Text   |

  Scenario: [US_015] - [TC-ORG-004]: Verify Organizations All Cards

    Given the user navigates to the homepage "https://qa.instulearn.com/"
    And the "Organizations" heading is displayed
    And User views and clicks the All Organizations button
    And User should be redirected to the All Organizations page.









