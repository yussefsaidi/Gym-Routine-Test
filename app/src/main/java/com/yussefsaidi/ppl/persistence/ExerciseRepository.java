package com.yussefsaidi.ppl.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.yussefsaidi.ppl.adapters.ExerciseRecyclerAdapter;
import com.yussefsaidi.ppl.models.Exercise;

import java.util.List;

public class ExerciseRepository {

    private ExerciseDatabase mExerciseDatabase;

    public ExerciseRepository(Context context){
        mExerciseDatabase = ExerciseDatabase.getInstance(context);
    }

    public void insertExerciseTask(Exercise exercise){

    }

    public void updateExerciseTask(Exercise exercise){

    }

    public LiveData<List<Exercise>> retrieveExercisesTask(){
        return mExerciseDatabase.getExerciseDao().getExercises();
    }

    public void deleteExercise(Exercise exercise){

    }

}