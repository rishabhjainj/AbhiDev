package com.wireout.Activities;

import android.os.Bundle;
import androidx.annotation.Nullable;


import com.wireout.R;

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
