package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryStatus;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryStatusResource {
  @Autowired
  private ProductCategoryStatusService service;

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody ProductCategoryDTO dto){
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }

}
