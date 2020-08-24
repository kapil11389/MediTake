package com.example.kapilyadav.medicine.Data;

/**
 * Created by Kapil Yadav on 05-07-2017.
 */

public class Disease {
    String illness,precautions;

    public Disease(String illness, String precautions) {
        this.illness = illness;
        this.precautions = precautions;
    }

    public String getIllness() {
        return illness;
    }

    public String getPrecautions() {
        return precautions;
    }
}
