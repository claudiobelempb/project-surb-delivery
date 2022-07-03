package br.com.surb.surbdeliver.modules.School.usecase.SchoolReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
public class SchoolReportResource {

  @Autowired
  private SchoolReportService service;

  @GetMapping("/report")
  public ResponseEntity<InputStreamResource> report() {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Disposition", "inline; filename=students.pdf");

      return ResponseEntity.ok()
        .headers(headers)
        .contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(this.service.execute()));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
