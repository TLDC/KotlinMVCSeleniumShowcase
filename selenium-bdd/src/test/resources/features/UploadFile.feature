@UploadFile
Feature: Upload file

  Scenario: Successful upload
    Given the file upload page is visited
    When the user submits a valid file
    Then the file upload is a SUCCESS

  Scenario: Unsuccessful upload
    Given the file upload page is visited
    When the user submits an invalid file
    Then the file upload is a FAILURE

