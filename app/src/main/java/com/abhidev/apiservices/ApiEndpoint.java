package com.abhidev.apiservices;

import com.abhidev.Exams.CategoryModel;
import com.abhidev.apiservices.responses.AuthenticationResponse;
import com.abhidev.apiservices.responses.ForgotPasswordResponse;
import com.abhidev.apiservices.responses.GenericResponse;
import com.abhidev.apiservices.responses.LikeResponse;
import com.abhidev.models.Assessment;
import com.abhidev.models.CareerList;
import com.abhidev.Exams.TestResponse;
import com.abhidev.models.Internships;
import com.abhidev.models.career_analysis.BooleanQuestion;
import com.abhidev.models.Articles;
import com.abhidev.models.BannerImages;
import com.abhidev.models.Campaigners;
import com.abhidev.models.Career;
import com.abhidev.models.Category;
import com.abhidev.models.Course;
import com.abhidev.models.CourseList;
import com.abhidev.models.DailyGoals;
import com.abhidev.models.Event;
import com.abhidev.models.Institution;
import com.abhidev.models.Mentor;
import com.abhidev.models.Notification;
import com.abhidev.models.RandomizedFeed;
import com.abhidev.models.Slot;
import com.abhidev.models.SlotBook;
import com.abhidev.models.Tag;
import com.abhidev.models.TedYouTube;
import com.abhidev.models.University;
import com.abhidev.models.User;
import com.abhidev.models.Videos;
import com.abhidev.models.CategoryList;
import com.abhidev.models.career_analysis.BooleanSectionResponse;
import com.abhidev.models.career_analysis.CareerAnalysis;
import com.abhidev.models.career_analysis.Report;
import com.abhidev.models.career_analysis.Section1;
import com.abhidev.models.career_analysis.Section13;
import com.abhidev.models.career_analysis.Section9;
import com.abhidev.models.exams.ExamSubCategory;
import com.abhidev.responses.PaginatedResponse;
import com.abhidev.models.ShortTermCourse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by sharda on 24/02/18.
 *
 * API Endpoint declarations
 *
 */

public interface ApiEndpoint {


    /** Register User using manual form **/
    @POST("users/")
    @Multipart
    Call<User> registerUser(@PartMap() Map<String, RequestBody> map);

    /** Get details for the user whose token is sent in Authorization header **/
    @GET("users/by_token")
    Call<User> getCurrentUser();

    /** Get Yantra OAuth2 Access Token using username(email) and password
     *
     *  Method : POST
     *  Parameters (SET 1) : client_id, client_secret, grant_type - PASSWORD_GRANT, username, password
     *  Parameters (SET 2 - for refresh_token) : client_id, client_secret, grant_type - REFRESH_TOKEN_GRANT, refresh_token
     *  Result : Returns Yantra OAUTH2 Access Token
     *
     **/
    //fcm token send to server

    @GET("videos/")
    Call<PaginatedResponse<Videos>> getVideos(@QueryMap Map<String, String> filterData);

    @FormUrlEncoded
    @POST("fcm/")
    Call<GenericResponse> sendTokenToServer(
            @Field("registrationId") String registrationId
    );
    @GET("universityTags/")
    Call<PaginatedResponse<Tag>> getTags(@QueryMap Map<String, String> filterData);

    @GET("articles/")
    Call<PaginatedResponse<Articles>> getArticles(@QueryMap Map<String, String> filterData);


    @GET("courses/{id}/")
    Call<Course>getCourseById(@Path("id") String id);

    @GET("careerOptions/{id}/")
    Call<Career>getCareerById(@Path("id") String id);

    @GET("schools/{id}/")
    Call<Category>getCategoryById(@Path("id") String id);

    @GET("schools/")
    Call<PaginatedResponse<CategoryList>>getSchoolsList(@QueryMap Map<String, String> filterData);


    @GET("courses")
    Call<PaginatedResponse<CourseList>> getCourses(@QueryMap Map<String, String> filterData);
    @GET("courses/")
    Call<PaginatedResponse<CourseList>> getCourses(@QueryMap Map<String, String> filterData, @Query("schools") List<String> schools);
    @GET("shortTermCourses/")
    Call<PaginatedResponse<ShortTermCourse>> getShortTermCourses(@QueryMap Map<String, String> filterData);
    @GET("universities/")
    Call<PaginatedResponse<University>> getUniversities(@QueryMap Map<String, String> filterData);
    @GET("universities/{id}")
    Call<PaginatedResponse<University>> getUniversityById(@Path("id") String id);
    @GET("dailyGoals/")
    Call<PaginatedResponse<DailyGoals>> getDailyGoals(@QueryMap Map<String, String> filterData);
    @GET("universities/")
    Call<PaginatedResponse<Institution>> searchUniversities(@QueryMap Map<String, String> filterData);
    @GET("internships/")
    Call<PaginatedResponse<Internships>> searchInternships(@QueryMap Map<String, String> filterData);
    @GET("campaigners/")
    Call<PaginatedResponse<Campaigners>> getCampaigners(@QueryMap Map<String, String> filterData);
    @GET("careerTags/")
    Call<PaginatedResponse<DailyGoals>> getCareerTags(@QueryMap Map<String, String> filterData);


    @GET("mentors/")
    Call<PaginatedResponse<Mentor>> getMentors(@QueryMap Map<String, String> filterData);

    @GET("tedTalks/")
    Call<PaginatedResponse<TedYouTube>> getTedVideos(@QueryMap Map<String, String> filterData);

    @POST("universities/{id}/like/")
    Call<LikeResponse> likeUniversity(@Path("id") int id);

