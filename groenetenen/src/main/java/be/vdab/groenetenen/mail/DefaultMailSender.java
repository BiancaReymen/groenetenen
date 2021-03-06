package be.vdab.groenetenen.mail;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import be.vdab.groenetenen.entities.Offerte;
import be.vdab.groenetenen.exceptions.KanMailNietZendenException;

@Component
public class DefaultMailSender implements MailSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMailSender.class);
	private final JavaMailSender sender;
	
	DefaultMailSender (JavaMailSender sender) {
		this.sender = sender;
	}
	@Async
	@Override
	public void nieuweOfferte(Offerte offerte, String offertesURL) {
		try {
			//zonder HTML opmaak
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setTo(offerte.getEmailAdres());
//			message.setSubject("Nieuwe offerte");
//			message.setText("Uw offerte heeft het nummer: " + offerte.getId());
			
			//met HTML opmaak
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(offerte.getEmailAdres());
			helper.setSubject("Nieuwe offerte");
			String offerteURL = offertesURL + offerte.getId();
			helper.setText("Uw offerte heeft het nummer <strong> " + offerte.getId() +
					"</strong>. Je vindt de offerte <a href='" + offerteURL + "'>hier</a>.", true);
			sender.send(message);
		} catch (MessagingException | MailException  ex) {
			LOGGER.error("Kan mail nieuwe offerte niet versturen",ex);
			throw new KanMailNietZendenException();
		}
		
	}
}
