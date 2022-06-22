package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductUpdate;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryProductUpdateResource {
  @Autowired
  private CategoryProductUpdateService service;

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoryProductDTO> handle(@PathVariable Long id, @RequestBody CategoryProductDTO dto){
    dto = service.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }
}
