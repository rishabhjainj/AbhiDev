package com.abhidev.presenters;

import android.content.Context;
import android.util.Log;

import com.abhidev.common.AbstractCallback;
import com.abhidev.common.EntitiesLoader;
import com.abhidev.common.LikeEntityManager;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.BannerImages;
import com.abhidev.models.CareerList;
import com.abhidev.models.CourseList;
import com.abhidev.models.DailyGoals;
import com.abhidev.models.Mentor;
import com.abhidev.models.ShortTermCourse;
import com.abhidev.models.University;
import com.abhidev.repositories.HomePageRepository;
import com.abhidev.responses.PaginatedResponse;
import com.abhidev.viewactions.UniversityViewAction;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Rishabh on 3/9/2018.
 */

public class HomePagePresenter extends BasePresenter{
    UniversityViewAction viewAction;
    Context context;

    public HomePagePresenter(Context context,UniversityViewAction viewAction,HomePageRepository repository){
        this.viewAction = viewAction;
        this.context = context;
    }
    public void getCampaigners(OnEntitiesReceivedListener<Mentor> listener){
        repository.getMentors(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getBannerImages(OnEntitiesReceivedListener<BannerImages> listener){
        repository.getBannerImages(new EntitiesLoader<>(listener));
    }
    public void getCareer(OnEntitiesReceivedListener<CareerList> listener){
        repository.getCareer(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }

    public void getDailyGoals(OnEntitiesReceivedListener<DailyGoals> listener){
        repository.getDailyGoals(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
    public void getCareerTags(OnEntitiesReceivedListener<DailyGoals> listener){
        repository.getCareerTags(new HashMap<String, String>(),new EntitiesLoader<>(listener));
    }
//    public void getCourses(){
//        repository.getCourses(new HashMap<String, String>(), new AbstractCallback(viewAction) {
//            @Override
//            public void onResponse(Call call, Response response) {
//                Log.d("responseCode",response.code()+","+response.message());
//                PaginatedResponse<Course> arrayResponse = (PaginatedResponse<Course>) response.body();
//                if(arrayResponse!=null){
//                    viewAction.setCoursesRecyclerView(arrayResponse.getResults());
//                }
//                else{
//                    //viewAction.showMessage("null");
//                }
//            }
//        });
//    }
public void getCourses(OnEntitiesReceivedListener<CourseList> listener){
    repository.getCourses(new HashMap<String, String>(),new EntitiesLoader<>(listener));
}
    public void getShortTermCourses(){
        repository.getShortTermCourses(new HashMap<String, String>(), new AbstractCallback(viewAction) {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("responseCode",response.code()+","+response.message());
                PaginatedResponse<ShortTermCourse> arrayResponse = (PaginatedResponse<ShortTermCourse>) response.body();
                if(arrayResponse!=null){
                    viewAction.setShortTermCoursesRecyclerView(arrayResponse.getResults());
                }
                else{
                    //viewAction.showMessage("null");
                }
            }
        });
    }
//    public void getCampaigners(){
//        repository.getCampaigners(new HashMap<String, String>(), new AbstractCallback(viewAction) {
//            @Override
//            public void onResponse(Call call, Response response) {
//                Log.d("responseCode",response.code()+","+response.message());
//                PaginatedResponse<Mentor> arrayResponse = (PaginatedResponse<Mentor>) response.body();
//                if(arrayResponse!=null){
//                    viewAction.setCampaignersRecyclerView(arrayResponse.getResults());
//                }
//                else{
//                    //viewAction.showMessage("null");
//                }
//            }
//
//        });
//    }
    public void likeUniversity(int id){repository.likeUniversity(id, new LikeEntityManager(viewAction) );}

    public void likeCourse(int id){
        repository.likeCourse(id, new LikeEntityManager(viewAction));
    }

    public void likeShortTermCourse(int id){repository.likeShortTermCourse(id, new LikeEntityManager(viewAction) );}

    public void likeCampaigners(int id){repository.likeCampaigners(id, new LikeEntityManager(viewAction));}
    
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
