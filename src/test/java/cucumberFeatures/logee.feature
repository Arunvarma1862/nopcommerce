Feature: Login

@sanity
Scenario: Successful login with valid Credentials
Given User launch chrome Browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When user click on logout link
Then Page Title should be "Your store. Login"
 And close browsers
 
 
 
 Scenario Outline: Login Data Driven
 Given User launch chrome Browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enters email as "<email>" and password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When user click on logout link
Then Page Title should be "Your store. Login"
 And close browsers
 
 
 Examples:
 
 |email|password|
| admin@yourstore.com  |admin|
| admin12@yourstore.com  |admin123|
 