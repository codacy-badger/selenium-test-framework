[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ed67de1ff5954ca5b1572ccfb2046814)](https://www.codacy.com/manual/npvinh140589/java-test-framework?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zarashima/java-test-framework&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.com/zarashima/java-test-framework.svg?branch=master)](https://travis-ci.com/zarashima/java-test-framework)
![Build Status](https://github.com/zarashima/java-test-framework/workflows/Build%20verify/badge.svg)

### Framework Architechture
![Framework Architechture](https://github.com/zarashima/java-test-framework/blob/master/Framework-Architecture.png)


### Roadmap
* Dependencies injection by Guice (Done)
* Store executed browser information in the report (Done)
* Ensure mechanism (Done)

### Introduction
A simple automated testing framework for Web platform. Support Chrome, Firefox and IE

### Technologies
* Maven
* TestNG
* ExtentReport

### Features
* Dependencies injection using Guice
* Ensure mechanism
* Thread-safe driver instances
* Auto download webdrivers (using WebDriverManager)

### Usage
Execute maven command and pass in the browser's name. Example:
```bash
# Chrome
./mvnw clean test -DbrowserName=chrome

# Firefox
./mvnw clean test -DbrowserName=firefox

# IE
./mvnw clean test -DbrowserName=ie
```

### Extension
## [Ensure](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/ensure/Ensure.java) 
Execute designated functions before a specific event. The current one will scroll to element before element interactions. To add other ensure actions, refer to [Wait](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/ensure/Wait.java) class as an example

## Drivers
Driver instances are created using Factory design pattern, refer to [webdrivers](https://github.com/zarashima/java-test-framework/tree/master/src/main/java/webdriver) package. To reduce boilerplate code, I use Guice and manage them through [DriverModule](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/modules/DriverModule.java)
