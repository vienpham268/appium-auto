# 📱 Appium Mobile Automation Project

## 1. Overview

This project uses **Appium + Java + TestNG + Maven** to automate mobile testing (Android). The framework is designed to be **scalable, maintainable**, and suitable for both local execution and CI pipelines (GitHub Actions).

---

## 2. Tech Stack

* Java 11+
* Appium 2.x
* Selenium WebDriver
* TestNG
* Maven
* Android SDK
* Git & GitHub Actions

## 4. Key Components

### 4.1 DriverFactory

* Initializes Appium Driver
* Reads configuration by platform (android)
* Manages desired capabilities

### 4.2 BaseTest

* Contains `@BeforeMethod` and `@AfterMethod`
* Handles driver setup and teardown per test

### 4.3 Page Objects (POM)

* Implements **Page Object Model**
* Each screen is represented by a separate class

### 4.4 testng.xml

* Manages test suites
* Supports parameters and parallel execution

---

## 5. testng.xml Configuration

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Mobile Automation Suite" parallel="false">
    <parameter name="platform" value="android"/>

    <test name="Android Tests">
        <classes>
            <class name="tests.CallTest"/>
        </classes>
    </test>
</suite>
```

---

## 6. pom.xml Configuration (UTF-8 & TestNG)

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

---

## 7. How to Run Tests

### 7.1 Run with Maven (Local)

```bash
mvn clean test
```

### 7.2 Run a Specific Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 8. Prerequisites

* Java installed and `JAVA_HOME` configured
* Android SDK installed
* `ANDROID_HOME` or `ANDROID_SDK_ROOT` environment variable set
* Android emulator or real device running
* Appium Server (2.x) started

---

## 9. CI with GitHub Actions

* Workflow defined in `.github/workflows/mobile-ci.yml`
* Triggers on push / pull request to `main`
* Runs Maven tests automatically

---

## 10. Best Practices

* Use Page Object Model
* Keep tests independent
* Avoid hard waits, use explicit waits
* Centralize driver & config management

---

## 11. Author

**Vien Pham**
QA Automation Manager


