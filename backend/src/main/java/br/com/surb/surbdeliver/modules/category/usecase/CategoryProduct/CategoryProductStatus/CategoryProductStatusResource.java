package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductStatus;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryProductStatusResource {
  @Autowired
  private CategoryProductStatusService service;

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody CategoryProductDTO dto){
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }

}
