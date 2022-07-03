package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryCreate.ProductCategoryFindById;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
public class ProductCategoryFindByIdResource {

  @Autowired
  private ProductCategoryFindByIdService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductCategoryDTO> handle(@PathVariable Long id) {
    ProductCategoryDTO dto = service.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
