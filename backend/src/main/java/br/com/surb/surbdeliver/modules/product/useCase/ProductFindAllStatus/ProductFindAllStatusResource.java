package br.com.surb.surbdeliver.modules.product.useCase.ProductFindAllStatus;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products/status")
public class ProductFindAllStatusResource {

  @Autowired
  private ProductFindAllStatusService service;

  @GetMapping("/{status}")
  public ResponseEntity<List<ProductDTO>> handle(@PathVariable Long status){
    List<ProductDTO> dto = service.execute(status);
    return ResponseEntity.ok().body(dto);
  }


}
