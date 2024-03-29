package com.ruoyi.project.mhxy.fairy.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ruoyi.common.utils.FileUploadUtil;
import com.ruoyi.common.utils.GuavaCacheDemo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dto.EnglishRecordDTO;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mhxy.fairy.IArticleService;
import com.ruoyi.project.mhxy.fairy.IEnglishRecordService;
import com.ruoyi.project.mhxy.fairy.ILabelService;
import com.ruoyi.project.mhxy.fairy.bean.Article;
import com.ruoyi.project.mhxy.fairy.bean.EnglishRecord;
import com.ruoyi.project.mhxy.fairy.bean.Label;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-11-20
 */
@Controller
@RequestMapping("/system/article")
@Slf4j
public class ArticleController extends BaseController {
    private String prefix = "system/article";

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ILabelService labelService;

    @Autowired
    private IEnglishRecordService englishRecordService;


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
        String[] split = article.getArticleType().split(",");
        Set<String> list = Sets.newHashSet();
        for (String s : split) {
            Label label = labelService.selectLabelById(Long.parseLong(s));
            list.add(label.getName());
        }
        String str = StringUtils.join(list, ",");
        article.setArticleName(str);
        if (Objects.nonNull(article.getId())) {
            Article articleById = articleService.selectArticleById(article.getId());
            article.setVersion(articleById.getVersion() + 1);
            articleService.updateArticle(article);
        } else {
            articleService.insertArticle(article);
        }
        if (article.getTitle().contains("英语")) {
            setEnglishRecord(article.getContent(), article.getId());
        }
        return success(article);
    }

    public void setEnglishRecord(String text, Long id) {
        if (GuavaCacheDemo.isExist(id.intValue())) {
            return;
        }
        new Thread(() -> {
            log.info("ac=insertEnglishRecord start id={}", id);
            String[] split = text.split("#");
            List<EnglishRecordDTO> dateList = Lists.newArrayList();
            for (String value : split) {
                EnglishRecordDTO dto = new EnglishRecordDTO();
                dto.setRecordDate(value.substring(1, 11).trim());
                dto.setEnglishListModel(Lists.newArrayList(value.split("1.")));
                dateList.add(dto);
            }
            dateList.remove(0);
            for (EnglishRecordDTO dto : dateList) {
                EnglishRecord englishRecord = new EnglishRecord();
                englishRecord.setArticleId(id);
                englishRecord.setRecordDate(dto.getRecordDate());
                englishRecord.setState(1);
                englishRecordService.insertEnglishRecord(englishRecord, dto.getEnglishList());
            }
            log.info("ac=insertEnglishRecord end id={}", id);
        }).start();
        GuavaCacheDemo.setCacheKey(id.intValue(), System.currentTimeMillis());
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
     * @return: java.util.Map<java.lang.String, java.lang.Object>
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
