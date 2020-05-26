package com.example.demo.Entity;

import com.example.demo.annovation.TimeToDayAnnotation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MiniDreanListEntity {
    private String id;
    private String title;
    private String tagColor;
    private String tagName;
    private String content;
    private String picPath;
    private String openId;
    private Date createTime;
    @TimeToDayAnnotation(value = "测试")
    private String createTimeDesc;
    private String nickName;
    private String likeNum;
    private String commentsNum;
    private String shareNum;
    private String avatarUrl;
    private boolean shoucangStatus;
    private boolean likeStatus;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTagColor() { return tagColor; }
    public void setTagColor(String tagColor) { this.tagColor = tagColor; }

    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getPicPath() { return picPath; }
    public void setPicPath(String picPath) { this.picPath = picPath; }

    public String getOpenId() { return openId; }
    public void setOpenId(String openId) { this.openId = openId; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

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
    public void setCreateTimeDesc(String createTimeDesc) { this.createTimeDesc = createTimeDesc; }

    public String getNickName() { return nickName; }
    public void setNickName(String nickName) { this.nickName = nickName; }

    public String getLikeNum() { return likeNum; }
    public void setLikeNum(String likeNum) { this.likeNum = likeNum; }

    public String getCommentsNum() { return commentsNum; }
    public void setCommentsNum(String commentsNum) { this.commentsNum = commentsNum; }

    public String getShareNum() { return shareNum; }
    public void setShareNum(String shareNum) { this.shareNum = shareNum; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public boolean isShoucangStatus() {return shoucangStatus; }
    public void setShoucangStatus(boolean shoucangStatus) { this.shoucangStatus = shoucangStatus; }

    public boolean isLikeStatus() { return likeStatus; }
    public void setLikeStatus(boolean likeStatus) { this.likeStatus = likeStatus; }
}
