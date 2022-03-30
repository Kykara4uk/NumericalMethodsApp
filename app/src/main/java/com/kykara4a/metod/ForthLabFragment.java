package com.kykara4a.metod;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import org.mariuszgromada.math.mxparser.*;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
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
 * Use the {@link ForthLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForthLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Unbinder unbinder;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Object> inputArray1;
    ArrayList<Object> inputArray2;
    ArrayList<Object> inputArray3;
    ArrayList<Object> inputArrayToSave1;
    ArrayList<Object> inputArrayToSave2;
    ArrayList<Object> inputArrayToSave3;
    Vibrator vibrator;
    TextInputEditText focusedEditText;
    @BindView(R.id.layout1)
    LinearLayout layout1;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.layout3)
    LinearLayout layout3;
    @BindView(R.id.input1)
    TextInputEditText input1;
    @BindView(R.id.input2)
    TextInputEditText input2;
    @BindView(R.id.input3)
    TextInputEditText input3;
    @BindView(R.id.input4)
    TextInputEditText input4;
    @BindView(R.id.input5)
    TextInputEditText input5;
    @BindView(R.id.input6)
    TextInputEditText input6;
    @BindView(R.id.input7)
    TextInputEditText input7;
    @BindView(R.id.input8)
    TextInputEditText input8;
    @BindView(R.id.input9)
    TextInputEditText input9;
    boolean timeToReturn;
    @BindView(R.id.textView1)
    TextView textView;
    @BindView(R.id.button1)
    MaterialButton button1;
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
    @BindView(R.id.keyboardButton21)
    MaterialButton keyboardButton21;
    @BindView(R.id.keyboardButton22)
    MaterialButton keyboardButton22;
    @BindView(R.id.keyboardButton23)
    MaterialButton keyboardButton23;
    @BindView(R.id.keyboardButton24)
    MaterialButton keyboardButton24;
    @BindView(R.id.keyboardButton25)
    MaterialButton keyboardButton25;
    @BindView(R.id.keyboardButton26)
    MaterialButton keyboardButton26;
    @BindView(R.id.keyboardButton27)
    MaterialButton keyboardButton27;
    @BindView(R.id.keyboardButton0)
    MaterialButton getKeyboardButton0;
    @BindView(R.id.mathLayout1)
            LinearLayout mathLayout1;
    @BindView(R.id.mathLayout2)
    LinearLayout mathLayout2;
    @BindView(R.id.mathLayout3)
    LinearLayout mathLayout3;
    @BindView(R.id.radioButton1)
    RadioButton radioButton1;

    @BindView(R.id.radioButton2)
            RadioButton radioButton2;
    @BindView(R.id.radioButton3)
            RadioButton radioButton3;
    View v;
    SharedPreferences sharedPreferences;
    String conditionLine;





public ForthLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForthLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForthLabFragment newInstance(String param1, String param2) {
        ForthLabFragment fragment = new ForthLabFragment();
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
        v = inflater.inflate(R.layout.fragment_forth_lab, container, false);
        unbinder = ButterKnife.bind(this, v);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        conditionLine = "";
        inputArray1 = new ArrayList<>();
        inputArray2 = new ArrayList<>();
        inputArray3 = new ArrayList<>();
        inputArrayToSave1 = new ArrayList<>();
        inputArrayToSave2 = new ArrayList<>();
        inputArrayToSave3 = new ArrayList<>();
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        input1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        input9.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });
        timeToReturn = false;
