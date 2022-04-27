#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login to an application

Scenario: Login with Valid Credentials
	Given Initialize browser with chrome
	Given I go to Modulr Customer Page
	When I enter Username as "Kiran.Chopade70"
	And I enter Password as "Password@123"
	And I click on Login Button
	Then I should log in
	Then close the Browser
	
Scenario: Pass Invalid Credentials
	Given Initialize browser with chrome
	Given I go to Modulr Customer Page
	When I enter Username as "Kiran"
	And I enter Password as "1234"
	And I click on Login Button
	Then I should not log in
	Then close the Browser
	
Scenario: Pass Only UserName
	Given Initialize browser with chrome
	Given I go to Modulr Customer Page
	When I enter Username as "Kiran"
	And I enter Password as ""
	And I click on Login Button
	Then I should get message as "This field is required"
	Then close the Browser