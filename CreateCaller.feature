Feature: Create caller in Service Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Type username as 'Admin'
And Type password as 'India@123'
And click Login Button
And click filter


Scenario Outline: Create Caller with Multiple Data
When type filter as <filterNav>
And click Caller
And click New button to create caller
And type firstname as <firstName>
And type lastname as <lastName>
And type Email as <emailId>
And get firstname
And tick Submit
Then verify caller Created

Examples:
|filterNav|firstName|lastName|emailId|
|Caller|Santhoshi|Meena|santhoshi1996@gmail.com|