package com.yussefsaidi.ppl.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;
import com.yussefsaidi.ppl.models.Exercise;

import java.util.ArrayList;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<Exercise> mExercises;
    private Exercise mExercise;
    private static final String TAG = "ExerciseRecyclerAdapter";


    public ExerciseRecyclerAdapter(ArrayList<Exercise> exercises) {
        this.mExercises = exercises;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_exercise_list_item, parent, false);
        final ExerciseViewHolder holder = new ExerciseViewHolder(view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: position: " + holder.getAdapterPosition());
                mExercise = mExercises.get(holder.getAdapterPosition());
                boolean expanded = mExercise.isExpanded();
                if(expanded){
                    mExercise.setExpanded(false);
                }
                else{
                    mExercise.setExpanded(true);
                }
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
        return holder;
    }

   /**
    }**/

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ExerciseViewHolder)holder).name.setText(mExercises.get(position).getName());
        ((ExerciseViewHolder)holder).repetitions.setText(mExercises.get(position).getRepetitions());
        ((ExerciseViewHolder)holder).sets.setText(mExercises.get(position).getSets());
        ((ExerciseViewHolder)holder).bind(mExercises.get(position));

    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

}
