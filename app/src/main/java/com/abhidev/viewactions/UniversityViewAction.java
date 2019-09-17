package com.abhidev.viewactions;


import com.abhidev.models.Course;
import com.abhidev.models.Mentor;
import com.abhidev.models.ShortTermCourse;
import com.abhidev.models.University;

import java.util.List;

/**
 * Created by Rishabh on 2/18/2018.
 */

public interface UniversityViewAction extends BaseViewAction {
    public void setCoursesRecyclerView(List<Course> courses);
    public void setUniversitiesRecyclerView(List<University> universitiesi);
    public void setShortTermCoursesRecyclerView(List<ShortTermCourse> shortTermCourses);
    public void setCampaignersRecyclerView(List<Mentor> campaigners);
    public void setLikedUniversity(int id);


}
