package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryFindAllPage;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryFindAllPageResource {

  @Autowired
  private ProductCategoryFindAllPageService service;

  @GetMapping(value = "/page")
  public ResponseEntity<Page<ProductCategoryDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<ProductCategoryDTO> dto = service.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }
}
