Feature: Google Search

  Scenario: Navigation to google page
    Given user go to google site
    When Do search
    Then Football page shown as 'Football - BBC Sport'