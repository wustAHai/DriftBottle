package com.hai.service;

import com.hai.mapper.BottleMapper;
import com.hai.mapper.UserMapper;
import com.hai.pojo.Bottle;
import com.hai.pojo.Info;
import com.hai.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenz at 13:11 on 2021/4/30
 */
@Service
public class BottleService {

    @Autowired
    BottleMapper bottleMapper;

    @Autowired
    UserMapper userMapper;

    public Message addBottle(Bottle bottle){
        final int i = bottleMapper.addBottle(bottle);
        if (i==1){
            return  new Message(0,null,"投递成功");
        }else {
            return  new Message(1,null,"投递失败");
        }
    }

    @Transactional
    public Message getBottle(long id){
        final List<Long> getBottles = bottleMapper.getBottles(id);
        if (getBottles.size()==0){
            return  new Message(1,null,"暂时没有瓶子");
        }
        final int size = getBottles.size();
        int index =(int)(Math.random()*size);
        final Long aLong = getBottles.get(index);
        final Bottle bottle = bottleMapper.getBottle(aLong);
        bottleMapper.updateBottle(aLong);
        final Info infoById = userMapper.getInfoById(bottle.getSendId());
        final Object[] objects = new Object[2];
        objects[0]=infoById;
        objects[1]=bottle;
        return  new Message(0,objects,"捞到了瓶子");
    }

    public Message collectBottle(long id,long bId){
        final Bottle bottle = bottleMapper.getBottle(bId);
        if (bottle.getStatus()==1){
            bottleMapper.collectBottle(id,bId);
            return new Message(0,null,"收藏成功");
        }else {
            bottleMapper.backCollect(bId);
            return new Message(1,null,"取消收藏成功");
        }
    }

    public Message backBottle(long bId) {
        bottleMapper.backBottle(bId);
        return  new Message(0,null,"扔回海里了");
    }
}
