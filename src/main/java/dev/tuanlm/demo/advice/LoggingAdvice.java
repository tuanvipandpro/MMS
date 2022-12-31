package dev.tuanlm.demo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* dev.tuanlm.demo..*Controller.*(..))")
	public void myPointcut() {}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//		ObjectMapper mapper = new ObjectMapper()
		;
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
//		Object[] array = pjp.getArgs();
//		log.info("==> REQUEST: " + className + " : " + methodName + "() " + "Params : "
//				+ mapper.writeValueAsString(array));
		log.info("==> REQUEST: " + className + " : " + methodName + "()");
		Object object = pjp.proceed();
		log.info("<== RESPONSE : " + className + " : " + methodName + "() ");
//		log.info("<== RESPONSE : " + className + " : " + methodName + "() " + "Returns : "
//				+ mapper.writeValueAsString(object));
		return object;
	}
}
