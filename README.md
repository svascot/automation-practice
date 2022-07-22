# automation-practice

The intention of this project is to automate some features of
[automationpractice.com](http://automationpractice.com/) following [Automation Testing Masterclass](https://www.udemy.com/course/automation-testing-masterclass/) course.

To run the test cases execute the class `src/test/java/automation/RunTests.java`
The cucumber report is in `target/cucumber-reports/report.html`.

This project implements ExtentReports, the report is in `report/TestReport.html`.

This project perform these test cases:
* Tests cases:
  * Sign in with an account, to test sign-in Page.
  * Add a few items to the cart.
  * Proceed with the checkout.


* SearchTest class: `removed`
  * Search form a products in the search bar. (This use a list of products to perform many tests).

To take screenshots use `Utils.takeScreenshot(name)` where `name` will be a meaningful name and will be completed with the method time of execution. The screenshot are stored in `screenshots/`.

## WebDrivers
Download the WebDrivers and place them into `src/main/resources/drivers` 
* [Chromedriver](https://chromedriver.chromium.org/downloads)
* [phantomjs](https://phantomjs.org/download.html)
* [geckodriver](https://github.com/mozilla/geckodriver/releases) (Firefox)
