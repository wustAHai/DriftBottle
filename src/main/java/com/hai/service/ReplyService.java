package com.hai.service;

import com.hai.mapper.BottleMapper;
import com.hai.mapper.ReplyMapper;
import com.hai.mapper.UserMapper;
import com.hai.pojo.Reply;
import com.hai.pojo.Result;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenz at 12:42 on 2021/5/3
 */
@Service
public class ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BottleMapper bottleMapper;

    public Message reply(Reply reply){
        if (replyMapper.addReply(reply)==1){
            return new Message(0,null,"回复成功");
        }else {
            return new Message(1,null,"回复失败，请重试");
        }
    }

    public Message getNum(long id){
        final int num = replyMapper.getNum(id);
        return new Message(0,num,"查询到"+num+"条数据");
    }

    public Message getReply(long id){
        final List<Reply> reply = replyMapper.getReply(id);
        final List<Result> results = new LinkedList<>();
        for (Reply rep:
             reply) {
            final Result result = new Result();
            result.setReply(rep);
            result.setBottle(bottleMapper.getBottle(rep.getBottleId()));
            result.setInfo(userMapper.getInfoById(rep.getFromId()));
            results.add(result);
        }
        return new Message(0,results,"您有新的"+results.size()+"条消息");
    }

    public Message setStatus(long id){
        replyMapper.setStatus(id);
        return  new Message(0,null,"设置为已读");
    }

    public Message r2r(Reply reply){
        if (replyMapper.r2r(reply)==1){
            return new Message(0,null,"回复成功");
        }else {
            return  new Message(1,null,"回复失败,请重试");
        }
    }
}
