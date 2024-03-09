package com.example.qualitycontrolsystem.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT count(*) FROM user WHERE username = #{username} AND password = #{password}")
    int getCountByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
