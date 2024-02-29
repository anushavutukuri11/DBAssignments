Feature: Perform the search operations on google.com
  
@SearchFunctionality
Scenario: Perform the search operations on google.com
Given Launch the chrome Browser to perform search operations
When Perform the search action on the search bar
And  Print the respective suggestion and click the respective suggestion 
Then User is quit the  chrome browser