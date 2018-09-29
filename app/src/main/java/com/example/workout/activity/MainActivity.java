package com.example.workout.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.workout.R;
import com.example.workout.fragment.WorkoutDetailFragment;
import com.example.workout.fragment.WorkoutListFragment;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id) {

        View fragmentContainer=findViewById(R.id.fragment_container);
        if(fragmentContainer!=null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            fragmentTransaction.replace(R.id.fragment_container, details);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
        else{
            Intent intent=new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
            startActivity(intent);
        }
    }
}
