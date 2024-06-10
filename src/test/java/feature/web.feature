@web
Feature: Web Automation Test

  @login @positive
  Scenario: Test login web
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page

  @login @negative
  Scenario: Test login web locked out user
    Given user is on login page
    When user input username "locked_out_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see error message "user has been locked out"

  @login @negative
  Scenario: Test login web invalid username and password
    Given user is on login page
    When user input username "username"
    And user input password "password"
    And user clicks login button
    Then user should see error message "Username and password do not match"

  @login @negative
  Scenario: Test login web blank input on password field
    Given user is on login page
    When user input username "username"
    And user input password ""
    And user clicks login button
    Then user should see error message "Password is required"

  @login @negative
  Scenario: Test login web blank input on username field
    Given user is on login page
    When user input username ""
    And user input password "password"
    And user clicks login button
    Then user should see error message "Username is required"

  @items @positive
  Scenario: Test add items to cart
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks add to cart button 3 time(s)
    Then verify number of items in cart matches

  @items @positive
  Scenario: Test add specific items to cart
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks add to cart button on "Sauce Labs Bolt T-Shirt"
    Then verify number of items in cart matches
    When user clicks the cart icon
    Then user redirected to cart page
    And user should see the "Sauce Labs Bolt T-Shirt" item in cart

  @items @positive
  Scenario: Test remove items from cart
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks add to cart button 3 time(s)
    Then verify number of items in cart matches
    When user clicks remove button 3 time(s)
    Then verify number of items in cart matches

  @items @positive
  Scenario: Test sort items by name ascending
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks sort button and select "Name (Z to A)"
    Then user should see the items sorted by "Name (Z to A)"