package com.abhidev.viewactions;

import com.abhidev.models.Course;
import com.abhidev.models.CourseList;

import java.util.List;

public interface CourseViewAction extends BaseViewAction {
    void initUi(Course course);
    void feedUniName(String name);
    void addToRecyclerView(List<CourseList> courseLists);
}
