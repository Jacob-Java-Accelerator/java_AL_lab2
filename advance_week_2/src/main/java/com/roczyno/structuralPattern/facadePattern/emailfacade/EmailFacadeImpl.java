package com.roczyno.structuralPattern.facadePattern.emailfacade;



import java.time.LocalDateTime;

public class EmailFacadeImpl implements EmailFacade {
	private EmailService emailService = new EmailService();
	private Email composedEmail;  // Store the composed email

	@Override
	public void compose(String recipient, String subject, String body) {
		System.out.println("Composing email...");
		composedEmail = new Email(recipient, subject, body);
	}

	@Override
	public void send() {
		if (composedEmail == null) {
			System.out.println("No email composed yet. Please compose before sending.");
			return;
		}
		System.out.println("Sending composed email...");
		emailService.sendEmail(composedEmail);
		composedEmail = null;  // reset after sending
	}

	@Override
	public void schedule(String recipient, String subject, String body, LocalDateTime sendTime) {
		System.out.println("Scheduling email for " + sendTime + "...");
		Email email = new Email(recipient, subject, body);
		// Simulate scheduling logic
		System.out.println("Email scheduled successfully (simulation).");
	}

	public static void main(String[] args) {
		EmailFacade emailFacade = new EmailFacadeImpl();

		emailFacade.compose("recipient@example.com", "Hello", "This is a test email.");
		emailFacade.send();

		LocalDateTime sendTime = LocalDateTime.now().plusHours(1);
		emailFacade.schedule("recipient@example.com", "Scheduled Email", "This is a scheduled email.", sendTime);
	}
}
