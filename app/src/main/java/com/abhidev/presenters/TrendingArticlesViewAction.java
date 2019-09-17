package com.abhidev.presenters;

import com.abhidev.models.Articles;
import com.abhidev.viewactions.BaseViewAction;

import java.util.List;

public interface TrendingArticlesViewAction extends BaseViewAction {
    void addMoreTrendingArticles(List<Articles> articles);
    void addMoreCareerBlogs(List<Articles> articles);
}
