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
import com.example.salameh.adapter.ReportAdapert;
import com.example.salameh.databinding.FragmentReportsBinding;
import com.example.salameh.model.ReportDataFiled;

import java.util.ArrayList;


public class Reports_Fragment extends Fragment {
    private FragmentReportsBinding binding;
    private final ArrayList<ReportDataFiled> reports = new ArrayList<>();
    private int ListImg[] = new int[23];
    private String type[] = new String[23];
    private ReportAdapert adapert;
    private float Long;
    private float lang;


    public Reports_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        init();
        setAdapter();

    }

    private void getArgs() {


        Long = getArguments().getFloat("long");
        lang = getArguments().getFloat("lang");
//

        Toast.makeText(getContext(), "Location" + lang + " , " + Long + "", Toast.LENGTH_SHORT).show();
    }


    private void setAdapter() {
        adapert = new ReportAdapert(reports, new ReportAdapert.ItemClickListener() {
            @Override
            public void onItemClick(ReportDataFiled reportDataFiled) {
                action(reportDataFiled);
            }
        });

        binding.rvReports.setAdapter(adapert);
    }

    private void action(ReportDataFiled reportDataFiled) {
        Reports_FragmentDirections.ActionReportsFragmentToEmergencyFragment directions =
                Reports_FragmentDirections.actionReportsFragmentToEmergencyFragment(reportDataFiled.getNameReport(), Long, lang);
        Navigation.findNavController(getView()).navigate(directions);

    }

    private void init() {
        type = getResources().getStringArray(R.array.Reports);
        setImageList(ListImg);
        setDataInArray();

    }


    private void setDataInArray() {
        for (int i = 0; i < type.length; i++){
            reports.add(i, new ReportDataFiled(ListImg[i], type[i]));}
//


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setImageList(int[] listImg) {
        listImg[0] = R.drawable.ic_electricity;
        listImg[1] = R.drawable.ic_water;
        listImg[2] = R.drawable.ic__1;
        listImg[3] = R.drawable.ic__8;
        listImg[4] = R.drawable.ic__18;
        listImg[5] = R.drawable.ic__8;
        listImg[6] = R.drawable.ic__5;
        listImg[7] = R.drawable.ic__17;
        listImg[8] = R.drawable.ic__7;
        listImg[9] = R.drawable.ic__10;
        listImg[10] = R.drawable.ic__12;
        listImg[11] = R.drawable.ic__12;
        listImg[12] = R.drawable.ic__21;
        listImg[13] = R.drawable.ic__12;
        listImg[14] = R.drawable.ic__12;
        listImg[15] = R.drawable.ic__14;
        listImg[16] = R.drawable.ic__15;
        listImg[17] = R.drawable.ic__12;
        listImg[18] = R.drawable.ic__19;
        listImg[19] = R.drawable.ic__20;
        listImg[20] = R.drawable.ic_fire;
        //company
        listImg[21] = R.drawable.ic__21;
        listImg[22] = R.drawable.ic__21;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReportsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}