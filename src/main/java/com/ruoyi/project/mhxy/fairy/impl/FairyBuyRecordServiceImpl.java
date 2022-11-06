package com.ruoyi.project.mhxy.fairy.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.mhxy.fairy.IFairyBuyRecordService;
import com.ruoyi.project.mhxy.fairy.bean.FairyBuyRecord;
import com.ruoyi.project.mhxy.fairy.bean.FairyStoreType;
import com.ruoyi.project.mhxy.fairy.mapper.FairyBuyRecordMapper;
import com.ruoyi.project.mhxy.fairy.mapper.FairyStoreTypeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-13
 */
@Service
public class FairyBuyRecordServiceImpl implements IFairyBuyRecordService {
    @Resource
    private FairyBuyRecordMapper fairyBuyRecordMapper;
    @Resource
    private FairyStoreTypeMapper fairyStoreTypeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FairyBuyRecord selectFairyBuyRecordById(Long id) {
        return fairyBuyRecordMapper.selectFairyBuyRecordById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FairyBuyRecord> selectFairyBuyRecordList(FairyBuyRecord fairyBuyRecord) {
        if (StringUtils.isNotBlank(fairyBuyRecord.getTypeDesc())) {
            FairyStoreType type = new FairyStoreType();
            type.setName(fairyBuyRecord.getTypeDesc());
            List<FairyStoreType> list = fairyStoreTypeMapper.selectFairyStoreTypeList(type);
            if (!list.isEmpty()) {
                fairyBuyRecord.setFairyStoreId(list.get(0).getId());
            }
        }

        List<FairyBuyRecord> list = fairyBuyRecordMapper.selectFairyBuyRecordList(fairyBuyRecord);
        if (!list.isEmpty()) {
            for (FairyBuyRecord buyRecord : list) {
                FairyStoreType fairyStoreType = fairyStoreTypeMapper.selectFairyStoreTypeById(buyRecord.getFairyStoreId());
                buyRecord.setTypeDesc(fairyStoreType.getName());
            }
        }
        return list;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFairyBuyRecord(FairyBuyRecord fairyBuyRecord) {
        fairyBuyRecord.setCreateTime(DateUtils.getNowDate());
        fairyBuyRecord.setIsBuySuccess(Objects.nonNull(fairyBuyRecord.getStatus()) && fairyBuyRecord.getStatus() ? 1 : 0);
        return fairyBuyRecordMapper.insertFairyBuyRecord(fairyBuyRecord);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param fairyBuyRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFairyBuyRecord(FairyBuyRecord fairyBuyRecord) {
        fairyBuyRecord.setUpdateTime(DateUtils.getNowDate());
        return fairyBuyRecordMapper.updateFairyBuyRecord(fairyBuyRecord);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFairyBuyRecordByIds(String ids) {
        return fairyBuyRecordMapper.deleteFairyBuyRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFairyBuyRecordById(Long id) {
        return fairyBuyRecordMapper.deleteFairyBuyRecordById(id);
    }
}
