package com.ruoyi.project.mhxy.fairy.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mhxy.fairy.IEnglishRecordItemService;
import com.ruoyi.project.mhxy.fairy.bean.EnglishRecordItem;
import com.ruoyi.project.mhxy.fairy.mapper.EnglishRecordItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-04
 */
@Service
public class EnglishRecordItemServiceImpl implements IEnglishRecordItemService
{
    @Autowired
    private EnglishRecordItemMapper englishRecordItemMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EnglishRecordItem selectEnglishRecordItemById(Long id)
    {
        return englishRecordItemMapper.selectEnglishRecordItemById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EnglishRecordItem> selectEnglishRecordItemList(EnglishRecordItem englishRecordItem)
    {
        return englishRecordItemMapper.selectEnglishRecordItemList(englishRecordItem);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEnglishRecordItem(EnglishRecordItem englishRecordItem)
    {
        englishRecordItem.setCreateTime(DateUtils.getNowDate());
        return englishRecordItemMapper.insertEnglishRecordItem(englishRecordItem);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param englishRecordItem 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEnglishRecordItem(EnglishRecordItem englishRecordItem)
    {
        englishRecordItem.setUpdateTime(DateUtils.getNowDate());
        return englishRecordItemMapper.updateEnglishRecordItem(englishRecordItem);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnglishRecordItemByIds(String ids)
    {
        return englishRecordItemMapper.deleteEnglishRecordItemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnglishRecordItemById(Long id)
    {
        return englishRecordItemMapper.deleteEnglishRecordItemById(id);
    }
}
