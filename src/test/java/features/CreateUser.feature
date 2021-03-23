Feature: Application Login

Scenario Outline: Acti time Home page default login
Given user is on Actitime login landing page
When user login into applicattion with username "<username>" and password "<password>"
Then Click onLogin Button
And Login successful msg should display
And Click on Users Button
And Click on AddUser Button
And Passing all Parameters "<firstname>" "<lastname>" "<email>" "<usernameone>" "<passwordone>" "<retypePassword>"




Examples:
    |username | password | firstname | lastname | email            | usernameone   |passwordone   |retypePassword |
    |admin    | manager  | kiran     | Halagi   | abc123@gamil.com | abc123        |abc@1234      |abc@1234       |
    