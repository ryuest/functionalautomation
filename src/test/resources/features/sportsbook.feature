@all
Feature: Sportstbook

  @Test
  Scenario: Navigation to my sportsbook page
    Given User go to mine-portfolio site
    When The user enter correct credentials
    When Click selection
    When Add Stake
    When Place the bet
    Then Page show 'Bet Placed!'