package com.example.mandatoryassignment.recyclerView;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mandatoryassignment.R;
import com.example.mandatoryassignment.model.Rating;

import java.util.ArrayList;


public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> {
    private ArrayList<Rating> ratingList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class RatingViewHolder extends RecyclerView.ViewHolder {
        public ImageView courseImage;
        public TextView teacherName;
        public TextView courseName;

        public RatingViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            courseImage = itemView.findViewById(R.id.imageView);
            teacherName = itemView.findViewById(R.id.textView);
            courseName = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RatingAdapter(ArrayList<Rating> mRatingList) {
        ratingList = mRatingList;
    }

    @Override
    public RatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rating, parent, false);
        RatingViewHolder evh = new RatingViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(RatingViewHolder holder, int position) {
        Rating currentItem = ratingList.get(position);

        holder.courseImage.setImageResource(currentItem.getCourseImage());
        holder.teacherName.setText(currentItem.getTeacherName());
        holder.courseName.setText(currentItem.getTeacherCourses());
    }

    @Override
    public int getItemCount() {
        return ratingList.size();
    }
}