package com.meroapp.e_studentsapplication.controller;

import android.service.autofill.UserData;

import com.meroapp.e_studentsapplication.model.UsersData;

public class UserController {
    public boolean CheckUser(UsersData usersData) {
        if ((usersData.getName().equals("Ashok")) && (usersData.getPassword().equals("123"))) {
            return true;

        } else {
            return false;
        }
    }
}
