package br.com.surb.surbdeliver.modules.student.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class StudentDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @NotEmpty
  private String name;

  @Email
  @NotEmpty
  private String email;

  @NotEmpty
  private String password;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Instant birthday;

}
