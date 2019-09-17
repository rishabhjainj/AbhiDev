package com.abhidev.Recommendation.AnalysisViewPager.presenters;

import android.content.Context;
import android.util.Log;

import com.abhidev.common.EntityLoader;
import com.abhidev.listeners.OnEntityReceivedListener;
import com.abhidev.models.CareerList;
import com.abhidev.models.Course;
import com.abhidev.models.CourseList;
import com.abhidev.models.ShortTermCourse;
import com.abhidev.models.University;
import com.abhidev.models.career_analysis.Report;
import com.abhidev.responses.PaginatedResponse;
import com.abhidev.Recommendation.TabFragmentViewAction;
import com.abhidev.common.AbstractCallback;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.presenters.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by sharda on 17/03/18.
 */

public class TabFragment1Presenter extends BasePresenter {
    OnEntitiesReceivedListener<ShortTermCourse> shortTermCoursesListener;
    OnEntitiesReceivedListener<Course> coursesListener;
    TabFragmentViewAction viewAction;
    public TabFragment1Presenter(Context context, TabFragmentViewAction viewAction
                                 ){
        this.viewAction = viewAction;
        this.shortTermCoursesListener = shortTermCoursesListener;
        this.coursesListener = coursesListener;
    }
    public void getCourses(OnEntitiesReceivedListener<CourseList> listener){
        repository.getCourses(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }

    public void getCareer(OnEntitiesReceivedListener<CareerList> listener){
        repository.getCareer(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void likeCourse(int id){
        repository.likeCourse(id, new LikeEntityManager(viewAction));
    }
    public void getAnalysisReport(OnEntityReceivedListener<Report> listener){
        repository.getAnalysisReport(new EntityLoader(listener));
    }
    public void likeShortTermCourse(int id){repository.likeShortTermCourse(id, new LikeEntityManager(viewAction) );}

    public void loadShortTermCourses(Map<String, String> uriQuery){
        repository.getShortTermCourses(uriQuery, new EntitiesLoader<>(shortTermCoursesListener));
    }

    public void loadCourses(Map<String, String> uriQuery){
        repository.getCourses(uriQuery, new EntitiesLoader<>(coursesListener));
    }
    public void getUniversities(){
        repository.getUniversities(new HashMap<String, String>(), new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("responseCode",response.code()+","+response.message());
                PaginatedResponse<University> arrayResponse = (PaginatedResponse<University>) response.body();
                if(arrayResponse!=null){
                    viewAction.setUniversitiesRecyclerView(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }
        });
    }
}
