package com.ruoyi.project.mhxy.fairy.mapper;


import com.ruoyi.project.mhxy.fairy.bean.ArticleVO;

import java.util.List;

/**
 * @ClassName ArticleDao
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2020年04月02日 12:04
 **/
public interface ArticleMapper {

    /**
     * @param articleVO
     * @Description TODO 添加文章
     * @return: void
     * @Author: Xinhxu
     * @Date: 14:02 2020/4/2
     */

    int addArticle(ArticleVO articleVO);

    /**
     * @param articleVO
     * @Description TODO 获取文章列表
     * @return: java.util.List<com.visionvera.vo.ArticleVO>
     * @Author: Xinhxu
     * @Date: 14:03 2020/4/2
     */

    List<ArticleVO> getArticleList(ArticleVO articleVO);

    /**
     * @param articleVO
     * @Description TODO 修改文章
     * @return: void
     * @Author: Xinhxu
     * @Date: 14:41 2020/4/2
     */

    void updateArticle(ArticleVO articleVO);

    /**
     * @param articleVO
     * @Description TODO 删除文章
     * @return: void
     * @Author: Xinhxu
     * @Date: 15:11 2020/4/6
     */

    void deleteArticle(ArticleVO articleVO);
}

