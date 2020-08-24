package com.example.kapilyadav.medicine.Data;

/**
 * Created by Kapil Yadav on 05-07-2017.
 */

public class Member {
    private String name,gender,age;

    public Member(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }
}
