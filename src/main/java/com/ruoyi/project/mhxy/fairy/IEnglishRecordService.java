package com.ruoyi.project.mhxy.fairy;


import com.ruoyi.dto.EnglishRecordDTO;
import com.ruoyi.project.mhxy.fairy.bean.EnglishRecord;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-04
 */
public interface IEnglishRecordService {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EnglishRecord selectEnglishRecordById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param englishRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EnglishRecord> selectEnglishRecordList(EnglishRecord englishRecord);

    /**
     * 新增【请填写功能名称】
     *
     * @param englishRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertEnglishRecord(EnglishRecord englishRecord, List<EnglishRecordDTO.EnglishInfo> englishList);

    /**
     * 修改【请填写功能名称】
     *
     * @param englishRecord 【请填写功能名称】
     * @return 结果
     */
    public int updateEnglishRecord(EnglishRecord englishRecord);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEnglishRecordByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEnglishRecordById(Long id);
}
