package com.example.demo.Entity;

import java.util.Date;

public class MiniDreamsLike {
    private String id;
    private String dreamId;
    private String liker;
    private String likerName;
    private Date createTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDreamId() { return dreamId; }
    public void setDreamId(String dreamId) { this.dreamId = dreamId; }

    public String getLiker() { return liker; }
    public void setLiker(String liker) { this.liker = liker; }

    public String getLikerName() { return likerName; }
    public void setLikerName(String likerName) { this.likerName = likerName; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
