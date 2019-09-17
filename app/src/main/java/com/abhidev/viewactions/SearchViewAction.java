package com.abhidev.viewactions;

import com.abhidev.models.CareerList;
import com.abhidev.models.CategoryList;
import com.abhidev.models.CourseList;
import com.abhidev.models.Institution;

import java.util.List;

/**
 * Created by Rishabh on 4/19/2018.
 */

public interface SearchViewAction extends BaseViewAction {
    public void setUniversityRecyclerView(List<Institution> universityDataList);
    public void setCoursesRecyclerView(List<CourseList> courses);
    public void setShortTermCoursesRecyclerView(List<CategoryList> shortTermCourses);
    public void setCampaignersRecyclerView(List<CareerList> campaigners);
    public void showLoader();
    public void addGenStaticData();
    public void hideLoader();
}
