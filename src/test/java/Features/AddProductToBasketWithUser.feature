Feature: Add a product to the basket with registered user
  Scenario: A registered user add two product to his basket

    Given a web browser is at the hepsiburada home page
    And user login to the site
    And verify that the user login successfully
    And user search a spesific product
    And user add two product from two different seller

