package com.ruoyi.project.mhxy.fairy.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mhxy.fairy.IFairyBuyRecordService;
import com.ruoyi.project.mhxy.fairy.bean.FairyBuyRecord;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-09-13
 */
@Controller
@RequestMapping("/system/record")
public class FairyBuyRecordController extends BaseController {
    private String prefix = "system/record";

    @Resource
    private IFairyBuyRecordService fairyBuyRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record() {
        return prefix + "/record";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FairyBuyRecord fairyBuyRecord) {
        startPage();
        List<FairyBuyRecord> list = fairyBuyRecordService.selectFairyBuyRecordList(fairyBuyRecord);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:record:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FairyBuyRecord fairyBuyRecord) {
        List<FairyBuyRecord> list = fairyBuyRecordService.selectFairyBuyRecordList(fairyBuyRecord);
        ExcelUtil<FairyBuyRecord> util = new ExcelUtil<FairyBuyRecord>(FairyBuyRecord.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:record:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FairyBuyRecord fairyBuyRecord) {
        return toAjax(fairyBuyRecordService.insertFairyBuyRecord(fairyBuyRecord));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        FairyBuyRecord fairyBuyRecord = fairyBuyRecordService.selectFairyBuyRecordById(id);
        mmap.put("fairyBuyRecord", fairyBuyRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FairyBuyRecord fairyBuyRecord) {
        return toAjax(fairyBuyRecordService.updateFairyBuyRecord(fairyBuyRecord));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(fairyBuyRecordService.deleteFairyBuyRecordByIds(ids));
    }
}
