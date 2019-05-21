package com.creativeapps.selfstudy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    List<Subjects> subjects;
    Context context;

    int progressCount;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        initialiseSubject();
        initialiseAdapter();
    }

    public void initialiseSubject() {
        subjects = new ArrayList<>();
        subjects.add(new Subjects(10, "Maths", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(20, "Physics", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(5, "Chemistry", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(30, "Biology", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(15, "Mental Ability", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(25, "Economics", R.drawable.ic_launcher_background));
        subjects.add(new Subjects(10, "Geography", R.drawable.ic_launcher_background));
    }

    public void initialiseAdapter() {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(subjects);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public class Subjects {
        int progress;
        String textViewSubjectName;
        int imageViewSubjectId;

        public Subjects(int progress, String textViewSubjectName, int imageViewSubjectId) {
            this.progress = progress;
            this.textViewSubjectName = textViewSubjectName;
            this.imageViewSubjectId = imageViewSubjectId;
        }
    }
}
