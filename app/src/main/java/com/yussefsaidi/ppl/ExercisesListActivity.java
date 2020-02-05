package com.yussefsaidi.ppl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.yussefsaidi.ppl.adapters.ExerciseRecyclerAdapter;
import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class ExercisesListActivity extends AppCompatActivity {

    private static final String TAG = "ExercisesListActivity";

    // UI Components
    private RecyclerView mRecyclerView;

    // Vars
    private ArrayList<Exercise> mExercises = new ArrayList<>();
    private ExerciseRecyclerAdapter mExerciseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_exercise_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
        insertFakeExercises();
    }

    private void insertFakeExercises(){
        for(int i = 0; i < 100; i++){
            Exercise exercise = new Exercise();
            exercise.setName("Exercise # " + i);
            exercise.setSets("5");
            exercise.setRepetitions("5");
            mExercises.add(exercise);
        }
        mExerciseRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mExerciseRecyclerAdapter = new ExerciseRecyclerAdapter(mExercises);
        mRecyclerView.setAdapter(mExerciseRecyclerAdapter);
    }
}
