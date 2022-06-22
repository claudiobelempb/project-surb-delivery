package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductCreate;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class CategoryProductCreateResource {

   @Autowired
   private CategoryProductCreateService service;

   @PostMapping
   public ResponseEntity<CategoryProductDTO> handle(@RequestBody CategoryProductDTO dto)   {
     dto = service.execute(dto);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
     return ResponseEntity.created(uri).body(dto);
   }
}
