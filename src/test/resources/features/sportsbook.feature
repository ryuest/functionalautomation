@all
Feature: Sportstbook

@Test
Scenario: Navigation to my sportsbook page
Given user go to mine-portfolio site
When the user enter correct credentials
When Click selection
When Add Stake
When Place the bet
Then page show 'Bet Placed!'