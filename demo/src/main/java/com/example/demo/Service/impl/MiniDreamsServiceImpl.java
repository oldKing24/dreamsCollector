package com.example.demo.Service.impl;

import com.example.demo.Dao.IMiniDreamDAO;
import com.example.demo.Entity.*;
import com.example.demo.Service.IMiniDreamsService;
import com.example.demo.utils.Pager;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MiniDreamsServiceImpl implements IMiniDreamsService {
    @Autowired
    private IMiniDreamDAO miniDreamDAO;
    @Override
    public void ajaxAddUserInfo(MiniUserInfo userInfo) throws Exception {
        miniDreamDAO.ajaxAddUserInfo(userInfo);
    }

    @Override
    public void ajaxUpdateUserInfo(MiniUserInfo userInfo) throws Exception {
        miniDreamDAO.ajaxUpdateUserInfo(userInfo);
    }

    @Override
    public MiniUserInfo ajaxSearchUserInfo(Map<String,String> map) throws Exception {
        MiniUserInfo miniUserInfo = miniDreamDAO.ajaxSearchUserInfo(map);
        return miniUserInfo;
    }

    @Override
    public List<MiniDreamsTag> getAllTags() throws Exception {
        return miniDreamDAO.getAllTags();
    }

    @Override
    public void ajaxAddDreams(MiniDreamsInfo dreamsInfo) throws Exception {
        miniDreamDAO.ajaxAddDreams(dreamsInfo);
    }

    @Override
    public List<MiniDreanListEntity> ajaxGetDreamsPager(Integer pageSize, Integer currentPage, String keyWord,String openId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<MiniDreanListEntity> list =  miniDreamDAO.ajaxGetDreamsPager(map);
        for(MiniDreanListEntity dreanListEntity:list){
            Map newMap = new HashMap();
            newMap.put("id",dreanListEntity.getId());
            newMap.put("openId",openId);
            dreanListEntity.setLikeStatus(miniDreamDAO.getLike(newMap)==null?false:true);
            dreanListEntity.setShoucangStatus(miniDreamDAO.getShare(newMap)==null?false:true);
        }
        return list;
    }

    @Override
    public MiniDreanListEntity getDreamDetail(Map map) throws Exception {
        return miniDreamDAO.getDreamDetail(map);
    }

    @Override
    public void addComments(MiniDreamsComments comments) throws Exception {
        miniDreamDAO.addComments(comments);
    }

    @Override
    public List<MiniDreamsCommentsEntity> getComments(Map map) throws Exception {
        return miniDreamDAO.getComments(map);
    }

    @Override
    public void insertDreamShare(MiniDreamsShare share) throws Exception {
        miniDreamDAO.insertDreamShare(share);
    }

    @Override
    public void deleteDreamShare(MiniDreamsShare share) throws Exception {
        miniDreamDAO.deleteDreamShare(share);
    }
}
