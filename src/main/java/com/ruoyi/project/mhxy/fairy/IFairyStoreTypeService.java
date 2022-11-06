package com.ruoyi.project.mhxy.fairy;


import com.ruoyi.project.mhxy.fairy.bean.FairyStoreType;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-09-13
 */
public interface IFairyStoreTypeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FairyStoreType selectFairyStoreTypeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FairyStoreType> selectFairyStoreTypeList(FairyStoreType fairyStoreType);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 结果
     */
    public int insertFairyStoreType(FairyStoreType fairyStoreType);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 结果
     */
    public int updateFairyStoreType(FairyStoreType fairyStoreType);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFairyStoreTypeByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFairyStoreTypeById(Long id);
}
