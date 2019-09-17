package com.abhidev.viewactions;

import com.abhidev.models.CourseList;
import com.abhidev.models.Mentor;
import com.abhidev.models.ShortTermCourse;
import com.abhidev.models.University;

import java.util.List;

/**
 * Created by rahul on 18/4/18.
 */

public interface WishlistViewAction extends BaseViewAction {

    public void setWishListRecyclerView(List<University> universityDataList);
    public void setWishListCourses(List<CourseList> courseList);
    public void setWishListShortTermCourses(List<ShortTermCourse> shortTermCourseList);
    public void setWishListCampaigners(List<Mentor> campaignersList);


}
