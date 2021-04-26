package com.hai.mapper;

import com.hai.pojo.Info;
import com.hai.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by chenz at 10:38 on 2021/4/21
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user value(#{id},#{name},#{pwd})")
    int register(User user);

    @Select("select count(*) from user where name=#{name}")
    int checkReg(String name);

    @Select("select * from user where name=#{name}")
    User getUserByName(String name);

    @Select("select id from user where name=#{name}")
    Long getUserId(String name);

    @Insert("insert into info value(#{id},#{nickname},#{location},#{description})")
    int addInfo(Info info);

    @Update("update info set nickname=#{nickname},location=#{location},description=#{description} where id=#{id}")
    int updateInfo(Info info);

    @Select("select * from info where id=#{id}")
    Info getInfoById(Long id);
}
