Feature: Manage todo list

  Background : Given User navigates ToDoMVC page

  Scenario Outline: Enter todo List

    When user enter "<todoItem>" in the textfield
    Then user entered "<todoItem>" should be added
    And proper count should be displayed

    Examples:
      |todoItem             |
      |Requirement analysis |
      |Test case development|
      |Test Execution       |

  Scenario: Select completed items


    When user select items as complete
    Then count should be updated properly
    And user verifies items should be in completed list

  Scenario: Clear completed items

    When user click clear completed
    Then completed list should be cleared


