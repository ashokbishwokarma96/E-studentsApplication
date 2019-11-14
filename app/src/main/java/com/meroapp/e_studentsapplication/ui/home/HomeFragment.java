package com.meroapp.e_studentsapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meroapp.e_studentsapplication.R;
import com.meroapp.e_studentsapplication.adapter.StudentListAdapter;
import com.meroapp.e_studentsapplication.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    List<DataSet> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.RcView);
        DataSet sd= new DataSet("Ram", "20", "Boudha", "Male");

        studentList=sd.getSlist();


        if(studentList.isEmpty()){
            studentList.add(sd);

            studentList.add( new DataSet("Sam", "20", "Mahankal", "male"));


            sd.setSlist(studentList);

        }


        StudentListAdapter studentListAdapter = new StudentListAdapter(getActivity(), studentList);
        recyclerView.setAdapter(studentListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;

    }
}