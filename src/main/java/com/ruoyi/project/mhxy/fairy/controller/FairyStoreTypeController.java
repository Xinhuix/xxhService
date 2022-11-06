package com.ruoyi.project.mhxy.fairy.controller;

import java.util.List;

import com.ruoyi.project.mhxy.fairy.IFairyStoreTypeService;
import com.ruoyi.project.mhxy.fairy.bean.FairyStoreType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-09-13
 */
@Controller
@RequestMapping("/system/type")
public class FairyStoreTypeController extends BaseController
{
    private String prefix = "system/type";

    @Resource
    private IFairyStoreTypeService fairyStoreTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FairyStoreType fairyStoreType)
    {
        List<FairyStoreType> list = fairyStoreTypeService.selectFairyStoreTypeList(fairyStoreType);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FairyStoreType fairyStoreType)
    {
        List<FairyStoreType> list = fairyStoreTypeService.selectFairyStoreTypeList(fairyStoreType);
        ExcelUtil<FairyStoreType> util = new ExcelUtil<FairyStoreType>(FairyStoreType.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FairyStoreType fairyStoreType)
    {
        return toAjax(fairyStoreTypeService.insertFairyStoreType(fairyStoreType));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:type:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FairyStoreType fairyStoreType = fairyStoreTypeService.selectFairyStoreTypeById(id);
        mmap.put("fairyStoreType", fairyStoreType);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FairyStoreType fairyStoreType)
    {
        return toAjax(fairyStoreTypeService.updateFairyStoreType(fairyStoreType));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fairyStoreTypeService.deleteFairyStoreTypeByIds(ids));
    }
}
