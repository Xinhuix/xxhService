package com.ruoyi.project.mhxy.fairy;

import com.ruoyi.project.mhxy.fairy.bean.EnglishRecordItem;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-04
 */
public interface IEnglishRecordItemService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EnglishRecordItem selectEnglishRecordItemById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EnglishRecordItem> selectEnglishRecordItemList(EnglishRecordItem englishRecordItem);

    /**
     * 新增【请填写功能名称】
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 结果
     */
    public int insertEnglishRecordItem(EnglishRecordItem englishRecordItem);

    /**
     * 修改【请填写功能名称】
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 结果
     */
    public int updateEnglishRecordItem(EnglishRecordItem englishRecordItem);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEnglishRecordItemByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEnglishRecordItemById(Long id);
}
