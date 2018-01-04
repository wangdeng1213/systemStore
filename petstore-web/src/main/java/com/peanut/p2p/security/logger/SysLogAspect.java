package com.peanut.p2p.security.logger;

import com.peanut.p2p.log.SysControllerLog;
import com.peanut.p2p.log.SysServiceLog;
import com.peanut.p2p.security.model.entity.SysLog;
import com.peanut.p2p.security.service.SysLogService;
import com.peanut.security.realm.entity.user.User;
import com.peanut.security.springSecurity.utils.AuthUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by my on 2015/5/22.
 */
@Aspect
@Component
public class SysLogAspect {
    @Resource
    private SysLogService sysLogService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(SysLogAspect.class);
    @Pointcut("@annotation(com.peanut.p2p.log.SysServiceLog)")
    public void serviceAspect(){

    }
    @Pointcut("@annotation(com.peanut.p2p.log.SysControllerLog)")
    public void controllerAspect(){}
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                //获取当前登录用户
               User user = AuthUtils.getCurrentUser();
               //请求的IP
               String ip = request.getRemoteAddr();
                 try {
                       System.out.println("=====前置通知开始=====");
                       System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
                       System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
                       System.out.println("请求人:" + user.getUserName());
                       System.out.println("请求IP:" + ip);
                       SysLog sysLog = new SysLog();
                     sysLog.setContent(getControllerMethodDescription(joinPoint));
                     sysLog.setTarget((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
                     sysLog.setResult("0");
                     sysLog.setIp(ip);
                     sysLog.setType(request.getMethod());
                     sysLog.setSource(request.getRequestURI());
                    /*    log.setExceptionCode( null);
                       log.setExceptionDetail( null);
                       log.setParams(null);*/
                     sysLog.setLoginid(user.getId());
                     sysLog.setUser(user.getUserName());
                        //保存数据库
                     sysLogService.doSave(sysLog);
                       System.out.println("=====前置通知结束=====");
                   }  catch (Exception e) {
                        //记录本地异常日志
                       logger.error("==前置通知异常==");
                        logger.error("异常信息:{}", e.getMessage());
                  }
    }
    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //获取当前登录用户
        User user = AuthUtils.getCurrentUser();
        //获取请求ip
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
               // params += JSON.toJsonString(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {
              /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
/*            System.out.println("请求人:" + user.getName());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
               *//*==========数据库日志=========*//*
            Log log = SpringContextHolder.getBean("logxx");
            log.setDescription(getServiceMthodDescription(joinPoint));
            log.setExceptionCode(e.getClass().getName());
            log.setType("1");
            log.setExceptionDetail(e.getMessage());
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setParams(params);
            log.setCreateBy(user);
            log.setCreateDate(DateUtil.getCurrentDate());
            log.setRequestIp(ip);
            //保存数据库
            logService.add(log);*/
            System.out.println("=====异常通知结束=====");
        }  catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
         /*==========记录本地异常日志==========*/
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);

    }
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SysServiceLog. class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SysControllerLog. class).description();
                    break;
                }
            }
        }
        return description;
    }
}
