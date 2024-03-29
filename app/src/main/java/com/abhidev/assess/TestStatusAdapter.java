package com.abhidev.assess;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.squareup.picasso.Picasso;
import com.abhidev.R;
import com.abhidev.models.Assessment;
import com.abhidev.models.career_analysis.CareerAnalysis;

import java.io.Serializable;
import java.util.List;

public class TestStatusAdapter extends RecyclerView.Adapter<TestStatusAdapter.MyViewHolder> {
    Context context;
    List<String> sectionNames;
    List<Integer> sectionImages;
    List<String> time;
    Intent i;
    CareerAnalysis status;
    ImagePopup imagePopup;
    List<Assessment> assessments;
    public TestStatusAdapter(Context context,List<Assessment> assessments){
       this.context = context;
       this.assessments = assessments;
    }
    @Override
    public TestStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.analysis_status_item_view,parent,false);
        return new TestStatusAdapter.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final TestStatusAdapter.MyViewHolder holder, final int position) {
        final Assessment assessment = assessments.get(position);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,AssessmentSections.class);
                i.putExtra("section",assessment.getTitle());
                i.putExtra("LIST", (Serializable) assessment);
                context.startActivity(i);
            }
        });
        Picasso.with(context).load(assessment.getCoverImage()).into(holder.sectionImage);
        holder.sectionName.setText(assessment.getTitle());
    }
    @Override
    public int getItemCount() {
        return assessments.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView sectionImage;
        TextView sectionName;
        TextView time;
        ImageView infoButton;
        View parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            infoButton = itemView.findViewById(R.id.info_button);
            sectionImage=itemView.findViewById(R.id.section_image);
            sectionName=itemView.findViewById(R.id.section_name);
            time = itemView.findViewById(R.id.section_time);

            parent=this.itemView;
        }
    }
}
