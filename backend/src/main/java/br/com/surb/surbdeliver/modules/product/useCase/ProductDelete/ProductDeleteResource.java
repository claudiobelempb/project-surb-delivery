package br.com.surb.surbdeliver.modules.product.useCase.ProductDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductDeleteResource {

  @Autowired
  private ProductDeleteService service;

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id){
    service.execute(id);
    return ResponseEntity.noContent().build();
  }
}
