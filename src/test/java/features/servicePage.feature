@ServiceQuery
Feature: Contact and Query resolving services
  As a user
  I want to use different service options (Email, Call, Chat)
  So that I can contact and resolve my queries.

  Scenario: Validate only one option selection in service page
    Given I open the site and navigate to the Services page
    When I select the "Email" option
    And I select the "Call" option
    And I select the "Chat" option
    Then Only one option should remain selected

  Scenario: Validate Email option with valid email id
    Given I open the site and navigate to the Services page
    When I select the "Email" option
    And I enter email id "valid@example.com"
    And I enter email query "Need help with my account"
    And I click the submit button
    Then I should see a successful email validation message

  Scenario: Validate Email option with invalid email id
    Given I open the site and navigate to the Services page
    When I select the "Email" option
    And I enter email id "invalid-email"
    And I enter email query "Need help with my account"
    And I click the submit button
    Then I should see an error message for invalid email

  Scenario: Validate Email option with blank email id
    Given I open the site and navigate to the Services page
    When I select the "Email" option
    And I leave the email id field blank
    And I enter email query "Need help with my account"
    And I click the submit button
    Then I should see an error message for blank email

  Scenario: Validate Chat section with valid phone number
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I enter user name "Ritam"
    And I enter phone number "7812903454"
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see a successful phone validation message

  Scenario: Validate Chat section with invalid phone number
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I enter user name "Ritam"
    And I enter phone number "abc123"
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see an error message for invalid phone

  Scenario: Validate Chat section with blank phone number
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I enter user name "Ritam"
    And I leave the phone number field blank
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see an error message for blank phone number

  Scenario: Validate Chat section with valid name
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I enter user name "Ritam"
    And I enter phone number "7812903454"
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see a successful name validation message

  Scenario: Validate Chat section with invalid name
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I enter user name "1234@@"
    And I enter phone number "7812903454"
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see an error message for invalid name

  Scenario: Validate Chat section with blank name
    Given I open the site and navigate to the Services page
    When I select the "Chat" option
    And I leave the name field blank
    And I enter phone number "7812903454"
    And I enter chat query "Need help with my account"
    And I click the submit button
    Then I should see an error message for blank name