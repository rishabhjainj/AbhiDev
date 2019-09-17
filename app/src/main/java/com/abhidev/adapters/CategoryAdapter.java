package com.abhidev.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhidev.R;
import com.abhidev.models.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    Random r;
    private LayoutInflater inflater;
    List<University> universityDatas = new ArrayList<>();

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        View parent;
        TextView categoryName;
        ImageView collegeImage;
        public MyViewHolder(View view) {
            super(view);

            categoryName = view.findViewById(R.id.category_text);
            collegeImage = view.findViewById(R.id.category_image);
            this.parent = view;

        }
    }
}
