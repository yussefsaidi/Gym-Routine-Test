package com.yussefsaidi.ppl.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;
import com.yussefsaidi.ppl.models.Exercise;

import java.util.ArrayList;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<Exercise> mExercises;
    private static final String TAG = "ExerciseRecyclerAdapter";


    public ExerciseRecyclerAdapter(ArrayList<Exercise> exercises) {
        this.mExercises = exercises;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_exercise_list_item, parent, false);
        final ExerciseViewHolder holder = new ExerciseViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ExerciseViewHolder)holder).mViewName.setText(mExercises.get(position).getName());
        ((ExerciseViewHolder)holder).mEditName.setText(mExercises.get(position).getName());
        ((ExerciseViewHolder)holder).repetitions.setText(mExercises.get(position).getRepetitions());
        ((ExerciseViewHolder)holder).sets.setText(mExercises.get(position).getSets());
        // Send exercise item reference to viewholder to update it
        ((ExerciseViewHolder)holder).mExercise = mExercises.get(position);
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }


}
