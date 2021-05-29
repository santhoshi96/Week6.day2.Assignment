Feature: Create proposal in Service Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Type username as 'Admin'
And Type password as 'India@123'
And click Login Button
And click filter


Scenario Outline: Create proposal with Multiple Data
When type filter as <filterNav>
And click My Proposals
And click New button
And get proposal number
And type Template Description as 'Test'
And type the Short Description
And click on Submit
Then verify Proposal Created

Examples:
|filterNav|
|proposal|