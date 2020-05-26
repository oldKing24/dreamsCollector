package com.example.demo.Entity;

import java.util.Date;

public class MiniDreamsComments {
    private String id;
    private String commentor;
    private String commentorName;
    private String dreamsId;
    private String commentContent;
    private Date createTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCommentor() { return commentor; }
    public void setCommentor(String commentor) { this.commentor = commentor; }

    public String getCommentorName() { return commentorName; }
    public void setCommentorName(String commentorName) { this.commentorName = commentorName; }

    public String getDreamsId() { return dreamsId; }
    public void setDreamsId(String dreamsId) { this.dreamsId = dreamsId; }

    public String getCommentContent() { return commentContent; }
    public void setCommentContent(String commentContent) { this.commentContent = commentContent; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
