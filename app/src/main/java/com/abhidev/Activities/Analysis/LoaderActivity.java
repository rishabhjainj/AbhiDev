package com.abhidev.Activities.Analysis;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.abhidev.Activities.Recommendations;
import com.abhidev.R;
import com.abhidev.common.MyApplication;
import com.abhidev.listeners.AnalysisEventListener;
import com.abhidev.listeners.OnEntityReceivedListener;
import com.abhidev.models.career_analysis.Report;
import com.abhidev.presenters.AnalysisPresenter;

public class LoaderActivity extends AnalysisActivity implements AnalysisEventListener {

    OnEntityReceivedListener<Report> reportListener;
    Intent intent;
    AnalysisPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        reportListener = new OnEntityReceivedListener<Report>(this) {
            @Override
            public void onReceived(Report entity) {
                Gson gson = new Gson();
                String json = gson.toJson(entity,Report.class);
                MyApplication.getInstance().prefManager.saveString("report",json);
                intent = new Intent(getApplicationContext(), Recommendations.class);
                intent.putExtra("key", 1);
                startActivity(intent);
            }
        };

        presenter = new AnalysisPresenter(this);
        presenter.getAnalysisReport(reportListener);
    }
}
