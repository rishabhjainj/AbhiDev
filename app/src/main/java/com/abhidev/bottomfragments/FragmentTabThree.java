package com.abhidev.bottomfragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abhidev.Activities.Analysis.AnalysisActivity;
import com.abhidev.R;

/**
 * Created by Rishabh on 2/14/2018.
 */

public class FragmentTabThree extends Fragment {
    ImageView start;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_bottom_3, container, false);
        start = (ImageView) view.findViewById(R.id.start_p);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), AnalysisActivity.class);
                i.putExtra("state","0");
                startActivity(i);
            }
        });
        return  view;

    }
    public static FragmentTabThree newInstance(int index) {
        FragmentTabThree fragment = new FragmentTabThree();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

}
