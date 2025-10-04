@yusuf26
Feature: As a registered user, I would like to have an area on the site where I can view and manage my certificates.

  @tc01
  Scenario: TC-001 As a registered user, I want the site to have an area where I can view and manage my certificates.
    Given The user accesses the homepage using the relevant URL.
    And The user clicks "Log In" and logs in with their valid instructor email and password.
    And The user scrolls down until they see the My Certificates link.
    Then The user clicks the Certificates button.

  @tc02
  Scenario: TC-002 As a registered user, I need to successfully log in to the site to view my Certificates in the Control Panel sidebar.
  Under the "Certificates" heading in the Control Panel sidebar, I should see the "List," "Achievements," "Certificate Verification," and
  "Certificates of Completion" links, and they should be active when I click them.
    Given The user accesses the homepage using the relevant URL.
    And The user clicks "Log In" and logs in with their valid instructor email and password.
    And The user scrolls down until they see the My Certificates link.
    Then The user clicks the Certificates button.
    Then The user clicks list.
    And The user clicks Achievements.
    And The user clicks Certificate Verification.
    And The user returns to the page first.
    And The user clicks Certificates of Completion The page scrolls down until the user sees the exit link first.
    Then The user clicks the Exit button first.

  @tc03
  Scenario: TC-003 When I click the 'List' icon, I should see Certificate statistics information on the page. In the list of active certificates,
  I should be able to view and edit any filtered certificates.
    Given The user clicks the List.
    Then Confirms that the Certificate statistics link is visible and active.
    And The user sees and clicks the filtering icons.
    And The page scrolls down until the user sees the exit link.
    Then The user clicks the Exit button.

  @tc04
  Scenario: TC-004 When I click the 'Achievements' link, I should see Achievement statistics information on the page. In the list of successful
  certificates, I should be able to view, edit, and delete filtered certificates.
    Given The user clicks the "Achievements" heading.
    Then The user sees the "My certificate statistics" heading.
    And The user sees and clicks the filter icons.
    And The user clicks the Certificates button again.
    And The user scrolls down until they see the exit link.
    Then The user clicks the Exit button again.

  @tc05
  Scenario: TC-005 When I click the 'Certificate Verification' link, I should be redirected to the certificate verification page.
  Verification should be successful if a valid certificate ID and captcha are entered.
    Given The user clicks the Certificate Verification banner.
    Then The user sees the ID and captcha.
    And The user returns to the page.
    And The page scrolls down until the user sees the exit link again.
    Then The user clicks the Exit button last again.

  @tc06
  Scenario: TC-006 When I click the 'Completed Certificate' link, I can view, edit, and delete filtered certificates in the list of
  completed certificates.
    Given The user clicks the Completion Certificates heading.
    Then The user sees the Filter certificates heading.
    And The user clicks the Show Results heading.
    And The page scrolls down until the user sees the exit link last.
    Then The user clicks the Exit button last.
    And The user closes the page.
