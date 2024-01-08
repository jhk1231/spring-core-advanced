package hello.advanced.aop.order.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * AspectV1
 *
 * @author jhkang
 * @since 0.1.0
 */
@Slf4j
@Aspect
public class AspectV1 {

    @Around("execution(* hello.advanced.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature()); //  join point 시그니쳐
        return joinPoint.proceed();
    }
}
