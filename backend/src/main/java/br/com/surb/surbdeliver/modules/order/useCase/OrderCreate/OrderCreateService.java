package br.com.surb.surbdeliver.modules.order.useCase.OrderCreate;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import br.com.surb.surbdeliver.modules.order.infra.entities.Order;
import br.com.surb.surbdeliver.modules.order.infra.repositories.OrderRepository;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import br.com.surb.surbdeliver.shared.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderCreateService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Transactional
  public OrderDTO execute(OrderDTO orderDTO) {
    Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),
      Instant.now(), OrderStatusEnum.PENDING);
    for (ProductDTO p : orderDTO.getProducts()){
      Product product = productRepository.getReferenceById(p.getId());
      order.getProducts().add(product);
    }
    order = orderRepository.save(order);
    return new OrderDTO(order);
  }
}
