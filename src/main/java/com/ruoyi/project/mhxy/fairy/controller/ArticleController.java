package com.ruoyi.project.mhxy.fairy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.FileUploadUtil;
import com.ruoyi.project.mhxy.fairy.IArticleService;
import com.ruoyi.project.mhxy.fairy.bean.Article;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-11-20
 */
@Controller
@RequestMapping("/system/article")
public class ArticleController extends BaseController {
    private String prefix = "system/article";

    @Autowired
    private IArticleService articleService;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article() {
        return prefix + "/article";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Article article) {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Article article) {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
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
    @RequiresPermissions("system:article:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Article article) {
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:article:edit")
    @GetMapping("/edit/{id}")
    @ResponseBody
    public AjaxResult edit(@PathVariable("id") Long id) {
        return success(articleService.selectArticleById(id));
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Article article) {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(articleService.deleteArticleByIds(ids));
    }


    /**
     * @param request
     * @param remark
     * @Description TODO 上传图片
     * @return: java.util.Map<java.lang.String ,   java.lang.Object>
     * @Author: Xinhxu
     * @Date: 15:03 2020/4/15
     */

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = "multipart/form-data")
    public Map<String, Object> uploadFile(HttpServletRequest request,
                                          @RequestParam(value = "remark", required = false) String remark) {
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> uploadFile = FileUploadUtil.uploadFile(request, null, "");
            //图片上传文件完成 数据库插入数据
            map.put("code", 0);
            map.put("msg", "上传成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
