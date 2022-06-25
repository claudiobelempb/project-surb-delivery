package br.com.surb.surbdeliver.shared.components.SendEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ObjectUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public abstract class AppMailComponent {
  private JavaMailSender javaMailSender;

  protected void sendSimpleEmail(AppMailMessage mail) {
    log.info("Sending email.");

    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(mail.getTo());
      message.setFrom(mail.getFrom());
      message.setSubject(mail.getSubject());
      message.setText(mail.getMessage());

      this.javaMailSender.send(message);

      log.info("Simple email sent successfully.");
    } catch (Exception e) {

      log.error("Error when tried to send the email.");
    }
  }

  protected void sendAdvancedEmail(AppMailMessage mail) {
    log.info("Sending email.");

    try {
      MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

      helper.setTo(mail.getTo());
      helper.setFrom(mail.getFrom(), "Experts Club - Fuskinha");
      helper.setSubject(mail.getSubject());
      helper.setText(mail.getMessage(), true);

      if(!ObjectUtils.isEmpty(mail.getAttachments())){
        for (Map.Entry<String, ClassPathResource> map : mail.getAttachments().entrySet()) {
          helper.addAttachment(map.getKey(), map.getValue());
        }
      }

      if(!ObjectUtils.isEmpty(mail.getBodyFiles())) {
        for (Map.Entry<String, ClassPathResource> map : mail.getBodyFiles().entrySet()) {
          helper.addInline(map.getKey(), map.getValue());
        }
      }

      this.javaMailSender.send(mimeMessage);
      log.info("Advanced email sent successfully.");
    } catch (Exception e) {
      log.error("Error when tried to send the email.");
    }
  }
}
