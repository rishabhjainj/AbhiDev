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
import android.widget.TextView;

import com.abhidev.Activities.BaseActivity;
import com.abhidev.Exams.ExamPresenter;
import com.abhidev.Exams.ExamViewAction;
import com.abhidev.Exams.TagAdapter;
import com.abhidev.R;
import com.abhidev.adapters.ExamListAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.exams.ExamSubCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamSubCategoryListActivity extends BaseActivity implements ExamViewAction {
    ExamListAdapter adapter;
    TagAdapter tagAdapter;
    OnEntitiesReceivedListener<ExamSubCategory> listener;
    ExamPresenter presenter;
    ImageView backBtn;
    TextView subjectText;
    String category;
    RecyclerView tagRecyclerView;
    RecyclerView careerOptionsRecyclerView;
    ExamSubCategory exam;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        category = getIntent().getStringExtra("category");
        presenter = new ExamPresenter(this,new Repository());
        listener = new OnEntitiesReceivedListener<ExamSubCategory>(this) {
            @Override
            public void onReceived(List<ExamSubCategory> entities) {

                //showMessage("recieved");
                initUi(entities);

            }
        };
        Map<String,String> query = new HashMap<>();
        query.put("category",category);
        presenter.getExamSubCategories(listener,query);


    }
    public void initUi(List<ExamSubCategory> examSubCategoryList){
        setContentView(R.layout.activity_exam_list);

        subjectText = findViewById(R.id.subject_text);
        subjectText.setText(category);
        tagRecyclerView = findViewById(R.id.tag_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        careerOptionsRecyclerView = findViewById(R.id.career_recyclerview);

        setSubCategoriesRecyclerView(examSubCategoryList);

        tagRecyclerView.setHasFixedSize(true);
        tagRecyclerView.removeAllViews();
        tagRecyclerView.setNestedScrollingEnabled(false);
        tagRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
        tagRecyclerView.setLayoutManager(layoutManager);
        List<String> tags = new ArrayList<>();
        tags.add("Logical Reasoning");
        tags.add("Aptitude");
        tags.add("Data Interpretation");
        tags.add("English & Vocabulary");
        tags.add("Quantitative Aptitude");

        tagAdapter =
                new TagAdapter(tags,this);
        tagRecyclerView.setAdapter(tagAdapter);
        tagRecyclerView.setLayoutManager(layoutManager);

        tagAdapter.notifyDataSetChanged();
        backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamSubCategoryListActivity.this,ExamsActivity.class));
                finish();
            }
        });
    }
    public void setSubCategoriesRecyclerView(List<ExamSubCategory> examList){
        careerOptionsRecyclerView.setHasFixedSize(true);
        careerOptionsRecyclerView.removeAllViews();
        careerOptionsRecyclerView.setNestedScrollingEnabled(false);
        careerOptionsRecyclerView.removeAllViewsInLayout();
        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
        adapter =
                new ExamListAdapter(this,examList);
        careerOptionsRecyclerView.setAdapter(adapter);
        careerOptionsRecyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                startActivity(new Intent(ExamSubCategoryListActivity.this,ExamsActivity.class));
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ExamSubCategoryListActivity.this,ExamsActivity.class));
        finish();

    }
}
