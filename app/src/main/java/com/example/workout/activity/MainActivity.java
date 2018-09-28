package com.example.workout.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.workout.R;
import com.example.workout.fragment.WorkoutDetailFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkoutDetailFragment frag = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        frag.setWorkoutId(2);

    }
}
