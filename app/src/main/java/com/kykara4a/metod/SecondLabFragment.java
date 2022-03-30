package com.kykara4a.metod;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Bundle;
import android.content.SharedPreferences;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.InputType;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.aghajari.graphview.AXGraphCanvas;
import com.aghajari.graphview.AXGraphFormula;
import com.aghajari.graphview.AXGraphOptions;
import com.aghajari.graphview.AXGraphPointType;
import com.aghajari.graphview.AXGraphView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import im.dacer.androidcharts.LineView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextInputEditText input1, input2, input3, input4, input5, input6, input7, input8, input9, input10, input11, input12;
    Button button1, buttonMinus, buttonPlus, buttonMinus2, buttonPlus2;
    ArrayList <Double> xarray, xarray2;
    ArrayList<TextInputEditText> xarrayEditText;
    ArrayList<TextInputEditText> yarrayEditText;
    ArrayList<TextInputEditText> xarrayEditText2;
    Vibrator vibrator;
    ArrayList <Double> yarray, xarrayBig, yarrayBig, xarrayNew, yarrayNew, yarraySort;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView21, textViewN, textViewN2;
    View.OnClickListener onClickListener1;
    CardView cardView;
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences sharedPreferences;
    LinearLayout layoutX, layoutY, layoutX2, linearOutput;
    GraphView graph;
    TableRow tableRowX, tableRowY;
    double minY, maxY;
    RadioButton radioButton2A, radioButton2B, radioButton3A, radioButton3B;
    View v;
    public SecondLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondLabFragment newInstance(String param1, String param2) {
        SecondLabFragment fragment = new SecondLabFragment();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second_lab, container, false);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        textView1 = (TextView) v.findViewById(R.id.textView1);
        textView2 = (TextView) v.findViewById(R.id.textView2);
        textView3 = (TextView) v.findViewById(R.id.textView3);
        textView4 = (TextView) v.findViewById(R.id.textView4);
        textView5 = (TextView) v.findViewById(R.id.textView5);
        textViewN = (TextView) v.findViewById(R.id.textViewN);
        textViewN2 = (TextView) v.findViewById(R.id.textViewN2);
        button1 = (Button) v.findViewById(R.id.button1);
        buttonMinus = (Button) v.findViewById(R.id.buttonMinus);
        buttonPlus = (Button) v.findViewById(R.id.buttonPlus);
        buttonMinus2 = (Button) v.findViewById(R.id.buttonMinus2);
        buttonPlus2 = (Button) v.findViewById(R.id.buttonPlus2);
        cardView = (CardView) v.findViewById(R.id.cardview);
        layoutX = (LinearLayout) v.findViewById(R.id.layoutX);
        layoutX2 = (LinearLayout) v.findViewById(R.id.layoutX2);
        layoutY = (LinearLayout) v.findViewById(R.id.layoutY);
        linearOutput = (LinearLayout) v.findViewById(R.id.linearOutput);
        xarrayEditText  = new ArrayList<TextInputEditText>();
        yarrayEditText  = new ArrayList<TextInputEditText>();
        xarrayEditText2  = new ArrayList<TextInputEditText>();

        graph = (GraphView) v.findViewById(R.id.graph);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-15);
        graph.getViewport().setMaxY(15);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-15);
        graph.getViewport().setMaxX(15);
        graph.getViewport().setScrollable(false); // enables horizontal scrolling
        graph.getViewport().setScrollableY(false); // enables vertical scrolling
        graph.getViewport().setScalable(false); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(false); // enables vertical zooming and scrolling

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textN = textViewN.getText().toString().substring(2);
                int n = Integer.parseInt(textN)-1;
                if (n==1){
                    buttonMinus.setBackgroundColor(getResources().getColor(R.color.grey));
                    buttonMinus.setClickable(false);
                }
                deleteTablePoint(xarrayEditText, layoutX,0);
                deleteTablePoint(yarrayEditText, layoutY,1);
                textViewN.setText("n="+n);

            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textN = textViewN.getText().toString().substring(2);
                int n = Integer.parseInt(textN)+1;
                if (n==2){
                    buttonMinus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    buttonMinus.setClickable(true);
                }
                createTablePoint(xarrayEditText, layoutX,0);
                createTablePoint(yarrayEditText, layoutY,1);
                textViewN.setText("n="+n);
            }
        });
        buttonMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textN = textViewN2.getText().toString().substring(2);
                int n = Integer.parseInt(textN)-1;
                if (n==1){
                    buttonMinus2.setBackgroundColor(getResources().getColor(R.color.grey));
                    buttonMinus2.setClickable(false);
                }
                deleteTablePoint(xarrayEditText2, layoutX2,2);
                textViewN2.setText("i="+n);

            }
        });
        buttonPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textN = textViewN2.getText().toString().substring(2);
                int n = Integer.parseInt(textN)+1;
                if (n==2){
                    buttonMinus2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    buttonMinus2.setClickable(true);
                }
                createTablePoint(xarrayEditText2, layoutX2,2);
                textViewN2.setText("i="+n);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    linearOutput.removeAllViews();
                    xarray  = new ArrayList<Double>();
                    yarray  = new ArrayList<Double>();
                    xarray2  = new ArrayList<Double>();
                    xarrayNew  = new ArrayList<Double>();
                    yarrayNew  = new ArrayList<Double>();
                    xarrayBig  = new ArrayList<Double>();
                    yarrayBig  = new ArrayList<Double>();
                    for (int i = 0; i < layoutX.getChildCount()-1; i++){
                        String text1 = xarrayEditText.get(i).getText().toString();
                        String text2 = yarrayEditText.get(i).getText().toString();
                        double xDB = Double.parseDouble(text1);
                        double yDB = Double.parseDouble(text2);
                        xarray.add(xDB);
                        yarray.add(yDB);

                    }
                    ArrayList<Double> koef = getFormula(xarray, yarray);
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
                    for (int k = 0; k < koef.size(); k++){
                        if (!round(koef.get(k)).equals("0")) {


                            if (k == koef.size() - 1) {
                                if (k != 0) {
                                    if (round(koef.get(k)).startsWith("-")) {
                                        text3 += round(koef.get(k));
                                    } else {
                                        text3 += "+" + round(koef.get(k));
                                    }
                                } else {
                                    text3 += round(koef.get(k));
                                }
                            } else if (k == koef.size() - 2) {
                                if (k != 0) {
                                    if (round(koef.get(k)).equals("1")) {
                                        text3 += "+x";
                                    } else if (round(koef.get(k)).equals("-1")) {
                                        text3 += "-x";
                                    } else if (round(koef.get(k)).startsWith("-")) {
                                        text3 += round(koef.get(k)) + "x";
                                    } else {
                                        text3 += "+" + round(koef.get(k)) + "x";
                                    }
                                } else {
                                    if (round(koef.get(k)).equals("1")) {
                                        text3 += "x";
                                    } else if (round(koef.get(k)).equals("-1")) {
                                        text3 += "-x";
                                    } else if (round(koef.get(k)).startsWith("-")) {
                                        text3 += round(koef.get(k)) + "x";
                                    } else {
                                        text3 += round(koef.get(k)) + "x";
                                    }
                                }
                            } else {
                                if (k != 0) {
                                    if (round(koef.get(k)).equals("1")) {
                                        text3 += "+x" + (powers.get(koef.size() - 1 - k));
                                    } else if (round(koef.get(k)).equals("-1")) {
                                        text3 += "-x" + (powers.get(koef.size() - 1 - k));
                                    } else if (round(koef.get(k)).startsWith("-")) {
                                        text3 += round(koef.get(k)) + "x" + (powers.get(koef.size() - 1 - k));
                                    } else {
                                        text3 += "+" + round(koef.get(k)) + "x" + (powers.get(koef.size() - 1 - k));
                                    }
                                } else {
                                    if (round(koef.get(k)).equals("1")) {
                                        text3 += "x" + (powers.get(koef.size() - 1 - k));
                                    } else if (round(koef.get(k)).equals("-1")) {
                                        text3 += "-x" + (powers.get(koef.size() - 1 - k));
                                    } else if (round(koef.get(k)).startsWith("-")) {
                                        text3 += round(koef.get(k)) + "x" + (powers.get(koef.size() - 1 - k));
                                    } else {
                                        text3 += round(koef.get(k)) + "x" + (powers.get(koef.size() - 1 - k));
                                    }
                                }
                            }
                        }


                    }
                    TextView textView1 = new TextView(getContext());
                    textView1.setTextSize(20);
                    textView1.setText(text3);
                    linearOutput.addView(textView1);

                    for (int i = 0; i < layoutX2.getChildCount()-1; i++){
                        String text1 = xarrayEditText2.get(i).getText().toString();
                        double xDB = Double.parseDouble(text1);
                        xarray2.add(xDB);
                        TextView textView = new TextView(getContext());
                        double result = getPoint(xDB, xarray, yarray);
                        String text = "f(" + xDB+") = "+ round(result);
                        textView.setText(text);
                        linearOutput.addView(textView);
                    }




                    xarrayNew = new ArrayList<>(xarray);
                    xarrayNew.addAll(xarray2);
                    Collections.sort(xarrayNew);
                    for (double j = xarrayNew.get(0)-1; j < xarrayNew.get(xarrayNew.size()-1)+1; j+=0.1f){
                        xarrayBig.add(j);
                        double y = getPoint(j, xarray, yarray);
                        yarrayBig.add(y);

                    }
                    DataPoint[] dataPoints = new DataPoint[xarrayBig.size()]; // declare an array of DataPoint objects with the same size as your list
                    for (int i = 0; i < xarrayBig.size(); i++) {
                        // add new DataPoint object to the array for each of your list entries
                        dataPoints[i] = new DataPoint(xarrayBig.get(i), yarrayBig.get(i)); // not sure but I think the second argument should be of type double
                    }
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
                    DataPoint[] dataPoints2 = new DataPoint[xarrayNew.size()]; // declare an array of DataPoint objects with the same size as your list
                    for (int i = 0; i < xarrayNew.size(); i++) {
                        // add new DataPoint object to the array for each of your list entries
                        yarrayNew.add(getPoint(xarrayNew.get(i), xarray, yarray));
                        dataPoints2[i] = new DataPoint(xarrayNew.get(i), yarrayNew.get(i)); // not sure but I think the second argument should be of type double
                    }
                    PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(dataPoints2);

                    yarraySort = new ArrayList<>(yarrayNew);
                    Collections.sort(yarraySort);
                    double minY = yarraySort.get(0)-2;
                    double maxY = yarraySort.get(yarraySort.size()-1)+2;
                    graph.removeAllSeries();
                    graph.getViewport().setYAxisBoundsManual(true);
                    graph.getViewport().setMinY(minY);
                    graph.getViewport().setMaxY(maxY);
                    graph.getViewport().setXAxisBoundsManual(true);
                    graph.getViewport().setMinX(xarrayNew.get(0)-1);
                    graph.getViewport().setMaxX(xarrayNew.get(xarrayNew.size()-1)+2);
                    series.setColor(getResources().getColor(R.color.colorAccent));
                    series1.setColor(getResources().getColor(R.color.colorAccent));
                    graph.addSeries(series);
                    graph.addSeries(series1);
                    series1.setShape(PointsGraphSeries.Shape.POINT);
                    cardView.setVisibility(View.VISIBLE);
                    graph.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent(getActivity(), GraphActivity.class);
                                intent.putExtra("xarray", xarrayBig);
                                intent.putExtra("yarray", yarrayBig);
                                intent.putExtra("xarrayNew", xarrayNew);
                                intent.putExtra("yarrayNew", yarrayNew);
                                intent.putExtra("minY", minY);
                                intent.putExtra("maxY", maxY);
                                intent.putExtra("minX", xarrayNew.get(0)-1 );
                                intent.putExtra("maxX", xarrayNew.get(xarrayNew.size()-1)+2 );
                                ActivityOptionsCompat options = ActivityOptionsCompat.
                                        makeSceneTransitionAnimation(getActivity(), (View)graph, "profile");
                                startActivity(intent, options.toBundle());
                            }catch (NullPointerException e){

                            }

                        }
                    });
                } catch (NumberFormatException e) {
                    vibro();
                    Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                    graph.setOnClickListener(null);
                }
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    public double getPoint(double x, ArrayList<Double> xlist, ArrayList<Double> ylist){

        double y = 0f;
        for (int i = 0; i < xlist.size(); i++){
            double tempY = ylist.get(i);
            for (int j = 0; j < xlist.size(); j++) {
                if (i != j) {
                    tempY *= (x - xlist.get(j)) / (xlist.get(i) - xlist.get(j));
                }
            }
            y+= tempY;
        }
        return y;
    }
    public ArrayList<Double> getFormula(ArrayList<Double> xlist, ArrayList<Double> ylist){
        ArrayList<Double> koefList = new ArrayList<>();
        for (int i = 0; i < xlist.size(); i++){
            double tempY = ylist.get(i);
            for (int j = 0; j < xlist.size(); j++) {
                if (i != j) {
                    tempY *= 1 / (xlist.get(i) - xlist.get(j));
                }
            }
            if (koefList.size()>=1){
                koefList.set(0, koefList.get(0)+1*tempY);
            } else {
                koefList.add((double) 1*tempY);
            }
            ArrayList<Double> xListLocal = new ArrayList<>();
            for (int t = 0; t < xlist.size(); t++){
                if (i != t) {
                    xListLocal.add(-xlist.get(t));
                }
            }
            for (int n = 1; n < xlist.size(); n++){
                int combinations = getFactorial(xListLocal.size())/(getFactorial(n)*getFactorial(xListLocal.size()-n));
                ArrayList<Integer> indexes = new ArrayList<>();
                for (int m = 0; m < n; m++){
                    indexes.add(m);
                }
                int tempCoef = 0;

                for (int k = 0; k < combinations; k++){
                    int tempCoef1 = 1;
                    for (int g = 0; g <n; g++){
                        tempCoef1*= xListLocal.get(indexes.get(g));
                    }
                    int zCounter=0;
                    for (int l = 0; l < indexes.size(); l++){
                            if (indexes.get(indexes.size()-1-l) == xListLocal.size()-1-zCounter){
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
                if (koefList.size()>n){
                    koefList.set(n, koefList.get(n)+tempCoef*tempY);
                } else {
                    koefList.add(tempCoef*tempY);
                }
            }
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
    public Profile getData(Profile profile){
        ArrayList<String> xarray2_1 = new ArrayList<>();
        ArrayList<String> xarray2_2 = new ArrayList<>();
        ArrayList<String> yarray2_1 = new ArrayList<>();
        for (int i = 0; i < xarrayEditText.size(); i++){
            xarray2_1.add(xarrayEditText.get(i).getText().toString());
            yarray2_1.add(yarrayEditText.get(i).getText().toString());
        }
        for (int i = 0; i < xarrayEditText2.size(); i++){
            xarray2_2.add(xarrayEditText2.get(i).getText().toString());
        }
        profile.xarray2_1 = xarray2_1;
        profile.yarray2_1 = yarray2_1;
        profile.xarray2_2 = xarray2_2;
        return profile;
    }

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();
        ArrayList<String> xarray = new ArrayList<>();
        ArrayList<String> xarray2 = new ArrayList<>();
        ArrayList<String> yarray = new ArrayList<>();
        for (int i = 0; i < xarrayEditText.size(); i++){
            xarray.add(xarrayEditText.get(i).getText().toString());
            yarray.add(yarrayEditText.get(i).getText().toString());
        }
        for (int i = 0; i < xarrayEditText2.size(); i++){
            xarray2.add(xarrayEditText2.get(i).getText().toString());
        }
        currentProfile.xarray2_1 = xarray;
        currentProfile.xarray2_2 = xarray2;
        currentProfile.yarray2_1 = yarray;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson1 = new Gson();
        String json1 = gson1.toJson(currentProfile);
        editor.putString("currentProfileSecond", json1);
        editor.apply();
    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileSecond", null);
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
        if (currentProfile.xarray2_1!=null) {
            createTablePoints(currentProfile.xarray2_1.size(), xarrayEditText, layoutX, 0);
            createTablePoints(currentProfile.xarray2_1.size(), yarrayEditText, layoutY,1);
            for (int i = 0; i < currentProfile.xarray2_1.size(); i++){
                xarrayEditText.get(i).setText(currentProfile.xarray2_1.get(i));
                yarrayEditText.get(i).setText(currentProfile.yarray2_1.get(i));
            }
        } else {
            createTablePoints(4, xarrayEditText, layoutX,0);
            createTablePoints(4, yarrayEditText, layoutY,1);
        }
        if (currentProfile.xarray2_2!= null){
            createTablePoints(currentProfile.xarray2_2.size(), xarrayEditText2, layoutX2,2);
            for (int i = 0; i < currentProfile.xarray2_2.size(); i++){
                xarrayEditText2.get(i).setText(currentProfile.xarray2_2.get(i));
            }
        } else {
            createTablePoints(2, xarrayEditText2, layoutX2,2);
        }

        textViewN2.setText("i="+(xarrayEditText2.size()));
        textViewN.setText("n="+(xarrayEditText.size()-1));
        if (xarrayEditText2.size()==1){
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
    }
    public void createTablePoint(ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type){
        TextInputEditText textInputEditTextX = new TextInputEditText(getContext());
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(
                200,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams editTextParams2 = new LinearLayout.LayoutParams(
                200,
                LinearLayout.LayoutParams.MATCH_PARENT);
        if (type==0){
            editTextParams.setMargins(3, 0, 0, 3);
            editTextParams2.setMargins(3, 0, 3, 3);
        } else if (type==1){
            editTextParams.setMargins(3, 3, 0, 0);
            editTextParams2.setMargins(3, 3, 3, 0);
        } else {
            editTextParams.setMargins(3, 0, 0, 0);
            editTextParams2.setMargins(3, 0, 3, 0);
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
    public void deleteTablePoint(ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type){
        int index = layout.getChildCount()-1;
        layout.removeViewAt(index);
        LinearLayout.LayoutParams editTextParams2 = new LinearLayout.LayoutParams(
                200,
                LinearLayout.LayoutParams.MATCH_PARENT);
        if (type==0){
            editTextParams2.setMargins(3, 0, 0, 3);
        } else if (type==1){
            editTextParams2.setMargins(3, 3, 0, 0);
        } else {
            editTextParams2.setMargins(3, 0, 0, 0);
        }
        layout.getChildAt(index-1).setLayoutParams(editTextParams2);
        arrayEditText.remove(arrayEditText.size()-1);
    }
    public void createTablePoints(int x, ArrayList<TextInputEditText> arrayEditText, LinearLayout layout, int type){
        if (x < arrayEditText.size()){
            int size = arrayEditText.size();
            for (int i = 0; i < size-x; i++){
                deleteTablePoint(arrayEditText, layout, type);
            }
        } else if (x > arrayEditText.size()){
            int size = arrayEditText.size();
            for (int i = 0; i < x-size; i++){
                createTablePoint(arrayEditText, layout,type);
            }
        }
    }
    public void vibro(){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(200);
        }
    }
}