package com.ruoyi.project.mhxy.fairy;

import com.ruoyi.project.mhxy.fairy.bean.Label;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-20
 */
public interface ILabelService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Label selectLabelById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param label 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Label> selectLabelList(Label label);

    /**
     * 新增【请填写功能名称】
     * 
     * @param label 【请填写功能名称】
     * @return 结果
     */
    public int insertLabel(Label label);

    /**
     * 修改【请填写功能名称】
     * 
     * @param label 【请填写功能名称】
     * @return 结果
     */
    public int updateLabel(Label label);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteLabelByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteLabelById(Long id);
}
