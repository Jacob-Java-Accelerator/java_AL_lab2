package com.structuralPattern.facadePattern.emailfacade;

import java.time.LocalDateTime;

class Email {
  private String recipient;
  private String subject;
  private String body;

  public Email(String recipient, String subject, String body) {
    this.recipient = recipient;
    this.subject = subject;
    this.body = body;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }
}

class EmailService {
  public void sendEmail(Email email) {
    System.out.println("Sending email to: " + email.getRecipient());
    System.out.println("Subject: " + email.getSubject());
    System.out.println("Body: " + email.getBody());
  }
}

public class EmailFacadeImpl implements EmailFacade {
  private EmailService emailService = new EmailService();

  @Override
  public void compose(String recipient, String subject, String body) {
    System.out.println("Composing email...");
    Email email = new Email(recipient, subject, body);
  }

  @Override
  public void send() {
    System.out.println("Sending composed email...");
    Email email = new Email("recipient@example.com", "Test Subject", "Test Body");
    emailService.sendEmail(email);
  }

  @Override
  public void schedule(String recipient, String subject, String body, LocalDateTime sendTime) {
    System.out.println("Scheduling email for " + sendTime + "...");
    Email email = new Email(recipient, subject, body);
  }

  public static void main(String[] args) {
    EmailFacade emailFacade = new EmailFacadeImpl();

    emailFacade.compose("recipient@example.com", "Hello", "This is a test email.");
    emailFacade.send();

    LocalDateTime sendTime = LocalDateTime.now().plusHours(1);
    emailFacade.schedule("recipient@example.com", "Scheduled Email", "This is a scheduled email.", sendTime);
  }
}
