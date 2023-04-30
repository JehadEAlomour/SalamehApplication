package com.example.salameh.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salameh.adapter.AdminAdapter;
import com.example.salameh.databinding.FragmentAdminReportBinding;
import com.example.salameh.model.Reports;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminReport extends Fragment {
private FragmentAdminReportBinding binding;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = firebaseDatabase.getReference("Reports/");
    private AdminAdapter adminAdapter;
    private ArrayList <Reports> list;

    public AdminReport() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();

    }

    private void initAdapter() {
        binding.reportAdminList.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        adminAdapter=new AdminAdapter(getContext(),list);
        binding.reportAdminList.setAdapter(adminAdapter);
    }

    private void init() {
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Reports reports= dataSnapshot.getValue(Reports.class);
                    assert reports != null;
                    Log.d("TAG555", "onDataChange: "+reports.getTypeReport());
                    list.add(reports);

                }
                adminAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAdminReportBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();}
}