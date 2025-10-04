Feature: Verify Store Link Visibility and Functionality on Homepage
  @niko
  Scenario: Store link should be visible and clickable
    Given I am on the homepage
    When I check the "Store" link visibility
    And I click the "Store" link
    Then I have to redirected to the "Store" page


  Scenario: Verify "Products" text is displayed after clicking the link
    Given I am on the homepage
    When I click the "Products"list link
    Then the text of "Products" should be displayed



  @niko2
  Scenario: Check visibility and clickability of search elements

    Given I am on the Products page
    Then the search textbox should be visible and enabled
    And the search button should be visible and enabled

@nihad3



  Scenario: User applies filters before selecting a product


  Given I am on the homepage
  And I click and reach "Store" link
    Given I am on the product page
    When I click the "Free", "Free Shipping", and "Discount" filters

  @nihad4
  Scenario: Verify product details are visible after selecting a product

    Given I am on the homepage
    And I click and reach "Store" link
    Then Price, Seller, Product Name, and Description information of the selected product should be visible
    And I select a product

@nihad5
Scenario: Verify product details are visible after selecting a bombey

    Given I am on the homepage
    And I am login
    And I click and reach "Store" link
  And I select a product
  Then "Add to Cart"and buy now  button should be visible and enabled
    And product details should be displayed
    And rating and comments should be visible

@nihad6
  Scenario: payment
  Given I am on the homepage
  And I am login
  And I click and reach "Store" link
  And I select a product
    Then  I Select buy know and click checkout and choose payment method
    Then  click start payment and pay


