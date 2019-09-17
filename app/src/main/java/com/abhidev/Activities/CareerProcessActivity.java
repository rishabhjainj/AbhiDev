package com.abhidev.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.abhidev.common.MyApplication;
import com.abhidev.R;

public class CareerProcessActivity extends BaseActivity {
    ImageView start;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.career_process_layout);
        start = findViewById(R.id.getStarted);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MyApplication.getInstance().prefManager.isLoggedIn())
                    startActivity(new Intent(CareerProcessActivity.this,CareerAssesmentStartActivity.class));
                else{
                    showMessage("Login to start Career Assessment.");
                    startActivity(new Intent(CareerProcessActivity.this, LoginActivity.class));
                }
            }
        });

    }
}
