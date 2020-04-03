package com.example.androidquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidquizapp.Model.QuestionScore;
import com.example.androidquizapp.ViewHolder.ScoreDetailViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreDetail extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference questionScore;
    RecyclerView scoreList;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<QuestionScore, ScoreDetailViewHolder> adapter;


    String viewUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_detail);

        // firebase
        db = FirebaseDatabase.getInstance();
        questionScore = db.getReference("Question_Score");

        // view
        scoreList = (RecyclerView) findViewById(R.id.scoreList);
        scoreList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        scoreList.setLayoutManager(layoutManager);

        if (getIntent() != null) {
            viewUser = getIntent().getStringExtra("viewUser");
        }
        if (!viewUser.isEmpty()) {
            loadScoreDetail(viewUser);
        }


    }

    private void loadScoreDetail(String viewUser) {
        adapter = new FirebaseRecyclerAdapter<QuestionScore, ScoreDetailViewHolder>(
                QuestionScore.class,
                R.layout.score_detail_layout,
                ScoreDetailViewHolder.class,
                questionScore.orderByChild("user").equalTo(viewUser)
        ) {
            @Override
            protected void populateViewHolder(ScoreDetailViewHolder scoreDetailViewHolder, QuestionScore score, int i) {
                scoreDetailViewHolder.txtName.setText(score.getCategoryName());
                scoreDetailViewHolder.txtScore.setText(String.valueOf(score.getScore()));
            }
        };

        adapter.notifyDataSetChanged();
        scoreList.setAdapter(adapter);

    }
}
