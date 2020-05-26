package com.example.demo.Entity;

import java.util.Date;

public class MiniDreamsInfo {
    private String id;
    private String title;
    private String tagColor;
    private String tagName;
    private String content;
    private String picPath;
    private String openId;
    private Date createTime;

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
}
