@java
  Feature: Java steps
    @Java1
    Scenario: Initial Java scenario
      Given I write  first  step
      And I print "Hi" in console
      And I do action with "Apple" and "Orange"
      And I compare "str1" and "str2"

    @java2
    Scenario: Java steps with numbers
      Given I run operators with 10 and 3
      And I do addition with numbers int1 and int2

    @Java2
    Scenario: Java arrays
     Given I print arrays







