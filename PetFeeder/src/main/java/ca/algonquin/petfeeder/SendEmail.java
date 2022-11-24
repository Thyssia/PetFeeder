package ca.algonquin.petfeeder;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class SendEmail {

	private static SendEmail instance = null;

	String sender = "notification@petfeeder.com";
	String host = "localhost";
	Properties properties = System.getProperties();
	UserBean user;
		
	// making sure there isn't already an instance of SendEmail going:
	public static synchronized SendEmail getInstance() {
		if (instance == null) {
			instance = new SendEmail();
		}
		return instance;
	}

	// method to generate/send the email
	public void sendEmail(UserBean user, int daysLeft) {
			
		String recipient = user.getEmail();
		String sender = "notification@petfeeder.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", host);
		// creating session object to get properties
		Session session = Session.getDefaultInstance(properties);

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("PetFeeder Reminder");

			// determine whether the notification is for 7 or 14 days in advance:
			if (daysLeft == 7) {

				message.setText("Hello" + user.getFirstName() + " " + user.getLastName() + ".  "
						+ "Your dog's food runs out in 7 days. ");
			}

			else if (daysLeft == 14) {

				message.setText("Hello" + user.getFirstName() + " " + user.getLastName() + ".  "
						+ "Your dog's food runs out in 14 days. ");
			}

			else {

				System.out.println("There was an error sending a notification to " + user.getFirstName() + " "
						+ user.getLastName() + "'s email: " + user.getEmail());
			}

			Transport.send(message);
			System.out.println("The PetFeeder notification for " + user.getFirstName() + " " + user.getLastName()
					+ " was successfully sent to " + user.getEmail());

		} catch (MessagingException excp) {
			excp.printStackTrace();
		}
	}
}
