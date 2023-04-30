package com.example.salameh.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.salameh.R;
import com.example.salameh.databinding.FragmentNewReportsBinding;
import com.example.salameh.model.Reports;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New_Reports extends Fragment {
    private static final String ADDRESS = "Address";
    private static final String DESCRIPTION = "Description";
    private static final String NERST_LOCATION = "NerstLocation";
    private static final String TYPE_REPORTS = "TypeReports";
    private FragmentNewReportsBinding binding;
    private float Long;
    private float lang;
    private String typeReport;
    private String em;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = database.getReference("Reports");


    public New_Reports() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewReportsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        inti(view);
    }

    @SuppressLint("SetTextI18n")
    private void getArgs() {
        if(getArguments()!=null)
        {
            New_ReportsArgs args=New_ReportsArgs.fromBundle(getArguments());
            lang=args.getLange();
            Long=args.getLong();
            em=args.getTypeEmergency();
            typeReport=args.getTypeReport();
            binding.tvTypeReport.setText(typeReport);
            binding.tvAddress.setText(lang+" , "+Long);

        }
    }

    private void inti(View view) {
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setReport(new Reports(binding.tvAddress.getText().toString()
                        ,binding.tvDescription.getText().toString()
                        ,binding.tvNearestKnownLocation.getText().toString(),
                        binding.tvTypeReport.getText().toString(),em));
                action(view);
                Toast.makeText(getContext(), "reports is upload", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void action(View view) {
        Navigation.findNavController(view).navigate(R.id.action_new_Reports_to_mapFragment);
    }

    public void setReport(Reports report) {

        database.getReference("Reports").push()
                .setValue(report);

    }



}