package mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SendReport {

    public String[] ToAdresses = { "dandantest.001@gmail.com"};

    public void triggerMail(String reportName, String reportPath)
                throws IOException, AddressException, MessagingException {

        Date d = new Date();


            Properties sysmProp = System.getProperties();
            sysmProp.put("mail.smtp.starttls.enable", "true");
            sysmProp.put("mail.smtp.host", "smtp.gmail.com");
            sysmProp.put("mail.smtp.user", "dandantest.001@gmail.com");
            sysmProp.put("mail.smtp.password", "test1234@");
            sysmProp.put("mail.smtp.port", "587");
            sysmProp.put("mail.smtp.auth", "true");

            /*Create session object*/
            Session session = Session.getInstance(sysmProp, null);

            /*Create MimeMessage object and add recipients */
            MimeMessage message = new MimeMessage(session);

            /* Setting the string value type as address */
            InternetAddress[] recipients = new InternetAddress[ToAdresses.length];

            for (int i = 0; i < ToAdresses.length; i++) {
                recipients[i] = new InternetAddress(ToAdresses[i]);
            }

            /* Adding the recipients to the message object. */
            for (int j = 0; j < ToAdresses.length; j++) {
                message.addRecipient(Message.RecipientType.TO, recipients[j]);
            }

            message.setSubject("Salesforce Regression Automation Test Report"+d.toString().replace(":", "_").replace(" ", "_"));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Execution of Salesforce Regression Automation Test is done. Please open attach file for the results");

            /* Adding the attachment to the mail. */
            File file = new File(System.getProperty("user.dir") + reportPath);
            BodyPart messageBodyPart_2 = new MimeBodyPart();
            DataSource source = new FileDataSource(file.getAbsolutePath());
            messageBodyPart_2.setDataHandler(new DataHandler(source));
            messageBodyPart_2.setFileName(reportName);

            /* Clubbing the subject of mail. */
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messageBodyPart_2);
            message.setContent(multipart);

            /* Triggers mail. */
            Transport.send(message,"dandantest.001@gmail.com","test1234@");

        }
    }

