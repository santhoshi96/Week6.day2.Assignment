Feature: Delete existing caller in Service Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Type username as 'Admin'
And Type password as 'India@123'
And click Login Button
And click filter


Scenario Outline: Delete Caller with Multiple Data
When type filter as <filterNav>
And click on Caller
And set lastname in search dropdown
And enter lastname in search box 'Meena'
And click firstOption
And click delete button
Then Print caller is deleted

Examples:
|filterNav|
|Caller|