package com.abhidev.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;


import com.abhidev.R;

public class YantraClubActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yantra_club_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}