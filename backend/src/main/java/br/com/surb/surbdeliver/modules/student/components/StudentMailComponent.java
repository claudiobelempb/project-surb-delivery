package br.com.surb.surbdeliver.modules.student.components;

import br.com.surb.surbdeliver.modules.student.infra.entities.Student;
import br.com.surb.surbdeliver.shared.components.SendEmail.AppMailComponent;
import br.com.surb.surbdeliver.shared.components.SendEmail.AppMailMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.Instant;

@Component
public class StudentMailComponent extends AppMailComponent {
  private final TemplateEngine templateEngine;

  public StudentMailComponent(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
    super(javaMailSender);
    this.templateEngine = templateEngine;
  }

  public void sendSimpleWelcomeEmail(Student student) {
    AppMailMessage mail = AppMailMessage.builder()
      .to(student.getEmail())
      .from("claudio.cardoso@aluno.pb.gov.br")
      .message(String.format("Olá, %s! Espero que você tenha curtido a aula.", student.getName()))
      .subject("Aula do Experts Club - Spring Mail Sender")
      .build();

    this.sendSimpleEmail(mail);
  }


  public void sendWelcomeEmail(Student student) {
    Context context = new Context();
    context.setVariable("name", student.getName());
    context.setVariable("email", student.getEmail());
    context.setVariable("birthday", student.getBirthday());
    context.setVariable("date", Instant.now());

    String templateMessage = this.templateEngine.process("welcome-template", context);

    AppMailMessage mail = AppMailMessage.builder()
      .to(student.getEmail())
      .from("claudio.cardoso@aluno.pb.gov.br")
      .message(templateMessage)
      .subject("Aula do Experts Club - Spring Mail Sender")
      .bodyFile("headerLogo", new ClassPathResource("static/images/Logo_ExpertsClub.png"))
      .attachment("Apresentacao.pptx", new ClassPathResource("static/docs/Apresentacao_Spring_Mail_Thymeleaf.pptx"))
      .build();

    this.sendAdvancedEmail(mail);
  }
}
