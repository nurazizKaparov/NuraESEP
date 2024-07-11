
Feature: Report STI-100-4

  Background: Go to eDeclaration page
    Given Authorization and go to the eDeclaration page
    When user click on link eDeclaration
    And user should see list of groups

  Scenario: Verifying Report sti_100_4 warning empty period field
    Given user click on link navVPillsTab
    When click on report sti_100_4
    And user should see the report form sti_100_4
    Then user click on save button in form sti_100_4
    And user should see form sti_100_4 warning empty period field

  @Smoke
  Scenario: Verifying Report sti_100_4 fill detail 3
    Given user click on link navVPillsTab
    When click on report sti_100_4
    And user should see the report form sti_100_4
    Then insert data for sti_100_4
    And select checkbox detail_3 - sti_100_4
    When click on button understand
    And user should see title text of the detail_3 sti_100_4
    Then click on add row button for section_1 detail_3 sti_100_4
    When fill in the row fields for section_1 detail_3 sti_100_4
    Then click on add row button for section_1 detail_3 sti_100_4
    When fill in the row fields for section_1 detail_3 sti_100_4
    Then check calculation for section_1 detail_3 sti_100_4
    And  delete last row for section_1 detail_3 sti_100_4
    Then click on add row button for section_2 detail_3 sti_100_4
    When fill in the row fields for section_2 detail_3 sti_100_4
    Then click on add row button for section_2 detail_3 sti_100_4
    When fill in the row fields for section_2 detail_3 sti_100_4
    Then check calculation for section_2 detail_3 sti_100_4
    And  delete last row for section_2 detail_3 sti_100_4
    Then click on add row button for section_3 detail_3 sti_100_4
    When fill in the row fields for section_3 detail_3 sti_100_4
    Then click on add row button for section_3 detail_3 sti_100_4
    When fill in the row fields for section_3 detail_3 sti_100_4
    Then check calculation for section_3 detail_3 sti_100_4
    And  delete last row for section_3 detail_3 sti_100_4
    Then click on add row button for section_4 detail_3 sti_100_4
    When fill in the row fields for section_4 detail_3 sti_100_4
    Then click on add row button for section_4 detail_3 sti_100_4
    When fill in the row fields for section_4 detail_3 sti_100_4
    Then check calculation for section_4 detail_3 sti_100_4
    And  delete last row for section_4 detail_3 sti_100_4
    Then click on add row button for section_5 detail_3 sti_100_4
    When fill in the row fields for section_5 detail_3 sti_100_4
    Then click on add row button for section_5 detail_3 sti_100_4
    When fill in the row fields for section_5 detail_3 sti_100_4
    Then check calculation for section_5 detail_3 sti_100_4
    And  delete last row for section_5 detail_3 sti_100_4
    Then click on add row button for section_6 detail_3 sti_100_4
    When fill in the row fields for section_6 detail_3 sti_100_4
    Then click on add row button for section_6 detail_3 sti_100_4
    When fill in the row fields for section_6 detail_3 sti_100_4
    Then check calculation for section_6 detail_3 sti_100_4
    And  delete last row for section_6 detail_3 sti_100_4
    Then user click on save button in form sti_100_4
