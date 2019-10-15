@webdriver
  Feature: Webdriver methods
    @webdriver1
    Scenario: Open the page
      Given I go to "google" page and print details
      And I go "sample" page and print details
      And I go back and forward then refresh the page

    @ webdriver2
      Scenario: Elements on the page
        Given I go to "sample" page and print some info
        When I fill out first name "Peter" and last name "Orange"
        And I fill out required fields
        Then I assert submitted data

#Home work part

    @webdriver3
    Scenario: test not required fields
      Given I go to "sample" page
      When I fill out first name "Oksana" and last name "Nahibina"
      And I fill out required fields
      And I fill out not required fields
      Then I assert submitted data





