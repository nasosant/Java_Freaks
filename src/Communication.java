package Covid_tracking;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Communication {
//send mail to High Danger contacts
	public static void sendMailToHighDangerContacts(String recepient) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "javafreaks.dmst@gmail.com";
		String password = "javafreaks";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message  = prepareMessage1(session, myAccountEmail, recepient);
		
		Transport.send(message);
		System.out.println("Message sent successfully");
	}
	
	private static Message prepareMessage1(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("National Public Health Agency");
			String htmlCode = "<html>\r\n" + 
					"<head>\r\n" + 
					"<title>National Public Health Agency</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h1>COVID-19 contact tracking procedure</h1>\r\n" + 
					"<p>	Hello,</p>\r\n" + 
					"<p> According to recent information, you were in close contact with a confirmed case of COVID-19. Based on the above, we provide you with the following instructions for close contacts of confirmed cases. <p>\r\n" + 
					"<p>Close contact management<p>\r\n" + 
					"\r\n" + 
					"<p>People who have been in close contact with a possible or confirmed case of COVID-19 have been monitoring their health since the day of the last contact and for 14 days. In case of symptoms of respiratory infection (eg fever, cough, sore throat, difficulty breathing, anomaly, tastelessness) or diarrhea, seek immediate medical attention.<p>\r\n" + 
					"\r\n" + 
					"<p>Regular (daily) and preferably direct communication of close contacts with a health professional for the entire duration of the follow-up is advisable.<p>\r\n" + 
					"\r\n" + 
					"<p>People who are considered close contacts should have instructions on how to go to a particular hospital if the need arises.<p>\r\n" + 
					"   <p>Use by the patient of a simple surgical mask during his transfer to the hospital unit<p>\r\n" + 
					"    <p>Avoid using public transport. It is preferable to use an ambulance or a private vehicle with the windows open.<p>\r\n" + 
					"    <p>Application of respiratory hygiene by the patient (covering the mouth and nose during coughing or sneezing, use of a simple surgical mask, tissues or the inside of the elbow) as well as hand hygiene. Keeping a distance of at least 1m. from those around him both during the transition to the hospital unit and during the waiting for examination.<p>\r\n" + 
					"\r\n" + 
					"   <p> Cleaning and disinfecting surfaces soiled during the patient's transition to the hospital unit from respiratory secretions or other body fluids with common detergent or soap, rinsing and then disinfecting with a 1:10 home bleach solution.<p>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"";

			message.setContent(htmlCode,"text/html");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
}

