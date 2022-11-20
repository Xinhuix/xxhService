package com.ruoyi.project.mhxy.fairy.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mhxy.fairy.ILabelService;
import com.ruoyi.project.mhxy.fairy.bean.Label;
import com.ruoyi.project.mhxy.fairy.mapper.LabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-20
 */
@Service
public class LabelServiceImpl implements ILabelService
{
    @Autowired
    private LabelMapper labelMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Label selectLabelById(Long id)
    {
        return labelMapper.selectLabelById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param label 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Label> selectLabelList(Label label)
    {
        return labelMapper.selectLabelList(label);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param label 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertLabel(Label label)
    {
        label.setCreateTime(DateUtils.getNowDate());
        return labelMapper.insertLabel(label);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param label 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateLabel(Label label)
    {
        return labelMapper.updateLabel(label);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLabelByIds(String ids)
    {
        return labelMapper.deleteLabelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLabelById(Long id)
    {
        return labelMapper.deleteLabelById(id);
    }
}
