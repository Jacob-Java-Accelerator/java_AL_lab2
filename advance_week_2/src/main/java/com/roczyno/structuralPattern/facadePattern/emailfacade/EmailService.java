package com.roczyno.structuralPattern.facadePattern.emailfacade;

class EmailService {
	public void sendEmail(Email email) {
		System.out.println("Sending email to: " + email.getRecipient());
		System.out.println("Subject: " + email.getSubject());
		System.out.println("Body: " + email.getBody());
	}
}
