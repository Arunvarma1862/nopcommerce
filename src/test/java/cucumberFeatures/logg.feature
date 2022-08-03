Feature: OrangeHrm login

Scenario: Logo pressence on orangeHRm home page
Given i Launch chrome browser
When i open orange hrm homepage
Then i verify that the logo presence on page
And close browser