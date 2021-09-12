import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtility {

	public static void sendForgetPasswordMail(String recipient) throws Exception {

		System.out.println("Preparing to send mail.");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "wegathermanagement@gmail.com";
		String emailPassword = "weGather2021";

		// mail.smtp.auth
		// mail.setup.starttls
		// mail.smtp.host //for gmail // smtp.gmail.com // port 587
		// mail.smtp.port

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccountEmail, emailPassword);
			}
		});

		Message message = prepareForgotPassMessage(session, myAccountEmail, recipient); // make message modify at
																						// prepareMessage

		System.out.println("Sending mail.");

		Transport.send(message);
		System.out.println("Mail sent successfully.");

	}

	private static Message prepareForgotPassMessage(Session session, String myAccountEmail, String recipient) {
		// TODO Auto-generated method stub

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Forget password email from WeGather");
			message.setText("Hi there!\nHere is your verification code : " + ForgotPasswordFrame.getAuthCode()); // the
																													// authcode
																													// sent
																													// to
																													// mail
																													// from
																													// forgotPasswordFrame
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void sendInviteMail(String recipient, Event event) throws Exception {

		System.out.println("Preparing to send mail.");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "wegathermanagement@gmail.com";
		String emailPassword = "weGather2021";

		// mail.smtp.auth
		// mail.setup.starttls
		// mail.smtp.host //for gmail // smtp.gmail.com // port 587
		// mail.smtp.port

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccountEmail, emailPassword);
			}
		});
		
		Transport transport = session.getTransport("smtp");
		transport.connect();

		Message message = prepareInviteMessage(session, myAccountEmail, recipient, event); // make message modify at
																							// prepareMessage

		System.out.println("Sending mail.");

		Transport.send(message);
		
		 File imgFile = new File("mail.png"); 
		    
		 if (imgFile.delete()) { 
		      System.out.println("Deleted the file: " + imgFile.getName());
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
		   
		 imgFile.deleteOnExit();
		 
		System.out.println("Mail sent successfully.");

	}
	
	public static void sendMultipleInviteMail(String recipient, Event event) throws Exception {				//Array of string

		System.out.println("Preparing to send mail.");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "wegathermanagement@gmail.com";
		String emailPassword = "weGather2021";

		// mail.smtp.auth
		// mail.setup.starttls
		// mail.smtp.host //for gmail // smtp.gmail.com // port 587
		// mail.smtp.port

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccountEmail, emailPassword);
			}
		});

		Message message = prepareInviteMessage(session, myAccountEmail, recipient, event); // make message modify at
																							// prepareMessage

		System.out.println("Sending mail.");

		Transport.send(message);
		
		 File myObj = new File("mail.png"); 
		    
		 if (myObj.delete()) { 
		      System.out.println("Deleted the file: " + myObj.getName());
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
		    
		System.out.println("Mail sent successfully.");

	}

	private static Message prepareInviteMessage(Session session, String myAccountEmail, String recipient, Event event) {
		// TODO Auto-generated method stub

		String htmlCode = "<img src=\"cid:mailImg\" />"
				+ "<h4 style=\"text-align: center;\"><span style=\"color: #ff6600;\">" + event.getEventName() + "</span></h4>\r\n"
				+ "<p style=\"text-align: center;\"><span style=\"color: #ff6600;\">" + event.getEventDescription() + "</span></p>\r\n"
				+ "<p style=\"text-align: center;\"><span style=\"color: #ff9900;\">Starts: " + event.getStartTime() +"</span></p>\r\n"
				+ "<p style=\"text-align: center;\"><span style=\"color: #ff9900;\">Ends: " + event.getEndTime() + "</span></p>\r\n"
				+ "<p style=\"text-align: center;\"><span style=\"color: #ff9900;\">Loaction: " + event.getLocation() +"</span></p>\r\n"
				+ "<p style=\"text-align: right;\"><span style=\"color: #ff6600;\">You are invited!!</span></p>\r\n"
				+ "<p style=\"text-align: right;\"><span style=\"color: #ff9900;\">Come join us!</span></p>";

		Message message = new MimeMessage(session);
		try {
		
			Multipart allPart = new MimeMultipart();
			
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(htmlCode, "text/html");
			
			allPart.addBodyPart(bodyPart);
			
			MimeBodyPart imagePart = new MimeBodyPart();
			imagePart.setHeader("Content-ID", "mailImg");
			imagePart.setDisposition(MimeBodyPart.INLINE);
			// attach the image file
			imagePart.attachFile(getImageFile(event.getImg()));
			
			allPart.addBodyPart(imagePart);

			message.setContent(allPart);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Invitation to " + event.getEventName());
			// message.setText("Hi there!\nHere is your verification code : " +
			// ForgotPasswordFrame.getAuthCode()); // the


			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static File getImageFile(byte[] img) {
		// TODO Auto-generated method stub

		try {

			FileOutputStream fos = new FileOutputStream("mail.png");
			fos.write(img);
			fos.close();
			
			File imgFile = new File("mail.png");
			
			return imgFile;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fos.close(); There is no more need for this line since you had created the
		// instance of "fos" inside the try. And this will automatically close the
		// OutputStream

		return null;

	}

	public static void main(String[] args) {

		try {
			// sendInviteMail("sadiuchiha@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