//send mail to Low Danger Contacts
	public static void sendMailtoLowDangerContacts(String recepient) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties = new Properties();
	
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "javafreaks.dmst@gmail.com";
		String password = "javafreaks";
	
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
	
		Message message  = prepareMessage2(session, myAccountEmail, recepient);
	
		Transport.send(message);
		System.out.println("Message sent successfully");
	}

	private static Message prepareMessage2(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("National Public Health Agency");
			String htmlCode = "<html>\r\n" + 
					"<head>\r\n" + 
					"<title>National Public Health Agency</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h1>COVID-19 contact tracking procedure</h1>\r\n" + 
					"<p>According to recent information, you were in contact with a confirmed case of COVID-19. Based on the above, we provide you with the following instructions for recent contacts of confirmed cases.<p>\r\n" + 
					"<p>People who have come into contact with a suspected or confirmed case of the new coronavirus (eg family members, friends, colleagues) monitor their health (thermometer twice a day) from the day of the last contact with the case and for 14 days. It is advisable to communicate regularly (daily) with a health professional for the entire duration of the follow-up.</p>\r\n" + 
					"<p>The following must be applied for the entire monitoring period (14 days):<p>\r\n" + 
					"<ul>\r\n" + 
					"<li>Restrict the person's movements at home as much as possible.</li>\r\n" + 
					"<li>Accommodation in a well-ventilated room used only by this person.</li>\r\n" + 
					"<li>Limitation of caregivers, ideally a person who does not belong to a high-risk group (ie is not elderly and does not have a chronic illness).</li>\r\n" + 
					"<li>No visits are allowed.</li>\r\n" + 
					"<li>Accommodation of other family members in a different room and if this is not possible, keep a distance of at least 2m from the person.</li>\r\n" + 
					"<li>Restrict the person's movements at home as much as possible.</li>\r\n" + 
					"<li>Good ventilation of common areas.</li>\r\n" + 
					"<li>Good hand washing before and after any contact with the person or his environment (room, objects), before and after food preparation, before eating and after using the toilet (washing with soap and water or using an antiseptic depending on whether the hands are visibly dirty or not).</li>\r\n" + 
					"<li>Always cover mouth and nose during coughing or sneezing.</li>\r\n" + 
					"<li>Carefully discard the materials used to cover the nose and mouth, rinse thoroughly if they are not disposable.</li>\r\n" + 
					"<li>Avoid direct contact with body fluids, especially saliva, sputum or other respiratory secretions and feces with bare hands and use of disposable gloves. Proper application of hand hygiene.</li>\r\n" + 
					"<li>Avoid contact with potentially contaminated objects of the patient such as dishes, glasses, cutlery, towels, sheets which after careful washing are reused.</li>\r\n" + 
					"<li>Cleaning and disinfecting surfaces and objects in the patient's room daily with common detergent or soap, rinsing and then disinfecting with a 1:50 solution of household bleach if 5% initial dilution bleach is used.</li>\r\n" + 
					"<li>Clean the toilet daily in the same way.</li>\r\n" + 
					"</ul>\r\n" + 
					"<p>In case the person shows symptoms of a respiratory infection (eg fever, cough, sore throat, difficulty breathing) he immediately calls his doctor or the EODY (tel: 1135, 210 5212 054), for instructions.<p>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"";

			message.setContent(htmlCode,"text/html");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
}
	public static void sendMailToConfirmedCases(String recepient) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "javafreaks.dmst@gmail.com";
		String password = "javafreaks";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message  = prepareMessage3(session, myAccountEmail, recepient);
		
		Transport.send(message);
		System.out.println("Message sent successfully");
	}
	
	private static Message prepareMessage3(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("National Public Health Agency");
			String htmlCode = "<html>\r\n" + 
					"<head>\r\n" + 
					"<title>National Public Health Agency</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h1>COVID-19 contact tracking procedure</h1>\r\n" + 
					"<p>According to renent information, you were found positive in the test of COVID-19. This email is a way of tracking the contacts of COVID-19 cases so as to reduce the spreading of COVID-19. </p>\r\n" + 
					"<p> To make it easier to locate your contacts we will need you to provide us with some specific information about them and classify them into one of the following categories: High Risk or Low Risk.<p>\r\n" + 
					"<p>The following are considered high risk contacts:<p>\r\n" + 
					"<ul>\r\n" + 
					"<li>Person living in the same area as the COVID-19 case</li>\r\n" + 
					"<li>Person who had direct physical contact with COVID-19 (such as by handshake)</li>\r\n" + 
					"<li>A person who came into contact without protective equipment with infectious secretions of the COVID-19 case (eg being in a short range when the patient coughed, coming in contact with used tissues without wearing protective gloves)</li>\r\n" + 
					"<li>Person who had face-to-face contact with a COVID-19 case and at a distance of less than 2 meters more than 15 ' </li>\r\n" + 
					"<li>Person indoors (eg classroom, conference room, hospital waiting room, etc.) with a COVID-19 case of 15 'or more and less than 2 meters</li>\r\n" + 
					"<li>A health care worker or other caregiver who has provided care COVID-19 without using the recommended personal protective equipment (PPE) or in the event of a PPE failure</li>\r\n" + 
					"<li>A person in the cockpit of an aircraft sitting at a distance of two seats (in each direction) from a COVID-19 case, fellow passengers or caregivers and cabin crew in the compartment of the aircraft where the patient was sitting (if the severity of the symptoms or movements of the case indicate a higher exposure rate, all passengers in this part of the aircraft can be considered close contacts).</li>\r\n" + 
					"</ul>\r\n" + 
					"<p>The following are considered low risk contacts:<p>\r\n" + 
					"<ul>\r\n" + 
					"<li>Person (s) found indoors with COVID-19 case for less than 15 'or more than 2 meters</li>\r\n" + 
					"<li>Person (s) who had face-to-face contact with COVID-19 at a distance of less than 2 meters but less than 15 '</li>\r\n" + 
					"<li>Companions of the COVID-19 case in other means of transport</li>\r\n" + 
					"</ul>\r\n" + 
					"<p>Based on the above, you are called to write to us the people you were in contact with as well as some information. You will send an email for each contact with COVID-19 tracking procedure as the subject in the following way: <p>\r\n" + 
					"<p>Code space name space surname space email space phone number space SSN space relationship with the victim (family,friend)<p>\r\n" + 
					"<p>In code you write either H or L depends on if the contact is High danger or Low Danger.<p>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>";

			message.setContent(htmlCode,"text/html");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
}
}