package com.yussefsaidi.ppl.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;
import com.yussefsaidi.ppl.models.Exercise;

import java.util.ArrayList;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter  {

    private ArrayList<Exercise> mExercises;

    public ExerciseRecyclerAdapter(ArrayList<Exercise> exercises) {
        this.mExercises = exercises;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_exercise_list_item, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ExerciseViewHolder)holder).name.setText(mExercises.get(position).getName());
        ((ExerciseViewHolder)holder).repetitions.setText(mExercises.get(position).getRepetitions());
        ((ExerciseViewHolder)holder).sets.setText(mExercises.get(position).getSets());
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

}
