package com.ruoyi.project.mhxy.fairy.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 english_record
 *
 * @author ruoyi
 * @date 2023-03-04
 */
public class EnglishRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 日期
     */
    @Excel(name = "日期")
    private String recordDate;

    /**
     * 完成状态（0：未完成，1：已完成）
     */
    @Excel(name = "完成状态", readConverterExp = "0=：未完成，1：已完成")
    private Integer state;

    /**
     * 文章id
     */
    @Excel(name = "文章id")
    private Long articleId;

    public EnglishRecord(String recordDate) {
        this.recordDate = recordDate;
    }

    public EnglishRecord() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleId() {
        return articleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("recordDate", getRecordDate())
                .append("state", getState())
                .append("articleId", getArticleId())
                .toString();
    }
}
