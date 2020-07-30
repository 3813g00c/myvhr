package com.ywxiang.controller;

import com.ywxiang.common.RespBean;
import com.ywxiang.common.utils.RedisUtils;
import com.ywxiang.common.utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ywxiang
 * @date 2020/7/29 下午9:31
 */
@RestController
public class LoginController {
    private static final long EXPIRE_TIME = 60 * 5;
    @Autowired
    RedisUtils redisUtils;

    @GetMapping
    public RespBean login(){
        return RespBean.error("尚未登录！");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();

        String verifyId = UUID.randomUUID().toString().replaceAll("-", "");

        HttpSession session = request.getSession();
        session.setAttribute("VERIFYID", verifyId);
        redisUtils.set(verifyId, text, EXPIRE_TIME);
        // 保存到redis
        VerificationCode.output(image, resp.getOutputStream());
    }
}
