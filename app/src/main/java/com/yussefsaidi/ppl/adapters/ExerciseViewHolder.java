package com.yussefsaidi.ppl.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.yussefsaidi.ppl.R;
import com.yussefsaidi.ppl.models.Exercise;
import com.yussefsaidi.ppl.persistence.ExerciseRepository;

public class ExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "ExerciseViewHolder";
    private static final int EDIT_MODE_DISABLED = 0;
    private static final int EDIT_MODE_ENABLED = 1;

    ExerciseRepository mExerciseRepository;
    Exercise mExercise;
    TextView sets, repetitions;
    private LinearLayout mSubItem;
    private Button mEditButton;
    private ImageButton mCheckContainer;
    EditText mEditName;
    TextView mViewName;
    View exerciseItem;
    private int mMode;
    Activity activity;


    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);


        mViewName = itemView.findViewById(R.id.exercise_text_name);
        mEditName = itemView.findViewById(R.id.exercise_edit_name);
        sets = itemView.findViewById(R.id.exercise_reps);
        repetitions = itemView.findViewById(R.id.exercise_sets);
        mSubItem = itemView.findViewById(R.id.exercise_subinfo);
        mEditButton = itemView.findViewById(R.id.edit_name_button);
        mCheckContainer = itemView.findViewById(R.id.check_container);
        exerciseItem = itemView.findViewById(R.id.exercise_item);
        exerciseItem.setOnClickListener(this);
        mEditButton.setOnClickListener(this);
        mCheckContainer.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        activity = getActivity(view);
        if(view.getId() == exerciseItem.getId() && mMode != EDIT_MODE_ENABLED){
            if(mSubItem.getVisibility() == View.VISIBLE){
                mSubItem.setVisibility(View.GONE);
            } else
                mSubItem.setVisibility(View.VISIBLE);
        }

        if (view.getId() == mEditButton.getId()) {
            enableEditMode(activity);
        }
        // Check pressed in edit mode
        if (view.getId() == mCheckContainer.getId()) {
            disableEditMode(activity);
            saveChanges(activity);
        }
        // When edit mode is enabled, clicking anywhere results in disabling edit mode

    }


    private void enableEditMode(Activity activity) {
        mViewName.setVisibility(View.GONE);
        mEditName.setVisibility(View.VISIBLE);
        mMode = EDIT_MODE_ENABLED;
        mCheckContainer.setVisibility(View.VISIBLE);
        mEditButton.setVisibility(View.GONE);
        mEditName.requestFocus();
    }

    private void disableEditMode(Activity activity) {
        mEditName.setVisibility(View.GONE);
        mViewName.setVisibility(View.VISIBLE);
        mMode = EDIT_MODE_DISABLED;
        mCheckContainer.setVisibility(View.GONE);
        mEditButton.setVisibility(View.VISIBLE);
        hideKeyboard(activity);


    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    private Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private void onBackPressed(Activity activity){
        if(mMode == EDIT_MODE_ENABLED){
            onClick(mCheckContainer);
        }
        else {
            activity.onBackPressed();
        }
    }

    private void saveChanges(Activity activity){
        mExerciseRepository = new ExerciseRepository(activity);
        mExercise.setName(mEditName.getText().toString());
        mExercise.setSets(sets.getText().toString());
        mExercise.setRepetitions(repetitions.getText().toString());
        mExerciseRepository.updateExerciseTask(mExercise);
        Log.d(TAG, "saveChanges: UPDATE ITEM");
    }
}
