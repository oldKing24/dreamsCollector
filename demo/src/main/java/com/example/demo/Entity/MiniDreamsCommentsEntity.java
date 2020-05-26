package com.example.demo.Entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MiniDreamsCommentsEntity {
    private String id;
    private String commentor;
    private String commentorName;
    private String dreamsId;
    private String commentContent;
    private Date createTime;
    private String avatarUrl;
    private String createTimeDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentor() {
        return commentor;
    }

    public void setCommentor(String commentor) {
        this.commentor = commentor;
    }

    public String getCommentorName() {
        return commentorName;
    }

    public void setCommentorName(String commentorName) {
        this.commentorName = commentorName;
    }

    public String getDreamsId() {
        return dreamsId;
    }

    public void setDreamsId(String dreamsId) {
        this.dreamsId = dreamsId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreateTimeDesc() {
        int offSet = Calendar.getInstance().getTimeZone().getRawOffset();
        long today = (System.currentTimeMillis()+offSet)/86400000;
        long start = (createTime.getTime()+offSet)/86400000;
        if((start-today)==-2){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return "前天"+sdf.format(createTime);
        }else if((start-today)==-1){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return "昨天"+sdf.format(createTime);
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(createTime);
        }
    }

    public void setCreateTimeDesc(String createTimeDesc) {
        this.createTimeDesc = createTimeDesc;
    }
}
