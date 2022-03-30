package com.kykara4a.metod;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Build;
import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Unbinder unbinder;
    @BindView(R.id.linearOutput)
    LinearLayout linearOutput;

    LinearLayout.LayoutParams editTextParams;
    LinearLayout.LayoutParams editTextParams2;
    @BindView(R.id.linearTableMain)
    LinearLayout linearTableMain;

    @BindView(R.id.linearTableX)
    LinearLayout linearTableX;

    @BindView(R.id.linearTableY)
    LinearLayout linearTableY;
    @BindView(R.id.linearTables)
    LinearLayout linearTables;
    @BindView(R.id.linearTabl2)
    LinearLayout linearTabl2;
    @BindView(R.id.linearTabl2X)
    LinearLayout linearTabl2X;
    @BindView(R.id.buttonMinusThird)
    Button buttonMinus;
    @BindView(R.id.buttonPlusThird)
    Button buttonPlus;
    @BindView(R.id.buttonMinus2)
    Button buttonMinus2;
    @BindView(R.id.buttonPlus2)
    Button buttonPlus2;
    @BindView(R.id.button1)
    MaterialButton button1;
    @BindView(R.id.textViewN)
    TextView textViewN;
    @BindView(R.id.textViewN2)
    TextView textViewN2;
    @BindView(R.id.radioButtonVariant)
    RadioButton radioBurronVariant;
    @BindView(R.id.radioButtonTabl)
    RadioButton radioButtonTabl;
