package hello.advanced.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OrderService
 *
 * @author jhkang
 * @since 0.1.0
 */
@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        log.info("[OrderService] 실행");
        orderRepository.save(itemId);
    }

}
