package com.yussefsaidi.ppl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.yussefsaidi.ppl.models.Exercise;

public class ExercisesListActivity extends AppCompatActivity {

    private static final String TAG = "ExercisesListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Exercise exercise = new Exercise();
    }
}
