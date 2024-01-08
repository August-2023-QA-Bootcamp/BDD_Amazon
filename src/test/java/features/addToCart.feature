@cart
Feature: Amazon Add To Cart for Guest User

	@smoke
  Scenario: Guest Add to Cart verification
    Given user is in the homepage
    And user clicks on search box
    And user type in 'iphone 15'
    When user click the search icon
    Then user will see 'iphone 15' from the result
    When user click the first item
    And select storage
    And click 'add to cart' button
    Then cart item number will increase

	@regression
  Scenario: Guest Add to Cart verification 2
    Given user is in the homepage
    And user clicks on search box
    And user type in 'iphone 15'
    When user click the search icon
    Then user will see 'iphone 15' from the result
    When user click the first item
    And select storage
    And click 'add to cart' button
    Then cart item number will increase
