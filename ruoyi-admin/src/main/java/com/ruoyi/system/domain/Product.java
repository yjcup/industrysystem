package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品信息管理对象 product
 * 
 * @author ruoyi
 * @date 2024-02-06
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String des;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String imglist;

    /** 销量 */
    @Excel(name = "销量")
    private Long count;

    /** 库存 */
    @Excel(name = "库存")
    private Long inventory;

    /** 商品状态 */
    @Excel(name = "商品状态")
    private String status;

    /** 商品地区 */
    @Excel(name = "商品地区")
    private String prov;


    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setImglist(String imglist) 
    {
        this.imglist = imglist;
    }

    public String getImglist() 
    {
        return imglist;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setInventory(Long inventory) 
    {
        this.inventory = inventory;
    }

    public Long getInventory() 
    {
        return inventory;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setProv(String prov) 
    {
        this.prov = prov;
    }

    public String getProv() 
    {
        return prov;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("des", getDes())
            .append("imglist", getImglist())
            .append("count", getCount())
            .append("inventory", getInventory())
            .append("status", getStatus())
            .append("prov", getProv())
            .append("price", getPrice())
            .append("createTime", getCreateTime())
            .toString();
    }
}
