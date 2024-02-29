Feature: Load the Demo Automation Practice form and perform actions on webelements
  I want to use this template for my feature file

Background: 
Given Launch the chrome Browser
When The browser is launched enter the Demo automation Practice form URL
Then User is on Demo automation Practice form  page and verify the title of the webpage

@ActionsonWebelements
  Scenario: Performing different actions on Demo Websiste
    Given Enter valid first name
    And  Enter valid Last name
    And Select the gender
    And Select the number of years of experience
    And Enter Date
    And Enter profession
    And Enter Automation Tools
    And Enter Continents
    And Enter Selenium Command
   # And Upload the file to be choosen
    And Download the file
    When Click on submit button
    Then Verify the title of the page
    
    