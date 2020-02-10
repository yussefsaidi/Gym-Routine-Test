package com.yussefsaidi.ppl.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import com.yussefsaidi.ppl.adapters.ExerciseRecyclerAdapter;
import com.yussefsaidi.ppl.async.DeleteAsyncTask;
import com.yussefsaidi.ppl.async.InsertAsyncTask;
import com.yussefsaidi.ppl.async.UpdateAsyncTask;
import com.yussefsaidi.ppl.models.Exercise;

import java.util.List;

public class ExerciseRepository {

    private ExerciseDatabase mExerciseDatabase;

    public ExerciseRepository(Context context){
        mExerciseDatabase = ExerciseDatabase.getInstance(context);
    }

    public void insertExerciseTask(Exercise exercise){
        exercise.setName("Exercise");
        exercise.setRepetitions("5");
        exercise.setSets("5");
        new InsertAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);
    }

    public void updateExerciseTask(Exercise exercise){
        new UpdateAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);
    }

    public LiveData<List<Exercise>> retrieveExercisesTask(){
        return mExerciseDatabase.getExerciseDao().getExercises();
    }

    public void deleteExercise(Exercise exercise){
        new DeleteAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);
    }

}
