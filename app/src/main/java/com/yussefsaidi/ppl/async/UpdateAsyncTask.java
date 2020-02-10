package com.yussefsaidi.ppl.async;

import android.os.AsyncTask;

import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.persistence.ExerciseDao;

public class UpdateAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mDao;

    public UpdateAsyncTask(ExerciseDao mDao) {
        this.mDao = mDao;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        mDao.update(exercises);
        return null;
    }
}
