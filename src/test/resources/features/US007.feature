
Feature: Store Products section on Home

  Background:
    Given The user on the homepage "url"
  Scenario:TC-01 Store Products heading and slider are visible

    When I scroll to the body store section
    Then the Store Products heading should be visible
    And a product slider should be visible with at least one product card


  Scenario:TC-02 Product card shows price, rating, and add-to-cart icon

    When I inspect the first product card
    Then the card should display a price
    And the card should display a rating
    And the card should display an add to cart icon

  Scenario:TC-03 Clicking a product card navigates to its detail page
    When I click the first product card
    Then the product detail page should open
    And the product title should be visible


  Scenario:TC-04 "All product" button lists all products
    When I click the All product button
    Then the product listing page should open
    And all products should be listed

