package com.yussefsaidi.ppl.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    TextView name, sets, repetitions;


    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.exercise_name);
        sets = itemView.findViewById(R.id.exercise_reps);
        repetitions = itemView.findViewById(R.id.exercise_sets);
    }
}
