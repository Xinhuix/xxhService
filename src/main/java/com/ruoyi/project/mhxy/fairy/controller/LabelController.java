package com.ruoyi.project.mhxy.fairy.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mhxy.fairy.ILabelService;
import com.ruoyi.project.mhxy.fairy.bean.Label;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-11-20
 */
@Controller
@RequestMapping("/system/label")
public class LabelController extends BaseController {
    private String prefix = "system/label";

    @Autowired
    private ILabelService labelService;

    @RequiresPermissions("system:label:view")
    @GetMapping()
    public String label() {
        return prefix + "/label";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Label label) {
        startPage();
        List<Label> list = labelService.selectLabelList(label);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:label:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Label label) {
        List<Label> list = labelService.selectLabelList(label);
        ExcelUtil<Label> util = new ExcelUtil<Label>(Label.class);
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
    @RequiresPermissions("system:label:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Label label) {
        return toAjax(labelService.insertLabel(label));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:label:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Label label = labelService.selectLabelById(id);
        mmap.put("label", label);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:label:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Label label) {
        return toAjax(labelService.updateLabel(label));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:label:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(labelService.deleteLabelByIds(ids));
    }
}
