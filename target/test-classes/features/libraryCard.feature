@LibraryCard
Feature: Validate the Get a Library Card form fields

  Background:
    Given the user is on the Get a Library Card form page

  Scenario: Enter an invalid first name
    When the user enters "1234" as the first name
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then no error message should appear for the first name

  Scenario: Enter an invalid last name
    When the user enters "John" as the first name
    And enters "99last" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then no error message should appear for the last name

  Scenario: Leave the first name blank
    When the user leaves the first name field blank
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please Enter first name"

  Scenario: Enter an incorrect age
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And enters "abc" as the age
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please enter a valid age"

  Scenario: Leave the age field blank
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And leaves the age field blank
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please enter the age"

  Scenario: Enter an invalid email
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "email@invalid" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please enter a valid email"

  Scenario: Enter an invalid phone number
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And enters "abc123" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please enter a valid phone number"

  Scenario: Leave the phone number field blank
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And leaves the phone number field blank
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then an error message should appear saying "Please Enter the phone"

  Scenario: Submit the form with all valid data
    When the user enters "John" as the first name
    And enters "Doe" as the last name
    And enters "25" as the age
    And enters "john.doe@example.com" as the email
    And enters "9876543210" as the phone number
    And selects "Student" as the occupation
    And enters "Greenwood High" as the school name
    And selects "Apply New Card" as the action
    And submits the form
    Then the browser should close