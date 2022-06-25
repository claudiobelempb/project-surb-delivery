package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductUpdate;

import br.com.surb.surbdeliver.modules.product.dto.ProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductUpdateResource {

  @Autowired
  private ProductUpdateService productUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductUpdateDTO> handle(@PathVariable Long id, @RequestBody ProductUpdateDTO dto){
    dto = productUpdateService.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }

}
