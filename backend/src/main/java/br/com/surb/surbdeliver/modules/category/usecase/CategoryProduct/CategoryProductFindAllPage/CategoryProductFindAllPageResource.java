package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindAllPage;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryProductFindAllPageResource {

  @Autowired
  private CategoryProductFindAllPageService service;

  @GetMapping(value = "/page")
  public ResponseEntity<Page<CategoryProductDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<CategoryProductDTO> dto = service.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }
}
