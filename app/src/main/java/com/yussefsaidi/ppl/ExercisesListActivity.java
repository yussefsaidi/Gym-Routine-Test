package com.yussefsaidi.ppl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yussefsaidi.ppl.adapters.ExerciseRecyclerAdapter;
import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.persistence.ExerciseRepository;
import com.yussefsaidi.ppl.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class ExercisesListActivity extends AppCompatActivity implements FloatingActionButton.OnClickListener {

    private static final String TAG = "ExercisesListActivity";



    // UI Components
    private RecyclerView mRecyclerView;

    // Vars
    private ArrayList<Exercise> mExercises = new ArrayList<>();
    private ExerciseRecyclerAdapter mExerciseRecyclerAdapter;
    private ExerciseRepository mExerciseRepository;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_exercise_list);
        mRecyclerView = findViewById(R.id.recyclerView);
        mExerciseRepository = new ExerciseRepository(this);
        findViewById(R.id.fab).setOnClickListener(this);

        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());

        initRecyclerView();
        //insertFakeExercises();
        retrieveExercises();
        setSupportActionBar((Toolbar)findViewById(R.id.exercises_toolbar));
        setTitle("PPL");
    }

    private void retrieveExercises(){
        mExerciseRepository.retrieveExercisesTask().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                if(mExercises.size() > 0){
                    mExercises.clear();
                }
                if(exercises != null){
                    mExercises.addAll(exercises);
                }
                mExerciseRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void saveNewExercise(){

    }

    private void saveChanges(){

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
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mRecyclerView);
        mExerciseRecyclerAdapter = new ExerciseRecyclerAdapter(mExercises);
        mRecyclerView.setAdapter(mExerciseRecyclerAdapter);
    }

    @Override
    public void onBackPressed() {

    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteExercise(mExercises.get(viewHolder.getAdapterPosition()));
        }
    };

    private void deleteExercise(Exercise exercise){
        mExercises.remove(exercise);
        mExerciseRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: MAKE NEW EXERCISE HERE!");
        mExerciseRepository.insertExerciseTask(new Exercise());
    }
}
