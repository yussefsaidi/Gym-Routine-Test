package com.yussefsaidi.ppl.persistence;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.yussefsaidi.ppl.models.Exercise;

@Database(entities = {Exercise.class}, version = 1)
public abstract class ExerciseDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "exercises_db";

    private static ExerciseDatabase instance;

    static ExerciseDatabase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ExerciseDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

}
