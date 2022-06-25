package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductFindById;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductFindByIdResource {

  @Autowired
  private ProductFindByIdService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> handle(@PathVariable Long id) {
    ProductDTO dto = service.execute(id);
    return ResponseEntity.ok().body(dto);
  }

}
