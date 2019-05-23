package com.example.mandatoryassignment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.mandatoryassignment.R;
import com.example.mandatoryassignment.model.Rating;
import com.example.mandatoryassignment.recyclerView.RatingAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static ArrayList<Rating> ratingList;

    private RecyclerView mRecyclerView;
    private RatingAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with

        courseRatingList();
        buildRecyclerView();


    }

    public void courseRatingList(){
        ratingList = new ArrayList<>();
        ratingList.add(new Rating(R.drawable.ios, "Kim", "IOS-Development", "Aniq0011@stud.kea.dk"));
        ratingList.add(new Rating(R.drawable.android, "Lars", "AndroidApp-Development", "Anique_uddin@live.dk"));
        ratingList.add(new Rating(R.drawable.python, "Frank", "Python", "Aniq0011@stud.kea.dk"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RatingAdapter(ratingList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RatingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, courseRatingActivity.class);
                intent.putExtra("Course Rating", ratingList.get(position));

                startActivity(intent);
            }
        });
    }



}











