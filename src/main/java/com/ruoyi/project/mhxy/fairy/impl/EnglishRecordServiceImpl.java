package com.ruoyi.project.mhxy.fairy.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.dto.EnglishRecordDTO;
import com.ruoyi.project.mhxy.fairy.IEnglishRecordService;
import com.ruoyi.project.mhxy.fairy.bean.EnglishRecord;
import com.ruoyi.project.mhxy.fairy.bean.EnglishRecordItem;
import com.ruoyi.project.mhxy.fairy.mapper.EnglishRecordItemMapper;
import com.ruoyi.project.mhxy.fairy.mapper.EnglishRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-04
 */
@Service
public class EnglishRecordServiceImpl implements IEnglishRecordService {
    @Autowired
    private EnglishRecordMapper englishRecordMapper;

    @Autowired
    private EnglishRecordItemMapper englishRecordItemMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EnglishRecord selectEnglishRecordById(Long id) {
        return englishRecordMapper.selectEnglishRecordById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param englishRecord 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EnglishRecord> selectEnglishRecordList(EnglishRecord englishRecord) {
        return englishRecordMapper.selectEnglishRecordList(englishRecord);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param englishRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertEnglishRecord(EnglishRecord englishRecord, List<EnglishRecordDTO.EnglishInfo> englishList) {
        englishRecord.setCreateTime(DateUtils.getNowDate());
        List<EnglishRecord> list = englishRecordMapper.selectEnglishRecordList(new EnglishRecord(englishRecord.getRecordDate()));
        int id = 0;
        Date now = new Date();
        englishRecord.setCreateTime(now);
        englishRecord.setUpdateTime(now);
        if (Objects.isNull(list) || list.isEmpty()) {
            englishRecordMapper.insertEnglishRecord(englishRecord);
            id = englishRecord.getId();
        } else {
            EnglishRecord record = list.get(0);
            id = record.getId();
        }
        EnglishRecordItem item = new EnglishRecordItem();
        item.setEnglishRecordId(id);
        for (EnglishRecordDTO.EnglishInfo info : englishList) {
            item.setEnglish(info.getEnglish());
            List<EnglishRecordItem> items = englishRecordItemMapper.selectEnglishRecordItemList(item);
            if (Objects.isNull(items) || items.isEmpty()) {
                EnglishRecordItem insert = new EnglishRecordItem();
                insert.setEnglish(info.getEnglish());
                insert.setEnglishRecordId(id);
                insert.setChinese(info.getChinese());
                insert.setState(0);
                insert.setCreateTime(now);
                insert.setUpdateTime(now);
                englishRecordItemMapper.insertEnglishRecordItem(insert);
            }
        }
        return 0;
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param englishRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEnglishRecord(EnglishRecord englishRecord) {
        englishRecord.setUpdateTime(DateUtils.getNowDate());
        return englishRecordMapper.updateEnglishRecord(englishRecord);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnglishRecordByIds(String ids) {
        return englishRecordMapper.deleteEnglishRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnglishRecordById(Long id) {
        return englishRecordMapper.deleteEnglishRecordById(id);
    }
}
