
/*
 * name: Alex Miller
 * 
 * Program description: This program uses the concepts of inheritence to create an email application.
 * Date: 2/26/2023
 * Self grade: 100
 */
import java.util.*;
import org.w3c.dom.Text;

public class DocumentMiller // <-------add your last name here
{
   // no code goes here. Must leave empty
}

class Document {
   private String content;

   public Document(String text) {
      content = text;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String text) {
      content = text;
   }

   @Override
   public String toString() {
      return "Content:" + content;
   }

   public int getContentLength() {
      return content.length();
   }

   public boolean contains(String keyword) {
      return content.contains(keyword);
   }

   public boolean equals(Document other) {
      return this.content.equalsIgnoreCase(other.content);
   }
}

class Date {
   int d;
   int m;
   int y;

   public Date() {
      d = 0;
      m = 0;
      y = 0;
   }
}

class Email extends Document {
   private String sender;
   private String recipient;
   private Date date;
   private String subject;
   private String cc;
   private boolean iSent;

   public Email(String text, String sender, String recipient, String subject, String cc) {
      super(text);
      this.sender = sender;
      this.recipient = recipient;
      this.subject = subject;
      this.cc = cc;
   }

   public void send() {
      iSent = true;
   }

   public boolean getSent() {
      return iSent;
   }

   public String getSender() {
      return sender;
   }

   public String getRecipiant() {
      return recipient;
   }

   public String getSubject() {
      return subject;
   }

   public String getCC() {
      return cc;
   }

   public Date getDate() {
      return date;
   }

   public void setSender(String s) {
      if (iSent == false)
         sender = s;
      else
         System.out.println("This email has been sent and cannot be modified");

   }

   public void setRecipient(String r) {
      if (iSent == false)
         recipient = r;
      else
         System.out.println("This email has been sent and cannot be modified");
   }

   public void setSubject(String s) {
      if (iSent == false)
         subject = s;
      else
         System.out.println("This email has been sent and cannot be modified");
   }

   public void setCC(String c) {
      if (iSent == false)
         cc = c;
      else
         System.out.println("This email has been sent and cannot be modified");
   }

   @Override
   public String toString() {
      return "Sender:" + sender + "\nRecipient:" + recipient + "\nDate:" + date.d + "/" + date.m + "/" + date.y
            + "\nSubject:" + subject + "\ncc:" + cc + "\n" + super.toString();
   }

   public void modifyContent(String s) {
      if (iSent == false)
         super.setContent(s);
      else
         System.out.println("This email has been sent and cannot be modified");
   }

   public Email forward(String rec, String sender, String cc) {
      Email f = new Email(super.getContent(), sender, rec, this.subject, cc);
      f.date = new Date();
      f.iSent = true;
      return f;
   }
}

//
// uncommnet this driver class once you have implemented the Documnet class and
// the Email class

class EmailDriver {
   // public Email(String text, String sender,String recipiant, String subject,
   // String cc)

   public static void main(String[] args) {
      // creating an Email object
      Email e1 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi", "Alex", "Meeting",
            "");

      // sending the email
      e1.send();

      // disply the details about the email
      System.out.println(e1);
      System.out.println("\n\n");

      // searching the email for the email for the word tomorrow
      boolean b = e1.contains("tomorrow");
      if (b)
         System.out.println("The word tomorrow was  found in the email");
      else
         System.out.println("The word tomorrow was found in the email");

      // displaying just the content(text) of the email
      System.out.println("\nThe content of this email is: " + e1.getContent());
      System.out.println();
      // modifying the content of the email
      e1.modifyContent("bye");

      // changing the recipient of the e1 email
      e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
      System.out.println();

      // forwarding the email
      Email forward = e1.forward("Alex", "Gita", "Maria");
      System.out.println();

      // printing the forwarded email
      System.out.println("forwarded message\n" + forward);
      System.out.println();

      // display the length of the text in the email
      System.out.println("The number of the letters in the email is: " + e1.getContentLength());

      // ***********************************************************************
      // your turn, refer to the provided documnet on the codes you need to write
   }
}

class myDriver {
   public static void main(String[] args) {
      Email e1 = new Email("text1", "sender1", "recipient1", "subject1", "cc1");
      Email e2 = new Email("text2", "sender2", "recipient2", "subject2", "cc2");
      e1.send();
      e1.setContent("text");
      e1.forward("rec", "sender", "cc");
      System.out.println(e1);
      e1.forward("rec", "sender", "cc");
      e2.setRecipient("r");
      e2.modifyContent("s");
      System.out.println(e2.getContentLength());
      System.out.println(e2.contains("keyword"));
      e2.send();
      System.out.println(e2);
   }
}