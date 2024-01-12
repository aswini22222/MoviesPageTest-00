Feature: Default
     Scenario: User logs in and views account details
       Given the user navigates to the login page
              When the user enters valid username and password
              When clicks on the login button
              Then the user should be successfully logged in

  Scenario: User login Functionality
    Given the user is logged in
    When the user navigates to the membership details page
    Then the user should see the membership details
    And the membership plan should be Premium Ultra HD

  Scenario: User logout Functionality
    Given The user is logged in
    When the user clicks on the logout button
    Then the user should be successfully logged out
    And redirected to the login page
