package com.kykara4a.metod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.mtp.MtpConstants;
import android.os.Build;
import android.os.Bundle;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FivethLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FivethLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.keyboardLayout1)
    LinearLayout keyboardLayout1;
    @BindView(R.id.keyboardButton1)
    MaterialButton keyboardButton1;
    @BindView(R.id.keyboardButton2)
    MaterialButton keyboardButton2;
    @BindView(R.id.keyboardButton3)
    MaterialButton keyboardButton3;
    @BindView(R.id.keyboardButton4)
    MaterialButton keyboardButton4;
    @BindView(R.id.keyboardButton5)
    MaterialButton keyboardButton5;
    @BindView(R.id.keyboardButton6)
    MaterialButton keyboardButton6;
    @BindView(R.id.keyboardButton7)
    MaterialButton keyboardButton7;
    @BindView(R.id.keyboardButton8)
    MaterialButton keyboardButton8;
    @BindView(R.id.keyboardButton9)
    MaterialButton keyboardButton9;
    @BindView(R.id.keyboardButton10)
    MaterialButton keyboardButton10;
    @BindView(R.id.keyboardButton11)
    MaterialButton keyboardButton11;
    @BindView(R.id.keyboardButton12)
    MaterialButton keyboardButton12;
    @BindView(R.id.keyboardButton13)
    MaterialButton keyboardButton13;
    @BindView(R.id.keyboardButton14)
    MaterialButton keyboardButton14;
    @BindView(R.id.keyboardButton15)
    MaterialButton keyboardButton15;
    @BindView(R.id.keyboardButton16)
    MaterialButton keyboardButton16;
    @BindView(R.id.keyboardButton17)
    MaterialButton keyboardButton17;
    @BindView(R.id.keyboardButton18)
    MaterialButton keyboardButton18;
    @BindView(R.id.keyboardButton19)
    MaterialButton keyboardButton19;
    @BindView(R.id.keyboardButton20)
    MaterialButton keyboardButton20;
    @BindView(R.id.button1)
    MaterialButton button1;
    Vibrator vibrator;
    @BindView(R.id.motionLayout)
    MotionLayout motionLayout;
    @BindView(R.id.textView5_2)
    TextView textView;
    @BindView(R.id.keyboardButton0)
    MaterialButton keyboardButton0;
    @BindView(R.id.graph)
    GraphView graph;
    @BindView(R.id.input5_1)
    TextInputEditText input5_1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    SharedPreferences sharedPreferences;
    private Unbinder unbinder;
    public FivethLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FivethLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FivethLabFragment newInstance(String param1, String param2) {
        FivethLabFragment fragment = new FivethLabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fiveth_lab, container, false);
        unbinder = ButterKnife.bind(this, v);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        input5_1.setShowSoftInputOnFocus(false);
        input5_1.requestFocus();
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        input5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.hasFocus()){
                    motionLayout.transitionToStart();
                    setClicableKeyboard(true);
                }
            }
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick(R.id.keyboardButton0)
    void OnClick0(){

        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) input5_1.getText();


            selection.replace(cursorPos - 1, cursorPos, "");
            input5_1.setText(selection);
            input5_1.setSelection(cursorPos - 1);
            return;

        }


    }
    @OnClick(R.id.keyboardButton1)
    void OnClick1(){
        updateText(".");
    }
    @OnClick(R.id.keyboardButton2)
    void OnClick2(){

        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();
        if (cursorPos != 0 && textLen != 0) {

            input5_1.setSelection(cursorPos - 1);
        }
    }
    @OnClick(R.id.keyboardButton3)
    void OnClick3(){

        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();
        if (cursorPos != textLen) {

            input5_1.setSelection(cursorPos + 1);
        }
    }
    @OnClick(R.id.keyboardButton4)
    void OnClick4(){
        updateText("7");
    }

    @OnClick(R.id.keyboardButton5)
    void OnClick5(){
        updateText("8");
    }
    @OnClick(R.id.keyboardButton6)
    void OnClick6(){
        updateText("9");

    }
    @OnClick(R.id.keyboardButton7)
    void OnClick7(){
        SpannableStringBuilder selection = (SpannableStringBuilder) input5_1.getText();
        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();
        if (cursorPos == 0 ){
            return;
        } else if ( selection.subSequence(cursorPos - 1, cursorPos).toString().equals("(")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("+")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("-")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals(".")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("×")){
            return;

        }  else
        {
            updateText("²");
        }
    }
    @OnClick(R.id.keyboardButton8)
    void OnClick8(){
        updateText("4");
    }
    @OnClick(R.id.keyboardButton9)
    void OnClick9(){
        updateText("5");
    }
    @OnClick(R.id.keyboardButton10)
    void OnClick10(){
        updateText("6");
    }
    @OnClick(R.id.keyboardButton11)
    void OnClick12(){
        SpannableStringBuilder selection = (SpannableStringBuilder) input5_1.getText();
        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();
        if (cursorPos == 0 ){
            return;
        } else if ( selection.subSequence(cursorPos - 1, cursorPos).toString().equals("(")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("+")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("-")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals(".")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("×")){
            return;

        }  else
        {
            updateText(getString(R.string.three));
        }
    }
    @OnClick(R.id.keyboardButton12)
    void OnClick13(){
        updateText("1");
    }
    @OnClick(R.id.keyboardButton13)
    void OnClick14(){
        updateText("2");
    }
    @OnClick(R.id.keyboardButton14)
    void OnClick15(){
        updateText("3");
    }
    @OnClick(R.id.keyboardButton15)
    void OnClick16(){
        SpannableStringBuilder selection = (SpannableStringBuilder) input5_1.getText();
        int cursorPos = input5_1.getSelectionStart();
        int textLen = input5_1.getText().length();
        if (cursorPos == 0 ){
            return;
        } else if ( selection.subSequence(cursorPos - 1, cursorPos).toString().equals("(")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("+")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("-")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals(".")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("×")){
            return;

        }  else
        {
            updateText(getString(R.string.four));
        }
    }
    @OnClick(R.id.keyboardButton16)
    void OnClick17(){
        updateText("X");
    }
    @OnClick(R.id.keyboardButton17)
    void OnClick18(){
        updateText("0");
    }
    @OnClick(R.id.keyboardButton18)
    void OnClick19(){
        updateText("-");
    }
    @OnClick(R.id.keyboardButton19)
    void OnClick20(){
        updateText("+");
    }

    @OnClick(R.id.keyboardButton20)
    void OnClick21(){
        updateText("=");
    }

    private void updateText(String strToAdd){

        String oldStr = input5_1.getText().toString();
        int cursorPos = input5_1.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if ((!strToAdd.equals(")"))&&strToAdd.endsWith(")")){
            cursorPos-=1;
        }
        input5_1.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        input5_1.setSelection(cursorPos + strToAdd.length());




    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileFifth", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    public Profile getData(Profile currentProfile){
        currentProfile.input5_1 = input5_1.getText().toString();
        return currentProfile;
    }
    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();
        if (currentProfile.input5_1!=null) {
            input5_1.setText(currentProfile.input5_1);
            input5_1.setSelection(input5_1.getText().toString().length());
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();

        currentProfile.input5_1 = input5_1.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson2 = new Gson();
        String json2 = gson2.toJson(currentProfile);
        editor.putString("currentProfileFifth", json2);
        editor.apply();
    }

    @OnClick(R.id.button1)
    void onClickButton1(){
        try {
            textView.setText("");

            String text = input5_1.getText().toString();
            ArrayList<Double> koefs = new ArrayList<>();
            ArrayList<Double> roots = new ArrayList<>();
            HashMap<Integer, Double> koefsDict = new HashMap<>();
            String[] koefsTemp;
            String textTemp = text;
            textTemp = textTemp.replaceAll("²", "^2");
            textTemp = textTemp.replaceAll("³", "^3");
            textTemp = textTemp.replaceAll("⁴", "^4");
            for (int i = 0; i < textTemp.length() - 1; i++) {
                String letter1 = String.valueOf(textTemp.charAt(i));
                if (letter1.equals("-") || letter1.equals("+")) {
                    textTemp = textTemp.substring(0, i) + " " + textTemp.substring(i);
                    i++;
                }
            }
            String[] parts = textTemp.split("=");
            String[] koefsAfter = parts[1].split(" ");
            for (int i = 0; i < koefsAfter.length; i++) {
                if (koefsAfter[i].startsWith("+")) {
                    koefsAfter[i] = "-" + koefsAfter[i].substring(1);
                } else if (koefsAfter[i].startsWith("-")) {
                    koefsAfter[i] = "+" + koefsAfter[i].substring(1);
                } else if (!(koefsAfter[i].startsWith("+") || koefsAfter[i].startsWith("-"))) {
                    koefsAfter[i] = "-" + koefsAfter[i];
                }
            }
            koefsTemp = parts[0].split(" ");
            String[] koefsTempAll = (String[]) Array.newInstance(koefsTemp.getClass().getComponentType(), koefsTemp.length + koefsAfter.length);
            System.arraycopy(koefsTemp, 0, koefsTempAll, 0, koefsTemp.length);
            System.arraycopy(koefsAfter, 0, koefsTempAll, koefsTemp.length, koefsAfter.length);
            int power = 0;
            for (int i = 0; i < koefsTempAll.length; i ++){
                if (koefsTempAll[i].startsWith("+X")){
                    koefsTempAll[i] = "+1X" + koefsTempAll[i].substring(2);
                } else if (koefsTempAll[i].startsWith("-X")){
                    koefsTempAll[i] = "-1X" + koefsTempAll[i].substring(2);
                } else if (koefsTempAll[i].startsWith("X")){
                    koefsTempAll[i] = "+1X" + koefsTempAll[i].substring(1);
                }
            }
            for (String i : koefsTempAll) {

                if (i.contains("X^")) {
                    int index = i.indexOf("^");
                    if (Integer.parseInt(String.valueOf(i.charAt(index + 1))) > power) {
                        power = Integer.parseInt(String.valueOf(i.charAt(index + 1)));

                    }
                    if (koefsDict.containsKey(Integer.parseInt(String.valueOf(i.charAt(index + 1))))) {
                        koefsDict.put(Integer.parseInt(String.valueOf(i.charAt(index + 1))), Double.parseDouble(i.substring(0, index - 1)) + koefsDict.get(Integer.parseInt(String.valueOf(i.charAt(index + 1)))));
                    } else {
                        koefsDict.put(Integer.parseInt(String.valueOf(i.charAt(index + 1))), Double.parseDouble(i.substring(0, index - 1)));
                    }
                } else if (i.contains("X")) {
                    int index = i.indexOf("X");
                    if (1 > power) {
                        power = 1;

                    }
                    if (koefsDict.containsKey(1)) {
                        koefsDict.put(1, Double.parseDouble(i.substring(0, index)) + koefsDict.get(1));
                    } else {
                        koefsDict.put(1, Double.parseDouble(i.substring(0, index)));
                    }
                } else if (i.matches("\\+?\\-?\\d*\\.?\\d+")) {
                    if (0 > power) {
                        power = 0;

                    }
                    if (koefsDict.containsKey(0)) {
                        koefsDict.put(0, Double.parseDouble(i) + koefsDict.get(0));
                    } else {
                        koefsDict.put(0, Double.parseDouble(i));
                    }
                }
            }

            for (int i = power; i >= 0; i--) {

                if (koefsDict.containsKey(i)) {
                    koefs.add(koefsDict.get(i));
                } else {
                    koefs.add(0.0);
                }
            }

            ArrayList<Double> derrKoefs = getDerivative(koefs);
            String text3 = getResources().getString(R.string.derivative)+": ";
            ArrayList<String> powers2 = new ArrayList<>();
            ArrayList<String> powers = new ArrayList<>();
            powers2.add("⁰");
            powers2.add("¹");
            powers2.add("²");
            powers2.add("³");
            powers2.add("⁴");
            powers2.add("⁵");
            powers2.add("⁶");
            powers2.add("⁷");
            powers2.add("⁸");
            powers2.add("⁹");
            for (int k =0; k < 100; k++){
                if (k>9){
                    powers.add(powers2.get((int) k/10)+powers2.get(k%10));
                } else {
                    powers.add(powers2.get(k));
                }
            }
            for (int k = 0; k < derrKoefs.size(); k++){
                if (!round(derrKoefs.get(k)).equals("0")) {


                    if (k == derrKoefs.size() - 1) {
                        if (k != 0) {
                            if (round(derrKoefs.get(k)).startsWith("-")) {
                                text3 += round(derrKoefs.get(k));
                            } else {
                                text3 += "+" + round(derrKoefs.get(k));
                            }
                        } else {
                            text3 += round(derrKoefs.get(k));
                        }
                    } else if (k == derrKoefs.size() - 2) {
                        if (k != 0) {
                            if (round(derrKoefs.get(k)).equals("1")) {
                                text3 += "+x";
                            } else if (round(derrKoefs.get(k)).equals("-1")) {
                                text3 += "-x";
                            } else if (round(derrKoefs.get(k)).startsWith("-")) {
                                text3 += round(derrKoefs.get(k)) + "x";
                            } else {
                                text3 += "+" + round(derrKoefs.get(k)) + "x";
                            }
                        } else {
                            if (round(derrKoefs.get(k)).equals("1")) {
                                text3 += "x";
                            } else if (round(derrKoefs.get(k)).equals("-1")) {
                                text3 += "-x";
                            } else if (round(derrKoefs.get(k)).startsWith("-")) {
                                text3 += round(derrKoefs.get(k)) + "x";
                            } else {
                                text3 += round(derrKoefs.get(k)) + "x";
                            }
                        }
                    } else {
                        if (k != 0) {
                            if (round(derrKoefs.get(k)).equals("1")) {
                                text3 += "+x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else if (round(derrKoefs.get(k)).equals("-1")) {
                                text3 += "-x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else if (round(derrKoefs.get(k)).startsWith("-")) {
                                text3 += round(derrKoefs.get(k)) + "x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else {
                                text3 += "+" + round(derrKoefs.get(k)) + "x" + (powers.get(derrKoefs.size() - 1 - k));
                            }
                        } else {
                            if (round(derrKoefs.get(k)).equals("1")) {
                                text3 += "x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else if (round(derrKoefs.get(k)).equals("-1")) {
                                text3 += "-x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else if (round(derrKoefs.get(k)).startsWith("-")) {
                                text3 += round(derrKoefs.get(k)) + "x" + (powers.get(derrKoefs.size() - 1 - k));
                            } else {
                                text3 += round(derrKoefs.get(k)) + "x" + (powers.get(derrKoefs.size() - 1 - k));
                            }
                        }
                    }
                }


            }
            text3+="=0";
            textView.setText(text3);



            if (derrKoefs.size()>3){
                double dKoef = derrKoefs.get(derrKoefs.size()-1);
                double aKoef = derrKoefs.get(0);

                    if (dKoef == (int) dKoef || aKoef == (int) aKoef) {
                        int dKoefInt = (int) dKoef;
                        int aKoefInt = (int) aKoef;
                        ArrayList<Integer> dDividers = getDividers(dKoefInt);
                        ArrayList<Integer> aDividers = getDividers(aKoefInt);
                        boolean breakFlag = false;
                        double firstX = 0;
                        for (int d : dDividers) {
                            for (int a : aDividers) {
                                double x = (double) d / (double) a;
                                double result = getEquationValue(derrKoefs, x);

                                if (Double.parseDouble(round(result)) == 0) {
                                    firstX = x;
                                    breakFlag = true;
                                    break;
                                }
                            }
                            if (breakFlag) {
                                break;
                            }
                        }

                        roots.add(firstX);
                        ArrayList<Double> koefsOfNewEquation = new ArrayList<>();
                        ArrayList<Double> derrKoefsTemp = new ArrayList<>(derrKoefs);

                        for (int i = 1; i < derrKoefsTemp.size(); i++) {
                            double leftKoef = derrKoefsTemp.get(i - 1);
                            koefsOfNewEquation.add(leftKoef);
                            derrKoefsTemp.set(i, derrKoefsTemp.get(i) - (leftKoef * (-firstX)));
                        }
                        if (koefsOfNewEquation.size() == 3) {
                            roots = getSecondDegreeEquation(roots, koefsOfNewEquation);
                        }
                    } else {
                        System.out.println("dKoef or aKoef not int, error");
                    }
            } else if (derrKoefs.size()==3){
                roots = getSecondDegreeEquation(roots, derrKoefs);
            } else if (derrKoefs.size()==2){

                roots.add(-derrKoefs.get(1)/derrKoefs.get(0));
            }
            String textWithRoots = textView.getText().toString();
            textWithRoots += "\n"+getResources().getString(R.string.derivative_roots)+": ";
            ArrayList<String> lowers2 = new ArrayList<>();
            ArrayList<String> lowers = new ArrayList<>();
            lowers2.add(getResources().getString(R.string.zero_low));
            lowers2.add(getResources().getString(R.string.one_low));
            lowers2.add(getResources().getString(R.string.two_low));
            lowers2.add(getResources().getString(R.string.three_low));
            lowers2.add(getResources().getString(R.string.four_low));
            lowers2.add(getResources().getString(R.string.five_low));
            lowers2.add(getResources().getString(R.string.six_low));
            lowers2.add(getResources().getString(R.string.seven_low));
            lowers2.add(getResources().getString(R.string.eight_low));
            lowers2.add(getResources().getString(R.string.nine_low));
            for (int k = 0; k < 100; k++) {
                if (k > 9) {
                    lowers.add(lowers2.get((int) k / 10) + lowers2.get(k % 10));
                } else {
                    lowers.add(lowers2.get(k));
                }
            }
            Collections.sort(roots);
            if (roots.size()!=0) {
                for (int i = 0; i < roots.size(); i++) {
                    System.out.println("x" + lowers.get(roots.size() - 1 - i) + "= " + roots.get(i));
                    textWithRoots += "x" + lowers.get(i) + "= " + round(roots.get(i));
                    if (i != roots.size() - 1) {
                        textWithRoots += ", ";
                    }
                }
            } else {
                textWithRoots+=getResources().getString(R.string.no_roots);
            }
            textView.setText(textWithRoots);
            ArrayList<Boolean> signs = new ArrayList<>();
            roots.add(-1000000.0);
            roots.add(1000000.0);
            Collections.sort(roots);
            for (double i : roots) {
                double rootValue = getEquationValue(koefs, i);
                signs.add(!(rootValue < 0));
            }

            String textNeuton = getResources().getString(R.string.newton)+": ";
            String textBisec = getResources().getString(R.string.bisection)+": ";
            String textGaps = getResources().getString(R.string.root_boundaries)+": ";
            ArrayList<Double> xArrayPoints = new ArrayList<>();
            int counter = 0;
            for (int i = 1; i < signs.size(); i++) {
                if ((signs.get(i) && (!signs.get(i - 1))) || (!signs.get(i) && (signs.get(i - 1)))) {
                    if (roots.get(i - 1) == -1000000.0) {
                        double leftGapBorder = roots.get(i) - 1;
                        while (true) {
                            double leftGapBorderValue = getEquationValue(koefs, leftGapBorder);
                            if ((leftGapBorderValue < 0 && !signs.get(i - 1)) || (leftGapBorderValue >= 0 && signs.get(i - 1))) {
                                roots.set(i - 1, leftGapBorder);
                                break;
                            } else {
                                leftGapBorder--;
                                roots.set(i, roots.get(i)-1);
                            }
                        }
                    }
                    if (roots.get(i) == 1000000.0) {
                        double rightGapBorder = roots.get(i - 1) + 1;
                        while (true) {
                            double rightGapBorderValue = getEquationValue(koefs, rightGapBorder);
                            if ((rightGapBorderValue < 0 && !signs.get(i)) || (rightGapBorderValue >= 0 && signs.get(i))) {
                                roots.set(i, rightGapBorder);
                                break;
                            } else {
                                rightGapBorder++;
                                roots.set(i-1, roots.get(i-1)+1);
                            }
                        }
                    }
                    textGaps += "[" + round(roots.get(i - 1)) + "; " + round(roots.get(i)) + "], ";
                    //---------------Метод Ньютона----------
                    ArrayList<Double> secondDerrKoefs = getDerivative(derrKoefs);
                    double secondDerrLeftValue = getEquationValue(secondDerrKoefs, roots.get(i - 1));
                    double startValueNeuton = 0;
                    if ((secondDerrLeftValue < 0 && !signs.get(i - 1)) || (secondDerrLeftValue >= 0 && signs.get(i - 1))) {
                        startValueNeuton = roots.get(i - 1);
                    } else {
                        startValueNeuton = roots.get(i);
                    }
                    double valueNeuton = startValueNeuton;
                    double equationValue = getEquationValue(koefs, valueNeuton);
                    double derrEquationValue = getEquationValue(derrKoefs, valueNeuton);
                    if (derrEquationValue != 0) {
                        while (Math.abs(equationValue) >= 0.0001) {
                            valueNeuton = valueNeuton - (equationValue / derrEquationValue);
                            equationValue = getEquationValue(koefs, valueNeuton);
                            derrEquationValue = getEquationValue(derrKoefs, valueNeuton);
                        }
                        textNeuton += "x" + lowers.get(counter) + "= " + round(valueNeuton) + ", ";
                        System.out.println("value= " + valueNeuton);
                    } else {
                        textNeuton += "x" + lowers.get(counter) +" " +getResources().getString(R.string.cant_calc_by_newton)+", ";
                        System.out.println("startValue is root of derr equation, error");
                    }

                    //----------------Метод бисекций-----------------------------------
                    double leftBorder = roots.get(i - 1);
                    double rightBorder = roots.get(i);
                    double middle = (leftBorder + rightBorder) / 2;
                    double middleEquationValue = getEquationValue(koefs, middle);
                    double gap = Math.abs(leftBorder - rightBorder);
                    while (gap >= 0.0002) {
                        if (middleEquationValue * getEquationValue(koefs, leftBorder) > 0) {
                            leftBorder = middle;
                        } else {
                            rightBorder = middle;
                        }
                        middle = (leftBorder + rightBorder) / 2;
                        middleEquationValue = getEquationValue(koefs, middle);
                        gap = Math.abs(leftBorder - rightBorder);
                    }
                    textBisec += "x" + lowers.get(counter) + "= " + round(middle) + ", ";
                    counter += 1;
                    xArrayPoints.add(Double.valueOf(round(middle)));
                }
            }
            if (textNeuton.endsWith(", ")) {
                textNeuton = textNeuton.substring(0, textNeuton.length() - 2);
            }
            if (textGaps.endsWith(", ")) {
                textGaps = textGaps.substring(0, textGaps.length() - 2);
            }
            if (textBisec.endsWith(", ")) {
                textBisec = textBisec.substring(0, textBisec.length() - 2);
            }
            try {
                String lastText = textView.getText().toString();
                lastText += "\n" + textGaps + "\n" + textNeuton + "\n" + textBisec;
                textView.setText(lastText);
                input5_1.clearFocus();
                setClicableKeyboard(false);
                ArrayList<Double> xarray = new ArrayList<>();
                ArrayList<Double> yarray = new ArrayList<>();
                ArrayList<Double> yArrayPoints = new ArrayList<>();
                double minY = getEquationValue(koefs, xArrayPoints.get(0));
                double maxY = getEquationValue(koefs, xArrayPoints.get(0));
                for (double j = xArrayPoints.get(0) - 3; j < xArrayPoints.get(xArrayPoints.size() - 1) + 3; j += 0.1f) {
                    xarray.add(j);
                    double y = getEquationValue(koefs, j);
                    if (y < minY) {
                        minY = y;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                    yarray.add(y);
                }
                DataPoint[] dataPoints = new DataPoint[xarray.size()]; // declare an array of DataPoint objects with the same size as your list
                for (int i = 0; i < xarray.size(); i++) {
                    // add new DataPoint object to the array for each of your list entries
                    dataPoints[i] = new DataPoint(xarray.get(i), yarray.get(i)); // not sure but I think the second argument should be of type double
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
                DataPoint[] dataPoints2 = new DataPoint[xArrayPoints.size()]; // declare an array of DataPoint objects with the same size as your list
                for (int i = 0; i < xArrayPoints.size(); i++) {
                    // add new DataPoint object to the array for each of your list entries
                    yArrayPoints.add(0.0);
                    dataPoints2[i] = new DataPoint(xArrayPoints.get(i), yArrayPoints.get(i)); // not sure but I think the second argument should be of type double
                }
                PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(dataPoints2);
                graph.removeAllSeries();
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setMinY(minY - 2);
                graph.getViewport().setMaxY(10.0);
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(xArrayPoints.get(0) - 1);
                graph.getViewport().setMaxX(xArrayPoints.get(xArrayPoints.size() - 1) + 2);
                series.setColor(getResources().getColor(R.color.colorAccent));
                series1.setColor(getResources().getColor(R.color.colorAccent));
                graph.addSeries(series);
                graph.addSeries(series1);
                series1.setShape(PointsGraphSeries.Shape.POINT);
                double finalMinY = minY-2;
                double finalMaxY = maxY;
                graph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(getActivity(), GraphActivity.class);
                            intent.putExtra("xarray", xarray);
                            intent.putExtra("yarray", yarray);
                            intent.putExtra("xarrayNew", xArrayPoints);
                            intent.putExtra("yarrayNew", yArrayPoints);
                            intent.putExtra("minY", finalMinY );
                            intent.putExtra("maxY", 10.0);
                            intent.putExtra("minX", xArrayPoints.get(0) - 1 );
                            intent.putExtra("maxX", xArrayPoints.get(xArrayPoints.size() - 1) + 2 );
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(getActivity(), (View) graph, "profile");
                            startActivity(intent, options.toBundle());
                        } catch (NullPointerException e) {

                        }
                    }
                });
                motionLayout.transitionToEnd();
            } catch (IndexOutOfBoundsException e){
                vibro();
                Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();

            }









        } catch (NumberFormatException e) {
            vibro();
            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }

    }

    public ArrayList<Integer> getDividers(int x){
        ArrayList<Integer> dividers = new ArrayList<>();
        if (x < 0) {
            x = -x;
        }
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                dividers.add(i);
                dividers.add(-i);
            }
        }
        return dividers;
    }

    public void vibro(){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(200);
        }
    }

    public ArrayList<Double> getDerivative(ArrayList<Double> koefs){
        ArrayList<Double> derivative = new ArrayList<Double>();
        for (int i = 0; i < koefs.size(); i++){
                if (i!=koefs.size()-1) {
                    Double koef = koefs.get(i);
                    derivative.add(koef * (koefs.size() - i - 1));
                }

        }
        return derivative;
    }
    private static String round(double value) {
        long factor = (long) Math.pow(10, 4);
        value = value * factor;
        long tmp = Math.round(value);
        String newValue = String.valueOf((double) tmp / factor);
        boolean notIntValue = false;
        if (newValue.contains(".")){
            notIntValue = true;
        }
        if (newValue.contains("E")){
            String[] temp = newValue.split("E");
            int tempInt = Integer.parseInt(temp[1]);
            System.out.println(tempInt);
            for (int i = 0; i < -tempInt; i++){
                temp[0]="0"+temp[0];
            }
            temp[0]=temp[0].replace(".", "");
            temp[0] = temp[0].substring(0, 1) + "." + temp[0].substring(1);
            newValue = temp[0];
        }
        while ((newValue.endsWith("0")&&notIntValue)||newValue.endsWith(".")){
            if (newValue.length()!=1){
                newValue = newValue.substring(0, newValue.length()-1);
            }
            if (!newValue.contains(".")){
                notIntValue = false;
            }

        }
        return newValue;

    }
    public double getEquationValue(ArrayList<Double> koefs, double x){
        double result = 0;
        for (int l = 0; l < koefs.size(); l ++){
            int index = koefs.size()-1-l;
            double koefTemp = koefs.get(l);
            result+=(koefTemp*Math.pow(x, index));
        }
        return  result;
    }
    public void setClicableKeyboard(boolean isBool){
        keyboardButton2.setClickable(isBool);
        keyboardButton3.setClickable(isBool);
        keyboardButton0.setClickable(isBool);
        keyboardButton15.setClickable(isBool);
        keyboardButton11.setClickable(isBool);
        keyboardButton7.setClickable(isBool);
        keyboardButton4.setClickable(isBool);
        keyboardButton5.setClickable(isBool);
        keyboardButton6.setClickable(isBool);
        keyboardButton8.setClickable(isBool);
        keyboardButton9.setClickable(isBool);
        keyboardButton10.setClickable(isBool);
        keyboardButton12.setClickable(isBool);
        keyboardButton13.setClickable(isBool);
        keyboardButton14.setClickable(isBool);
        keyboardButton16.setClickable(isBool);
        keyboardButton17.setClickable(isBool);
        keyboardButton1.setClickable(isBool);
        keyboardButton18.setClickable(isBool);
        keyboardButton19.setClickable(isBool);
        keyboardButton20.setClickable(isBool);



    }
    public ArrayList<Double> getSecondDegreeEquation(ArrayList<Double> roots, ArrayList<Double> koefs){
        double D = Math.pow(koefs.get(1), 2) - (4 * koefs.get(0) * koefs.get(2));
        if (D >= 0) {
            double x1 = (-koefs.get(1) + Math.sqrt(D)) / (2 * koefs.get(0));
            double x2 = (-koefs.get(1) - Math.sqrt(D)) / (2 * koefs.get(0));
            roots.add(x1);
            roots.add(x2);
        }
        return roots;
    }
}