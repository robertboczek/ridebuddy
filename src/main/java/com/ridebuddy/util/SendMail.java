package com.ridebuddy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ridebuddy.util.models.MailMessage;

@Component
public class SendMail {

	private static final Logger logger = Logger.getLogger(SendMail.class);

	private Session session;

	@PostConstruct
	private void init() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		InputStream is = this.getClass().getResourceAsStream("/mail.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			logger.error(e);
		}
		final String username = properties.getProperty("username");
		final String password = properties.getProperty("password");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new RuntimeException(
					"Could not instantiate SendMail component. Username/password not found");
		}

		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public boolean sendMail(MailMessage mailMessage) {

		Message message = new MimeMessage(session);
		logger.info("Sending message: " + mailMessage);
		try {
			message.setFrom(new InternetAddress(mailMessage.getFrom()));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailMessage.getTo()));
			message.setSubject(mailMessage.getSubject());
			message.setText(mailMessage.getBody());
			message.setContent(mailMessage.getBody(), "text/html; charset=UTF-8");

			Transport.send(message);
		} catch (MessagingException e) {
			logger.error("Exception while sending mail message: " + mailMessage, e);
			return false;
		}
		return true;
	}
}
