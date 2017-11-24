Feature: Google Search

  Scenario: Navigation to my sportsbook page
    Given user go to mine-portfolio site
    When the user enter correct credentials
    When Click seletion
    When Add Stake
    When Place the bet
    Then page show 'Bet Placed!'

  Scenario: Navigation to google page
    Given user go to google site
    When Do search
    Then Football page shown as 'Football - BBC Sport'

