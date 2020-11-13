import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReceiveMail {

    public static void main(String args[]) throws Exception {
        try {
            //1) get the session object
            Properties properties = System.getProperties();
            properties.setProperty("mai.store.protocol", "imaps");

            Session emailSession = Session.getDefaultInstance(properties, null);

            //2) connect with the store
            Store store = emailSession.getStore("imaps");
            store.connect("imap.gmail.com","javafreaks.dmst@gmail.com","javafreaks");

            //3) create folder??
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            //4)find the message
            Message messages [] = inbox.getMessages();
            for (Message message : messages){
                System.out.println(message.getSubject());
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}