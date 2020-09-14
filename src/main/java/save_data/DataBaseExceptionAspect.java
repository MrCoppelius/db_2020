package save_data;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataBaseExceptionAspect {
    @AfterThrowing(pointcut = "execution(* save_data..*.*(..))")
    public Object sendMail(ProceedingJoinPoint jp) throws Throwable {
        System.out.print(jp.getTarget().getClass().getSimpleName()+" обычно говорил в таких случаях: ");
        Object retVal = jp.proceed();
        System.out.println("sjdashdk");
        return retVal;
    }
}
