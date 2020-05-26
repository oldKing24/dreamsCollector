package com.example.demo.Dao;

import com.example.demo.Entity.TbCOVIDInfo;
import com.example.demo.Entity.TbUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface IUserDao {
    TbUserInfo getUserInfo() throws Exception;
    TbUserInfo checkUserInfo(Map<String,Object> map) throws Exception;
    void addUserInfo(TbUserInfo userInfo) throws Exception;
    void insertCovidInfo(TbCOVIDInfo tbCOVIDInfo) throws Exception;
}
