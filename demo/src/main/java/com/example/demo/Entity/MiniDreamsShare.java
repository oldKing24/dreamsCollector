package com.example.demo.Entity;

import java.util.Date;

public class MiniDreamsShare {
    private String id;
    private String shareId;
    private String shareName;
    private String dreamsId;
    private Date createTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getShareId() { return shareId; }
    public void setShareId(String shareId) { this.shareId = shareId; }

    public String getShareName() { return shareName; }
    public void setShareName(String shareName) { this.shareName = shareName; }

    public String getDreamsId() { return dreamsId; }
    public void setDreamsId(String dreamsId) { this.dreamsId = dreamsId; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
