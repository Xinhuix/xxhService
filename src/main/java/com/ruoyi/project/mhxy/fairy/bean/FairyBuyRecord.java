package com.ruoyi.project.mhxy.fairy.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 fairy_buy_record
 * 
 * @author ruoyi
 * @date 2022-09-13
 */
public class FairyBuyRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "类型id", readConverterExp = "$column.readConverterExp()")
    private Long fairyStoreId;

    private String typeDesc;

    private Boolean status;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;


    /** 地址 */
    @Excel(name = "地址")
    private String region;

    /** 搜索时辰 */
    @Excel(name = "搜索时辰")
    private String searchTime;

    /** 1成功：0失败 */
    @Excel(name = "1成功：0失败")
    private Integer isBuySuccess;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFairyStoreId(Long fairyStoreId)
    {
        this.fairyStoreId = fairyStoreId;
    }

    public Long getFairyStoreId()
    {
        return fairyStoreId;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }
    public void setSearchTime(String searchTime)
    {
        this.searchTime = searchTime;
    }

    public String getSearchTime()
    {
        return searchTime;
    }
    public void setIsBuySuccess(Integer isBuySuccess)
    {
        this.isBuySuccess = isBuySuccess;
    }

    public Integer getIsBuySuccess()
    {
        return isBuySuccess;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fairyStoreId", getFairyStoreId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("price", getPrice())
            .append("region", getRegion())
            .append("searchTime", getSearchTime())
            .append("isBuySuccess", getIsBuySuccess())
            .toString();
    }
}