    @POST("courses/{id}/like/")
    Call<LikeResponse> likeCourse(@Path("id") int id);

    @POST("shortTermCourses/{id}/like/")
    Call<LikeResponse> likeShortTermCourse(@Path("id") int id);

    @POST("mentors/{id}/like/")
    Call<LikeResponse> likeCampaigners(@Path("id") int id);

    @POST("internships/{id}/like/")
    Call<LikeResponse> likeInternship(@Path("id") int id);

    @GET("notifications/")
    Call<PaginatedResponse<Notification>> getNotifications();

    @GET("bannerImages/")
    Call<PaginatedResponse<BannerImages>> getBannerImages();

    @GET("randomizedFeeds/")
    Call<PaginatedResponse<RandomizedFeed>> getRandomizedFeeds();

    //change url here
    @GET("careerAnalysis/booleanSections/")
    Call<PaginatedResponse<BooleanQuestion>> getQuestionsForSections();


    @GET("assessments/")
    Call<PaginatedResponse<Assessment>> getAssessmentSections();

    @GET("careerOptions/")
    Call<PaginatedResponse<CareerList>> getCareer(@QueryMap Map<String, String> filterData);

    @GET("callSlots/")
    Call<PaginatedResponse<Slot>> getSlots(@QueryMap Map<String, String> filterData);

    @GET("tests/")
    Call<PaginatedResponse<ExamSubCategory>> getExamSubCategories(@QueryMap Map<String, String> map);


    @GET("careerOptions/")
    Call<PaginatedResponse<CareerList>> getCareer(@QueryMap Map<String, String> filterData, @Query("schools") List<String> schools);

    @GET("events/")
    Call<PaginatedResponse<Event>> getEvents(@QueryMap Map<String, String> filterData);



    /** Sends request to randomly set the password and send on registered email account**/
    @POST("users/forgot_password/")
    @FormUrlEncoded
    Call<ForgotPasswordResponse> forgotPasswordRequest(@Field("email") String email);

    @POST("careerAnalysis/1/")
    @FormUrlEncoded
    Call<ForgotPasswordResponse> sendBioDataSectionData(@Field("name") String name,
                                                        @Field("dob") String dob,
                                                        @Field("gender") String gender,
                                                        @Field("jobStatus") String jobStatus,
                                                        @Field("country")String country,
                                                        @Field("modeOfStudy")String modeOfStudy,
                                                        @Field("year")String year,
                                                        @Field("highestEducationLevel")String highestEducationLevel,
                                                        @Field("interest")String interest,
                                                        @Field("subject")String subject,
                                                        @Field("pastTime")String pastTime,
                                                        @Field("gameCategory")String gameCategory,
                                                        @Field("yearOfPassing10")String yearOfPassing10,
                                                        @Field("yearOfPassing12")String yearOfPassing12,
                                                        @Field("marks10")String marks10,
                                                        @Field("marks12")String marks12);

    /** Resets password for currently logged in user given the oldPassword is correct **/
    @POST("users/reset_password/")
    @FormUrlEncoded
    Call<ResetPasswordResponse> resetPasswordRequest(@Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

    @POST("callSlots/book/")
    @FormUrlEncoded
    Call<SlotBook> bookSlot(
            @Field("callSlots") String callSlot,
            @Field("mode") String mode,
            @Field("contact") String contact);



    @POST("auth/token/")
    @FormUrlEncoded
    Call<AuthenticationResponse> getToken(@FieldMap() Map<String, String> map);

    /** Convert third-party provider access token to Yantra OAuth2 Access Token
     *  Method : POST
     *  Parameters : backend - [facebook, google-oauth2], client_id, client_secret, grant_type - CONVERT_TOKEN_GRANT, token - Third Party Access Token
     *  Result : Returns Yantra OAUTH2 Access Token
     *
     **/


    @POST("auth/convert-token/")
    @FormUrlEncoded
    Call<AuthenticationResponse> convertToken(@FieldMap() Map<String, String> map);

    /** Use only for partial updates of non-nested attributes **/
    @POST("careerAnalysis/")
    @FormUrlEncoded
    Call<CareerAnalysis> postAnalysis(@FieldMap() Map<String,String> map);

    @GET("careerAnalysis/")
    Call<PaginatedResponse<CareerAnalysis>> getAnalysis();

    @POST("careerAnalysis/1/")
    @Headers("Content-Type: application/json")
    Call<Section1> postAnalysisSection1(@Body Section1 section);



    @POST("careerAnalysis/9/")
    @Headers("Content-Type: application/json")
    Call<Section9> postAnalysisSection9(@Body Section9 section);


    @POST("careerAnalysis/13/")
    @Multipart
    Call<Section13> postAnalysisSection13(@PartMap() Map<String, RequestBody> map, @Part MultipartBody.Part image);

    @POST("careerAnalysis/booleanSections/submit/")
    @Headers("Content-Type: application/json")
    Call<BooleanSectionResponse> postBooleanQuestionResponse(@Body BooleanSectionResponse booleanQuestionResponse);

    @POST("tests/attempt/")
    @Headers("Content-Type: application/json")
    Call<TestResponse> postTestResponse(@Body TestResponse testResponse);

    @GET("tests/categories/")
    Call<PaginatedResponse<CategoryModel>> getExamCategories();

    @GET("careerAnalysis/report")
    Call<Report> getAnalysisReport();

    @GET("internships/")
    Call<PaginatedResponse<Internships>> getInternships(@QueryMap Map<String, String> filterData);

    @GET("internships/{id}/")
    Call<Internships>getInternshipById(@Path("id") String id);
}
