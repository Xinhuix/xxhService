package com.ruoyi.project.mhxy.fairy.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mhxy.fairy.IFairyStoreTypeService;
import com.ruoyi.project.mhxy.fairy.bean.FairyStoreType;
import com.ruoyi.project.mhxy.fairy.mapper.FairyStoreTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-13
 */
@Service
public class FairyStoreTypeServiceImpl implements IFairyStoreTypeService
{
    @Resource
    private FairyStoreTypeMapper fairyStoreTypeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FairyStoreType selectFairyStoreTypeById(Long id)
    {
        return fairyStoreTypeMapper.selectFairyStoreTypeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FairyStoreType> selectFairyStoreTypeList(FairyStoreType fairyStoreType)
    {
        return fairyStoreTypeMapper.selectFairyStoreTypeList(fairyStoreType);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFairyStoreType(FairyStoreType fairyStoreType)
    {
        fairyStoreType.setCreateTime(DateUtils.getNowDate());
        return fairyStoreTypeMapper.insertFairyStoreType(fairyStoreType);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fairyStoreType 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFairyStoreType(FairyStoreType fairyStoreType)
    {
        fairyStoreType.setUpdateTime(DateUtils.getNowDate());
        return fairyStoreTypeMapper.updateFairyStoreType(fairyStoreType);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFairyStoreTypeByIds(String ids)
    {
        return fairyStoreTypeMapper.deleteFairyStoreTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFairyStoreTypeById(Long id)
    {
        return fairyStoreTypeMapper.deleteFairyStoreTypeById(id);
    }
}
