package com.meroapp.e_studentsapplication.model;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private String studentName;
    private String studentAge;
    private String studentAddress;
    private String studentGender;
    static List<DataSet> Slist =new ArrayList<>();

    public DataSet(String studentName, String studentAge, String studentAddress, String studentGender) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentAddress = studentAddress;
        this.studentGender = studentGender;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public static List<DataSet> getSlist() {
        return Slist;
    }

    public static void setSlist(List<DataSet> slist) {
        Slist = slist;
    }
}
