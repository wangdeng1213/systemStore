package com.peanut.p2p.filter;

import com.peanut.p2p.context.SessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wentao.awt on 2014/12/8.
 */
public class SessionContextFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(SessionContextFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        try {
            SessionContext.setRequest((HttpServletRequest) request);
            SessionContext.setResponse((HttpServletResponse) response);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("set threadLocal httpSession error!", e);
            }
        } finally {
            SessionContext.getRequestLocal().remove();
            SessionContext.getResponseLocal().remove();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
