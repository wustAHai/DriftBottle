package com.hai.controller;

import com.hai.pojo.Bottle;
import com.hai.service.BottleService;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenz at 13:11 on 2021/4/30
 */
@RestController
public class BottleController {

    @Autowired
    BottleService bottleService;

    @PostMapping("/addBottle")
    public Message addBottle(Long id,String msg){
        final Bottle bottle = new Bottle();
        bottle.setSendId(id);
        bottle.setMsg(msg);
        return  bottleService.addBottle(bottle);
    }

    @GetMapping("/getBottle")
    public Message getBottle(Long id){
        return bottleService.getBottle(id);
    }

    @PostMapping("/collectBottle")
    public Message collectBottle(long id,long bId){
        return bottleService.collectBottle(id,bId);
    }

    @PostMapping("/backBottle")
    public Message backBottle(long bId){
        return bottleService.backBottle(bId);
    }

}
