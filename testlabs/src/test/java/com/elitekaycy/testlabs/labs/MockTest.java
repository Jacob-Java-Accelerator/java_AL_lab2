package com.elitekaycy.testlabs.labs;

import com.elitekaycy.testlabs.labs.simpleService.User;
import com.elitekaycy.testlabs.labs.simpleService.UserRepository;
import com.elitekaycy.testlabs.labs.simpleService.UserServiceImpl;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class MockTest {

  @Mock
  private UserRepository userRepository;


  private UserServiceImpl userService;

  @BeforeMethod
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    userService = new UserServiceImpl(userRepository);
    System.out.println(">>> Setup before test");
  }


  @AfterMethod
  public void tearDown() {
    System.out.println("<<< Cleanup after test");
    reset(userRepository);
  }

  @Test
  public void testGetUserSuccess() {
    String name = "jacob";
    User expectedUser = new User(name, "jacob@gmail.com");

    when(userRepository.findUserByName(name)).thenReturn(expectedUser);

    User actualUser = userService.getUser(name);

    assertNotNull(actualUser);
    assertEquals(actualUser.getName(), expectedUser.getName());
    assertEquals(actualUser.getEmail(), expectedUser.getEmail());

    verify(userRepository).findUserByName(name);
  }

  @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = ".*email format.*")
  public void testGetUserWithWrongEmailThrowsException() {
    String name = "jacob";
    User mockedUser = new User(name, "wrongemail@notgmail.com");

    when(userRepository.findUserByName(name)).thenReturn(mockedUser);

    userService.getUser(name);
  }

  @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = ".*incorrect name.*")
  public void testGetUserWithWrongNameThrowsException() {
    String inputName = "jacob";
    User mockedUser = new User("john", "jacob@gmail.com");

    when(userRepository.findUserByName(inputName)).thenReturn(mockedUser);

    userService.getUser(inputName);
  }

  @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = ".*not found.*")
  public void testGetUserNotFoundThrowsException() {
    String name = "nonexistent";
    when(userRepository.findUserByName(name)).thenReturn(null);

    userService.getUser(name);
  }
}
