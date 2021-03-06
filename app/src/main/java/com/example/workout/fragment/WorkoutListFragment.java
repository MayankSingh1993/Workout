package com.example.workout.fragment;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.workout.Pojo.Workout;


public class WorkoutListFragment extends ListFragment {

    public interface WorkoutListListener{
        void itemClicked(long id);
    }
    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] names = new String[Workout.workouts.length];
        for(int i=0;i<names.length;i++){
            names[i]=Workout.workouts[i].getName();
        }
        ArrayAdapter<String> listAdapter =new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.listener=(WorkoutListListener)activity;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener!=null)
        {
            listener.itemClicked(id);
        }
    }


}
