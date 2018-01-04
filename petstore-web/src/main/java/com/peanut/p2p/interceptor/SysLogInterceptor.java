package com.peanut.p2p.interceptor;

import com.peanut.security.realm.entity.user.User;
import com.peanut.security.springSecurity.utils.AuthUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by my on 2015/5/17.
 */
public class SysLogInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SysLogInterceptor.class);
    private static final String LOGIN_URL = "/login";
    //在业务处理器处理请求之前对该请求进行拦截处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        User user = null;
        Integer loginId = null;
        try {
             user = AuthUtils.getCurrentUser();
             loginId = user.getId();
            if(null == user || ("").equals(user)){
                request.getRequestDispatcher(LOGIN_URL).forward(request,response);
                return false;
            }
         }catch (Throwable a){
            logger.error(a.getMessage());
            request.getRequestDispatcher(LOGIN_URL).forward(request,response);
            return false;

         }
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String sessionId = request.getRequestedSessionId();
        String contextPath = request.getServletPath();
        String content = request.getQueryString();
        if(null == loginId ||("").equals(loginId)){
            loginId = 0;
        }

        String ip = getIpAddr(request);
        logger.info(url+"||"+method+"||"+loginId+"||"+user.getUserName()+"||"+contextPath+"||"+content+"||"+sessionId+"||"+ip+"||"+request.getCookies());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(handler+"-------------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    public  static String getIpAddr(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 澶氭鍙嶅悜浠ｇ悊鍚庝細鏈夊涓狪P鍊硷紝绗竴涓负鐪熷疄IP銆?
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
}
