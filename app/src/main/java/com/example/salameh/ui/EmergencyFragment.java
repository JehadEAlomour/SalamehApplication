package com.example.salameh.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.salameh.databinding.FragmentEmergencyBinding;


public class EmergencyFragment extends Fragment {
    private FragmentEmergencyBinding binding;
    private float Long;
    private float lang;
    private String typeReport;

    public EmergencyFragment() {
        // Required empty public constructor
    }


    public static EmergencyFragment newInstance(String param1, String param2) {

        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate
        // the layout for this fragment
        binding = FragmentEmergencyBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        init(view);
    }

    private void getArgs() {
        if (getArguments() != null) {
            EmergencyFragmentArgs args = EmergencyFragmentArgs.fromBundle(getArguments());
            lang = args.getLange();
            Long = args.getLong();
            typeReport = args.getTypeReport();
        }
        Toast.makeText(getContext(), "Location" + lang + " , " + Long + "", Toast.LENGTH_SHORT).show();

    }

    private void init(View view) {
        binding.btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmergencyFragmentDirections.ActionEmergencyFragmentToNewReports directions = EmergencyFragmentDirections.
                        actionEmergencyFragmentToNewReports(typeReport, "Emergency", Long, lang);
                Navigation.findNavController(view).navigate(directions);

            }
        });
        binding.btnNotEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmergencyFragmentDirections.ActionEmergencyFragmentToNewReports directions = EmergencyFragmentDirections.
                        actionEmergencyFragmentToNewReports(typeReport, "Not Emergency", Long, lang);
                Navigation.findNavController(view).navigate(directions);
            }
        });

    }
}