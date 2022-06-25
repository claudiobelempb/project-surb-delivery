package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductFindAllOrderByNameAsc;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductFindAllByOrderByNameAscResource {

  @Autowired
  private ProductFindAllByOrderByNameAscService productFindAllService;

  @GetMapping(value = "/search/name")
  public ResponseEntity<List<ProductDTO>> handle(){
    List<ProductDTO> productDTOS = productFindAllService.execute();
    return ResponseEntity.ok().body(productDTOS);
  }


}
