# Web Automation Test

This project focuses on automating web UI tests for the [Swag Labs](https://www.saucedemo.com/) website and written in Java. It utilizes Cucumber test framework and Selenium WebDriver library.

## Features
* Selenium WebDriver: A popular library for automating web browser interactions. It allows you to control the browser and simulate user actions like clicking buttons, entering text, and submitting forms.
* Cucumber: A BDD (Behavior-Driven Development) framework that enables you to define test scenarios in a human-readable format using Gherkin syntax. This promotes better communication and understanding between testers and developers.
* Easy-to-read tests: Scenarios are written in plain English using Gherkin syntax, improving test maintainability and collaboration.
* Reusable steps: Common test actions are defined as reusable steps, promoting code reuse and reducing redundancy.
* Gradle Wrapper: Ensures consistent build environment across different machines.
* Automatic Test Reporting: Generates comprehensive reports after test execution using Cucumber reporting plugins.
* Page Object Model (POM): Organizes test logic by separating page elements (API endpoints in this case) and interactions from the test steps, improving test maintainability and reducing duplication.

## Getting Started

This project uses Gradle for build automation. The Gradle Wrapper included in the project automatically downloads and runs the appropriate Gradle version required by the project.
While you don't need to install Gradle to run the tests, you will need Java installed on your machine to execute the Java code within the tests.
Refer to the official [Java download page](https://www.java.com/en/download/) for installation instructions.

* Prerequisites
  * Java 21 or later installed

* Setting Up
  * Clone this repository: `git clone https://github.com/<your-username>/saucedemo-web-ui-automation-test.git` (replace `your-username` with yours)
  * Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse)
  * Ensure you have Java installed and accessible from the command line.
*  Running Tests 
  * Navigate to the project directory in your terminal. 
  * Run the tests using Gradle: `./gradlew webTest`

## Preview

Run the test according to the guide above

![Run the tests using Gradle Wrapper `./gradlew webTest`](preview/test-run.png)

Once the tests have been executed, it will automatically generate a test report, which can be accessed in the `reports` directory.

![Reports generated after test run](preview/test-reports.png)