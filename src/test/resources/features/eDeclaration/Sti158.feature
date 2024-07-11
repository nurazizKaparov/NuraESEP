Feature: Report STI-158

  Background: Go to eDeclaration page
    Given Authorization and go to the eDeclaration page
    When user click on link eDeclaration
    And user should see list of groups

  Scenario: Verifying Report Submission with default data
    Given user click on link Other
    And click on report sti158
    When user should see the report form sti158
    When select tax period for sti158
    Then user click on save button for sti158
    And user should successfully saved for sti158


  Scenario: Verifying Report Submission with data
    Given user click on link Other
    And click on report sti158
    When user should see the report form sti158
    When select tax period for sti158
    When insert data for sti158
    When checking the sum of values
    Then user click on save button for sti158
    And user should successfully saved for sti158