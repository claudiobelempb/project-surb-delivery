package br.com.surb.surbdeliver.modules.order.useCase.OrderSearchStatusPendingOrderByMomentAsc;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import br.com.surb.surbdeliver.modules.order.infra.entities.Order;
import br.com.surb.surbdeliver.modules.order.infra.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderSearchStatusPendingOrderByMomentAscService {

  @Autowired
  private OrderRepository orderRepository;

  @Transactional(readOnly = true)
  public List<OrderDTO> execute(){
    List<Order> orders = orderRepository.OrderSearchStatusPendingOrderByMomentAsc();
    return orders.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
  }
}
