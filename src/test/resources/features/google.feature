@all
Feature: Google Search

  @Google
  Scenario: Navigation to google page
    Given User go to google site
    When Do search
    Then Football page shown as 'Football - BBC Sport'

  @Google2
  Scenario: Navigation to google page
    Given User go to mine site
    When Do search
    Then Football page shown as 'Football - BBC Sport'

