package com.hai.mapper;

import com.hai.pojo.User;
import com.hai.util.MD5Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by chenz at 10:46 on 2021/4/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void register() {
        System.out.println(MD5Tool.getMD5("AA"));
    }

    @Test
    public void  checkRegister(){
        System.out.println(userMapper.checkReg("AAAA"));
    }
}