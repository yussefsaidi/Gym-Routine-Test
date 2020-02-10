package com.yussefsaidi.ppl.async;

import android.os.AsyncTask;

import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.persistence.ExerciseDao;
import com.yussefsaidi.ppl.persistence.ExerciseRepository;

public class DeleteAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mDao;

    public DeleteAsyncTask(ExerciseDao dao) {
        this.mDao = dao;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        mDao.delete(exercises);
        return null;
    }
}
