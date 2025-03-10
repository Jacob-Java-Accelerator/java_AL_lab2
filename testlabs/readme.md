## Overview

In these exercises, I will explore unit testing using Mockito and TestNG. I'll start by mocking a simple service and then verify mock interactions to ensure they behave as expected.

- **Lab 1** - [Mocking a Simple Service and Verifying Mock Interactions](./src/test/java/com/elitekaycy/testlabs/labs/MockTest.java)
- **Lab 2** - [Writing a simple testNg Test and use data providers](./src/test/java/com/elitekaycy/testlabs/labs/QuickSortTest.java)

## Complete Folder Structure

```plaintext
my-maven-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── elitekaycy/
│   │               └── testlabs/
│   │                   ├── labs/
│   │                   │   └── simpleService/
│   │                   │       ├── User.java
│   │                   │       ├── UserRepository.java
│   │                   │       └── UserService.java
│   │                   └── simpleSort/
│   │                       └── QuickSort.java
│   └── test/
│       └── java/
│           └── com/
│               └── elitekaycy/
│                   └── testlabs/
│                       ├── labs/
│                       │   ├── MockTest.java
│                       │   └── QuickSort.java
│                       └── DemoTest.java
└── pom.xml
```

### My Simple Guide to setting up mockito and testng on java projects

# Setting Up Mockito and TestNG in a Maven Java Project

This guide will help you set up Mockito and TestNG in your Maven Java project for unit testing.

## Step 1: Create a Maven Project

If you haven't already created a Maven project, you can create one using the following command:

````sh
mvn archetype:generate -DgroupId=com.example -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


## Step 2: Update `pom.xml`

To include the necessary dependencies for Mockito and TestNG in your Maven project, update your `pom.xml` file. Add the following dependencies inside the `<dependencies>` tag, and configure the Maven Surefire Plugin for running the tests:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://www.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- TestNG dependency -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.7.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Mockito dependency -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.5.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
````

### Key Things to Understand About the Surefire Plugin

- **Default Behavior**: By default, the Surefire Plugin looks for test classes in the `src/test/java` directory with filenames ending in `Test.java`. This means any class that follows this naming convention will be automatically picked up and run as a test.
- **Custom Configuration**: If your test classes do not follow the default naming convention or are located in a different directory, you can configure the Surefire Plugin to include specific test classes or directories. This can be done by modifying the `<includes>` and `<excludes>` tags in the plugin's configuration.
- **Test Suites**: You can define test suites using an XML configuration file to specify which test classes should be run. This is useful for organizing and managing large test sets.

#### Example of Custom Configuration:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M5</version>
            <configuration>
                <includes>
                    <include>**/*MyTest.java</include>
                </includes>
                <excludes>
                    <exclude>**/*IntegrationTest.java</exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>

```

### Run

```
mvn install
mvn test
```
