package simple_api.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect {

    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(* simple_api.controller.*.*(..))")
    public void controllerLogPointcut() { }

    @Before("controllerLogPointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("request url: {}", request.getRequestURL());
    }
}
