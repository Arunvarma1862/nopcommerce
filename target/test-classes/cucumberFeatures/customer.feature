Feature:  Customers

Background: below are common steps for every scenario
Given User launch chrome Browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then User can view DashBoard

Scenario: Add customer

When user click on customer menu
And  user click on customer menu item
And click on add new button
Then user can view add new customer page
When user enter customer info
And click on save button
Then user can view confirmation meassage "The new customer has been added successfully"
And close browsers


Scenario: search customer by emailid

When user click on customer menu
And  user click on customer menu item
And enter customer email
When click on search button
Then user should und email in search table
And close browsers 


Scenario: search customer by First and lastName

When user click on customer menu
And  user click on customer menu item
And enter customer first name
And enter customer last name
When click on search button
Then user should found First and lastName in search table
And close browsers 