/*
        //LinearLayout linear1 = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout, mathLayout1);
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout, mathLayout1);
        TextInputEditText textInputEditText = view.findViewById(R.id.input);
        inputArray1.add(textInputEditText);
        textInputEditText.setShowSoftInputOnFocus(false);
        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    focusedEditText = textInputEditText;


                }
            }
        });

        //LinearLayout linear2 = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout, mathLayout2);
        View view2 =  LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout, mathLayout2);
        TextInputEditText textInputEditText2 = view2.findViewById(R.id.input);
        inputArray2.add(textInputEditText2);
        textInputEditText2.setShowSoftInputOnFocus(false);
        textInputEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    focusedEditText = textInputEditText2;


                }
            }
        });

        //LinearLayout linear3 = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout, mathLayout3);
        View view3 =  LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout, mathLayout3);
        TextInputEditText textInputEditText3 = view3.findViewById(R.id.input);
        inputArray3.add(textInputEditText3);
        textInputEditText3.setShowSoftInputOnFocus(false);
        textInputEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    focusedEditText = textInputEditText3;


                }
            }
        });

 */
        //mathLayout.addView(view, 0);
        ArrayList<Object> newArray = new ArrayList<>();

        /*
        input4.setShowSoftInputOnFocus(false);
        input4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    input4.setTextIsSelectable(true);
                    input4.setCursorVisible(true);

                } else {
                    keyboardLayout1.setVisibility(View.GONE);
                }
            }
        });


         */
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.keyboardButton0)
    void OnClick0(){

        int cursorPos = focusedEditText.getSelectionStart();
        int textLen = focusedEditText.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) focusedEditText.getText();
            if (cursorPos>3){
                CharSequence sub =  selection.subSequence(cursorPos - 4, cursorPos);
            if (selection.subSequence(cursorPos - 4, cursorPos).toString().equals("sin(")){

                selection.replace(cursorPos - 4, cursorPos, "");
                focusedEditText.setText(selection);
                focusedEditText.setSelection(cursorPos - 4);
                return;
            } else if (selection.subSequence(cursorPos - 4, cursorPos).toString().equals("cos(")){
                selection.replace(cursorPos - 4, cursorPos, "");
                focusedEditText.setText(selection);
                focusedEditText.setSelection(cursorPos - 4);
                return;
            } else if (selection.subSequence(cursorPos - 4, cursorPos).toString().equals("ctg(")){
                selection.replace(cursorPos - 4, cursorPos, "");
                focusedEditText.setText(selection);
                focusedEditText.setSelection(cursorPos - 4);
                return;
            }
            }
            if (cursorPos > 2) {

                if (selection.subSequence(cursorPos - 3, cursorPos).toString().equals("tg(")) {
                    selection.replace(cursorPos - 3, cursorPos, "");
                    focusedEditText.setText(selection);
                    focusedEditText.setSelection(cursorPos - 3);
                    return;
                } else if (selection.subSequence(cursorPos - 3, cursorPos).toString().equals("lg(")) {
                    selection.replace(cursorPos - 3, cursorPos, "");
                    focusedEditText.setText(selection);
                    focusedEditText.setSelection(cursorPos - 3);
                    return;
                }
            }
            if (cursorPos>1) {
              if (selection.subSequence(cursorPos - 2, cursorPos).toString().equals("√(")) {
                    selection.replace(cursorPos - 2, cursorPos, "");
                    focusedEditText.setText(selection);
                    focusedEditText.setSelection(cursorPos - 2);
                  return;
                }
            }

                selection.replace(cursorPos - 1, cursorPos, "");
                focusedEditText.setText(selection);
                focusedEditText.setSelection(cursorPos - 1);
                return;

        }
        else {
            if (radioButton1.isChecked()) {
                findFocusedEditTextToDelete(inputArray1, focusedEditText, mathLayout1, inputArray1);
            } else if (radioButton2.isChecked()) {
                findFocusedEditTextToDelete(inputArray2, focusedEditText, mathLayout2, inputArray2);
            } else if (radioButton3.isChecked()) {
                findFocusedEditTextToDelete(inputArray3, focusedEditText, mathLayout3, inputArray3);
            }
        }


    }
    @OnClick(R.id.keyboardButton1)
    void OnClick1(){
        updateText("(");
    }
    @OnClick(R.id.keyboardButton2)
    void OnClick2(){
        updateText(")");
    }
    @OnClick(R.id.keyboardButton3)
    void OnClick3(){
        updateText("√()");
    }
    @OnClick(R.id.keyboardButton4)
    void OnClick4(){
        SpannableStringBuilder selection = (SpannableStringBuilder) focusedEditText.getText();
        int cursorPos = focusedEditText.getSelectionStart();
        int textLen = focusedEditText.getText().length();
        if (cursorPos == 0 ){
return;
        } else if ( selection.subSequence(cursorPos - 1, cursorPos).toString().equals("(")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("+")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("-")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals(".")||selection.subSequence(cursorPos - 1, cursorPos).toString().equals("×")){
return;

        }  else
            {
            updateText("²");
        }
    }

    @OnClick(R.id.keyboardButton5)
    void OnClick5(){
        timeToReturn=false;
        int cursorPos = focusedEditText.getSelectionStart();
        int textLen = focusedEditText.getText().length();
        if (cursorPos != 0 && textLen != 0) {

            focusedEditText.setSelection(cursorPos - 1);
        } else {
            ArrayList<Integer> indexes = new ArrayList<>();

            if (radioButton1.isChecked()) {
                findFocusedEditTextLeft(inputArray1, focusedEditText, indexes);
            } else if (radioButton2.isChecked()) {
                findFocusedEditTextLeft(inputArray2, focusedEditText, indexes);
            } else if (radioButton3.isChecked()) {
                findFocusedEditTextLeft(inputArray3, focusedEditText, indexes);
            }

        }
    }
    @OnClick(R.id.keyboardButton6)
    void OnClick6(){
        timeToReturn=false;
        int cursorPos = focusedEditText.getSelectionStart();
        int textLen = focusedEditText.getText().length();
        if (cursorPos != textLen) {

            focusedEditText.setSelection(cursorPos + 1);
        } else {
            ArrayList<Integer> indexes = new ArrayList<>();

            if (radioButton1.isChecked()) {
                findFocusedEditTextRight(inputArray1, focusedEditText, indexes);
            } else if (radioButton2.isChecked()) {
                findFocusedEditTextRight(inputArray2, focusedEditText, indexes);
            } else if (radioButton3.isChecked()) {
                findFocusedEditTextRight(inputArray3, focusedEditText, indexes);
            }

        }
    }
    @OnClick(R.id.keyboardButton7)
    void OnClick7(){
        updateText("sin()");
    }
    @OnClick(R.id.keyboardButton8)
    void OnClick8(){
        updateText("7");
    }
    @OnClick(R.id.keyboardButton9)
    void OnClick9(){
        updateText("8");
    }
    @OnClick(R.id.keyboardButton10)
    void OnClick10(){
        updateText("9");
    }
    @OnClick(R.id.keyboardButton11)
    void OnClick11(){

        LinearLayout oldLayout = (LinearLayout) focusedEditText.getParent().getParent().getParent();
        String oldStr = focusedEditText.getText().toString();
        int cursorPos = focusedEditText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        View view1 = null;
        View view2 = null;
    if (oldLayout==mathLayout1    &&mathLayout1.getChildCount()==1  ) {

        view1 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, mathLayout1);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.divider, mathLayout1);

        view2 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, mathLayout1);
        oldLayout.removeViewAt(0);
    } else if (oldLayout==mathLayout2    &&mathLayout2.getChildCount()==1  ) {
        view1 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, mathLayout2);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.divider, mathLayout2);

        view2 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, mathLayout2);
        oldLayout.removeViewAt(0);
    } else if (oldLayout==mathLayout3  &&mathLayout3.getChildCount()==1  ) {
        view1 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, mathLayout3);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.divider, mathLayout3);

        view2 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, mathLayout3);
        oldLayout.removeViewAt(0);
    }

     else {
         int index = oldLayout.indexOfChild((View) focusedEditText.getParent().getParent());
        oldLayout.removeViewAt(index);
        LinearLayout linear1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.layout, oldLayout, false);
        oldLayout.addView(linear1, index);
        view1 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, (LinearLayout)linear1);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.divider, (LinearLayout)linear1);

        view2 = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, (LinearLayout)linear1);
    }

        TextInputEditText textInputEditText1 = (TextInputEditText) view1.findViewById(R.id.input1);
        textInputEditText1.setText(leftStr);

        TextInputEditText textInputEditText2 = (TextInputEditText) view2.findViewById(R.id.input2);
        textInputEditText2.setText(rightStr);

        textInputEditText1.setShowSoftInputOnFocus(false);
        textInputEditText2.setShowSoftInputOnFocus(false);

        if (radioButton1.isChecked()) {
            findEditText(inputArray1, focusedEditText, textInputEditText1, textInputEditText2);
        } else if (radioButton2.isChecked()) {
            findEditText(inputArray2, focusedEditText, textInputEditText1, textInputEditText2);
        } else if (radioButton3.isChecked()) {
            findEditText(inputArray3, focusedEditText, textInputEditText1, textInputEditText2);
        }
            textInputEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    focusedEditText = textInputEditText1;

                }
            }
        });
        textInputEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                    keyboardLayout1.setVisibility(View.VISIBLE);
                    focusedEditText = textInputEditText2;

                }
            }
        });
        textInputEditText2.requestFocus();

    }
    void findEditText(ArrayList<Object> tempArray, TextInputEditText focusedEditTextTemp, TextInputEditText text1, TextInputEditText text2){
        if (tempArray.get(0) instanceof TextInputEditText){
            if (tempArray.get(0) == focusedEditTextTemp){

                        if (tempArray.size()==1&&(tempArray == inputArray1||tempArray == inputArray2||tempArray == inputArray3)){
                            tempArray.set(0, text1);
                            tempArray.add(text2);
                        } else {
                            ArrayList<Object> newList = new ArrayList<>();
                            newList.add(text1);
                            newList.add(text2);
                            tempArray.set(0, newList);
                        }
                        return;
            }
        } else if (tempArray.get(0) instanceof ArrayList){
            findEditText((ArrayList<Object>) tempArray.get(0), focusedEditTextTemp, text1, text2);
        }
        if (tempArray.size()>1) {
            if (tempArray.get(1) instanceof TextInputEditText) {
                if (tempArray.get(1) == focusedEditTextTemp) {

                    ArrayList<Object> newArray = new ArrayList<>();
                    newArray.add(text1);
                    newArray.add(text2);
                    tempArray.set(1, newArray);
                }
            } else if (tempArray.get(1) instanceof ArrayList) {
                findEditText((ArrayList<Object>) tempArray.get(1), focusedEditTextTemp, text1, text2);
            }
        }
    }
    void findFocusedEditTextLeft(ArrayList<Object> tempArray, TextInputEditText focusedEditTextTemp, ArrayList<Integer> indexes){
        if (tempArray.get(0) instanceof TextInputEditText){
            ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
            if (tempArray.get(0) == focusedEditTextTemp){



                    findLeftEditText(indexesNew);
                    return;

            }
        } else if (tempArray.get(0) instanceof ArrayList){
            ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
            indexesNew.add(0);
            findFocusedEditTextLeft((ArrayList<Object>) tempArray.get(0), focusedEditTextTemp, indexesNew);
        }
        if (tempArray.size()>1) {
            ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
            if (tempArray.get(1) instanceof TextInputEditText) {
                if (tempArray.get(1) == focusedEditText) {
                    indexesNew.add(0);
                    findLeftEditText2(indexesNew);
                    return;
                }
            } else if (tempArray.get(1) instanceof ArrayList) {
                indexesNew.add(1);
                findFocusedEditTextLeft((ArrayList<Object>) tempArray.get(1), focusedEditTextTemp, indexesNew);
            }
        }
    }
    void findLeftEditText2(ArrayList<Integer> indexes){
        ArrayList<Object> tempArray = null;
        if (radioButton1.isChecked()) {
            tempArray = inputArray1;
        } else if (radioButton2.isChecked()) {
            tempArray = inputArray2;
        } else if (radioButton3.isChecked()) {
            tempArray = inputArray3;
        }

        for (int i = 0; i < indexes.size(); i++){
            if (tempArray.get(indexes.get(i)) instanceof TextInputEditText){
                TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(0);
                textInputEditText.requestFocus();
                textInputEditText.setSelection(textInputEditText.getText().length());
                return;
            } else {
                tempArray = (ArrayList<Object>) tempArray.get(indexes.get(i));
            }

        }
        while (true){
            if (tempArray.get(1) instanceof TextInputEditText){
                TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(1);
                textInputEditText.requestFocus();
                textInputEditText.setSelection(textInputEditText.getText().length());
                return;
            } else {
                tempArray = (ArrayList<Object>) tempArray.get(1);
            }
        }

    }
    void findLeftEditText(ArrayList<Integer> indexes){
        ArrayList<Object> tempArray = null;
        if (radioButton1.isChecked()) {
            tempArray = inputArray1;
        } else if (radioButton2.isChecked()) {
            tempArray = inputArray2;
        } else if (radioButton3.isChecked()) {
            tempArray = inputArray3;
        }
        boolean flagOfEnd = false;
        while (indexes.size()!=0){
            if (indexes.get(indexes.size()-1)==1){
                indexes.set(indexes.size()-1, 0);
                for (int i = 0; i < indexes.size(); i++){
                    if (tempArray.get(indexes.get(i)) instanceof TextInputEditText){
                        TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(0);
                        textInputEditText.requestFocus();
                        textInputEditText.setSelection(textInputEditText.getText().length());
                        flagOfEnd = true;
                        return;
                    } else {
                        tempArray = (ArrayList<Object>) tempArray.get(indexes.get(i));
                    }

                }
                while (!flagOfEnd){
                    if (tempArray.size()>1){
                        if (tempArray.get(1) instanceof TextInputEditText){
                            TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(1);
                            textInputEditText.requestFocus();
                            textInputEditText.setSelection(textInputEditText.getText().length());
                            return;

                        } else {
                            tempArray = (ArrayList<Object>) tempArray.get(1);
                            continue;
                        }
                    } else {
                        if (tempArray.get(0) instanceof TextInputEditText){
                            TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(0);
                            textInputEditText.requestFocus();
                            textInputEditText.setSelection(textInputEditText.getText().length());
                            return;

                        } else {
                            tempArray = (ArrayList<Object>) tempArray.get(0);
                            continue;
                        }
                    }
                }
            } else {
                indexes.remove(indexes.size()-1);
            }
        }

    }
    @OnClick(R.id.keyboardButton12)
    void OnClick12(){
        updateText("cos()");
    }
    @OnClick(R.id.keyboardButton13)
    void OnClick13(){
        updateText("4");
    }
    @OnClick(R.id.keyboardButton14)
    void OnClick14(){
        updateText("5");
    }
    @OnClick(R.id.keyboardButton15)
    void OnClick15(){
        updateText("6");
    }
    @OnClick(R.id.keyboardButton16)
    void OnClick16(){
        updateText("×");
    }
    @OnClick(R.id.keyboardButton17)
    void OnClick17(){
        updateText("ctg()");
    }
    @OnClick(R.id.keyboardButton18)
    void OnClick18(){
        updateText("1");
    }
    @OnClick(R.id.keyboardButton19)
    void OnClick19(){
        updateText("2");
    }
    @OnClick(R.id.keyboardButton20)
    void OnClick20(){
        updateText("3");
    }
    @OnClick(R.id.keyboardButton21)
    void OnClick21(){
        updateText("-");
    }
    @OnClick(R.id.keyboardButton22)
    void OnClick22(){
        updateText("tg()");
    }
    @OnClick(R.id.keyboardButton23)
    void OnClick23(){
        updateText("lg()");
    }
    @OnClick(R.id.keyboardButton24)
    void OnClick24(){
        updateText("X");
    }
    @OnClick(R.id.keyboardButton25)
    void OnClick25(){
        updateText("0");
    }
    @OnClick(R.id.keyboardButton26)
    void OnClick26(){
        updateText(".");
    }
    @OnClick(R.id.keyboardButton27)
    void OnClick27(){
        updateText("+");
    }
    private void updateText(String strToAdd){
        TextInputEditText textInputEditText =  focusedEditText;


        String oldStr = textInputEditText.getText().toString();
        int cursorPos = textInputEditText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if ((!strToAdd.equals(")"))&&strToAdd.endsWith(")")){
            cursorPos-=1;
        }
        textInputEditText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        textInputEditText.setSelection(cursorPos + strToAdd.length());




    }
    void findFocusedEditTextRight(ArrayList<Object> tempArray, TextInputEditText focusedEditTextTemp, ArrayList<Integer> indexes){
        if (!timeToReturn) {
            if (tempArray.get(0) instanceof TextInputEditText) {
                ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
                if (tempArray.get(0) == focusedEditTextTemp) {


                        indexesNew.add(1);


                    findRightEditText2(indexesNew);
                    timeToReturn=true;
                    return;

                }
            } else if (tempArray.get(0) instanceof ArrayList) {
                ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
                indexesNew.add(0);
                findFocusedEditTextRight((ArrayList<Object>) tempArray.get(0), focusedEditTextTemp, indexesNew);
                if (timeToReturn) return;
            }
            if (tempArray.size() > 1) {
                ArrayList<Integer> indexesNew = new ArrayList<>(indexes);
                if (tempArray.get(1) instanceof TextInputEditText) {
                    if (tempArray.get(1) == focusedEditText) {

                        findRightEditText(indexesNew);
                        timeToReturn=true;
                        return;
                    }
                } else if (tempArray.get(1) instanceof ArrayList) {
                    indexesNew.add(1);
                    findFocusedEditTextRight((ArrayList<Object>) tempArray.get(1), focusedEditTextTemp, indexesNew);
                    if (timeToReturn) return;
                }
            }
        } else return;
    }
    void findRightEditText2(ArrayList<Integer> indexes){
        ArrayList<Object> tempArray = null;
        if (radioButton1.isChecked()) {
            tempArray = inputArray1;
        } else if (radioButton2.isChecked()) {
            tempArray = inputArray2;
        } else if (radioButton3.isChecked()) {
            tempArray = inputArray3;
        }
        for (int i = 0; i < indexes.size(); i++){
            if (tempArray.get(indexes.get(i)) instanceof TextInputEditText){
                if (tempArray.size()>1) {
                    TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(indexes.get(i));
                    textInputEditText.requestFocus();
                    textInputEditText.setSelection(0);

                }
                return;
            } else {
                tempArray = (ArrayList<Object>) tempArray.get(indexes.get(i));
            }

        }
        while (true){
            if (tempArray.get(0) instanceof TextInputEditText){
                TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(0);
                textInputEditText.requestFocus();
                textInputEditText.setSelection(0);
                return;
            } else {
                tempArray = (ArrayList<Object>) tempArray.get(0);
            }
        }

    }
    void findRightEditText(ArrayList<Integer> indexes){

        ArrayList<Object> tempArray = null;
        if (radioButton1.isChecked()) {
            tempArray = inputArray1;
        } else if (radioButton2.isChecked()) {
            tempArray = inputArray2;
        } else if (radioButton3.isChecked()) {
            tempArray = inputArray3;
        }
        boolean flagOfEnd = false;

        while (indexes.size()!=0){

            if (indexes.get(indexes.size()-1)==0){
                indexes.set(indexes.size()-1, 1);
                for (int i = 0; i < indexes.size(); i++){
                    if (tempArray.get(indexes.get(i)) instanceof TextInputEditText){
                        TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(1);
                        textInputEditText.requestFocus();
                        textInputEditText.setSelection(0);
                        flagOfEnd = true;
                        return;
                    } else {
                        tempArray = (ArrayList<Object>) tempArray.get(indexes.get(i));
                    }

                }
                while (!flagOfEnd){
                    if (tempArray.size()>1){
                        if (tempArray.get(0) instanceof TextInputEditText){
                            TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(0);
                            textInputEditText.requestFocus();
                            textInputEditText.setSelection(0);
                            return;

                        } else {
                            tempArray = (ArrayList<Object>) tempArray.get(0);
                            continue;
                        }
                    } else {
                        if (tempArray.get(1) instanceof TextInputEditText){
                            TextInputEditText textInputEditText = (TextInputEditText) tempArray.get(1);
                            textInputEditText.requestFocus();
                            textInputEditText.setSelection(0);
                            return;

                        } else {
                            tempArray = (ArrayList<Object>) tempArray.get(1);
                            continue;
                        }
                    }
                }
            } else {
                indexes.remove(indexes.size()-1);
            }
        }

    }
    @OnCheckedChanged(R.id.radioButton1)
    void OnCheckedChange1(){
        textView.setVisibility(View.GONE);
        if (radioButton1.isChecked()){
            layout1.setVisibility(View.VISIBLE);
            keyboardLayout1.setVisibility(View.GONE);
        } else {
            layout1.setVisibility(View.GONE);
        }
    }
    @OnCheckedChanged(R.id.radioButton2)
    void OnCheckedChange2(){
        textView.setVisibility(View.GONE);
        if (radioButton2.isChecked()){
            layout2.setVisibility(View.VISIBLE);
            keyboardLayout1.setVisibility(View.GONE);
        } else {
            layout2.setVisibility(View.GONE);
        }
    }
    @OnCheckedChanged(R.id.radioButton3)
    void OnCheckedChange3(){
        textView.setVisibility(View.GONE);
        if (radioButton3.isChecked()){
            layout3.setVisibility(View.VISIBLE);
            keyboardLayout1.setVisibility(View.GONE);
        } else {
            layout3.setVisibility(View.GONE);
        }
    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileForth", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    public Profile getData(Profile currentProfile){

        int radio4_1 = 0;
        if (radioButton1.isChecked()){
            radio4_1  = 1;
        } else if (radioButton2.isChecked()){
            radio4_1  = 2;
        } else if (radioButton3.isChecked()){
            radio4_1  = 3;
        }
        String n4_1 = input1.getText().toString();
        String n4_2 = input4.getText().toString();
        String n4_3 = input7.getText().toString();
        String upperBound4_1 = input2.getText().toString();
        String upperBound4_2= input5.getText().toString();
        String upperBound4_3= input8.getText().toString();
        String lowerBound4_1= input3.getText().toString();
        String lowerBound4_2= input6.getText().toString();
        String lowerBound4_3= input9.getText().toString();

        currentProfile.radio4_1 = radio4_1;
        currentProfile.n4_1 = n4_1;
        currentProfile.n4_2 = n4_2;
        currentProfile.n4_3 = n4_3;
        currentProfile.upperBound4_1 = upperBound4_1;
        currentProfile.upperBound4_2 = upperBound4_2;
        currentProfile.upperBound4_3 = upperBound4_3;
        currentProfile.lowerBound4_1 = lowerBound4_1;
        currentProfile.lowerBound4_2 = lowerBound4_2;
        currentProfile.lowerBound4_3 = lowerBound4_3;
        inputArrayToSave1.clear();
        inputArrayToSave2.clear();
        inputArrayToSave3.clear();
        getStrings(inputArrayToSave1, inputArray1);
        getStrings(inputArrayToSave2, inputArray2);
        getStrings(inputArrayToSave3, inputArray3);
        currentProfile.integral4_1 = inputArrayToSave1;
        currentProfile.integral4_2 = inputArrayToSave2;
        currentProfile.integral4_3 = inputArrayToSave3;
        return currentProfile;
    }
    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();
        if (currentProfile.radio4_1==1){
            radioButton1.setChecked(true);
        } else if (currentProfile.radio4_1==2){
            radioButton2.setChecked(true);
        } else if (currentProfile.radio4_1==3){
            radioButton3.setChecked(true);
        }
        mathLayout1.removeAllViews();
        mathLayout2.removeAllViews();
        mathLayout3.removeAllViews();
        input1.setText(currentProfile.n4_1);
        input4.setText(currentProfile.n4_2);
        input7.setText(currentProfile.n4_3);
        input2.setText(currentProfile.upperBound4_1);
        input5.setText(currentProfile.upperBound4_2);
        input8.setText(currentProfile.upperBound4_3);
        input3.setText(currentProfile.lowerBound4_1);
        input6.setText(currentProfile.lowerBound4_2);
        input9.setText(currentProfile.lowerBound4_3);
        inputArray1.clear();
        inputArray2.clear();
        inputArray3.clear();
        if (currentProfile.integral4_1!=null) {
            getTexts(currentProfile.integral4_1, inputArray1, mathLayout1);
        } else {
            ArrayList<Object> strings = new ArrayList<>();
            strings.add("");
            getTexts(strings, inputArray1, mathLayout1);
        }
        if (currentProfile.integral4_2!=null) {
            getTexts(currentProfile.integral4_2, inputArray2, mathLayout2);
        }else{
            ArrayList<Object> strings = new ArrayList<>();
            strings.add("");
            getTexts(strings, inputArray2, mathLayout2);
        }
        if (currentProfile.integral4_3!=null) {
            getTexts(currentProfile.integral4_3, inputArray3, mathLayout3);
        }else{
            ArrayList<Object> strings = new ArrayList<>();
            strings.add("");
            getTexts(strings, inputArray3, mathLayout3);
        }



    }

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();
        int radio4_1 = 0;
        if (radioButton1.isChecked()){
            radio4_1  = 1;
        } else if (radioButton2.isChecked()){
            radio4_1  = 2;
        } else if (radioButton3.isChecked()){
            radio4_1  = 3;
        }
        String n4_1 = input1.getText().toString();
        String n4_2 = input4.getText().toString();
        String n4_3 = input7.getText().toString();
         String upperBound4_1 = input2.getText().toString();
         String upperBound4_2= input5.getText().toString();
         String upperBound4_3= input8.getText().toString();
         String lowerBound4_1= input3.getText().toString();
         String lowerBound4_2= input6.getText().toString();
         String lowerBound4_3= input9.getText().toString();

        currentProfile.radio4_1 = radio4_1;
        currentProfile.n4_1 = n4_1;
        currentProfile.n4_2 = n4_2;
        currentProfile.n4_3 = n4_3;
        currentProfile.upperBound4_1 = upperBound4_1;
        currentProfile.upperBound4_2 = upperBound4_2;
        currentProfile.upperBound4_3 = upperBound4_3;
        currentProfile.lowerBound4_1 = lowerBound4_1;
        currentProfile.lowerBound4_2 = lowerBound4_2;
        currentProfile.lowerBound4_3 = lowerBound4_3;
        inputArrayToSave1.clear();
        inputArrayToSave2.clear();
        inputArrayToSave3.clear();
        getStrings(inputArrayToSave1, inputArray1);
        getStrings(inputArrayToSave2, inputArray2);
        getStrings(inputArrayToSave3, inputArray3);
        currentProfile.integral4_1 = inputArrayToSave1;
        currentProfile.integral4_2 = inputArrayToSave2;
        currentProfile.integral4_3 = inputArrayToSave3;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson2 = new Gson();
        String json2 = gson2.toJson(currentProfile);
        editor.putString("currentProfileForth", json2);
        editor.apply();
    }
    void getStrings(ArrayList<Object> strings, ArrayList<Object> texts){
        if (texts.get(0) instanceof TextInputEditText){
            strings.add(((TextInputEditText) texts.get(0)).getText().toString());
        } else {
            ArrayList<Object> newStrings = new ArrayList<>();
            strings.add(newStrings);
            getStrings((ArrayList)strings.get(0), (ArrayList)texts.get(0));
        }
        if (texts.size()>1){
            if (texts.get(1) instanceof TextInputEditText){
                strings.add(((TextInputEditText) texts.get(1)).getText().toString());
            } else {
                ArrayList<Object> newStrings = new ArrayList<>();
                strings.add(newStrings);
                getStrings((ArrayList)strings.get(1), (ArrayList)texts.get(1));
            }
        }
    }
    void getTexts(ArrayList<Object> strings, ArrayList<Object> texts, LinearLayout parentLayout){
        if (strings.get(0) instanceof String){
            View view =  LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, parentLayout);
            TextInputLayout textInputLayout = (TextInputLayout) parentLayout.getChildAt(0);

            TextInputEditText textInputEditText = (TextInputEditText) textInputLayout.getEditText();
            texts.add(textInputEditText);
            textInputEditText.setText((String)strings.get(0));
            textInputEditText.setShowSoftInputOnFocus(false);
            View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus){

                        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                        keyboardLayout1.setVisibility(View.VISIBLE);
                        focusedEditText = textInputEditText;


                    }
                }
            };
            textInputEditText.setOnFocusChangeListener(focusChangeListener);

        } else {
            LinearLayout linear1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.layout, parentLayout);
            ArrayList<Object> newStrings = new ArrayList<>();
            texts.add(newStrings);
            getTexts((ArrayList)strings.get(0), (ArrayList)texts.get(0), (LinearLayout) parentLayout.getChildAt(0));
        }
        if (strings.size()>1){
            View viewDiv = LayoutInflater.from(getContext()).inflate(R.layout.divider, (LinearLayout)parentLayout);
            if (strings.get(1) instanceof String){
                View view2 =  LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, parentLayout);
                TextInputLayout textInputLayout = (TextInputLayout) parentLayout.getChildAt(2);

                TextInputEditText textInputEditText2 = (TextInputEditText) textInputLayout.getEditText();
                texts.add(textInputEditText2);
                textInputEditText2.setText((String)strings.get(1));
                textInputEditText2.setShowSoftInputOnFocus(false);
                View.OnFocusChangeListener focusChangeListener2 = new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus){

                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                            keyboardLayout1.setVisibility(View.VISIBLE);
                            focusedEditText = textInputEditText2;


                        }
                    }
                };
                textInputEditText2.setOnFocusChangeListener(focusChangeListener2);

            } else {
                LinearLayout linear1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.layout, parentLayout);
                ArrayList<Object> newStrings = new ArrayList<>();
                texts.add(newStrings);
                getTexts((ArrayList)strings.get(1), (ArrayList)texts.get(1), (LinearLayout) parentLayout.getChildAt(2));
            }
        }
    }
    void findFocusedEditTextToDelete(ArrayList<Object> tempArray, TextInputEditText focusedEditTextTemp, LinearLayout parentLayout, ArrayList<Object> parentOfTempArray){
        if (tempArray.get(0) instanceof ArrayList){

            findFocusedEditTextToDelete((ArrayList<Object>) tempArray.get(0), focusedEditTextTemp, (LinearLayout) parentLayout.getChildAt(0), tempArray);
        }
        if (tempArray.size()>1) {
            if (tempArray.get(1) instanceof TextInputEditText) {
                if (tempArray.get(1) == focusedEditText) {
                    if (tempArray.get(0) instanceof TextInputEditText){
                        String text =((TextInputEditText) tempArray.get(0)).getText().toString();
                        tempArray.clear();

                        LinearLayout parentOfParentLayout = (LinearLayout) parentLayout.getParent();
                        int index =2;
                        if (parentLayout==mathLayout1||parentLayout==mathLayout2||parentLayout==mathLayout3){
                            index = 0;
                            parentLayout.removeAllViews();
                        } else {
                            index = parentOfParentLayout.indexOfChild(parentLayout);
                            parentOfParentLayout.removeViewAt(index);
                        }

                        View view = null;
                        TextInputEditText textInputEditText = null;
                        if (index == 0) {
                            view = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout1, parentOfParentLayout, false);
                            if (parentLayout==mathLayout1||parentLayout==mathLayout2||parentLayout==mathLayout3){
                                parentLayout.addView(view, index);
                            } else {
                                parentOfParentLayout.addView(view, index);
                            }
                            textInputEditText = view.findViewById(R.id.input1);
                        } else {
                            view = LayoutInflater.from(getContext()).inflate(R.layout.text_input_layout2, parentOfParentLayout, false);
                            if (parentLayout==mathLayout1||parentLayout==mathLayout2||parentLayout==mathLayout3){
                                parentLayout.addView(view, index);
                            } else {
                                parentOfParentLayout.addView(view, index);
                            }
                            textInputEditText = view.findViewById(R.id.input2);
                        }
                        if (tempArray == inputArray1||tempArray == inputArray2||tempArray == inputArray3){
                            tempArray.add(textInputEditText);
                        } else {
                            parentOfTempArray.set(parentOfTempArray.indexOf(tempArray), textInputEditText);
                        }
                        textInputEditText.setText(text);
                        textInputEditText.setShowSoftInputOnFocus(false);
                        TextInputEditText finalTextInputEditText = textInputEditText;
                        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {
                                if (hasFocus){

                                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                                    keyboardLayout1.setVisibility(View.VISIBLE);
                                    focusedEditText = finalTextInputEditText;


                                }
                            }
                        });
                        textInputEditText.requestFocus();
                    }
                    return;
                }
            } else if (tempArray.get(1) instanceof ArrayList) {
                findFocusedEditTextToDelete((ArrayList<Object>) tempArray.get(1), focusedEditTextTemp, (LinearLayout) parentLayout.getChildAt(2), tempArray);
            }
        }
    }
    void getLine(ArrayList<Object> tempaArray){

        if (tempaArray.get(0) instanceof TextInputEditText){
            conditionLine+="("+((TextInputEditText) tempaArray.get(0)).getText().toString()+")";
        } else {
            conditionLine+="(";
            getLine((ArrayList<Object>) tempaArray.get(0));
            conditionLine+=")";
        }
        if (tempaArray.size()>1){
            conditionLine+="/";
            if (tempaArray.get(1) instanceof TextInputEditText){
                conditionLine+="("+((TextInputEditText) tempaArray.get(1)).getText().toString()+")";
            } else {
                conditionLine+="(";
                getLine((ArrayList<Object>) tempaArray.get(1));
                conditionLine+=")";
            }
        }
    }
    @OnClick(R.id.button1)
    void OnButton1Click(){
        try {
            textView.setText("");
            int n = -1;
            Double upperBound = null;
            Double lowerBound = null;
            conditionLine="";
            if (radioButton1.isChecked()){
                n = Integer.parseInt(input1.getText().toString());
                upperBound = Double.parseDouble(input2.getText().toString());
                lowerBound = Double.parseDouble(input3.getText().toString());

                getLine(inputArray1);
            } else if (radioButton2.isChecked()){
                n = Integer.parseInt(input4.getText().toString());
                upperBound = Double.parseDouble(input5.getText().toString());
                lowerBound = Double.parseDouble(input6.getText().toString());
                getLine(inputArray2);
            } else if (radioButton3.isChecked()){
                n = Integer.parseInt(input7.getText().toString());
                upperBound = Double.parseDouble(input8.getText().toString());
                lowerBound = Double.parseDouble(input9.getText().toString());
                getLine(inputArray3);
            }
            if (conditionLine.contains("()")){
                vibro();
                Toast.makeText(getActivity(), R.string.empty_fields, Toast.LENGTH_SHORT).show();
            } else {

                conditionLine = conditionLine.replaceAll("×", "*");
                conditionLine = conditionLine.replaceAll("²", "^2");
                conditionLine = conditionLine.replaceAll("√", "sqrt");
                conditionLine = conditionLine.replaceAll("X", "(X)");
                for (int i = 0; i < conditionLine.length()-1; i++) {
                    String letter1 = String.valueOf(conditionLine.charAt(i));
                    String letter2 = String.valueOf(conditionLine.charAt(i+1));
                    if ((letter2.equals("("))&&((!letter1.equals("+"))&&(!letter1.equals("-"))&&(!letter1.equals("/"))&&(!letter1.equals("*"))&&(!letter1.equals("("))&&(!letter1.equals("n"))&&(!letter1.equals("s"))&&(!letter1.equals("g"))&&(!letter1.equals("t")))){
                        conditionLine = conditionLine.substring(0, i+1) + "*" + conditionLine.substring(i+1, conditionLine.length());
                    }
                    if ((letter2.equals("s")||letter2.equals("c")||letter2.equals("")||letter2.equals("l"))&&((!letter1.equals("+"))&&(!letter1.equals("-"))&&(!letter1.equals("/"))&&(!letter1.equals("*"))&&(!letter1.equals("("))&&(!letter1.equals("o")))){
                        conditionLine = conditionLine.substring(0, i+1) + "*" + conditionLine.substring(i+1, conditionLine.length());
                    }
                }
                for (int i = 0; i < conditionLine.length()-1; i++) {
                    String letter1 = String.valueOf(conditionLine.charAt(i));
                    String letter2 = String.valueOf(conditionLine.charAt(i+1));
                    if ((letter1.equals(")"))&&((!letter2.equals("+"))&&(!letter2.equals("-"))&&(!letter2.equals("/"))&&(!letter2.equals("*"))&&(!letter2.equals(")"))&&(!letter2.equals("^")))){
                        conditionLine = conditionLine.substring(0, i+1) + "*" + conditionLine.substring(i+1, conditionLine.length());
                    }
                }
                conditionLine = conditionLine.replaceAll("lg", "log10");
                String conditionLineNewCheck = conditionLine.replaceAll("X", "1.2");
                Expression expressionCheck = new Expression(conditionLineNewCheck);
                expressionCheck.checkSyntax();
                mXparser.consolePrint(expressionCheck.getErrorMessage());
                if (expressionCheck.checkSyntax()&&expressionCheck.checkLexSyntax()) {


                    if (radioButton1.isChecked()) {
                        Double leftAnswer = 0.0;
                        Double rightAnswer = 0.0;
                        Double middleAnswer = 0.0;
                        double step = (upperBound - lowerBound) / n;
                        double x = lowerBound;
                        for (int i = 0; i <= n; i++) {
                            String newX = "" + x ;
                            String conditionLineNew = conditionLine.replaceAll("X", newX);
                            Expression expression = new Expression(conditionLineNew);
                            String result = String.valueOf(expression.calculate());
                            if (i != n) {
                                leftAnswer += Double.parseDouble(result);

                                Double xMiddle = x + (step / 2);
                                String newXMiddle = "" + xMiddle;
                                String conditionLineNewMiddle = conditionLine.replaceAll("X", newXMiddle);
                                Expression expressionMiddle = new Expression(conditionLineNewMiddle);
                                String resultMiddle = String.valueOf(expressionMiddle.calculate());
                                middleAnswer += Double.parseDouble(resultMiddle);
                            }
                            if (i != 0) {
                                rightAnswer += Double.parseDouble(result);
                            }
                            x += step;
                        }
                        leftAnswer *= step;
                        rightAnswer *= step;
                        middleAnswer *= step;
                        String integralCondition = "int( " + conditionLine.replaceAll("X", "x") + ", x, " + lowerBound + ", " + upperBound + " )";
                        Expression integralExpression = new Expression(integralCondition);
                        Double integralAnswer = Double.parseDouble(String.valueOf(integralExpression.calculate()));
                        String text = getResources().getString(R.string.left_rect) +": " + round(leftAnswer) +"\n"+ getResources().getString(R.string.right_rect)+": " + round(rightAnswer)
                                +"\n"+ getResources().getString(R.string.middle_rect)+": " + round(middleAnswer) +"\n"+ getResources().getString(R.string.direct_integration)+": " + round(integralAnswer);
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(text);

                    } else if (radioButton2.isChecked()) {
                        Double answer = 0.0;
                        double step = (upperBound - lowerBound) / n;
                        double x = lowerBound;
                        for (int i = 0; i <= n; i++) {
                            String newX = "" + x;
                            String conditionLineNew = conditionLine.replaceAll("X", newX);
                            Expression expression = new Expression(conditionLineNew);
                            Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                            if (i == 0 || i == n) {
                                answer += result;
                            } else if (i % 2 == 0) {
                                answer += 2 * result;
                            } else if (i % 2 == 1) {
                                answer += 4 * result;
                            }
                            x += step;
                        }
                        answer = answer * step / 3;
                        String integralCondition = "int( " + conditionLine.replaceAll("X", "x") + ", x, " + lowerBound + ", " + upperBound + " )";
                        Expression integralExpression = new Expression(integralCondition);
                        Double integralAnswer = Double.parseDouble(String.valueOf(integralExpression.calculate()));
                        String text = getResources().getString(R.string.simpson)+": " + round(answer) + "\n"+getResources().getString(R.string.direct_integration)+": " + round(integralAnswer);
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(text);
                    } else if (radioButton3.isChecked()) {
                        Double answer = 0.0;
                        double step = (upperBound - lowerBound) / n;
                        double x = lowerBound;
                        for (int i = 0; i <= n; i++) {
                            String newX = "" + x ;
                            String conditionLineNew = conditionLine.replaceAll("X", newX);
                            Expression expression = new Expression(conditionLineNew);

                            Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                            if (i == 0 || i == n) {
                                answer += result / 2;
                            } else {
                                answer += result;
                            }
                            x += step;
                        }
                        answer *= step;
                        String integralCondition = "int( " + conditionLine.replaceAll("X", "x") + ", x, " + lowerBound + ", " + upperBound + " )";
                        Expression integralExpression = new Expression(integralCondition);
                        Double integralAnswer = Double.parseDouble(String.valueOf(integralExpression.calculate()));
                        String text = getResources().getString(R.string.trapezoids)+ ": " + round(answer) + "\n"+getResources().getString(R.string.direct_integration)+": " + round(integralAnswer);
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(text);
                    }
                } else {
                    vibro();
                    int open = 0;
                    int close = 0;
                    for (int i = 0; i < conditionLine.length(); i++) {
                        String letter = String.valueOf(conditionLine.charAt(i));
                        if (letter.equals("(")){
                            open+=1;
                        }
                        if (letter.equals(")")){
                            close+=1;
                        }
                    }
                    System.out.println("open="+open);
                    System.out.println("close="+close);
                    if (open<close){
                        Toast.makeText(getActivity(), R.string.open_parentheses, Toast.LENGTH_SHORT).show();
                    } else if (open>close){
                        Toast.makeText(getActivity(), R.string.close_parentheses, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                    }
                }
            }

        } catch (NumberFormatException e) {

            vibro();
            Toast.makeText(getActivity(), R.string.empty_fields, Toast.LENGTH_SHORT).show();
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

    private static String round(double value) {

        long factor = (long) Math.pow(10, 4);
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
}