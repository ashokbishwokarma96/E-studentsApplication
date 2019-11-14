package com.meroapp.e_studentsapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meroapp.e_studentsapplication.R;
import com.meroapp.e_studentsapplication.model.DataSet;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.Studentview> {

    Context context;
    List<DataSet> dataSetList;

    public StudentListAdapter(Context context, List<DataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public StudentListAdapter.Studentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new Studentview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.Studentview holder, final int position) {

        DataSet dataSet = dataSetList.get(position);

        if (dataSet.getStudentGender().equalsIgnoreCase("male")) {
            holder.imgcard.setImageResource(R.drawable.maleicon);
        } else {
            holder.imgcard.setImageResource(R.drawable.ic_woman);
        }

        holder.txname.setText(dataSet.getStudentName());
        holder.txage.setText(dataSet.getStudentAge());
        holder.txaddress.setText(dataSet.getStudentAddress());
        holder.txgender.setText(dataSet.getStudentGender());

        holder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSetList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public class Studentview extends RecyclerView.ViewHolder {
        ImageView imgcard;
        TextView txname, txaddress, txage, txgender;
        Button btndel;

        public Studentview(@NonNull View itemView) {
            super(itemView);
            imgcard = itemView.findViewById(R.id.cv);
            txname = itemView.findViewById(R.id.tvname);
            txaddress = itemView.findViewById(R.id.tvaddresss);
            txage = itemView.findViewById(R.id.tvage);
            btndel = itemView.findViewById(R.id.btndele);
            txgender = itemView.findViewById(R.id.tvgender);
        }
    }
}
