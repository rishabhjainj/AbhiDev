package com.abhidev.viewactions;

import com.abhidev.models.TedYouTube;

import java.util.List;

public interface TedViewAction extends BaseViewAction {
    void addToRecyclerView(List<TedYouTube> list);
}
