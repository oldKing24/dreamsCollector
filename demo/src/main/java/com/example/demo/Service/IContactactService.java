package com.example.demo.Service;

import com.example.demo.Entity.TbCOVIDInfo;
import com.example.demo.Entity.TbUserInfo;

public interface IContactactService {
    TbUserInfo  getUserInfo() throws Exception;
    boolean checkUserInfo(String userName,String password) throws Exception;
    void addUserInfo(TbUserInfo userInfo) throws Exception;
    void insertCovidInfo(TbCOVIDInfo tbCOVIDInfo) throws Exception;
}
