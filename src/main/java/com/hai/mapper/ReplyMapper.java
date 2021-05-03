package com.hai.mapper;

import com.hai.pojo.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by chenz at 12:41 on 2021/5/3
 */
@Mapper
public interface ReplyMapper {

    @Insert("insert into reply(bottleId,fromId,toId,msg,status) value(#{bottleId},#{fromId},#{toId},#{msg},#{status})")
    int addReply(Reply reply);
}
