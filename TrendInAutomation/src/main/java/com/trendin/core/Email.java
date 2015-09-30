package com.trendin.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Email {

	
	public static boolean sendEmail(String filePath)
	{
		Properties props = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("./resources/configuration.properties");
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(Arrays.toString(props.entrySet().toArray()));
		return Email.sendEmail(
				props.getProperty("emailToAddress"),
				props.getProperty("emailFromAddress"),
				props.getProperty("emailUsername"),
				props.getProperty("emailPassword"),
				String.valueOf(Boolean.parseBoolean(props.getProperty("emailSMTPAuth"))),
				String.valueOf(Boolean.parseBoolean(props.getProperty("emailSMTPStartTLS"))),
				props.getProperty("emailSMTPHost"),
				props.getProperty("emailSMTPPort"),
				filePath);
	}
	
	public static boolean sendEmail(String toAddress, String fromAddress, final String userName, final String password, String smt_auth, String smtp_starttls, String smtp_host, String smtp_port, String filepath)
	{

		Properties props = new Properties();
		props.put("mail.smtp.auth", smt_auth);
		props.put("mail.smtp.starttls.enable", smtp_starttls);
		props.put("mail.smtp.host", smtp_host);
		props.put("mail.smtp.port", smtp_port);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName,
								password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddress));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toAddress));

			try {
				Date date = new Date();
				message.setSubject("Test Results for "
						+ InetAddress.getLocalHost().getHostName() + " "
						+ date.toString());
			} catch (UnknownHostException e) {

				e.printStackTrace();
			}

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			String newl = System.getProperty("line.separator");

			// Now set the actual message
			messageBodyPart
					.setText("Hi,"
							+ newl
							+ "Please find the Html report attached."
							+ newl
							+ "This test report covers till 'send mail' functionality."
							+ newl + newl + "Thanks & Regards," + newl);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filepath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filepath);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

}
