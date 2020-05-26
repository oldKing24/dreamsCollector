package com.example.demo.Service;

import com.example.demo.Entity.*;

import java.util.List;
import java.util.Map;

public interface IMiniDreamsService {
    void ajaxAddUserInfo(MiniUserInfo userInfo) throws Exception;
    void ajaxUpdateUserInfo(MiniUserInfo userInfo) throws Exception;
    MiniUserInfo ajaxSearchUserInfo(Map<String,String> map) throws Exception;
    List<MiniDreamsTag> getAllTags() throws Exception;
    void ajaxAddDreams(MiniDreamsInfo dreamsInfo) throws Exception;
    List<MiniDreanListEntity> ajaxGetDreamsPager(Integer pageSize, Integer currentPage, String keyWord,String openId) throws Exception;
    MiniDreanListEntity getDreamDetail(Map map) throws Exception;
    void addComments(MiniDreamsComments comments) throws Exception;
    List<MiniDreamsCommentsEntity> getComments(Map map) throws Exception;
    void insertDreamShare(MiniDreamsShare share) throws Exception;
    void deleteDreamShare(MiniDreamsShare share) throws Exception;
}
