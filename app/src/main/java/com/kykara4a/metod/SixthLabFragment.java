package com.kykara4a.metod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import org.mariuszgromada.math.mxparser.Expression;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SixthLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SixthLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.cardGraph)
    CardView cardGraph;
    @BindView(R.id.graph)
    GraphView graph;
    @BindView(R.id. radioButton6_1)
    RadioButton radio6_1;
    @BindView(R.id. radioButton6_2)
    RadioButton radio6_2;
    @BindView(R.id.motionLayout)
    MotionLayout motionLayout;
    @BindView(R.id.input6_1)
    TextInputEditText input1;
    @BindView(R.id.input6_2)
    TextInputEditText input2;
    @BindView(R.id.input6_3)
    TextInputEditText input3;
    LinearLayout.LayoutParams editTextParamsI;
    LinearLayout.LayoutParams editTextParamsX;
    LinearLayout.LayoutParams editTextParamsY;
    @BindView(R.id.input6_5)
    TextInputEditText input5;
    @BindView(R.id.input6_6)
    TextInputEditText input6;
    @BindView(R.id.input6_7)
    TextInputEditText input7;
    @BindView(R.id.input6_8)
    TextInputEditText input8;
    @BindView(R.id.button6_1)
    MaterialButton button1;
    @BindView(R.id.input6_10)
    TextInputEditText input10;
    @BindView(R.id.cos_sin1)
    Spinner spinner1;
    @BindView(R.id.cos_sin2)
    Spinner spinner2;

    @BindView(R.id.textView6_1)
    TextView textView1;
    @BindView(R.id.textView6_2)
    TextView textView2;
    @BindView(R.id.tableI)
    LinearLayout tableI;
    @BindView(R.id.tableX)
    LinearLayout tableX;
    @BindView(R.id.tableY)
    LinearLayout tableY;
    @BindView(R.id.table)
    CardView table;
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
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    SharedPreferences sharedPreferences;
    private Unbinder unbinder;

    Vibrator vibrator;
    TextInputEditText currentET;
    public SixthLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SixthLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SixthLabFragment newInstance(String param1, String param2) {
        SixthLabFragment fragment = new SixthLabFragment();
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
        v = inflater.inflate(R.layout.fragment_sixth_lab, container, false);
        unbinder = ButterKnife.bind(this, v);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        input1.setShowSoftInputOnFocus(false);
        input2.setShowSoftInputOnFocus(false);
        input3.setShowSoftInputOnFocus(false);

        input5.setShowSoftInputOnFocus(false);
        input6.setShowSoftInputOnFocus(false);
        input7.setShowSoftInputOnFocus(false);
        input8.setShowSoftInputOnFocus(false);

        input10.setShowSoftInputOnFocus(false);
        currentET = input1;
        currentET.requestFocus();
        motionLayout.addTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                if(motionLayout.getCurrentState()==R.id.state_1_1){
                    if (currentET!=input1&&currentET!=input2&&currentET!=input3&&currentET!=input5) {
                        input1.requestFocus();
                    }
                } else if (motionLayout.getCurrentState()==R.id.state_2_1){

                    if (currentET!=input6&&currentET!=input7&&currentET!=input8&&currentET!=input10) {
                        input6.requestFocus();
                    }
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
        radio6_1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                motionLayout.transitionToState(R.id.state_1_1);
            }
        });

        radio6_2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                motionLayout.transitionToState(R.id.state_2_1);
            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView1.setText(input2.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView2.setText(input7.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){

                motionLayout.transitionToState(R.id.state_1_1);
                currentET = input1;

                setClicableKeyboard(true);

            }
        });
        input2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_1_1);

                currentET = input2;
                setClicableKeyboard(true);
            }
        });
        input3.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_1_1);
                currentET = input3;
                setClicableKeyboard(true);
            }
        });

        input5.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_1_1);
                currentET = input5;
                setClicableKeyboard(true);
            }
        });
        input6.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){

                currentET = input6;
                motionLayout.transitionToState(R.id.state_2_1);

                setClicableKeyboard(true);
            }
        });
        input7.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_2_1);
                currentET = input7;
                setClicableKeyboard(true);
            }
        });
        input8.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_2_1);
                currentET = input8;
                setClicableKeyboard(true);
            }
        });

        input10.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus){
                motionLayout.transitionToState(R.id.state_2_1);
                currentET = input10;
                setClicableKeyboard(true);
            }
        });
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        return v;
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
    private void updateText(String strToAdd){

        String oldStr = currentET.getText().toString();
        int cursorPos = currentET.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if ((!strToAdd.equals(")"))&&strToAdd.endsWith(")")){
            cursorPos-=1;
        }
        currentET.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        currentET.setSelection(cursorPos + strToAdd.length());




    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileSixth", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    public Profile getData(Profile currentProfile){
        currentProfile.input6_1 = input1.getText().toString();
        currentProfile.input6_2 = input2.getText().toString();
        currentProfile.input6_3 = input3.getText().toString();

        currentProfile.input6_5 = input5.getText().toString();
        currentProfile.input6_6 = input6.getText().toString();
        currentProfile.input6_7 = input7.getText().toString();
        currentProfile.input6_8 = input8.getText().toString();

        currentProfile.input6_10 = input10.getText().toString();
        currentProfile.radio6 = radio6_1.isChecked();
        currentProfile.spinner6_1 = spinner1.getSelectedItem().toString().equals("sin");
        currentProfile.spinner6_2 = spinner2.getSelectedItem().toString().equals("sin");
        return currentProfile;
    }
    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();

        input1.setText(currentProfile.input6_1);
        input2.setText(currentProfile.input6_2);
        input3.setText(currentProfile.input6_3);

        input5.setText(currentProfile.input6_5);
        input6.setText(currentProfile.input6_6);
        input7.setText(currentProfile.input6_7);
        input8.setText(currentProfile.input6_8);

        input10.setText(currentProfile.input6_10);



        if (currentProfile.spinner6_1){
            spinner1.setSelection(0);
        } else {
            spinner1.setSelection(1);
        }
        if (currentProfile.spinner6_2){
            spinner2.setSelection(0);
        } else {
            spinner2.setSelection(1);
        }
        if (currentProfile.radio6) {

            radio6_1.setChecked(true);


        } else {

            radio6_2.setChecked(true);

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();

        currentProfile.input6_1 = input1.getText().toString();
        currentProfile.input6_2 = input2.getText().toString();
        currentProfile.input6_3 = input3.getText().toString();

        currentProfile.input6_5 = input5.getText().toString();
        currentProfile.input6_6 = input6.getText().toString();
        currentProfile.input6_7 = input7.getText().toString();
        currentProfile.input6_8 = input8.getText().toString();

        currentProfile.input6_10 = input10.getText().toString();
        currentProfile.spinner6_1 = spinner1.getSelectedItem().toString().equals("sin");
        currentProfile.spinner6_2 = spinner2.getSelectedItem().toString().equals("sin");
        currentProfile.radio6 = radio6_1.isChecked();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson2 = new Gson();
        String json2 = gson2.toJson(currentProfile);
        editor.putString("currentProfileSixth", json2);
        editor.apply();
    }
    @OnClick(R.id.button6_1)
    void onButtonClick(){
        try {
            double step = 0.1;
            double x;
            double y;
            double lastValue;
            boolean cos_sin;
            String numerator;
            if (radio6_1.isChecked()){
                x = Double.parseDouble(input2.getText().toString());
                y = Double.parseDouble(input3.getText().toString());
                lastValue = Double.parseDouble(input5.getText().toString());
                cos_sin = spinner1.getSelectedItem().toString().equals("sin");
                numerator = input1.getText().toString();
            } else {
                x = Double.parseDouble(input7.getText().toString());
                y = Double.parseDouble(input8.getText().toString());
                lastValue = Double.parseDouble(input10.getText().toString());
                cos_sin = spinner2.getSelectedItem().toString().equals("sin");
                numerator = input6.getText().toString();
            }
            ArrayList<Double> arrayX = new ArrayList<>();
            ArrayList<Double> arrayY = new ArrayList<>();


            while (tableI.getChildCount()>1){
                deleteTablePoint();
            }
            createTablePoint(arrayX, arrayY, x, y);

            while (x < lastValue){


                String exp = x +" + ";
                if (cos_sin){
                    exp += "sin(";
                } else {
                    exp += "cos(";
                }
                exp += y + "/" + numerator + ")";


                exp = y + "+" + step + "*(" + exp + ")";
                if (radio6_2.isChecked()){
                    String oldExp = exp;
                    exp = y + "+" + step/2 +"*(" + x + "+";
                    if (cos_sin){
                        exp += "sin(";
                    } else {
                        exp += "cos(";
                    }
                    exp = exp  +y + "/"+ numerator+ ")+" + round(x+step) + "+";
                    if (cos_sin){
                        exp += "sin(";
                    } else {
                        exp += "cos(";
                    }
                    exp = exp + "(" + oldExp +")/" + numerator + "))";
                }
                exp = exp.replaceAll("√", "sqrt");
                exp = exp.replaceAll("π", "pi");
                System.out.println(exp);
                Expression expression = new Expression(exp);
                String result = String.valueOf(expression.calculate());
                x = Double.parseDouble(round(x+step));
                y = Double.parseDouble(result);

                createTablePoint(arrayX, arrayY, x, y);
                String print = "x=" + x+ ", y=" +y;
                System.out.println(print);

            }
            DataPoint[] dataPoints = new DataPoint[arrayX.size()]; // declare an array of DataPoint objects with the same size as your list
            for (int i = 0; i < arrayX.size(); i++) {
                // add new DataPoint object to the array for each of your list entries
                dataPoints[i] = new DataPoint(arrayX.get(i), arrayY.get(i)); // not sure but I think the second argument should be of type double
            }
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
            DataPoint[] dataPoints2 = new DataPoint[arrayX.size()];
            Double minY = arrayY.get(0);
            Double maxY = arrayY.get(0);
            for (int i = 0; i < arrayX.size(); i++) {
                if (arrayY.get(i) < minY){
                    minY = arrayY.get(i);
                }
                if (arrayY.get(i) > maxY){
                    maxY = arrayY.get(i);
                }
                // add new DataPoint object to the array for each of your list entries
                dataPoints2[i] = new DataPoint(arrayX.get(i), arrayY.get(i)); // not sure but I think the second argument should be of type double
            }
            PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(dataPoints2);
            graph.removeAllSeries();
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(minY-1);
            graph.getViewport().setMaxY(maxY+1);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(arrayX.get(0) - 1);
            graph.getViewport().setMaxX(arrayX.get(arrayX.size() - 1) + 1);
            series.setColor(getResources().getColor(R.color.colorAccent));
            series1.setColor(getResources().getColor(R.color.colorAccent));
            graph.addSeries(series);
            graph.addSeries(series1);
            series1.setShape(PointsGraphSeries.Shape.POINT);
            double finalMinY = minY-1;
            double finalMaxY = maxY+1;
            graph.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(getActivity(), GraphActivity.class);
                        intent.putExtra("xarray", arrayX);
                        intent.putExtra("yarray", arrayY);
                        intent.putExtra("xarrayNew", arrayX);
                        intent.putExtra("yarrayNew", arrayY);
                        intent.putExtra("minY", finalMinY );
                        intent.putExtra("maxY", finalMaxY );
                        intent.putExtra("minX", arrayX.get(0) - 1 );
                        intent.putExtra("maxX", arrayX.get(arrayX.size() - 1) + 1 );
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(getActivity(), (View) graph, "profile");
                        startActivity(intent, options.toBundle());
                    } catch (NullPointerException e) {

                    }
                }
            });
            setClicableKeyboard(false);
            if (radio6_1.isChecked()){
                motionLayout.transitionToState(R.id.state_1_2);
            } else {
                motionLayout.transitionToState(R.id.state_2_2);
            }
            currentET.clearFocus();
        } catch (NumberFormatException e){
            vibro();
            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
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
    @OnClick(R.id.keyboardButton1)
    void OnClick1(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != 0 && textLen != 0) {

            currentET.setSelection(cursorPos - 1);
        }
         else if (currentET == input2){
            input1.requestFocus();
            input1.setSelection(input1.getText().length());
        } else if (currentET == input3){
            input2.requestFocus();
            input2.setSelection(input2.getText().length());
        } else if (currentET == input5){
            input3.requestFocus();
            input3.setSelection(input3.getText().length());
        } else if (currentET == input7){
            input6.requestFocus();
            input6.setSelection(input6.getText().length());
        } else if (currentET == input8){
            input7.requestFocus();
            input7.setSelection(input7.getText().length());
        } else if (currentET == input10){
            input8.requestFocus();
            input8.setSelection(input8.getText().length());
        }
    }

    @OnClick(R.id.keyboardButton2)
    void OnClick2(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != textLen) {

            currentET.setSelection(cursorPos + 1);
        }  else if (currentET == input1){
            input2.requestFocus();
            input2.setSelection(0);
        } else if (currentET == input2){
            input3.requestFocus();
            input3.setSelection(0);
        } else if (currentET == input3){
            input5.requestFocus();
            input5.setSelection(0);
        } else if (currentET == input6){
            input7.requestFocus();
            input7.setSelection(0);
        } else if (currentET == input7){
            input8.requestFocus();
            input8.setSelection(0);
        } else if (currentET == input8){
            input10.requestFocus();
            input10.setSelection(0);
        }
    }

    @OnClick(R.id.keyboardButton3)
    void OnClick3(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) currentET.getText();


            selection.replace(cursorPos - 1, cursorPos, "");
            currentET.setText(selection);
            currentET.setSelection(cursorPos - 1);
            return;

        }
    }

    @OnClick(R.id.keyboardButton4)
    void OnClick4(){
        updateText("e");
    }

    @OnClick(R.id.keyboardButton5)
    void OnClick5(){
        updateText("√()");
    }

    @OnClick(R.id.keyboardButton6)
    void OnClick6(){
        updateText("π");
    }

    @OnClick(R.id.keyboardButton7)
    void OnClick7(){
        updateText("7");
    }

    @OnClick(R.id.keyboardButton8)
    void OnClick8(){
        updateText("8");
    }

    @OnClick(R.id.keyboardButton9)
    void OnClick9(){
        updateText("9");
    }

    @OnClick(R.id.keyboardButton10)
    void OnClick10(){
        updateText("4");
    }

    @OnClick(R.id.keyboardButton11)
    void OnClick11(){
        updateText("5");
    }
    @OnClick(R.id.keyboardButton12)
    void OnClick12(){
        updateText("6");
    }

    @OnClick(R.id.keyboardButton13)
    void OnClick13(){
        updateText("1");
    }

    @OnClick(R.id.keyboardButton14)
    void OnClick14(){
        updateText("2");
    }

    @OnClick(R.id.keyboardButton15)
    void OnClick15(){
        updateText("3");
    }

    @OnClick(R.id.keyboardButton16)
    void OnClick16(){
        updateText("-");
    }

    @OnClick(R.id.keyboardButton17)
    void OnClick17(){
        updateText("0");
    }

    @OnClick(R.id.keyboardButton18)
    void OnClick18(){
        updateText(".");
    }

    public void createTablePoint(ArrayList<Double> arrayX, ArrayList<Double> arrayY, double x, double y){
        editTextParamsI = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editTextParamsX = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editTextParamsY = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        if (arrayX.size()!=0) {

            editTextParamsI.setMargins(0, 3, 3, 3);

            editTextParamsX.setMargins(3, 3, 3, 3);

            editTextParamsY.setMargins(3, 3, 0, 3);
            tableI.getChildAt(tableI.getChildCount()-1).setLayoutParams(editTextParamsI);
            tableX.getChildAt(tableX.getChildCount()-1).setLayoutParams(editTextParamsX);
            tableY.getChildAt(tableY.getChildCount()-1).setLayoutParams(editTextParamsY);
        }

        editTextParamsI.setMargins(0, 3, 3, 0);
        editTextParamsX.setMargins(3, 3, 3, 0);
        editTextParamsY.setMargins(3, 3, 0, 0);
        TextView textViewI = new TextView(getContext());
        TextView textViewX = new TextView(getContext());
        TextView textViewY = new TextView(getContext());
        textViewI.setGravity(Gravity.CENTER);
        textViewX.setGravity(Gravity.CENTER);
        textViewY.setGravity(Gravity.CENTER);

        textViewI.setText(String.valueOf(arrayX.size()));
        textViewX.setText(String.valueOf( x));
        textViewY.setText(round(y));
        textViewI.setBackgroundResource(R.color.white);
        textViewX.setBackgroundResource(R.color.white);
        textViewY.setBackgroundResource(R.color.white);
        textViewI.setLayoutParams(editTextParamsI);
        textViewX.setLayoutParams(editTextParamsX);
        textViewY.setLayoutParams(editTextParamsY);
        textViewI.setTextSize(20);
        textViewX.setTextSize(20);
        textViewY.setTextSize(20);
        tableI.addView(textViewI);
        tableX.addView(textViewX);
        tableY.addView(textViewY);
        arrayX.add(x);
        arrayY.add(y);


    }
    public void deleteTablePoint(){
        int index = tableI.getChildCount()-1;
        tableI.removeViewAt(index);
        tableX.removeViewAt(index);
        tableY.removeViewAt(index);


        editTextParamsI= new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
        editTextParamsI.setMargins(0, 3, 3, 0);
        editTextParamsX= new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editTextParamsX.setMargins(3, 3, 3, 0);
        editTextParamsY= new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editTextParamsY.setMargins(3, 3, 0, 0);

        tableI.getChildAt(index-1).setLayoutParams(editTextParamsI);
        tableX.getChildAt(index-1).setLayoutParams(editTextParamsX);
        tableY.getChildAt(index-1).setLayoutParams(editTextParamsY);

    }
    public void setClicableKeyboard(boolean isBool){
        keyboardButton1.setClickable(isBool);
        keyboardButton2.setClickable(isBool);
        keyboardButton3.setClickable(isBool);
        keyboardButton4.setClickable(isBool);
        keyboardButton5.setClickable(isBool);
        keyboardButton6.setClickable(isBool);
        keyboardButton7.setClickable(isBool);
        keyboardButton8.setClickable(isBool);
        keyboardButton9.setClickable(isBool);
        keyboardButton10.setClickable(isBool);
        keyboardButton11.setClickable(isBool);
        keyboardButton12.setClickable(isBool);
        keyboardButton13.setClickable(isBool);
        keyboardButton14.setClickable(isBool);
        keyboardButton15.setClickable(isBool);
        keyboardButton16.setClickable(isBool);
        keyboardButton17.setClickable(isBool);
        keyboardButton18.setClickable(isBool);
        button1.setClickable(isBool);
        graph.setClickable(!isBool);


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}