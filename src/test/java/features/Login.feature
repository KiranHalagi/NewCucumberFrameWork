Feature: Application Login

Scenario Outline: Acti time Home page default login
Given user is on Actitime login landing page
When user login into applicattion with username "<username>" and password "<password>"
Then Click onLogin Button
And Login successful msg should display

Examples:
    |username | password |
    |admin   | manager  |
    
#Scenario: Create User
#Given user is on Actitime login landing page
#When user login into applicattion with username "<username>" and password "<password>"
#Then Click onLogin Button
#Then Create user
#And Validating User is created Successfully or not


    
    
