Feature: Load the Demo webtables and perform actions on tables
  
@HandlingTables
Scenario: Performing actions on dynamic and static webtables
Given Launch the chrome Browser with Demotables URL
When Perform the actions on the static webtable
And  Perform actions on Dynamic webtable 
Then User is quit the browser

    