@regression
Feature: input field feature

  @regression
  Scenario Outline: fill up the input form with valid data
    Given I am in homepage and click input to navigate the input form
    When I fillup the input form "<fullName>" add value "<AppendText>"
    And I retrive value from "<textBox>"
    And I Clear the text in clearField
    And I verify the email confirm field is enbled or not
    And I Confirm the text "<confirmText>"
    Then I validate the title "<Title>" and THE Url "<Url>"

    Examples: 
      | fullName         | AppendText | textBox  | confirmText           | Title                      | Url                     |
      | Rayhan Chowdhury | boy        | ortonikc | This text is readonly | Interact with Input fields | https://letcode.in/edit |
