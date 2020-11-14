import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReceiveMail {

    public static void main(String args[]) throws Exception {

            //1) get the session object
            Properties properties = System.getProperties();
            properties.setProperty("mail.store.protocol", "imaps");

            Session emailSession = Session.getDefaultInstance(properties, null);

            //2) connect with the store
            Store store = emailSession.getStore("imaps");
            store.connect("imap.gmail.com","javafreaks.dmst@gmail.com","javafreaks");

            //3) create folder??
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4)find the message
            Message[] messages = emailFolder.getMessages();
            int c=0;
            for (Message message : messages){
                c=c+1;
                System.out.println("email's subject #"+ c +" " + message.getSubject());
            }


        }


    }

