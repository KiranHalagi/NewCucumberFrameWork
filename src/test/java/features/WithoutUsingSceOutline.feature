Feature: Application Login

Scenario: Acti time Home page default login
Given user is on Actitime login landing page
When user login into applicattion with username  and password 
|admin    | manager  |
Then Click onLogin Button
And Login successful msg should display
