/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.captcha.controller;

import com.peanut.p2p.security.captcha.producer.CaptchaProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class CaptchaController {
    @Resource
    private CaptchaProducer captchaProducer;

    @RequestMapping(value = "/img/captcha.jpg", method = RequestMethod.GET)
    public ModelAndView generateCaptchaImage() {
        captchaProducer.generateCaptchaImage();
        return null;
    }
}