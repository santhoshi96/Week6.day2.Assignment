Feature: Create incident in Service Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Type username as 'Admin'
And Type password as 'India@123'
And click Login Button
And click filter


Scenario Outline: Create Incident with Multiple Data
When type filter as <filterNav>
And click create New
And get incident number
And click caller
And select System Administrator in caller
And type Short Description as 'Testing'
And click on Submit button
Then verify Incident Created

Examples:
|filterNav|
|Incident|