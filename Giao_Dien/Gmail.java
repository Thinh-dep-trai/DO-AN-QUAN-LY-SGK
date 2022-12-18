/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Giao_Dien;

/**
 *
 * @author Bon
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Gmail {
 
  public static void sendText(String mailReceive, String text) throws AddressException, MessagingException {
    Properties mailServerProperties;
    Session getMailSession;
    MimeMessage mailMessage;
 
    mailServerProperties = System.getProperties();
    mailServerProperties.put("mail.smtp.port", "587");
    mailServerProperties.put("mail.smtp.auth", "true");
    mailServerProperties.put("mail.smtp.starttls.enable", "true");
    
    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
    mailMessage = new MimeMessage(getMailSession);
                                                        
    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceive));
 
    //tiêu đề
    mailMessage.setSubject("Xác nhận tài khoản");
    //nội dung
    mailMessage.setText(text+" là mã xác nhận tài khoản của bạn.");
 
    Transport transport = getMailSession.getTransport("smtp");
 
                                           /*Mail người gữi*/    /*mật khẩu ứng dụng*/
    transport.connect("smtp.gmail.com", "asjdasdasdsd@gmail.com", "tzvjtirogfhmjjci"); 
    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
    transport.close();
  }
 
}