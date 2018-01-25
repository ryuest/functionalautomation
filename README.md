# Functional Automation

Here my Functional Automation Techniques

Small example of functional automation using Java, WebDriver Selenium, Maven, JUNIT and Cucumber.io BDD.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* [JAVA JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - Java SE Development Kit). For Java Developers. Includes a complete JRE plus tools for developing, debugging, and monitoring Java applications.
* [Maven](https://maven.apache.org/) - for downloading, building and managing any Java-based project


### Run

To build install and start

```
mvn clean install -Dtest=TestRunner "-Dcucumber.options= --tags @All"
```

JUNIT Class: cucumber.test.TestRunner and VM Options: "-Dcucumber.options=--tags @all"
```

## Built With

* [Cucumber](https://cucumber.io/) - for Behaviour-Driven Development, executes your .feature files, and those files contain executable specifications written in a language called Gherkin
* [Selenium](http://www.seleniumhq.org/) - is a suite of tools to automate web browsers across many platforms
* [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) - ChromeDriver is a standalone server which implements WebDriver's wire protocol for Chromium

