package com.structuralPattern.facadePattern.emailfacade;

import java.time.LocalDateTime;

public interface EmailFacade {
  void compose(String recipient, String subject, String body);

  void send();

  void schedule(String recipient, String subject, String body, LocalDateTime sendTime);
}
