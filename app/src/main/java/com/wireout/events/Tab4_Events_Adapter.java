package com.wireout.events;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wireout.R;

import java.util.ArrayList;

/**
 * Created by rahul on 18/2/18.
 */

public class Tab4_Events_Adapter extends RecyclerView.Adapter<Tab4_Events_Adapter.MyViewHolder>  {


    Context context;
    ArrayList<String> titles,dates,timeAM,timePM,labels,orgNames,addrs,distances, months;
    ArrayList<String> imageUrls;
    ArrayList<String> images;

    public Tab4_Events_Adapter(Context context, ArrayList<String> titles, ArrayList<String> dates, ArrayList<String> timeAM, ArrayList<String> timePM, ArrayList<String> labels, ArrayList<String> orgNames,ArrayList<String> addrs, ArrayList<String> distances,ArrayList<String> images, ArrayList<String> months) {
        this.context = context;
        this.titles = titles;
        this.dates = dates;
        this.timeAM = timeAM;
        this.timePM = timePM;
        this.labels = labels;
        this.orgNames = orgNames;
        this.months=months;
        this.addrs=addrs;
        this.distances = distances;
        this.imageUrls=images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.tab4_events_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView_title.setText(titles.get(position));
        holder.textView_months.setText(months.get(position));
        holder.textView_date.setText(dates.get(position));
        holder.textView_timeAM.setText(timeAM.get(position));
        holder.textView_time_PM.setText(timePM.get(position));
        holder.textView_label.setText(labels.get(position));
        holder.textView_orgName.setText(orgNames.get(position));
        holder.textView_addr.setText(addrs.get(position));
        holder.textView_dist.setText(distances.get(position));

//        holder.relativeLayout_parent.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.sample_new));
        Picasso.with(context)
                .load(imageUrls.get(position))
                .fit()
                .into(holder.imageView);
//        Uri uri=Uri.parse("data:image/jpeg;base64,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");
        //Picasso.with(context).load("data:image/jpeg;base64,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").fit().into(holder.imageView);
//        holder.imageView.setImageURI(uri);
        //holder.imageView.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        CardView cardView;
        TextView textView_title, textView_date, textView_timeAM, textView_time_PM, textView_months;
        TextView textView_label, textView_orgName, textView_addr, textView_dist;
        RelativeLayout relativeLayout_parent;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_months=(TextView)itemView.findViewById(R.id.tv_months_tab4);
            imageView=(ImageView)itemView.findViewById(R.id.img_events_tab4);
            cardView=(CardView)itemView.findViewById(R.id.card_tab4);
            textView_title=(TextView)itemView.findViewById(R.id.tv_eventName_tab4);
            textView_date=(TextView)itemView.findViewById(R.id.tv_dates_tab4);
            textView_timeAM=(TextView)itemView.findViewById(R.id.tv_timeAM_tab4);
            textView_time_PM=(TextView)itemView.findViewById(R.id.tv_timePM_tab4);
            textView_label=(TextView)itemView.findViewById(R.id.tv_label_tab4);
            textView_orgName=(TextView)itemView.findViewById(R.id.tv_orgName_tab4);
            textView_addr=(TextView)itemView.findViewById(R.id.tv_addr_tab4);
            textView_dist=(TextView)itemView.findViewById(R.id.tv_dist_tab4);
            relativeLayout_parent=(RelativeLayout)itemView.findViewById(R.id.rel3);


        }
    }


}