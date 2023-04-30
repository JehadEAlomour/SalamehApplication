package com.example.salameh.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salameh.R;
import com.example.salameh.databinding.FragmentSplachBinding;


public class splach extends Fragment {
private FragmentSplachBinding binding;


    public splach() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSplachBinding.inflate(getLayoutInflater());
                binding.btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goToLogin(view);
                    }
                });
                binding.btnReg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goToReg(view);
                    }
                });


        return binding.getRoot();}
    private void goToLogin(View view)
    {
        Navigation.findNavController(view).navigate(R.id.action_splach_to_login);
    }
    private void goToReg(View view)
    {
        Navigation.findNavController(view).navigate(R.id.action_splach_to_fragment_Regester);
    }

}
