@Form
Feature: Enter form details

  Scenario: The user enters form details successfully
    Given the form page is visited
    And the user completed the form with the following data
      | Name     | Age | Gender | Height | Confirmed |
      | Selenium | 27  | M      | 174.5  | true      |
    When the submit button is clicked
    Then the summary is shown

  Scenario: The user enters more form details successfully
    Given the form page is visited
    And the user completed the form with the following data
      | Name      | Age | Gender | Height | Confirmed |
      | Selenium2 | 17  | F      | 20.0   | false     |
    When the submit button is clicked
    Then the summary is shown
