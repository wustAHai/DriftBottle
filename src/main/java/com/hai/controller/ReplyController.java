package com.hai.controller;

import com.hai.pojo.Reply;
import com.hai.service.ReplyService;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenz at 12:47 on 2021/5/3
 */
@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("/reply")
    public Message reply(long bottleId,long fromId,long toId,String msg){
        final Reply reply = new Reply();
        reply.setBottleId(bottleId);
        reply.setFromId(fromId);
        reply.setToId(toId);
        reply.setMsg(msg);
        return  replyService.reply(reply);
    }
}
