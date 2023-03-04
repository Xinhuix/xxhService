package com.ruoyi.project.mhxy.fairy.bean;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 english_record_item
 *
 * @author ruoyi
 * @date 2023-03-04
 */
public class EnglishRecordItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 状态（0：未完成，1：已完成）
     */
    @Excel(name = "状态", readConverterExp = "0=：未完成，1：已完成")
    private Integer state;

    /**
     * 中文
     */
    @Excel(name = "中文")
    private String chinese;

    /**
     * 单词
     */
    @Excel(name = "单词")
    private String english;

    /**
     * 复习
     */
    @Excel(name = "复习")
    private String review;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer englishRecordId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return chinese;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getEnglish() {
        return english;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setEnglishRecordId(Integer englishRecordId) {
        this.englishRecordId = englishRecordId;
    }

    public Integer getEnglishRecordId() {
        return englishRecordId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("state", getState())
                .append("chinese", getChinese())
                .append("english", getEnglish())
                .append("review", getReview())
                .append("englishRecordId", getEnglishRecordId())
                .toString();
    }

}
