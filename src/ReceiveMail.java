import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Properties;
import java.util.Scanner;

public class ReceiveMail {

    public static void main(String args[]) throws Exception {

        //1) get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.store.protocol", "imaps");

        Session emailSession = Session.getDefaultInstance(properties, null);

        //2) connect with the store
        Store store = emailSession.getStore("imaps");
        store.connect("imap.gmail.com", "javafreaks.dmst@gmail.com", "javafreaks");

        //3) create folder??
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        //4)find the message


        Message[] messages = emailFolder.getMessages();
        int c = 0;
        for (Message message : messages) {
            BufferedReader Reader = new BufferedReader(new StringReader(message.getContent().toString()));
            String mess = Reader.readLine();
            Scanner sc = new Scanner(mess);

            c = c + 1;
            System.out.println("email's subject #" + c + " " + message.getSubject() + "\n" + "main body:");

            int wordCount = 0;

            boolean word = false;
            int endOfLine = mess.length() - 1;

            for (int i = 0; i < mess.length(); i++) {
                // if the char is a letter, word = true.
                if (Character.isLetter(mess.charAt(i)) && i != endOfLine) {
                    word = true;
                    // if char isn't a letter and there have been letters before,
                    // counter goes up.
                } else if (!Character.isLetter(mess.charAt(i)) && word) {
                    wordCount++;
                    word = false;
                    // last word of String; if it doesn't end with a non letter, it
                    // wouldn't count without this.
                } else if (Character.isLetter(mess.charAt(i)) && i == endOfLine) {
                    wordCount++;
                }
            }

            for (int i=1;i<=wordCount;i++){
                System.out.println("#"+i+" word:" + sc.next());
        }



    }


}

}