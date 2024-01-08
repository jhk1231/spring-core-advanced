package hello.advanced.aop.order.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Pointcuts
 *
 * @author jhkang
 * @since 0.1.0
 */
public class Pointcuts {


    @Pointcut("execution(* hello.advanced.aop.order..*(..))")
    public void addOrder() { //pointcut signature
    }

    //클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {
    }


    @Pointcut("addOrder() && allService()")
    public void orderAndService() {}
}
