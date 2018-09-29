package com.example.workout.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.workout.Pojo.Workout;
import com.example.workout.R;



public class WorkoutDetailFragment extends Fragment {

    private long workoutId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null){
            workoutId=savedInstanceState.getLong("workoutId");
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view =getView();
        if(view!=null)
        {
            Workout workout=Workout.workouts[(int) workoutId];
            //get name
            TextView title =view.findViewById(R.id.textTitle);
            title.setText(workout.getName());
            //get description
            TextView desc=view.findViewById(R.id.textDescription);
            desc.setText(workout.getDescription());


        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId",workoutId);
    }
    //set fragment Id
    public void setWorkoutId(long id) {
        this.workoutId = id;
    }




}