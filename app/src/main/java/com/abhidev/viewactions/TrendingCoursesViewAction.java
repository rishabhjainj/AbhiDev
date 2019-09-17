package com.abhidev.viewactions;

import com.abhidev.models.CourseList;

import java.util.List;

/**
 * Created by rahul on 10/3/18.
 */

public interface TrendingCoursesViewAction  extends BaseViewAction{

    public void setTrendingCoursesRecyclerView(List<CourseList> courseList);
    public void startVideos();

}
