package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindAll;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryProductFindAllResource {

  @Autowired
  private CategoryProductFindAllService service;

  @GetMapping
  public ResponseEntity<List<CategoryProductDTO>> handle(){
   List<CategoryProductDTO> dto = service.execute();
    return ResponseEntity.ok().body(dto);
  }
}
