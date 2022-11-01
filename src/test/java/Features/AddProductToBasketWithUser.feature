Feature: Simple shopping example without purchase
  Scenario: Add two same product with different seller to the basket with registered user

    Given a web browser is at the hepsiburada home page
    And user login to the site
    And verify that the user login successfully
    And user search a specific product
    And user add two product from two different seller
    When user clicks on my basket button
    Then verify that two products added to the user's basket
