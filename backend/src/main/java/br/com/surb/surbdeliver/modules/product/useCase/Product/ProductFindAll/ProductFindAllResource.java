package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductFindAll;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductFindAllResource {

  @Autowired
  private ProductFindAllService productFindAllService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> handle(){
    List<ProductDTO> productDTOS = productFindAllService.execute();
    return ResponseEntity.ok().body(productDTOS);
  }


}
