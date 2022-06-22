package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindById;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
public class CategoryFindByIdResource {

  @Autowired
  private CategoryFindByIdService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryProductDTO> handle(@PathVariable Long id) {
    CategoryProductDTO dto = service.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
