package com.yussefsaidi.ppl.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yussefsaidi.ppl.models.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert
    long[] insertExercises(Exercise... exercises);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getExercises();

    @Delete
    int delete(Exercise... exercises);

    @Update
    int update(Exercise... exercises);
}
