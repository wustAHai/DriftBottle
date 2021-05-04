package com.hai.mapper;

import com.hai.pojo.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by chenz at 12:41 on 2021/5/3
 */
@Mapper
public interface ReplyMapper {

    @Insert("insert into reply(bottleId,fromId,toId,msg,status) value(#{bottleId},#{fromId},#{toId},#{msg},#{status})")
    int addReply(Reply reply);

    @Select("select count(*) from reply where status=0 and toId=#{id}")
    int getNum(long id);

    @Select("select * from reply where status=0 and toId=#{id} order by id desc")
    List<Reply> getReply(long id);

    @Update("update reply set status = 1 where id = #{id}")
    void setStatus(long id);

    @Insert("insert into reply(bottleId,replyId,fromId,toId,msg,status) value(#{bottleId},#{replyId},#{fromId},#{toId},#{msg},#{status})")
    int r2r(Reply reply);
}
