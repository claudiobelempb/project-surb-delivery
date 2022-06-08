package br.com.surb.surbdeliver.modules.order.useCase.OrderSearchStatusPendingOrderByMomentAsc;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderSearchStatusPendingOrderByMomentAscResource {

  @Autowired
  private OrderSearchStatusPendingOrderByMomentAscService orderSearchStatusPendingOrderByMomentAscService;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> handle(){
    List<OrderDTO> orderDTOS = orderSearchStatusPendingOrderByMomentAscService.execute();
    return ResponseEntity.ok().body(orderDTOS);
  }
}
