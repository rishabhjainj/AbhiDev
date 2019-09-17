package com.abhidev.Exams.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.abhidev.Activities.BaseActivity;
import com.abhidev.Activities.MainActivity;
import com.abhidev.Exams.CategoryModel;
import com.abhidev.Exams.ExamOptionModel;
import com.abhidev.Exams.ExamPresenter;
import com.abhidev.Exams.ExamViewAction;
import com.abhidev.R;
import com.abhidev.adapters.ExamsAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;

import java.util.List;

public class ExamsActivity extends BaseActivity implements ExamViewAction {

    List<ExamOptionModel> examList;
    ExamsAdapter adapter;
    ExamPresenter presenter;
    ImageView backBtn;
    RecyclerView careerOptionsRecyclerView;
    List<CategoryModel> categories;
    OnEntitiesReceivedListener<CategoryModel> listener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);
        listener  = new OnEntitiesReceivedListener<CategoryModel>(this) {
            @Override
            public void onReceived(List<CategoryModel> entities) {
                categories = entities;
                setCategoriesRecyclerview(entities);
            }
        };
        presenter= new ExamPresenter(this, new Repository());
        presenter.getExamCategories(listener);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamsActivity.this,MainActivity.class));
                finish();
            }
        });



    }
    public void setCategoriesRecyclerview(List<CategoryModel> categories){
        careerOptionsRecyclerView = findViewById(R.id.career_recyclerview);
        careerOptionsRecyclerView.setHasFixedSize(true);
        careerOptionsRecyclerView.removeAllViews();
        careerOptionsRecyclerView.setNestedScrollingEnabled(false);
        careerOptionsRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        adapter =
                new ExamsAdapter(this,categories);
        careerOptionsRecyclerView.setAdapter(adapter);
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                startActivity(new Intent(ExamsActivity.this,MainActivity.class));
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ExamsActivity.this,MainActivity.class));
        finish();

    }
}
