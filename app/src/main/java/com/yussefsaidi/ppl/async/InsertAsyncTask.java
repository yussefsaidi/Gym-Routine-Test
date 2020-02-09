package com.yussefsaidi.ppl.async;

import android.os.AsyncTask;
import android.util.Log;

import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.persistence.ExerciseDao;

public class InsertAsyncTask extends AsyncTask<Exercise, Void, Void> {
    
    private static final String TAG = "InsertAsyncTask";
    private ExerciseDao mExerciseDao;

    public InsertAsyncTask(ExerciseDao dao) {
        mExerciseDao = dao;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());
        mExerciseDao.insertExercises(exercises);
        return null;
    }


}
