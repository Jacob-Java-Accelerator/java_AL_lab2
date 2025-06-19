# TestLabs - Java Unit Testing Labs

This project contains hands-on labs for learning and practicing unit testing in Java using **Mockito** and **TestNG**. Each lab focuses on a specific concept, with simple, clear code examples and corresponding tests.

## Table of Contents

- [Lab 1: Mocking a Simple Service and Verifying Mock Interactions](#lab-1-mocking-a-simple-service-and-verifying-mock-interactions)
- [Lab 2: Writing a Simple TestNG Test and Using Data Providers](#lab-2-writing-a-simple-testng-test-and-using-data-providers)
- [Project Structure](#project-structure)
- [Setup and Running Tests](#setup-and-running-tests)

---

## Lab 1: Mocking a Simple Service and Verifying Mock Interactions

**Location:**

- Main code: `testlabs/src/main/java/com/elitekaycy/testlabs/labs/simpleService/`
- Test: `testlabs/src/test/java/com/elitekaycy/testlabs/labs/MockTest.java`

### Overview

This lab demonstrates how to use Mockito to mock dependencies and verify interactions in a service class. The example is a simple user service that fetches user data from a repository.

### Components

- **User.java**: A simple POJO representing a user with `name` and `email`.
- **UserRepository.java**: Simulates a data repository with a method to find a user by name.
- **UserService.java**: Service class that uses `UserRepository` to fetch user data.

### Test

- **MockTest.java**:
  - Uses Mockito to mock `UserRepository`.
  - Injects the mock into `UserService`.
  - Tests that `UserService.getUser(name)` returns the expected user.
  - Verifies that the repository's `findUserByName` method was called.

#### Example Test Snippet

```java
@Mock
private UserRepository userRepository;

@InjectMocks
private UserService userService;

@Test
public void testGetUser() {
    String name = "dickson";
    User user = new User(name, "dickson@gmail.com");

    when(userRepository.findUserByName(name)).thenReturn(user);

    User userResult = userService.getUser(name);

    assertNotNull(userResult);
    assertEquals(userResult.toString(), user.toString());

    verify(userRepository).findUserByName(name);
}
```

---

## Lab 2: Writing a Simple TestNG Test and Using Data Providers

**Location:**

- Main code: `testlabs/src/main/java/com/elitekaycy/testlabs/labs/simpleSort/QuickSort.java`
- Test: `testlabs/src/test/java/com/elitekaycy/testlabs/labs/QuickSortTest.java`

### Overview

This lab demonstrates how to write unit tests for a sorting algorithm using TestNG, including the use of data providers for parameterized testing.

### Components

- **QuickSort.java**:
  - Contains a static `sort(int[] arr)` method that sorts an array in ascending order using a simple (non-recursive) sorting algorithm.

### Test

- **QuickSortTest.java**:
  - Tests the `QuickSort.sort` method with hardcoded arrays.
  - Uses a TestNG `@DataProvider` to supply multiple test cases.
  - Asserts that the output array is sorted as expected.

#### Example Test Snippet

```java
@Test
public void unit_test_quicksort() {
    int[] arr = { 4, 3, 7, 1 };
    int[] result = QuickSort.sort(arr);
    int[] expected = { 1, 3, 4, 7 };
    for (int i = 0; i < result.length; i++) {
        assertEquals(expected[i], result[i]);
    }
}

@Test(dataProvider = "sortData")
public void test_quicksort_with_data_providers(int[] arr) {
    int[] result = QuickSort.sort(arr);
    assertTrue(result[0] <= result[1]);
    assertTrue(result[0] <= result[result.length - 1]);
}

@DataProvider(name = "sortData")
public Object[][] sortData() {
    return new Object[][] { { new int[] { 4, 3, 7, 1 } }, { new int[] { 17, 19, 12 } } };
}
```

---

## Project Structure

```
testlabs/
├── pom.xml
├── readme.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/elitekaycy/testlabs/
│   │           └── labs/
│   │               ├── simpleService/
│   │               │   ├── User.java
│   │               │   ├── UserRepository.java
│   │               │   └── UserService.java
│   │               └── simpleSort/
│   │                   └── QuickSort.java
│   └── test/
│       └── java/
│           └── com/elitekaycy/testlabs/
│               ├── labs/
│               │   ├── MockTest.java
│               │   └── QuickSortTest.java
│               └── DemoTest.java
```

---

## Setup and Running Tests

### Prerequisites

- Java 21+
- Maven

### Dependencies

The project uses the following dependencies (see `testlabs/pom.xml`):

- **TestNG** for unit testing
- **Mockito** for mocking

### Running Tests

To run all tests, use:

```sh
cd testlabs
mvn test
```

---

## Additional Notes

- The `DemoTest.java` file is a simple demonstration and not part of the main labs.
- The labs are designed to be minimal and focused on demonstrating core testing concepts.

---
