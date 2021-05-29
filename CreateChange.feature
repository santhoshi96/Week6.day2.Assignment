Feature: Create Change in Service Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Type username as 'Admin'
And Type password as 'India@123'
And click Login Button
And click filter


Scenario Outline: Create Change with Multiple Data
When type filter as <filterNav>
And click create New change
And click Normal
And get change number
And Enter Short Description as 'Hii'
And click on the Submit
And click Open
Then verify Change Created

Examples:
|filterNav|
|Change|