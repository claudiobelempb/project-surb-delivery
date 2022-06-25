package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductCreate;

import br.com.surb.surbdeliver.modules.product.dto.ProductCreateDTO;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductCreateResource {
  @Autowired
  private ProductCreateService service;

  @PostMapping
  public ResponseEntity<ProductDTO> handle(@RequestBody ProductCreateDTO productCreateDTO){
    ProductDTO productDTO = service.execute(productCreateDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(productDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(productDTO);
  }
}
