package ca.algonquin.petfeeder.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import ca.algonquin.petfeeder.beans.UserBean;
import ca.algonquin.petfeeder.dao.UserDao;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class SendEmail {

	private static SendEmail instance = null;
		String sender = "notification@petfeeder.com";
	String host = "localhost";
	Properties properties = System.getProperties();
	UserBean userBean;
	UserDao userdao = new UserDao();
		
	// making sure there isn't already an instance of SendEmail going:
	public static synchronized SendEmail getInstance() {
		if (instance == null) {
			instance = new SendEmail();
		}
		return instance;
	}

	// method to generate/send the email
	public void sendEmail(String user, int bob) throws ClassNotFoundException {
		this.userBean = userdao.getUserInfo(user);	
		String recipient = userBean.getEmail();
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
			if (bob == 7) {
				System.out.println("SENDING:  Hello" + userBean.getFirstName() + " " + userBean.getLastName() + ".  "
						+ "Your dog's food runs out in 7 days. ");
				message.setText("Hello" + userBean.getFirstName() + " " + userBean.getLastName() + ".  "
						+ "Your dog's food runs out in 7 days. ");
			}

			else if (bob == 14) {
				System.out.println("SENDING:  Hello" + userBean.getFirstName() + " " + userBean.getLastName() + ".  "
						+ "Your dog's food runs out in 14 days. ");
				message.setText("Hello" + userBean.getFirstName() + " " + userBean.getLastName() + ".  "
						+ "Your dog's food runs out in 14 days. ");
			}

			else {
				System.out.println("There was an error sending a notification to " + userBean.getFirstName() + " "
						+ userBean.getLastName() + "'s email: " + userBean.getEmail());
			}

			Transport.send(message);
			System.out.println("The PetFeeder notification for " + userBean.getFirstName() + " " + userBean.getLastName()
					+ " was successfully sent to " + userBean.getEmail());

		} catch (MessagingException excp) {
			System.out.println("Tried to send email, but failed");
			excp.printStackTrace();
		}
	}
}
