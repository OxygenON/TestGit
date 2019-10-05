@sample
  Feature: Required fields
    
    @Testcase1
    Scenario: Happy path for required fields only
      Given I open url "http://skryabin.com/webdriver/html/sample.html"
      Then I should see page title as "Sample Page"
      When I click on element using JavaScript with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be displayed
      Then I type "Pumpkin" into element with xpath "//input[@id='firstName']"
      And I type "Pie" into element with xpath "//input[@id='lastName']"
      And I click on element using JavaScript with xpath "//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//button[1]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Pumpkin Pie"
      When I click on element using JavaScript with xpath "//input[@name='username']"
      Then I type "Halloween" into element with xpath "//input[@name='username']"
      And I type "qwe@fgfg.com" into element with xpath "//input[@name='email']"
      And I type "12367" into element with xpath "//input[@id='password']"
      And I type "12367" into element with xpath "//input[@id='confirmPassword']"
      And I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
      When I click on element using JavaScript with xpath "//button[@id='formSubmit']"
      Then element with xpath "//div[@class='well form-container container-fluid']" should be present

      @Testcase2
      Scenario: Required field "I have read and accept Privacy Policy." is not checked
        Given I open url "http://skryabin.com/webdriver/html/sample.html"
        Then I should see page title as "Sample Page"
        When I click on element using JavaScript with xpath "//input[@id='name']"
        Then element with xpath "//div[@id='nameDialog']" should be displayed
        Then I type "Pumpkin" into element with xpath "//input[@id='firstName']"
        And I type "Pie" into element with xpath "//input[@id='lastName']"
        And I click on element using JavaScript with xpath "//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//button[1]"
        Then element with xpath "//input[@id='name']" should have attribute "value" as "Pumpkin Pie"
        When I click on element using JavaScript with xpath "//input[@name='username']"
        Then I type "Halloween" into element with xpath "//input[@name='username']"
        And I type "qwe@fgfg.com" into element with xpath "//input[@name='email']"
        And I type "12367" into element with xpath "//input[@id='password']"
        And I type "12367" into element with xpath "//input[@id='confirmPassword']"
        When I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "- Must check!"
        And element with xpath "//div[@class='well form-container container-fluid']" should not be displayed


    @Testcase3
    Scenario: Form information confirmation
      Given I open url "http://skryabin.com/webdriver/html/sample.html"
      Then I should see page title as "Sample Page"
      When I click on element using JavaScript with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be displayed
      Then I type "Pumpkin" into element with xpath "//input[@id='firstName']"
      And I type "Pie" into element with xpath "//input[@id='lastName']"
      And I click on element using JavaScript with xpath "//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//button[1]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Pumpkin Pie"
      When I click on element using JavaScript with xpath "//input[@name='username']"
      Then I type "Halloween" into element with xpath "//input[@name='username']"
      And I type "Halloween@yhoo.com" into element with xpath "//input[@name='email']"
      And I type "12367" into element with xpath "//input[@id='password']"
      And I type "12367" into element with xpath "//input[@id='confirmPassword']"
      And I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
      When I click on element using JavaScript with xpath "//button[@id='formSubmit']"
      Then element with xpath "//div[@class='well form-container container-fluid']" should be present
      And element with xpath "//b[@name='firstName']" should contain text "Pumpkin"
      And element with xpath "//b[@name='lastName']" should contain text "Pie"
      And element with xpath "//b[@name='email']" should contain text "Halloween@yhoo.com"
      And element with xpath "//b[@name='username']" should contain text "Halloween"
      And element with xpath "//b[@name='name']" should contain text "Pumpkin Pie"
      And element with xpath "//b[@name='password']" should contain text "[entered]"
      And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"




