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

import com.example.salameh.R;
import com.example.salameh.databinding.FragmentRegesterBinding;
import com.example.salameh.model.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_Regester extends Fragment {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = database.getReference("User/NormalUser");

    private FragmentRegesterBinding binding;

    public Fragment_Regester() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegesterBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init(view);
            }
        });
    }


    public void setUser(User user) {

        database.getReference("User/NormalUser").push()
                .setValue(user);

    }

    private void init(View view) {

            setUser(new User(binding.tvName.getText().toString(),
                    binding.tvPass.getText().toString(),
                    binding.tvEmail.getText().toString(),binding.tvPhoneNumber.getText().toString()));
            Toast.makeText(getContext(), "Now You  can Login", Toast.LENGTH_SHORT).show();
            action(view);

        }

    private boolean checkFeild() {
        if (
                binding.tvEmail.getText().toString().isEmpty() ||
                        binding.tvPass.getText().toString().isEmpty() ||
                        binding.tvRepass.getText().toString().isEmpty() ||
                        binding.tvName.getText().toString().isEmpty()
        )
            return false;
        else return true;
    }

    private void action(View view) {
        Navigation.findNavController(view).navigate(R.id.action_fragment_Regester_to_login);
    }

}