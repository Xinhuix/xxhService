package com.ruoyi.project.mhxy.fairy.mapper;

import com.ruoyi.project.mhxy.fairy.bean.FairyBuyRecord;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-13
 */
public interface FairyBuyRecordMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FairyBuyRecord selectFairyBuyRecordById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FairyBuyRecord> selectFairyBuyRecordList(FairyBuyRecord fairyBuyRecord);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertFairyBuyRecord(FairyBuyRecord fairyBuyRecord);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 结果
     */
    public int updateFairyBuyRecord(FairyBuyRecord fairyBuyRecord);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFairyBuyRecordById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFairyBuyRecordByIds(String[] ids);
}
