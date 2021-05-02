package com.hai.mapper;

import com.hai.pojo.Bottle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by chenz at 13:03 on 2021/4/30
 */
@Mapper
public interface BottleMapper {

    @Insert("insert into bottle(sendId,status,msg) value(#{sendId},#{status},#{msg})")
    int addBottle(Bottle bottle);

    @Select("select id from bottle where status=0 and sendId!=#{id}")
    List<Long> getBottles(long id);

    @Select("select * from bottle where id=#{id}")
    Bottle getBottle(long id);

    @Update("update bottle set status=1 where id = #{id}")
    void updateBottle(long id);

    @Update("update bottle set status=2 , getId=#{id} where id=#{bId}")
    void collectBottle(long id , long bId );

    @Update("update bottle set status=1, getId=null where id=#{id}")
    void backCollect(long id);

    @Update("update bottle set status=0,getId=null where id=#{id}")
    void backBottle(long id);
}
