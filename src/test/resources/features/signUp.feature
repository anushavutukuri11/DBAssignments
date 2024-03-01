Feature: Load the Demo Automation Practice form and perform actions on webelements
  I want to use this template for my feature file

@ActionsonWebelements
  Scenario: Performing different actions on Demo Websiste
  Given The browser is launched enter the Demo automation Practice form URL
    And Enter valid first name
    And  Enter valid Last name
    And Select the gender
    And Select the number of years of experience
    And Enter Date
    And Enter profession
    And Enter Automation Tools
    And Enter Continents
    And Enter Selenium Command
   # And Upload the file to be choosen
    When Download the file
    Then Click on submit button
   # Then Verify the title of the page
    
    