package cn.rpm.goods.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * cn.rpm.goods.provider.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    @Around("webLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuilder stringBuilder  = new StringBuilder();
        Object[] objects = pjp.getArgs();
        boolean hasUser=false;
//        if(objects!=null && objects.length>0){
//            CasAuthenticationToken casToken = null;
//            for (Object o:objects){
//                if(o instanceof  CasAuthenticationToken){
//                    casToken = (CasAuthenticationToken)o;
//                    String user = casToken.getUserDetails().getUsername();
//                    String role = casToken.getUserDetails().getAuthorities().toString();
//                    stringBuilder.append("RQUEST_USER:"+user+"  REQUEST_USER_ROLE:"+role+"\n");
//                    hasUser=true;
//                }
//
//            }
//        }
        if (!hasUser){
            stringBuilder.append("RQUEST_USER:unknown  REQUEST_USER_ROLE:unknown\n");
        }
        stringBuilder.append("URL : " + request.getRequestURL().toString()+"\n");
        stringBuilder.append("HTTP_METHOD : " + request.getMethod()+"\n");
        stringBuilder.append("IP : " + request.getRemoteAddr()+"\n");
        stringBuilder.append("REQUEST_PARAMETERS"+request.getParameterMap().toString()+"\n");
        stringBuilder.append("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info(stringBuilder.toString());
        pjp.proceed();
        logger.info("out aop ");


    }

}