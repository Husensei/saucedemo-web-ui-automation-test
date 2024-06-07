Feature: Web Automation Test

  @web @login @positive
  Scenario: Test login web
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page

  @web @login @negative
  Scenario: Test login web locked out user
    Given user is on login page
    When user input username "locked_out_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see error message "user has been locked out"

  @web @login @negative
  Scenario: Test login web invalid username and password
    Given user is on login page
    When user input username "username"
    And user input password "password"
    And user clicks login button
    Then user should see error message "Username and password do not match"

  @web @items @positive
  Scenario: Test add to cart
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks add to cart button 3 time(s)
    Then verify number of items in cart matches

  @web @items @positive
  Scenario: Test remove from cart
    Given user is on login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user clicks login button
    Then user should see cart icon on inventory page
    When user clicks add to cart button 3 time(s)
    Then verify number of items in cart matches
    When user clicks remove button 3 time(s)
    Then verify number of items in cart matches