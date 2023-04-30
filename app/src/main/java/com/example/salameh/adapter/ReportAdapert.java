package com.example.salameh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salameh.R;
import com.example.salameh.model.ReportDataFiled;

import java.util.ArrayList;

public class ReportAdapert extends RecyclerView.Adapter<ReportAdapert.ReportViewHolder>{
    private ArrayList<ReportDataFiled> reportsArrayList;
    private ItemClickListener listener;

    public ReportAdapert(ArrayList<ReportDataFiled> reportsArrayList,ItemClickListener itemClickListener) {
        this.reportsArrayList = reportsArrayList;
        this.listener=itemClickListener;

    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_report,null,false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        ReportDataFiled reports= reportsArrayList.get(position);
        holder.imageView.setImageResource(reports.getImageView());
        holder.textView.setText(reports.getNameReport());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(reportsArrayList.get(position));
        });

    }
public interface ItemClickListener{
        void onItemClick(ReportDataFiled reportDataFiled);

}

    @Override
    public int getItemCount() {
        return reportsArrayList.size();
    }

    static class ReportViewHolder extends RecyclerView.ViewHolder
{TextView textView;
    ImageView imageView;

    public ReportViewHolder(@NonNull View itemView) {
        super(itemView);
            textView=itemView.findViewById(R.id.tv_ReportName);
            imageView=itemView.findViewById(R.id.iv_svg);


    }
}}