@BindView(R.id.inputVariant) TextInputEditText inputVariant;
    @BindView(R.id.editTextVariant)View editTextVariant;
    ArrayList<Double> xarray, yarray, xarray2;
    ArrayList<TextInputEditText> xarrayEditText, yarrayEditText, x2arrayEditText;
    ArrayList<ArrayList<Double>> deltas;
    Vibrator vibrator;
    View v;
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences sharedPreferences;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdLabFragment newInstance(String param1, String param2) {
        ThirdLabFragment fragment = new ThirdLabFragment();
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
        v = inflater.inflate(R.layout.fragment_third_lab, container, false);
        //unbinder = ButterKnife.bind(this, v);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        unbinder = ButterKnife.bind(this, v);
        xarrayEditText  = new ArrayList<TextInputEditText>();
        yarrayEditText  = new ArrayList<TextInputEditText>();
        x2arrayEditText  = new ArrayList<TextInputEditText>();


        // Inflate the layout for this fragment
        return v;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnCheckedChanged(R.id.radioButtonTabl)
    void onRadioButtonTablChecked(boolean checked){
        if (checked){
            editTextVariant.setVisibility(View.GONE);
            linearTables.setVisibility(View.VISIBLE);
        } else {
            editTextVariant.setVisibility(View.VISIBLE);
            linearTables.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.buttonMinusThird)
    void onButtonMinusClick(){
        String textN = textViewN.getText().toString().substring(2);
        int n = Integer.parseInt(textN)-1;
        if (n==2){
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus.setClickable(false);
        }
        int index = linearTableX.getChildCount()-1;
        deleteTablePoint(xarrayEditText, linearTableX, 1, 0);
        deleteTablePoint(yarrayEditText, linearTableY, 1, 1);
        textViewN.setText("n="+n);
    }
    @OnClick(R.id.buttonPlusThird)
    void onButtonPlusClick(){
        String textN = textViewN.getText().toString().substring(2);
        int n = Integer.parseInt(textN)+1;
        if (n==3){
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus.setClickable(true);
        }
        createTablePoint(xarrayEditText, linearTableX, 0, 0);
        createTablePoint(yarrayEditText, linearTableY, 0, 1);
        textViewN.setText("n="+n);
    }
    @OnClick(R.id.buttonPlus2)
    void onButtonPlus2Click(){
        String textN = textViewN2.getText().toString().substring(2);
        int n = Integer.parseInt(textN)+1;
        if (n==2){
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus2.setClickable(true);
        }
        createTablePoint(x2arrayEditText, linearTabl2X, 1, 1);
        textViewN2.setText("i="+n);
    }
    @OnClick(R.id.buttonMinus2)
    void onButtonMinus2Click(){
        String textN = textViewN2.getText().toString().substring(2);
        int n = Integer.parseInt(textN)-1;
        if (n==1){
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus2.setClickable(false);
        }
        deleteTablePoint(x2arrayEditText, linearTabl2X, 0, 0);
        textViewN2.setText("i="+n);
    }
    @OnClick(R.id.button1)
    void onButton1Click(){
        try {
            linearOutput.removeAllViews();
            xarray  = new ArrayList<Double>();
            yarray  = new ArrayList<Double>();
            xarray2  = new ArrayList<Double>();
            deltas = new ArrayList<ArrayList<Double>>();
            if (radioBurronVariant.isChecked()){
                int isChet = Integer.parseInt(inputVariant.getText().toString());
                if (isChet%2==0){
                    xarray.add(1.5);
                    xarray.add(2.0);
                    xarray.add(2.5);
                    xarray.add(3.0);
                    xarray.add(3.5);
                    xarray.add(4.0);
                    xarray.add(4.5);
                    xarray.add(5.0);
                    xarray.add(5.5);
                    xarray.add(6.0);
                    xarray.add(6.5);
                    xarray.add(7.0);
                    yarray.add(10.517);
                    yarray.add(10.193);
                    yarray.add(9.807);
                    yarray.add(9.387);
                    yarray.add(8.977);
                    yarray.add(8.637);
                    yarray.add(8.442);
                    yarray.add(8.482);
                    yarray.add(8.862);
                    yarray.add(9.701);
                    yarray.add(11.132);
                    yarray.add(13.302);
                    xarray2.add(0.08*isChet+1.6);
                    xarray2.add(6.3-(0.12*isChet));
                } else {
                    xarray.add(2.4);
                    xarray.add(2.6);
                    xarray.add(2.8);
                    xarray.add(3.0);
                    xarray.add(3.2);
                    xarray.add(3.4);
                    xarray.add(3.6);
                    xarray.add(3.8);
                    xarray.add(4.0);
                    xarray.add(4.2);
                    xarray.add(4.4);
                    xarray.add(4.6);
                    yarray.add(3.526);
                    yarray.add(3.782);
                    yarray.add(3.945);
                    yarray.add(4.043);
                    yarray.add(4.104);
                    yarray.add(4.155);
                    yarray.add(4.222);
                    yarray.add(4.331);
                    yarray.add(4.507);
                    yarray.add(4.775);
                    yarray.add(5.159);
                    yarray.add(5.683);
                    xarray2.add(0.05*isChet+2.4);
                    xarray2.add(4.04-(0.04*isChet));
                }
            } else {
                for (int i = 0; i < xarrayEditText.size(); i++) {
                    String text1 = xarrayEditText.get(i).getText().toString();
                    String text2 = yarrayEditText.get(i).getText().toString();
                    double xDB = Double.parseDouble(text1);
                    double yDB = Double.parseDouble(text2);
                    xarray.add(xDB);
                    yarray.add(yDB);
                }
                for (int j = 0; j < x2arrayEditText.size();j++){
                    String text1 = x2arrayEditText.get(j).getText().toString();
                    double xDB = Double.parseDouble(text1);
                    xarray2.add(xDB);
                }
            }
            deltas.add(yarray);
            for (int j = 1; j < xarray.size(); j++){
                ArrayList<Double> arrayList = new ArrayList<Double>();
                for (int k = 0; k < deltas.get(j-1).size()-1; k++){
                    arrayList.add(deltas.get(j-1).get(k+1)-deltas.get(j-1).get(k));
                }
                deltas.add(arrayList);
            }
            for (int k = 0; k < xarray2.size(); k++){
                int n = -1;
                int deltasLineCounter = 1;
                ArrayList<Double> deltasLine = new ArrayList<>();
                for (int l = 0; l < yarray.size(); l ++){
                    if (l<yarray.size()/2){
                        if (!(xarray2.get(k)>xarray.get(l))&&!(xarray2.get(k)<xarray.get(l))){
                            n = l;
                            break;
                        } else
                        if (xarray2.get(k)<xarray.get(l)){
                            n = l-1;
                            break;
                        }
                    } else {
                        System.out.println(xarray.get(xarray.size()+(xarray.size()/2)-l-1));
                        if (!(xarray2.get(k)>(xarray.get(xarray.size()+(xarray.size()/2)-l-1)))&&!(xarray2.get(k)<(xarray.get(xarray.size()+(xarray.size()/2)-l-1)))){
                            n = xarray.size()+(xarray.size()/2)-l-1;
                            break;
                        } else
                        if (xarray2.get(k)>xarray.get(xarray.size()+(xarray.size()/2)-l-1)){
                            n = xarray.size()+(xarray.size()/2)-l-1;
                            break;
                        }
                    }
                }
                if (n==-1){
                    n = xarray.size()/2;
                }
                ArrayList<ArrayList<Double>> koefs = new ArrayList<ArrayList<Double>>();
                if (n <yarray.size()/2) {
                    System.out.println("less");
                    while (deltas.get(deltasLineCounter).size() > n) {
                        deltasLine.add(deltas.get(deltasLineCounter).get(n));
                        if (deltas.size()-1>deltasLineCounter){
                            deltasLineCounter += 1;
                        } else {
                            break;
                        }
                    }
                    koefs = getKoefs(deltasLine, 0);
                } else {
                    System.out.println("more");
                    for (int g = 0; g < n; g++){
                        deltasLine.add(deltas.get(g+1).get(n-g-1));
                    }
                    koefs = getKoefs(deltasLine, 1);
                }
                ArrayList<ArrayList<Double>> derivative1 = getDerivative(koefs);
                ArrayList<ArrayList<Double>> derivative2 = getDerivative(derivative1);
                Double h = xarray.get(1)-xarray.get(0);
                Double q = (xarray2.get(k)-xarray.get(n))/h;
                Double derivativeDouble1 = getDerivativeSumm(derivative1, h, deltasLine, q, 1);
                Double derivativeDouble2 = getDerivativeSumm(derivative2, h, deltasLine, q, 2);
                String text = "y'("+round(xarray2.get(k))+")≈ "+round(derivativeDouble1) +", y''("+round(xarray2.get(k))+")≈ "+round(derivativeDouble2);
                TextView textView1 = new TextView(getContext());
                textView1.setTextSize(20);
                textView1.setText(text);
                linearOutput.addView(textView1);
            }
            linearOutput.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            vibro();
        Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<ArrayList<Double>> getKoefs(ArrayList<Double> deltasLine, int tableType){
        ArrayList<ArrayList<Double>> koefList = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < deltasLine.size(); i++){
            ArrayList<Double> tempKoefs = new ArrayList<>();
            for (Double j = 0.0; j < i+1.0; j++){
                if (tableType == 0){
                    tempKoefs.add(-j);
                } else {
                    tempKoefs.add(j);
                }
            }
            ArrayList<Double> koefLine = new ArrayList<>();
            koefLine.add(1.0/getFactorial(i+1));
            for (int n = 1; n < tempKoefs.size()+1; n++){
                int combinations = getFactorial(tempKoefs.size())/(getFactorial(n)*getFactorial(tempKoefs.size()-n));
                ArrayList<Integer> indexes = new ArrayList<>();
                for (int m = 0; m < n; m++){
                    indexes.add(m);
                }
                int tempCoef = 0;

                for (int k = 0; k < combinations; k++){
                    int tempCoef1 = 1;
                    for (int g = 0; g <n; g++){
                        tempCoef1*= tempKoefs.get(indexes.get(g));
                    }
                    int zCounter=0;
                    for (int l = 0; l < indexes.size(); l++){
                        if (indexes.get(indexes.size()-1-l) == tempKoefs.size()-1-zCounter){
                            if (l!=indexes.size()-1){
                                zCounter+=1;
                            }
                        } else {
                            indexes.set(indexes.size()-1-l, indexes.get(indexes.size()-1-l)+1);
                            break;
                        }
                    }
                    for (int z = 0; z < zCounter; z++){
                        indexes.set(indexes.size()-zCounter+z, indexes.get(indexes.size()-zCounter-1+z)+1);
                    }
                    tempCoef+=tempCoef1;
                }
                koefLine.add((tempCoef*1.0/getFactorial(i+1)));
            }
            koefList.add(koefLine);

        }
        return koefList;
    }
    private static String round(double value) {

        long factor = (long) Math.pow(10, 3);
        value = value * factor;
        long tmp = Math.round(value);
        String newValue = String.valueOf((double) tmp / factor);
        boolean notIntValue = false;
        if (newValue.contains(".")){
            notIntValue = true;
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
    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
    public ArrayList<ArrayList<Double>> getDerivative(ArrayList<ArrayList<Double>> koefs){
        ArrayList<ArrayList<Double>> derivative = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < koefs.size(); i++){
            ArrayList<Double> derivativeLine = new ArrayList<>();
            for (int j = 0; j < koefs.get(i).size(); j++){
                if (j!=koefs.get(i).size()-1) {
                    Double koef = koefs.get(i).get(j);
                    derivativeLine.add(koef * (koefs.get(i).size() - j - 1));
                }
            }
            derivative.add(derivativeLine);
        }
        return derivative;
    }
    public Double getDerivativeSumm(ArrayList<ArrayList<Double>> koefs, Double h, ArrayList<Double> deltasLine, Double q, int dev){
        Double tempKoef2 = 0.0;
        for (int i = 0; i < deltasLine.size(); i++){
            Double tempKoef = 0.0;
            for (int j = 0; j < koefs.get(i).size(); j++){
                if (koefs.get(i).size()-1-j!=0){
                    tempKoef+= Math.pow(q, koefs.get(i).size()-1-j) *koefs.get(i).get(j);
                } else {
                    tempKoef+= koefs.get(i).get(j);
                }
            }
            tempKoef*=deltasLine.get(i);
            System.out.println(tempKoef);
            tempKoef2+=tempKoef;
        }
        System.out.println("---------");
        if (dev == 1){
            return (tempKoef2)/h;
        } else {
            return (tempKoef2)/Math.pow(h, 2);
        }
    }
    public  String getFormula(ArrayList<ArrayList<Double>> koefs){
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
        String text3 = getResources().getString(R.string.formula) + ": ";
        for (int q = 0; q<koefs.size(); q++){
            for (int k = 0; k < koefs.get(q).size(); k++){
                if (!round(koefs.get(q).get(k)).equals("0")) {


                    if (k == koefs.get(q).size() - 1) {
                        if (k != 0) {
                            if (round(koefs.get(q).get(k)).startsWith("-")) {
                                text3 += round(koefs.get(q).get(k));
                            } else {
                                text3 += "+" + round(koefs.get(q).get(k));
                            }
                        } else {
                            text3 += round(koefs.get(q).get(k));
                        }
                    } else if (k == koefs.get(q).size() - 2) {
                        if (k != 0) {
                            if (round(koefs.get(q).get(k)).equals("1")) {
                                text3 += "+x";
                            } else if (round(koefs.get(q).get(k)).equals("-1")) {
                                text3 += "-x";
                            } else if (round(koefs.get(q).get(k)).startsWith("-")) {
                                text3 += round(koefs.get(q).get(k)) + "x";
                            } else {
                                text3 += "+" + round(koefs.get(q).get(k)) + "x";
                            }
                        } else {
                            if (round(koefs.get(q).get(k)).equals("1")) {
                                text3 += "x";
                            } else if (round(koefs.get(q).get(k)).equals("-1")) {
                                text3 += "-x";
                            } else if (round(koefs.get(q).get(k)).startsWith("-")) {
                                text3 += round(koefs.get(q).get(k)) + "x";
                            } else {
                                text3 += round(koefs.get(q).get(k)) + "x";
                            }
                        }
                    } else {
                        if (k != 0) {
                            if (round(koefs.get(q).get(k)).equals("1")) {
                                text3 += "+x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else if (round(koefs.get(q).get(k)).equals("-1")) {
                                text3 += "-x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else if (round(koefs.get(q).get(k)).startsWith("-")) {
                                text3 += round(koefs.get(q).get(k)) + "x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else {
                                text3 += "+" + round(koefs.get(q).get(k)) + "x" + (powers.get(koefs.get(q).size() - 1 - k));
                            }
                        } else {
                            if (round(koefs.get(q).get(k)).equals("1")) {
                                text3 += "x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else if (round(koefs.get(q).get(k)).equals("-1")) {
                                text3 += "-x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else if (round(koefs.get(q).get(k)).startsWith("-")) {
                                text3 += round(koefs.get(q).get(k)) + "x" + (powers.get(koefs.get(q).size() - 1 - k));
                            } else {
                                text3 += round(koefs.get(q).get(k)) + "x" + (powers.get(koefs.get(q).size() - 1 - k));
                            }
                        }
                    }
                }


            }
            text3+="|";
        }
        return text3;
    }
    public void vibro(){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(200);
        }
    }
    public Profile getData(Profile profile){
        ArrayList<String> xarray2_1 = new ArrayList<>();
        ArrayList<String> xarray2_2 = new ArrayList<>();
        ArrayList<String> yarray2_1 = new ArrayList<>();
        boolean radio1 = radioBurronVariant.isChecked();
        String textVariant = inputVariant.getText().toString();
        for (int i = 0; i < xarrayEditText.size(); i++){
            xarray2_1.add(xarrayEditText.get(i).getText().toString());
            yarray2_1.add(yarrayEditText.get(i).getText().toString());
        }
        for (int i = 0; i < x2arrayEditText.size(); i++){
            xarray2_2.add(x2arrayEditText.get(i).getText().toString());
        }
        profile.xarray3_1 = xarray2_1;
        profile.yarray3_1 = yarray2_1;
        profile.xarray3_2 = xarray2_2;
        profile.radio3_1_1 = radio1;
        profile.input3_1_1 = textVariant;
        return profile;
    }

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();
        ArrayList<String> xarray = new ArrayList<>();
        ArrayList<String> xarray2 = new ArrayList<>();
        ArrayList<String> yarray = new ArrayList<>();
        boolean radio1 = radioBurronVariant.isChecked();
        String textVariant = inputVariant.getText().toString();
        for (int i = 0; i < xarrayEditText.size(); i++){
            xarray.add(xarrayEditText.get(i).getText().toString());
            yarray.add(yarrayEditText.get(i).getText().toString());
        }
        for (int i = 0; i < x2arrayEditText.size(); i++){
            xarray2.add(x2arrayEditText.get(i).getText().toString());
        }
        currentProfile.xarray3_1 = xarray;
        currentProfile.xarray3_2 = xarray2;
        currentProfile.yarray3_1 = yarray;
        currentProfile.radio3_1_1 = radio1;
        currentProfile.input3_1_1 = textVariant;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson1 = new Gson();
        String json1 = gson1.toJson(currentProfile);
        editor.putString("currentProfileThird", json1);
        editor.apply();
    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileThird", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();
        if (currentProfile.xarray3_1!=null) {
            createTablePoints(currentProfile.xarray3_1.size(), xarrayEditText, linearTableX, 0, 0);
            createTablePoints(currentProfile.xarray3_1.size(), yarrayEditText, linearTableY, 0, 1);
            for (int i = 0; i < currentProfile.xarray3_1.size(); i++){
                xarrayEditText.get(i).setText(currentProfile.xarray3_1.get(i));
                yarrayEditText.get(i).setText(currentProfile.yarray3_1.get(i));
            }
        } else {
            createTablePoints(4, xarrayEditText, linearTableX, 0, 0);
            createTablePoints(4, yarrayEditText, linearTableY, 0, 1);
        }
        if (currentProfile.xarray3_2!= null){
            createTablePoints(currentProfile.xarray3_2.size(), x2arrayEditText, linearTabl2X, 1, 0);
            for (int i = 0; i < currentProfile.xarray3_2.size(); i++){
                x2arrayEditText.get(i).setText(currentProfile.xarray3_2.get(i));
            }
        } else {
            createTablePoints(2, x2arrayEditText, linearTabl2X, 1, 0);
        }

        textViewN2.setText("i="+(x2arrayEditText.size()));
        textViewN.setText("n="+(xarrayEditText.size()));
        if (x2arrayEditText.size()==1){
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus2.setClickable(false);
        } else {
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus2.setClickable(true);
        }
        if (xarrayEditText.size()==2){
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus.setClickable(false);
        } else {
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus.setClickable(true);
        }
        inputVariant.setText(currentProfile.input3_1_1);
        if (currentProfile.radio3_1_1){
            radioBurronVariant.setChecked(true);
        } else {
            radioButtonTabl.setChecked(true);
        }
    }
    public void createTablePoint(ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type, int side){
        TextInputEditText textInputEditTextX = new TextInputEditText(getContext());
        if (type ==1){
            editTextParams= new LinearLayout.LayoutParams(
                    200,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            editTextParams.setMargins(3, 0, 0, 0);
            editTextParams2 = new LinearLayout.LayoutParams(
                    200,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            editTextParams2.setMargins(3, 0, 3, 0);
        } else {
            editTextParams2= new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            editTextParams= new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            if (side==0){
                editTextParams.setMargins(0, 3, 3, 0);
                editTextParams2.setMargins(0, 3, 3, 3);
            } else {
                editTextParams.setMargins(3, 3, 0, 0);
                editTextParams2.setMargins(3, 3, 0, 3);
            }

        }
        textInputEditTextX.setGravity(Gravity.CENTER);
        textInputEditTextX.setLayoutParams(editTextParams);
        if (layout.getChildCount()!=1) {
            layout.getChildAt(layout.getChildCount() - 1).setLayoutParams(editTextParams2);
        }
        textInputEditTextX.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED|
                InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);
        textInputEditTextX.setBackgroundColor(getResources().getColor(R.color.white));
        layout.addView(textInputEditTextX, editTextParams);
        arrayEditText.add(textInputEditTextX);
    }
    public void deleteTablePoint(ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type, int side){
        int index = layout.getChildCount()-1;
        layout.removeViewAt(index);
        if (type==0){
            editTextParams2= new LinearLayout.LayoutParams(
                    200,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            editTextParams2.setMargins(3, 0, 0, 0);
        } else {
            editTextParams2= new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            if (side ==0) {
                editTextParams2.setMargins(0, 3, 3, 0);
            } else {
                editTextParams2.setMargins(3, 3, 0, 0);
            }
        }
        layout.getChildAt(index-1).setLayoutParams(editTextParams2);
        arrayEditText.remove(arrayEditText.size()-1);
    }
    public void createTablePoints(int x, ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type, int side){
        if (x < arrayEditText.size()){
            int size = arrayEditText.size();
            for (int i = 0; i < size-x; i++){
                deleteTablePoint(arrayEditText, layout, type, side);
            }
        } else if (x > arrayEditText.size()){
            int size = arrayEditText.size();
            for (int i = 0; i < x-size; i++){
                createTablePoint(arrayEditText, layout, type, side);
            }
        }
    }
}