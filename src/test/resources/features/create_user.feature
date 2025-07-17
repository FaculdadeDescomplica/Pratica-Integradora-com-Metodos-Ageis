Feature: Create User

  Scenario: Successfully create a user

    Given the user name is "Pedro"
    When I send a request to create the user
    Then the user should be saved with name "Pedro"