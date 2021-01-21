import javax.mail.*;
import javax.mail.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Scanner;

public class ReceiveMail {

	public static String[][] VicContacts = new String[100][3];
	public static int VicCount = 0;
	public static Store store;
	public static String name;
	public static String surname;
	public static String email;
	public static String phonenumber;
	public static String AMKA;
	public static String confirmed_id;
	public static String victim_relationship;
	public static String danger;

	public static void connect() throws Exception {
		// 1) get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.store.protocol", "imaps");

		Session emailSession = Session.getDefaultInstance(properties, null);

		// 2) connect with the store
		store = emailSession.getStore("imaps");
		store.connect("imap.gmail.com", "javafreaks.dmst@gmail.com", "javafreaks");

	}

	public static void receiveMail() throws Exception {

		connect();

		// 3) create folder??
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);

		// 4)find the message
		Message[] messages = emailFolder.getMessages();

		for (Message message : messages) {

			// System.out.println(message.getContent());
			Object mess = message.getContent();
			Scanner sc = new Scanner(mess.toString());
			int c = 0;
			EmailToWords(message);
			c = c + 1;

		}
		email();

	}

	public static void EmailToWords(Message message) throws IOException, MessagingException {

		try {
			if (message.getSubject().equals("Covid-19")) {

				Object mess = message.getContent();
				Scanner sc = new Scanner(mess.toString());

				int wordCount = 0;

				boolean word = false;
				int endOfLine = mess.toString().length() - 1;

				for (int i = 0; i < mess.toString().length(); i++) {
					// if the char is a letter, word = true.
					if (Character.isLetter(mess.toString().charAt(i)) && i != endOfLine) {
						word = true;
						// if char isn't a letter and there have been letters before,
						// counter goes up.
					} else if (!Character.isLetter(mess.toString().charAt(i)) && word) {
						wordCount++;
						word = false;
						// last word of String; if it doesn't end with a non letter, it
						// wouldn't count without this.
					} else if (Character.isLetter(mess.toString().charAt(i)) && i == endOfLine) {
						wordCount++;
					}
				}

				for (int i = 1; i <= wordCount; i++) {
					try {
						String helper = sc.next();

						AnalyseW(helper, i);

					} catch (Exception e) {

					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public static void AnalyseW(String world, int a) {
		switch (a) {
		case (1):
			if (world.equals("H")) {
				danger = "High";
			}

			if (world.equals("L")) {
				danger = "Low";
			}
			break;
		case (3):
			surname = world;
			break;
		case (2):
			name = world;
			break;
		case (4):
			email = world;
			if (danger.equals("High")) {
				try {
					Communication.sendMailToHighDangerContacts(email);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else
				try {
					Communication.sendMailtoLowDangerContacts(email);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			break;
		case (5):
			phonenumber = world;
			break;
		case (6):
			AMKA = world;
			break;
		case (7):
			victim_relationship = world;
			PersonJdbo persondao = new PersonJdbo();
			try {
				persondao.addVictimContact(new VictimContact(name, surname, email, Integer.parseInt(phonenumber),
						Integer.parseInt(AMKA), victim_relationship, danger));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void email() {

		System.out.println(VicCount);
		for (int i = 0; i < VicCount; i++) {
			try {
				if (VicContacts[i][0].equals("L")) {
					Communication.sendMailtoLowDangerContacts(VicContacts[i][2]);
				} else {
					Communication.sendMailToHighDangerContacts(VicContacts[i][2]);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static void deleteMail() throws Exception {

		connect();
		// 3) create folder??
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);

		// 4)find the message
		Message[] messages = emailFolder.getMessages();

		for (Message message : messages) {
			message.setFlag(Flags.Flag.DELETED, true);
		}

	}
}