package com.example.robin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.robin.api.AbstractAPIListener;

public class loginfragment extends Fragment {
    EditText usernamee,passwordd;
    Button login,resetpass,signup;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usernamee = view.findViewById(R.id.username);
        passwordd= view.findViewById(R.id.password);
        resetpass= view.findViewById(R.id.resetpass);

        signup=view.findViewById(R.id.signup);
        login = view.findViewById(R.id.login);

        resetpass.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), resetpasswordActivity.class);
            startActivity(intent);

        });
        signup.setOnClickListener(v->{
            AppCompatActivity activity =(AppCompatActivity)view.getContext();
           signupfragment myFragment = new signupfragment();
           activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,myFragment).commit();
        });
        login.setOnClickListener(v -> {

            String username =usernamee.getText().toString();
            String password =  passwordd.getText().toString();
            if(username.length()   > 1){
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Logging in...");
                progressDialog.show();
                //final Model model = Model.getInstance(requireActivity().getApplication());
                final Model model = Model.getInstance(loginfragment.this.requireActivity().getApplication());
                model.login(username,password, new AbstractAPIListener() {
                    @Override
                    public void onLogin(User user){
                        model.setUser(user);
                        switch (user.getPermission()) {
                            case "user": {
                                Intent intent = new Intent(getContext(), student.class);
                                startActivity(intent);
                                progressDialog.dismiss();
                                break;
                            }
                            case "admin": {
                                Intent intent = new Intent(getContext(), AdminActivity.class);
                                startActivity(intent);
                                progressDialog.dismiss();
                                break;
                            }
                            case "landlord": {
                                Intent intent = new Intent(getContext(), landlordActivity.class);
                                startActivity(intent.putExtra("id", user.getId()));
                                progressDialog.dismiss();
                                break;
                            }
                            default:
                                Toast.makeText(getActivity(), user.getError(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                break;
                        }


                    }
                });


            }

            else if((username.length() & password.length()) == 0 ){
                Toast.makeText(getContext(), "Fill all fields", Toast.LENGTH_SHORT).show();


            }

        });
    }

}
