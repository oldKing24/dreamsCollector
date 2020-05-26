package com.example.demo.Entity;

import java.util.Date;

public class MiniUserSetting {
    private String id;
    private String openId;
    private String signInfo;
    private String backgroudId;
    private String backPic;
    private Date createTime;
    private Date updateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getOpenId() { return openId; }
    public void setOpenId(String openId) { this.openId = openId; }

    public String getSignInfo() { return signInfo; }
    public void setSignInfo(String signInfo) { this.signInfo = signInfo; }

    public String getBackgroudId() { return backgroudId; }
    public void setBackgroudId(String backgroudId) { this.backgroudId = backgroudId; }

    public String getBackPic() { return backPic; }
    public void setBackPic(String backPic) { this.backPic = backPic; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}
