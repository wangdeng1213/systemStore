/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.captcha.producer.impl;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.peanut.p2p.context.SessionContext;
import com.peanut.p2p.security.captcha.producer.CaptchaProducer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 安文涛
 * @version 1.0
 */
@Component("captchaProducer")
public class CaptchaProducerImpl implements CaptchaProducer {
    private static Log log = LogFactory.getLog(CaptchaProducerImpl.class);

    @Resource
    private DefaultKaptcha kaptchaProducer;

    public void generateCaptchaImage() {
        HttpServletResponse response = SessionContext.getResponse();
        HttpSession session = SessionContext.getSession();

        setResponse(response);

        BufferedImage bufferedImage = generateCaptchaText(session);

        printCaptchaImage(response, bufferedImage);
    }

    private void setResponse(HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
    }

    private BufferedImage generateCaptchaText(HttpSession session) {
        String captchaText = kaptchaProducer.createText();
        BufferedImage bi = kaptchaProducer.createImage(captchaText);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, captchaText);
        return bi;
    }

    private void printCaptchaImage(HttpServletResponse response,
                                   BufferedImage bufferedImage) {
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", out);
            out.flush();
        } catch (IOException e) {
            if (log.isErrorEnabled()) {
                log.error("输出验证码的过程中发生IO异常!", e);
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                if (log.isErrorEnabled()) {
                    log.error("关闭验证码的输出流时发生IO异常!", e);
                }
            }
        }
    }
}