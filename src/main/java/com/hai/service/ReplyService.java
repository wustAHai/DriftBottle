package com.hai.service;

import com.hai.mapper.ReplyMapper;
import com.hai.pojo.Reply;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenz at 12:42 on 2021/5/3
 */
@Service
public class ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    public Message reply(Reply reply){
        if (replyMapper.addReply(reply)==1){
            return new Message(0,null,"回复成功");
        }else {
            return new Message(1,null,"回复失败，请重试");
        }
    }
}
