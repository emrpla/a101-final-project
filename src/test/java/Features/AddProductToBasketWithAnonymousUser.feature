Feature: Simple shopping example without purchase
  Scenario: Add two same product with different seller to the basket with anonymous user.

    Given a web browser is at the Hepsiburada home page
    And user search a sample product
    And user add two product from two different site
    When user clicks on my basket
    Then verify that products added to the user's basket
