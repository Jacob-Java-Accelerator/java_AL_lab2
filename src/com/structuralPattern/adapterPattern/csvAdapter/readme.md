# CSV Adapter Project

This project demonstrates a simple CSV Adapter in Java using the Apache Commons CSV library to read data from a CSV file. It includes an implementation of the `DataSource` interface and a `CsvAdapter` class that reads CSV data and returns it as a list of string arrays. The main application class, `App`, reads the data and prints it to the console.

## Project Structure

```
csv-adapter/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── adapter/
│                   ├── CsvAdapter.java
│                   ├── DataSource.java
│                   └── App.java
│       └── resources/
│           └── data.csv
├── pom.xml
└── README.md
```

## Run the Application

### 1. Build the project

Clean and package the project using Maven:

```sh
mvn clean
mvn package
```

### Run the Application

Navigate to the directory containing the packaged JAR file:

```sh
java -jar target/[packageName].jar
```
