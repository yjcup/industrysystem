package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游玩日记管理对象 blog
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
public class Blog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 简介 */
    @Excel(name = "简介")
    private String des;

    /** 内容 */
    @Excel(name = "内容")
    private String conent;

    /** 点击量 */
    @Excel(name = "点击量")
    private Long click;

    /** 封面 */
    @Excel(name = "封面")
    private String img;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setConent(String conent) 
    {
        this.conent = conent;
    }

    public String getConent() 
    {
        return conent;
    }
    public void setClick(Long click) 
    {
        this.click = click;
    }

    public Long getClick() 
    {
        return click;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("des", getDes())
            .append("conent", getConent())
            .append("click", getClick())
            .append("img", getImg())
            .append("createTime", getCreateTime())
            .toString();
    }
}
