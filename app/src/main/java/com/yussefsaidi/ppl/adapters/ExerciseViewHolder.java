package com.yussefsaidi.ppl.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;
import com.yussefsaidi.ppl.models.Exercise;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    TextView name, sets, repetitions;
    private LinearLayout mSubItem;


    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.exercise_name);
        sets = itemView.findViewById(R.id.exercise_reps);
        repetitions = itemView.findViewById(R.id.exercise_sets);
        mSubItem = itemView.findViewById(R.id.exercise_subinfo);
    }


    public void bind(Exercise exercise) {
        boolean expanded = exercise.isExpanded();

        if (expanded) {
            mSubItem.setVisibility(View.VISIBLE);
        } else {
            mSubItem.setVisibility(View.GONE);
        }

    }

}
