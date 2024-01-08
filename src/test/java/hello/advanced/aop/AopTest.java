package hello.advanced.aop;

import hello.advanced.aop.order.OrderRepository;
import hello.advanced.aop.order.OrderService;
import hello.advanced.aop.order.aspect.AspectV5Order;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * AopTest
 *
 * @author jhkang
 * @since
 */
@Slf4j
@SpringBootTest
@Import({AspectV5Order.LogAspect.class, AspectV5Order.TxAspect.class})
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("")
    public void aopInfo() throws Exception {
        // given
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
        // when

        // then
    }

    @Test
    @DisplayName("succee")
    public void success() throws Exception {
        // given
        orderService.orderItem("itemA");
        // when

        // then
    }


    @Test
    @DisplayName("ex")
    public void exception() throws Exception {
        // given
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
        // when

        // then
    }
}
