package com.meroapp.e_studentsapplication.ui.addstudents;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.meroapp.e_studentsapplication.R;
import com.meroapp.e_studentsapplication.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class AddStudentsFragment extends Fragment {

    private EditText editTextName, editTextAge, editTextAddress;
    private RadioGroup RadioGroupGender;
    private Button buttonAdd;

    String name = "", age = "", address = "", gender = "";

    List<DataSet> studentList = new ArrayList<>();

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addstudents, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextAge = view.findViewById(R.id.editTextAge);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        RadioGroupGender = view.findViewById(R.id.RadioGroupGender);
        buttonAdd = view.findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextName.getText().toString())) {
                    editTextName.setError("Please Enter Name");
                    return;
                } else if (TextUtils.isEmpty(editTextAge.getText().toString())) {
                    editTextAge.setError("Please Enter Age");
                    return;
                } else if (TextUtils.isEmpty(editTextAddress.getText().toString())) {
                    editTextAddress.setError("Please Enter Address");
                    return;
                } else {
                    name = editTextName.getText().toString();
                    age = editTextAge.getText().toString();
                    address = editTextAddress.getText().toString();
                }

                int selectedRadioButtonId = RadioGroupGender.getCheckedRadioButtonId();
                if (selectedRadioButtonId > 0) {
                    RadioButton radioButton = getView().findViewById(selectedRadioButtonId);
                    gender = radioButton.getText().toString();

                    Toast.makeText(getContext(), "Welcome " + name, Toast.LENGTH_SHORT).show();

                    DataSet dataSet = new DataSet(name, age, address, gender);
                    studentList = dataSet.getSlist();
                    studentList.add(dataSet);
                    dataSet.setSlist(studentList);
                    editTextName.setText("");
                    editTextAge.setText("");
                    editTextAddress.setText("");
                } else {
                    Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                }
            }

            });
        return view;
        }
    }



