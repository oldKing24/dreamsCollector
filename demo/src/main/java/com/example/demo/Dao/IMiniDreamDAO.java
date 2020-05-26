package com.example.demo.Dao;

import com.example.demo.Entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IMiniDreamDAO {
    void ajaxAddUserInfo(MiniUserInfo userInfo) throws Exception;
    void ajaxUpdateUserInfo(MiniUserInfo userInfo) throws Exception;
    MiniUserInfo ajaxSearchUserInfo(Map<String,String> map) throws Exception;
    List<MiniDreamsTag> getAllTags() throws Exception;
    void ajaxAddDreams(MiniDreamsInfo dreamsInfo) throws Exception;
    List<MiniDreanListEntity> ajaxGetDreamsPager(Map map) throws Exception;
    MiniDreanListEntity getDreamDetail(Map map) throws Exception;
    void addComments(MiniDreamsComments comments) throws Exception;
    List<MiniDreamsComments> getCommentsListById(Map map) throws Exception;
    List<MiniDreamsCommentsEntity> getComments(Map map) throws Exception;
    MiniDreamsShare getShare(Map map) throws Exception;
    MiniDreamsLike getLike(Map map) throws Exception;
    void insertDreamShare(MiniDreamsShare share) throws Exception;
    void deleteDreamShare(MiniDreamsShare share) throws Exception;
}
