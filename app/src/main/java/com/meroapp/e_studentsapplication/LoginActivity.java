package com.meroapp.e_studentsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.meroapp.e_studentsapplication.controller.UserController;
import com.meroapp.e_studentsapplication.model.UsersData;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private TextView textViewLogin;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewLogin = findViewById(R.id.textViewLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersData dataSet = new UsersData();
                if (!TextUtils.isEmpty(editTextUsername.getText().toString())) {
                    dataSet.setName(editTextUsername.getText().toString());
                    if (!TextUtils.isEmpty(editTextPassword.getText().toString())) {
                        dataSet.setPassword(editTextPassword.getText().toString());
                        boolean result = new UserController().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(LoginActivity.this, BottomNavigationActivity.class);
                            startActivity(intent);
                            editTextUsername.setText("");
                            editTextPassword.setText("");
                        } else {
                            Toast.makeText(LoginActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        editTextPassword.setError("please enter password");
                    }
                } else {
                    editTextUsername.setError("please enter user name");

                }
            }
        });


    }
}
