package com.creativeapps.selfstudy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.SubjectViewHolder> {

    List<HomeFragment.Subjects> subjects;

    RecyclerViewAdapter(List<HomeFragment.Subjects> subjects) {
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview, viewGroup, false);
        SubjectViewHolder subjectViewHolder = new SubjectViewHolder(view);
        return subjectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.SubjectViewHolder holder, int i) {

        holder.progressBar.setProgress(subjects.get(i).progress);
        holder.imageViewSubject.setImageResource(subjects.get(i).imageViewSubjectId);
        holder.textViewProgress.setText(subjects.get(i).progress + "%");
        holder.textViewsubjectName.setText(subjects.get(i).textViewSubjectName);

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewSubject;
        TextView textViewsubjectName, textViewProgress;
        ProgressBar progressBar;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSubject = itemView.findViewById(R.id.subjectImage);
            textViewsubjectName = itemView.findViewById(R.id.subjectName);
            textViewProgress = itemView.findViewById(R.id.progressText);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
