package com.example.salameh.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.salameh.R;
import com.example.salameh.databinding.FragmentLoginBinding;
import com.example.salameh.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class login extends Fragment {
    private FragmentLoginBinding binding;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference reference = firebaseDatabase.getReference("User/NormalUser");
    private static final String ADMIN_KEY = "admin";
    ArrayList<User> users = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init(view);
            }
        });


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    private void init(View view) {
        if (binding.tvEmail.getText().toString().equals("Admin") && binding.tvPass.getText().toString().equals("Admin")) {
            AdminPageActoin(view);
        } else {

            ArrayList<String> phoneNumbers = new ArrayList<String>();
            ArrayList<String> usersPass = new ArrayList<>();
            ArrayList<String> email = new ArrayList<>();
            String lastThreeChars = binding.tvEmail.toString().substring(binding.tvEmail.toString().length() - 5);
            if (
                    binding.tvEmail.getText().toString().isEmpty() ||
                            binding.tvPass.getText().toString().isEmpty()
            ) {
                Toast.makeText(view.getContext(), "add Email or Password", Toast.LENGTH_SHORT).show();
            }
//        else if (lastThreeChars.equals(ADMIN_KEY)) {
//            AdminPageActoin(view);
//        }
            else {
                reference.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        snapshot.getChildren().forEach(dataSnapshot -> {
                            User users = dataSnapshot.getValue(User.class);
                            login.this.users.add(users);
                            assert users != null;
                            phoneNumbers.add(users.getPhoneNumber());
                            email.add(users.getEmail());
                            usersPass.add(users.getPassword());
//                        Log.d("TAG00", "on Success : " + login.this.users.size());

                        });

                        if (phoneNumbers.contains(binding.tvEmail.getText().toString()) || email.contains(binding.tvEmail.getText().toString())) {
                            if (usersPass.contains(binding.tvPass.getText().toString())) {

                                Toast.makeText(binding.getRoot().getContext(), "Done", Toast.LENGTH_SHORT).show();
                                action(view);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        }
    }


    private void action(View view) {
        Navigation.findNavController(view).navigate(R.id.action_login_to_mapFragment);
        Toast.makeText(binding.getRoot().getContext(), "Login done", Toast.LENGTH_SHORT).show();
    }

    private void AdminPageActoin(View view) {
        Navigation.findNavController(view).navigate(R.id.action_login_to_adminReport);
    }

}