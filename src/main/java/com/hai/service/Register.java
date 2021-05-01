package com.hai.service;

import com.hai.mapper.UserMapper;
import com.hai.pojo.Info;
import com.hai.pojo.User;
import com.hai.util.MD5Tool;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenz at 10:28 on 2021/4/21
 */
//0 是成功 1是失败
@Service
public class Register {
    @Autowired
    UserMapper userMapper;

    public Message register(String name,String pwd){
        final Message message = new Message();
        if (userMapper.checkReg(name)==1){
            message.setCode(1);
            message.setMsg("该用户名已被注册");
        }else {
            pwd= MD5Tool.getMD5(pwd);
            final User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            try {
                if (userMapper.register(user)==1){
                    final User userByName = userMapper.getUserByName(user.getName());
                    userMapper.addInfo(new Info(userByName.getId(),"暂无","暂无","暂无"));
                    message.setCode(0);
                    message.setMsg("注册成功");
                }else {
                    message.setCode(1);
                    message.setMsg("注册失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                message.setCode(1);
                message.setMsg("注册失败");
            }
        }
        return message;
    }

    public Message login(String name,String pwd){
        final Message message = new Message();
        final User user = userMapper.getUserByName(name);
        if (user!=null){
            if (user.getPwd().equals(MD5Tool.getMD5(pwd))){
                message.setMsg("登陆成功");
                message.setData(Long.valueOf(user.getId()));
            }else {
                message.setCode(1);
                message.setMsg("账号或密码错误");
            }
        }else {
            message.setCode(1);
            message.setMsg("账号或密码错误");
        }
        return message;
    }

    public Info getInfo(Long id){
        final Info infoById = userMapper.getInfoById(id);
        if (infoById==null){
            final Info info = new Info(id, "暂无", "暂无", "暂无");
            userMapper.addInfo(info);
            return info;
        }else {
            return infoById;
        }
    }

    public Message updateInfo(Info info){
        final int i = userMapper.updateInfo(info);
        if (i==1) {
            return new Message(0, null, "更新成功");
        }else {
            return new Message(1,null,"保存失败");
        }
    }

    public Message changePassword(Long id,String pwd,String pwd1){
        final User userById = userMapper.getUserById(id);
        final Message message = new Message();
        if (userById==null){
            message.setCode(1);
            message.setMsg("用户不存在");
        }else {
            if (userById.getPwd().equals(MD5Tool.getMD5(pwd))){
                if (userMapper.updateUserPassword(MD5Tool.getMD5(pwd1),id)==1){
                    message.setMsg("更新成功");
                }else {
                    message.setCode(1);
                    message.setMsg("更新密码失败");
                }
            }else {
                message.setCode(1);
                message.setMsg("原始密码错误");
            }
        }
        return message;
    }
}
