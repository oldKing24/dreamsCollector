package com.example.demo.Service.impl;

import com.example.demo.Dao.IUserDao;
import com.example.demo.Entity.TbCOVIDInfo;
import com.example.demo.Entity.TbUserInfo;
import com.example.demo.Service.IContactactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class contactServiceImpl implements IContactactService {
    @Autowired
    private IUserDao userDao;
    @Override
    public TbUserInfo getUserInfo() throws Exception {
        return userDao.getUserInfo();
    }

    @Override
    public boolean checkUserInfo(String userName, String password) throws Exception {
        Map map = new HashMap<String,Object>();
        map.put("userId",userName);
        map.put("password",password);
        TbUserInfo user = userDao.checkUserInfo(map);
        if(user==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void addUserInfo(TbUserInfo userInfo) throws Exception {
        userDao.addUserInfo(userInfo);
    }

    @Override
    public void insertCovidInfo(TbCOVIDInfo tbCOVIDInfo) throws Exception {
        userDao.insertCovidInfo(tbCOVIDInfo);
    }
}
