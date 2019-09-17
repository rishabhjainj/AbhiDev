package com.abhidev.Activities;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


import com.abhidev.R;
import com.abhidev.adapters.SchoolsAdapter;
import com.abhidev.apiservices.Repository;
import com.abhidev.listeners.OnEntitiesReceivedListener;
import com.abhidev.models.Category;
import com.abhidev.models.CategoryList;
import com.abhidev.presenters.CategoryPresenter;
import com.abhidev.viewactions.CategoryViewAction;

import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryViewAction{

    RecyclerView categoryRecyclerView;
    SchoolsAdapter schoolsAdapter;
    CategoryPresenter presenter;
    OnEntitiesReceivedListener<CategoryList> listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        presenter = new CategoryPresenter(this,new Repository());
        listener = new OnEntitiesReceivedListener<CategoryList>(this) {
            @Override
            public void onReceived(List<CategoryList> entities) {
                initActivity();
                setCategories(entities);
                Log.d("categoryList","setCategories");
            }
        };
        presenter.getCategoriesList(listener);




    }
    public void initActivity(){
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.filter_blue));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        categoryRecyclerView = findViewById(R.id.categories_recyclerView);
    }


    @Override
    public void initUi(Category category) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showNetworkError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void setCategories(List<CategoryList> categoryList) {
        schoolsAdapter=new SchoolsAdapter(CategoryActivity.this,categoryList);
        GridLayoutManager layoutManager=new GridLayoutManager(CategoryActivity.this,2);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setAdapter(schoolsAdapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
