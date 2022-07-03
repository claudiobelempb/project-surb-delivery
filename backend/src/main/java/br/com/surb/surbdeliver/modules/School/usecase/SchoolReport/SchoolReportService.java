package br.com.surb.surbdeliver.modules.School.usecase.SchoolReport;

import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import br.com.surb.surbdeliver.modules.School.infra.repositories.SchoolRepository;
import br.com.surb.surbdeliver.modules.student.infra.repositories.StudentRepository;
import br.com.surb.surbdeliver.shared.utils.DateUtils;
import br.com.surb.surbdeliver.shared.utils.ReportUtils;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Comparator;

@Service
public class SchoolReportService {
  @Autowired
  private SchoolRepository schoolRepository;
  @Autowired
  private StudentRepository studentRepository;

  public ByteArrayInputStream execute() throws IOException {
    ReportUtils report = ReportUtils.getInstance();

    report.addParagraph(new Paragraph("Schools List")
      .setFontSize(28)
      .setTextAlignment(TextAlignment.CENTER)
      .setFont(PdfFontFactory.createFont(StandardFonts.COURIER_BOLD))
    );

    report.addNewLine();
    report.openTable(3);
    report.addTableHeader("NAME", "STUDENTS", "CREATED AT");

    int totalStudents = this.schoolRepository.findAll()
      .stream()
      .sorted(Comparator.comparing(School::getName))
      .map(school -> {
        int studentsCount = this.studentRepository.countBySchool(school);
        report.addTableColumn(school.getName());
        report.addTableColumn(studentsCount);
        report.addTableColumn(school.getCreatedAt());
        return studentsCount;
      })
      .mapToInt(Integer::valueOf)
      .sum();

    report.addTableFooter(null, totalStudents, null);

    report.closeTable();
    report.closeDocument();

    return report.getByteArrayInputStream();
  }
}
