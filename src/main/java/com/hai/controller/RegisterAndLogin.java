package com.hai.controller;

import com.hai.pojo.Info;
import com.hai.service.Register;
import com.hai.util.Message;
import com.hai.util.VerifyCodeImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * Created by chenz at 10:10 on 2021/4/21
 */
@RestController
public class RegisterAndLogin {
    @Autowired
    Register register;

    @PostMapping("/register")
    public Message register(String name, String pwd,String checkCode,HttpServletRequest request) {
        final String text = (String) request.getSession().getAttribute("text");
        if (checkCode.equalsIgnoreCase(text)){
            return register.register(name,pwd);
        }else {
         return new Message(1,null,"验证码错误");
        }
    }

    @PostMapping("/login")
    public Message login(String name,String pwd,String checkCode,HttpServletRequest request){
        final String text = (String) request.getSession().getAttribute("text");
        if (text.equalsIgnoreCase(checkCode)){
            final Message message = register.login(name, pwd);
            if (message.getCode()==0){
                final HttpSession session = request.getSession();
                session.setAttribute("name",name);
            }
            return message;
        }else {
            return new Message(1,null,"验证码错误");
        }
    }

    @RequestMapping("/getImg")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCodeImg verifyCodeImg = new VerifyCodeImg();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = verifyCodeImg.getImage();  //获取验证码
        request.getSession().setAttribute("text", verifyCodeImg.getText()); //将验证码的文本存在session中
        verifyCodeImg.output(image, response.getOutputStream());//将验证码图片响应给客户端
    }

    @GetMapping("/getInfo")
    public Message getInfo(String id){
        final Info info = register.getInfo(Long.parseLong(id));
        final Message message = new Message(0, info, "OK");
        return message;
    }

    @PostMapping("/updateInfo")
    public Message updateInfo(Info info){
        return register.updateInfo(info);
    }

    @PostMapping("/changePassword")
    public Message changePassword(Long id,String pwd,String pwd1){
        return  register.changePassword(id,pwd,pwd1);
    }

    @GetMapping("/checkLogin")
    public Message checkLogin(HttpServletRequest request){
        final HttpSession session = request.getSession();
        final Object name = session.getAttribute("name");
        if (name==null){
            return new Message(1,null,"您没有登录");
        }else {
            return new Message(0,null,"已登录");
        }
    }

}
