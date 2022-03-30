package com.kykara4a.metod;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import java.security.PublicKey;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Profile {
    public int id;
    public String name;
    public String input1_1_1;
    public String input1_1_2;
    public String input1_1_3;
    public String input1_1_4;
    public String input5_1;
    public String input6_1;
    public String input6_2;
    public String input6_3;
    public boolean spinner6_1;
    public boolean spinner6_2;

    public boolean isSpinner6_1() {
        return spinner6_1;
    }

    public void setSpinner6_1(boolean spinner6_1) {
        this.spinner6_1 = spinner6_1;
    }

    public boolean isSpinner6_2() {
        return spinner6_2;
    }

    public void setSpinner6_2(boolean spinner6_2) {
        this.spinner6_2 = spinner6_2;
    }

    public Profile(int id, String name, String input1_1_1, String input1_1_2, String input1_1_3, String input1_1_4, String input5_1, String input6_1, String input6_2, String input6_3, String input6_4, String input6_5, String input6_6, String input6_7, String input6_8, String input6_9, String input6_10, boolean radio6, String input1_1_5, String input1_2_1, String input1_2_2, String input1_3_1, boolean radio1_2_1, boolean radio1_3_1, ArrayList<String> xarray2_1, ArrayList<String> yarray2_1, ArrayList<String> xarray2_2, boolean radio3_1_1, ArrayList<String> xarray3_1, ArrayList<String> yarray3_1, int radio4_1, String n4_1, String n4_2, String n4_3, String upperBound4_1, String upperBound4_2, String upperBound4_3, String lowerBound4_1, String lowerBound4_2, String lowerBound4_3, ArrayList<Object> integral4_1, ArrayList<Object> integral4_2, ArrayList<Object> integral4_3, ArrayList<String> xarray3_2, String input3_1_1) {
        this.id = id;
        this.name = name;
        this.input1_1_1 = input1_1_1;
        this.input1_1_2 = input1_1_2;
        this.input1_1_3 = input1_1_3;
        this.input1_1_4 = input1_1_4;
        this.input5_1 = input5_1;
        this.input6_1 = input6_1;
        this.input6_2 = input6_2;
        this.input6_3 = input6_3;
        this.input6_4 = input6_4;
        this.input6_5 = input6_5;
        this.input6_6 = input6_6;
        this.input6_7 = input6_7;
        this.input6_8 = input6_8;
        this.input6_9 = input6_9;
        this.input6_10 = input6_10;
        this.radio6 = radio6;
        this.input1_1_5 = input1_1_5;
        this.input1_2_1 = input1_2_1;
        this.input1_2_2 = input1_2_2;
        this.input1_3_1 = input1_3_1;
        this.radio1_2_1 = radio1_2_1;
        this.radio1_3_1 = radio1_3_1;
        this.xarray2_1 = xarray2_1;
        this.yarray2_1 = yarray2_1;
        this.xarray2_2 = xarray2_2;
        this.radio3_1_1 = radio3_1_1;
        this.xarray3_1 = xarray3_1;
        this.yarray3_1 = yarray3_1;
        this.radio4_1 = radio4_1;
        this.n4_1 = n4_1;
        this.n4_2 = n4_2;
        this.n4_3 = n4_3;
        this.upperBound4_1 = upperBound4_1;
        this.upperBound4_2 = upperBound4_2;
        this.upperBound4_3 = upperBound4_3;
        this.lowerBound4_1 = lowerBound4_1;
        this.lowerBound4_2 = lowerBound4_2;
        this.lowerBound4_3 = lowerBound4_3;
        this.integral4_1 = integral4_1;
        this.integral4_2 = integral4_2;
        this.integral4_3 = integral4_3;
        this.xarray3_2 = xarray3_2;
        this.input3_1_1 = input3_1_1;
    }

    public String input6_4;
    public String input6_5;
    public String input6_6;

    public String getInput6_1() {
        return input6_1;
    }

    public void setInput6_1(String input6_1) {
        this.input6_1 = input6_1;
    }

    public String getInput6_2() {
        return input6_2;
    }

    public void setInput6_2(String input6_2) {
        this.input6_2 = input6_2;
    }

    public String getInput6_3() {
        return input6_3;
    }

    public void setInput6_3(String input6_3) {
        this.input6_3 = input6_3;
    }

    public String getInput6_4() {
        return input6_4;
    }

    public void setInput6_4(String input6_4) {
        this.input6_4 = input6_4;
    }

    public String getInput6_5() {
        return input6_5;
    }

    public void setInput6_5(String input6_5) {
        this.input6_5 = input6_5;
    }

    public String getInput6_6() {
        return input6_6;
    }

    public void setInput6_6(String input6_6) {
        this.input6_6 = input6_6;
    }

    public String getInput6_7() {
        return input6_7;
    }

    public void setInput6_7(String input6_7) {
        this.input6_7 = input6_7;
    }

    public String getInput6_8() {
        return input6_8;
    }

    public void setInput6_8(String input6_8) {
        this.input6_8 = input6_8;
    }

    public String getInput6_9() {
        return input6_9;
    }

    public void setInput6_9(String input6_9) {
        this.input6_9 = input6_9;
    }

    public String getInput6_10() {
        return input6_10;
    }

    public void setInput6_10(String input6_10) {
        this.input6_10 = input6_10;
    }

    public boolean isRadio6() {
        return radio6;
    }

    public void setRadio6(boolean radio6) {
        this.radio6 = radio6;
    }

    public String input6_7;
    public String input6_8;
    public String input6_9;
    public String input6_10;
    public boolean radio6;

    public Profile(int id, String name, String input1_1_1, String input1_1_2, String input1_1_3, String input1_1_4, String input5_1, String input1_1_5, String input1_2_1, String input1_2_2, String input1_3_1, boolean radio1_2_1, boolean radio1_3_1, ArrayList<String> xarray2_1, ArrayList<String> yarray2_1, ArrayList<String> xarray2_2, boolean radio3_1_1, ArrayList<String> xarray3_1, ArrayList<String> yarray3_1, int radio4_1, String n4_1, String n4_2, String n4_3, String upperBound4_1, String upperBound4_2, String upperBound4_3, String lowerBound4_1, String lowerBound4_2, String lowerBound4_3, ArrayList<Object> integral4_1, ArrayList<Object> integral4_2, ArrayList<Object> integral4_3, ArrayList<String> xarray3_2, String input3_1_1) {
        this.id = id;
        this.name = name;
        this.input1_1_1 = input1_1_1;
        this.input1_1_2 = input1_1_2;
        this.input1_1_3 = input1_1_3;
        this.input1_1_4 = input1_1_4;
        this.input5_1 = input5_1;
        this.input1_1_5 = input1_1_5;
        this.input1_2_1 = input1_2_1;
        this.input1_2_2 = input1_2_2;
        this.input1_3_1 = input1_3_1;
        this.radio1_2_1 = radio1_2_1;
        this.radio1_3_1 = radio1_3_1;
        this.xarray2_1 = xarray2_1;
        this.yarray2_1 = yarray2_1;
        this.xarray2_2 = xarray2_2;
        this.radio3_1_1 = radio3_1_1;
        this.xarray3_1 = xarray3_1;
        this.yarray3_1 = yarray3_1;
        this.radio4_1 = radio4_1;
        this.n4_1 = n4_1;
        this.n4_2 = n4_2;
        this.n4_3 = n4_3;
        this.upperBound4_1 = upperBound4_1;
        this.upperBound4_2 = upperBound4_2;
        this.upperBound4_3 = upperBound4_3;
        this.lowerBound4_1 = lowerBound4_1;
        this.lowerBound4_2 = lowerBound4_2;
        this.lowerBound4_3 = lowerBound4_3;
        this.integral4_1 = integral4_1;
        this.integral4_2 = integral4_2;
        this.integral4_3 = integral4_3;
        this.xarray3_2 = xarray3_2;
        this.input3_1_1 = input3_1_1;
    }

    public String getInput5_1() {
        return input5_1;
    }

    public void setInput5_1(String input5_1) {
        this.input5_1 = input5_1;
    }

    public Profile() {
    }

    public String input1_1_5;
    public String input1_2_1;
    public String input1_2_2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String input1_3_1;
    public boolean radio1_2_1;
    public boolean radio1_3_1;
    public ArrayList<String> xarray2_1;
    public ArrayList<String> yarray2_1;
    public ArrayList<String> xarray2_2;
    public boolean radio3_1_1;
    public ArrayList<String> xarray3_1;
    public ArrayList<String> yarray3_1;
    public int radio4_1;
    public String n4_1;
    public String n4_2;
    public String n4_3;
    public String upperBound4_1;
    public String upperBound4_2;
    public String upperBound4_3;
    public String lowerBound4_1;
    public String lowerBound4_2;
    public String lowerBound4_3;
    public ArrayList<Object> integral4_1;
    public ArrayList<Object> integral4_2;
    public ArrayList<Object> integral4_3;

    //RGR fields
    public ArrayList<String> xarray_rgr;
    public ArrayList<String> yarray_rgr;
    public ArrayList<String> xarray_rgr_2;
    public String rgr_ab;
    public String rgr_bc;
    public String rgr_cd;
    public String rgr_da;
    public String rgr_2_step;
    public boolean rgr_less_more;

    public String rgr_3_gep_1;
    public String rgr_3_gep_2;
    public int rgr_task;
    public ArrayList<ArrayList<String>> rgr_fx_array;

    public int getRgr_task() {
        return rgr_task;
    }

    public void setRgr_task(int rgr_task) {
        this.rgr_task = rgr_task;
    }

    public ArrayList<ArrayList<String>> getRgr_fx_array() {
        return rgr_fx_array;
    }

    public void setRgr_fx_array(ArrayList<ArrayList<String>> rgr_fx_array) {
        this.rgr_fx_array = rgr_fx_array;
    }

    public boolean isRgr_less_more() {
        return rgr_less_more;
    }

    public void setRgr_less_more(boolean rgr_less_more) {
        this.rgr_less_more = rgr_less_more;
    }



    public String getRgr_3_gep_1() {
        return rgr_3_gep_1;
    }

    public void setRgr_3_gep_1(String rgr_3_gep_1) {
        this.rgr_3_gep_1 = rgr_3_gep_1;
    }

    public String getRgr_3_gep_2() {
        return rgr_3_gep_2;
    }

    public void setRgr_3_gep_2(String rgr_3_gep_2) {
        this.rgr_3_gep_2 = rgr_3_gep_2;
    }

    public ArrayList<String> getXarray_rgr() {
        return xarray_rgr;
    }

    public void setXarray_rgr(ArrayList<String> xarray_rgr) {
        this.xarray_rgr = xarray_rgr;
    }

    public ArrayList<String> getYarray_rgr() {
        return yarray_rgr;
    }

    public void setYarray_rgr(ArrayList<String> yarray_rgr) {
        this.yarray_rgr = yarray_rgr;
    }

    public ArrayList<String> getXarray_rgr_2() {
        return xarray_rgr_2;
    }

    public void setXarray_rgr_2(ArrayList<String> xarray_rgr_2) {
        this.xarray_rgr_2 = xarray_rgr_2;
    }

    public String getRgr_ab() {
        return rgr_ab;
    }

    public void setRgr_ab(String rgr_ab) {
        this.rgr_ab = rgr_ab;
    }

    public String getRgr_bc() {
        return rgr_bc;
    }

    public void setRgr_bc(String rgr_bc) {
        this.rgr_bc = rgr_bc;
    }

    public String getRgr_cd() {
        return rgr_cd;
    }

    public void setRgr_cd(String rgr_cd) {
        this.rgr_cd = rgr_cd;
    }

    public String getRgr_da() {
        return rgr_da;
    }

    public void setRgr_da(String rgr_da) {
        this.rgr_da = rgr_da;
    }

    public String getRgr_2_step() {
        return rgr_2_step;
    }

    public void setRgr_2_step(String rgr_2_step) {
        this.rgr_2_step = rgr_2_step;
    }



    public Profile(int id, String name, String input1_1_1, String input1_1_2, String input1_1_3, String input1_1_4, String input1_1_5, String input1_2_1, String input1_2_2, String input1_3_1, boolean radio1_2_1, boolean radio1_3_1, ArrayList<String> xarray2_1, ArrayList<String> yarray2_1, ArrayList<String> xarray2_2, boolean radio3_1_1, ArrayList<String> xarray3_1, ArrayList<String> yarray3_1, int radio, int n1, int n2, int n3, double upperBound1, double upperBound2, double upperBound3, double lowerBound1, double lowerBound2, double lowerBound3, ArrayList<Object> integral1, ArrayList<Object> integral2, ArrayList<Object> integral3, ArrayList<String> xarray3_2, String input3_1_1) {
        this.id = id;
        this.name = name;
        this.input1_1_1 = input1_1_1;
        this.input1_1_2 = input1_1_2;
        this.input1_1_3 = input1_1_3;
        this.input1_1_4 = input1_1_4;
        this.input1_1_5 = input1_1_5;
        this.input1_2_1 = input1_2_1;
        this.input1_2_2 = input1_2_2;
        this.input1_3_1 = input1_3_1;
        this.radio1_2_1 = radio1_2_1;
        this.radio1_3_1 = radio1_3_1;
        this.xarray2_1 = xarray2_1;
        this.yarray2_1 = yarray2_1;
        this.xarray2_2 = xarray2_2;
        this.radio3_1_1 = radio3_1_1;
        this.xarray3_1 = xarray3_1;
        this.yarray3_1 = yarray3_1;

    }



    public boolean isRadio1_2_1() {
        return radio1_2_1;
    }

    public boolean isRadio1_3_1() {
        return radio1_3_1;
    }

    public boolean isRadio3_1_1() {
        return radio3_1_1;
    }

    public void setRadio3_1_1(boolean radio3_1_1) {
        this.radio3_1_1 = radio3_1_1;
    }

    public ArrayList<String> getXarray3_1() {
        return xarray3_1;
    }

    public void setXarray3_1(ArrayList<String> xarray3_1) {
        this.xarray3_1 = xarray3_1;
    }

    public ArrayList<String> getYarray3_1() {
        return yarray3_1;
    }

    public void setYarray3_1(ArrayList<String> yarray3_1) {
        this.yarray3_1 = yarray3_1;
    }

    public ArrayList<String> getXarray3_2() {
        return xarray3_2;
    }

    public void setXarray3_2(ArrayList<String> xarray3_2) {
        this.xarray3_2 = xarray3_2;
    }

    public String getInput3_1_1() {
        return input3_1_1;
    }

    public void setInput3_1_1(String input3_1_1) {
        this.input3_1_1 = input3_1_1;
    }

    public Profile(int id, String name, String input1_1_1, String input1_1_2, String input1_1_3, String input1_1_4, String input1_1_5, String input1_2_1, String input1_2_2, String input1_3_1, boolean radio1_2_1, boolean radio1_3_1, ArrayList<String> xarray2_1, ArrayList<String> yarray2_1, ArrayList<String> xarray2_2, boolean radio3_1_1, ArrayList<String> xarray3_1, ArrayList<String> yarray3_1, int radio4_1, String n4_1, String  n4_2, String n4_3, String upperBound4_1, String upperBound4_2, String upperBound4_3, String lowerBound4_1, String lowerBound4_2, String lowerBound4_3, ArrayList<Object> integral4_1, ArrayList<Object> integral4_2, ArrayList<Object> integral4_3, ArrayList<String> xarray3_2, String input3_1_1) {
        this.id = id;
        this.name = name;
        this.input1_1_1 = input1_1_1;
        this.input1_1_2 = input1_1_2;
        this.input1_1_3 = input1_1_3;
        this.input1_1_4 = input1_1_4;
        this.input1_1_5 = input1_1_5;
        this.input1_2_1 = input1_2_1;
        this.input1_2_2 = input1_2_2;
        this.input1_3_1 = input1_3_1;
        this.radio1_2_1 = radio1_2_1;
        this.radio1_3_1 = radio1_3_1;
        this.xarray2_1 = xarray2_1;
        this.yarray2_1 = yarray2_1;
        this.xarray2_2 = xarray2_2;
        this.radio3_1_1 = radio3_1_1;
        this.xarray3_1 = xarray3_1;
        this.yarray3_1 = yarray3_1;
        this.radio4_1 = radio4_1;
        this.n4_1 = n4_1;
        this.n4_2 = n4_2;
        this.n4_3 = n4_3;
        this.upperBound4_1 = upperBound4_1;
        this.upperBound4_2 = upperBound4_2;
        this.upperBound4_3 = upperBound4_3;
        this.lowerBound4_1 = lowerBound4_1;
        this.lowerBound4_2 = lowerBound4_2;
        this.lowerBound4_3 = lowerBound4_3;
        this.integral4_1 = integral4_1;
        this.integral4_2 = integral4_2;
        this.integral4_3 = integral4_3;
        this.xarray3_2 = xarray3_2;
        this.input3_1_1 = input3_1_1;
    }

    public int getRadio4_1() {
        return radio4_1;
    }

    public void setRadio4_1(int radio4_1) {
        this.radio4_1 = radio4_1;
    }

    public String getN4_1() {
        return n4_1;
    }

    public void setN4_1(String n4_1) {
        this.n4_1 = n4_1;
    }

    public String getN4_2() {
        return n4_2;
    }

    public void setN4_2(String n4_2) {
        this.n4_2 = n4_2;
    }

    public String getN4_3() {
        return n4_3;
    }

    public void setN4_3(String n4_3) {
        this.n4_3 = n4_3;
    }

    public String getUpperBound4_1() {
        return upperBound4_1;
    }

    public void setUpperBound4_1(String upperBound4_1) {
        this.upperBound4_1 = upperBound4_1;
    }

    public String getUpperBound4_2() {
        return upperBound4_2;
    }

    public void setUpperBound4_2(String upperBound4_2) {
        this.upperBound4_2 = upperBound4_2;
    }

    public String getUpperBound4_3() {
        return upperBound4_3;
    }

    public void setUpperBound4_3(String upperBound4_3) {
        this.upperBound4_3 = upperBound4_3;
    }

    public String getLowerBound4_1() {
        return lowerBound4_1;
    }

    public void setLowerBound4_1(String lowerBound4_1) {
        this.lowerBound4_1 = lowerBound4_1;
    }

    public String getLowerBound4_2() {
        return lowerBound4_2;
    }

    public void setLowerBound4_2(String lowerBound4_2) {
        this.lowerBound4_2 = lowerBound4_2;
    }

    public String getLowerBound4_3() {
        return lowerBound4_3;
    }

    public void setLowerBound4_3(String lowerBound4_3) {
        this.lowerBound4_3 = lowerBound4_3;
    }

    public ArrayList<Object> getIntegral4_1() {
        return integral4_1;
    }

    public void setIntegral4_1(ArrayList<Object> integral4_1) {
        this.integral4_1 = integral4_1;
    }

    public ArrayList<Object> getIntegral4_2() {
        return integral4_2;
    }

    public void setIntegral4_2(ArrayList<Object> integral4_2) {
        this.integral4_2 = integral4_2;
    }

    public ArrayList<Object> getIntegral4_3() {
        return integral4_3;
    }

    public void setIntegral4_3(ArrayList<Object> integral4_3) {
        this.integral4_3 = integral4_3;
    }

    public ArrayList<String> xarray3_2;
    public String input3_1_1;
    public Profile(int id, String name, String input1_1_1, String input1_1_2, String input1_1_3, String input1_1_4, String input1_1_5, String input1_2_1, String input1_2_2, String input1_3_1, boolean radio1_2_1, boolean radio1_3_1, ArrayList<String> xarray2_1, ArrayList<String> yarray2_1, ArrayList<String> xarray2_2) {
        this.id = id;
        this.name = name;
        this.input1_1_1 = input1_1_1;
        this.input1_1_2 = input1_1_2;
        this.input1_1_3 = input1_1_3;
        this.input1_1_4 = input1_1_4;
        this.input1_1_5 = input1_1_5;
        this.input1_2_1 = input1_2_1;
        this.input1_2_2 = input1_2_2;
        this.input1_3_1 = input1_3_1;
        this.radio1_2_1 = radio1_2_1;
        this.radio1_3_1 = radio1_3_1;
        this.xarray2_1 = xarray2_1;
        this.yarray2_1 = yarray2_1;
        this.xarray2_2 = xarray2_2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput1_1_1() {
        return input1_1_1;
    }

    public void setInput1_1_1(String input1_1_1) {
        this.input1_1_1 = input1_1_1;
    }

    public String getInput1_1_2() {
        return input1_1_2;
    }

    public void setInput1_1_2(String input1_1_2) {
        this.input1_1_2 = input1_1_2;
    }

    public String getInput1_1_3() {
        return input1_1_3;
    }

    public void setInput1_1_3(String input1_1_3) {
        this.input1_1_3 = input1_1_3;
    }

    public String getInput1_1_4() {
        return input1_1_4;
    }

    public void setInput1_1_4(String input1_1_4) {
        this.input1_1_4 = input1_1_4;
    }

    public String getInput1_1_5() {
        return input1_1_5;
    }

    public void setInput1_1_5(String input1_1_5) {
        this.input1_1_5 = input1_1_5;
    }

    public String getInput1_2_1() {
        return input1_2_1;
    }

    public void setInput1_2_1(String input1_2_1) {
        this.input1_2_1 = input1_2_1;
    }

    public String getInput1_2_2() {
        return input1_2_2;
    }

    public void setInput1_2_2(String input1_2_2) {
        this.input1_2_2 = input1_2_2;
    }

    public String getInput1_3_1() {
        return input1_3_1;
    }

    public void setInput1_3_1(String input1_3_1) {
        this.input1_3_1 = input1_3_1;
    }

    public boolean getRadio1_2_1() {
        return radio1_2_1;
    }

    public void setRadio1_2_1(boolean radio1_2_1) {
        this.radio1_2_1 = radio1_2_1;
    }

    public boolean getRadio1_3_1() {
        return radio1_3_1;
    }

    public void setRadio1_3_1(boolean radio1_3_1) {
        this.radio1_3_1 = radio1_3_1;
    }

    public ArrayList<String> getXarray2_1() {
        return xarray2_1;
    }

    public void setXarray2_1(ArrayList<String> xarray2_1) {
        this.xarray2_1 = xarray2_1;
    }

    public ArrayList<String> getYarray2_1() {
        return yarray2_1;
    }

    public void setYarray2_1(ArrayList<String> yarray2_1) {
        this.yarray2_1 = yarray2_1;
    }

    public ArrayList<String> getXarray2_2() {
        return xarray2_2;
    }

    public void setXarray2_2(ArrayList<String> xarray2_2) {
        this.xarray2_2 = xarray2_2;
    }
}
