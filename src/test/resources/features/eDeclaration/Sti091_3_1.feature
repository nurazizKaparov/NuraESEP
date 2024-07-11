
Feature: Report STI-091_3_1

  Background: Go to eDeclaration page
    Given Authorization and go to the eDeclaration page
    When user click on link eDeclaration
    And user should see list of groups

  Scenario: Verifying Report Submission with default data for form sti_091_3_1
    Given user click on link Singletax
    And click on report sti_091_3_1
    Then user should see the report form sti_091_3_1
    And select tax period for form sti_091_3_1
    Then user click on save button in form sti_091_3_1
    And user should see form sti_091_3_1 successfully saved


  Scenario: Verifying Report Submission with default data for form sti_091_3_1
    Given user click on link Singletax
    And click on report sti_091_3_1
    Then user should see the report form sti_091_3_1
    And select tax period for form sti_091_3_1
    When insert data for sti_091_3_1
    When checking the sum of values for sti_091_3_1
    Then user click on save button in form sti_091_3_1
    And user should see form sti_091_3_1 successfully saved