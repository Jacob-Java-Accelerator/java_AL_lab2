package com.elitekaycy.testlabs.labs;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.elitekaycy.testlabs.labs.simpleService.User;
import com.elitekaycy.testlabs.labs.simpleService.UserRepository;
import com.elitekaycy.testlabs.labs.simpleService.UserService;

public class MockTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeMethod
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetUser() {
    String name = "dickson";
    User user = new User(name, "dickson@gmail.com");

    when(userRepository.findUserByName(name)).thenReturn(user);

    User userResult = userService.getUser(name);

    assertNotNull(userResult);
    assertEquals(userResult.toString(), user.toString());

    // verify methods
    verify(userRepository).findUserByName(name);
  }

}
