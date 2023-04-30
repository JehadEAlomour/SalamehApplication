package com.example.salameh.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salameh.R;
import com.example.salameh.model.Reports;

import java.util.ArrayList;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminHolder> {
    Context context;
    ArrayList<Reports> reportsArrayList;

    public AdminAdapter(Context context, ArrayList<Reports> reportsArrayList) {
        this.context = context;
        this.reportsArrayList = reportsArrayList;
    }

    @NonNull
    @Override
    public AdminHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cv_admin_report, parent, false);

        return new AdminHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdminHolder holder, int position) {
        Reports reports = reportsArrayList.get(position);
        holder.TypeReport.setText(reports.getTypeReport());
        holder.Em.setText(reports.getStatus() + "");
        holder.Discreption.setText(reports.getDescription());
        holder.NerstLocation.setText(reports.getNerstLocation());
        holder.Address.setText(reports.getAddress());

    }

    @Override
    public int getItemCount() {
        return reportsArrayList.size();
    }

    public class AdminHolder extends RecyclerView.ViewHolder {
        TextView Address;
        TextView NerstLocation;
        TextView Em;
        TextView Discreption;
        TextView TypeReport;

        public AdminHolder(@NonNull View itemView) {
            super(itemView);
            Address = itemView.findViewById(R.id.Address);
            NerstLocation = itemView.findViewById(R.id.nerstLocation);
            Em = itemView.findViewById(R.id.tv_em);
            Discreption = itemView.findViewById(R.id.discribtion);
            TypeReport = itemView.findViewById(R.id.typeReport);

        }
    }
}
