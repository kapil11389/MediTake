package com.example.kapilyadav.medicine.Data;

/**
 * Created by Kapil Yadav on 08-07-2017.
 */

public class MedicineList {
    private String Medicine,specialMention;
    private Boolean breakfast,lunch,dinner;

    public MedicineList() {
    }

    public MedicineList(String medicine, String specialMention, Boolean breakfast, Boolean lunch, Boolean dinner) {
        Medicine = medicine;
        this.specialMention = specialMention;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getMedicine() {
        return Medicine;
    }

    public String getSpecialMention() {
        return specialMention;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public Boolean getLunch() {
        return lunch;
    }

    public Boolean getDinner() {
        return dinner;
    }
}
