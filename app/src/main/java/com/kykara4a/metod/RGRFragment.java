package com.kykara4a.metod;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
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
import android.text.Html;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RGRFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RGRFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    SharedPreferences sharedPreferences;
    private Unbinder unbinder;
    @BindView(R.id.textViewTask1)
    View task1Button;
    @BindView(R.id.textViewTask2)
    View task2Button;
    @BindView(R.id.textViewTask3)
    View task3Button;
    @BindView(R.id.motion)
    MotionLayout motionLayout;
    Vibrator vibrator;
    LinearLayout.LayoutParams editTextParams;
    LinearLayout.LayoutParams editTextParams2;
    @BindView(R.id.linearTableX)
    LinearLayout linearX;
    @BindView(R.id.linearTableY)
    LinearLayout linearY;
    @BindView(R.id.linearTableX2)
    LinearLayout linearX2;
    @BindView(R.id.buttonMinus)
    Button buttonMinus;
    @BindView(R.id.buttonPlus)
    Button buttonPlus;
    @BindView(R.id.buttonMinus2)
    Button buttonMinus2;
    @BindView(R.id.buttonPlus2)
    Button buttonPlus2;
    @BindView(R.id.graph)
    GraphView graph;
    ArrayList<ArrayList<String>> fx_text_array;
    @BindView(R.id.textViewN)
    TextView textViewN;
    @BindView(R.id.textViewN2)
    TextView textViewN2;

    @BindView(R.id.tableTask2)
    CardView tableTask2;
    @BindView(R.id.textViewTask1Condition)
            TextView textViewTask1Condition;
    @BindView(R.id.linearButtonsOfTable)
            LinearLayout linearButtonsOfTable;
    @BindView(R.id.linearTableMain2)
            CardView linearTableMaun2;
    @BindView(R.id.horizontalTableOfX)
    HorizontalScrollView horizontalTableOfX;
    @BindView(R.id.buttonsOfX)
            LinearLayout buttonsOfX;
    @BindView(R.id.button1)
            MaterialButton button1;
    @BindView(R.id.textViewTask1Answer)
            TextView textViewTask1Answer;
    @BindView(R.id.cardGraph)
            CardView cardGraph;
    @BindView(R.id.textViewTask2Condition)
        TextView textViewTask2Condition;
    @BindView(R.id.button2)
            MaterialButton button2;
    @BindView(R.id.textViewTask2Condition2)
    TextView textViewTask2Condition2;
    @BindView(R.id.edit_text_layout_2)
    TextInputLayout edit_text_layout_2;
    @BindView(R.id.keyboardLayout1)
            LinearLayout keyboardLayout1;
    @BindView(R.id.tableTask2Answer)
            CardView tableTask2Answer;
    @BindView(R.id.textViewTask3Condition)
            TextView textViewTask3Condition;
    @BindView(R.id.spinner_3)
    Spinner spinner_3;
    @BindView(R.id.textViewTask3Condition2)
            TextView textViewTask3Condition2;
    @BindView(R.id.textViewTask3fx)
            TextView textViewTask3fx;
    @BindView(R.id.edit_text_layout_3)
            TextInputLayout edit_text_layout_3;
    @BindView(R.id.textViewTask3Gap)
            TextView textViewTask3Gap;
    @BindView(R.id.edit_text_layout_3_gap_1)
            TextInputLayout edit_text_layout_3_gap_1;
    @BindView(R.id.textViewTask3Gap2)
            TextView textViewTask3Gap2;
    @BindView(R.id.edit_text_layout_3_gap_2)
            TextInputLayout edit_text_layout_3_gap_2;
    @BindView(R.id.textViewTask3Gap3)
            TextView textViewTask3Gap3;
    @BindView(R.id.textViewTask3Accuracy)
            TextView textViewTask3Accuracy;
    @BindView(R.id.keyboardLayout2)
            LinearLayout keyboardLayout2;
    @BindView(R.id.textViewTask3Answer)
            TextView textViewTask3Answer;
    @BindView(R.id.button3)
            MaterialButton button3;
@BindView(R.id.inputAB)
    TextInputEditText inputAB;
    @BindView(R.id.inputBC)
    TextInputEditText inputBC;
    @BindView(R.id.inputCD)
    TextInputEditText inputCD;
    @BindView(R.id.inputDA)
    TextInputEditText inputDA;
    @BindView(R.id.input1)
    TextInputEditText input_2_step;

    @BindView(R.id.input2)
    TextInputEditText input_3_fx;
    @BindView(R.id.edit_text_3_gap_1)
    TextInputEditText input_3_gap_1;
    @BindView(R.id.edit_text_3_gap_2)
    TextInputEditText input_3_gap_2;
    @BindView(R.id.linearTableTask2Answer)
    LinearLayout linearTableTask2Answer;
    @BindView(R.id.keyboard2Button24)
            MaterialButton keyboardButtonApper;
    TextInputEditText currentET;
    boolean isApper = false;
    int currentTask;
    ArrayList<ArrayList<Double>> tableTask2Double;
    String fx_full_text;


            ArrayList<ArrayList<Double>> deltas;
    ArrayList<Double> xarray, yarray, xarray2;
    ArrayList<TextInputEditText> xarrayEditText, yarrayEditText, x2arrayEditText;
    public RGRFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RGRFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RGRFragment newInstance(String param1, String param2) {
        RGRFragment fragment = new RGRFragment();
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
        v = inflater.inflate(R.layout.fragment_r_g_r, container, false);
        unbinder = ButterKnife.bind(this, v);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        xarrayEditText  = new ArrayList<TextInputEditText>();
        yarrayEditText  = new ArrayList<TextInputEditText>();
        x2arrayEditText  = new ArrayList<TextInputEditText>();
        fx_text_array = new ArrayList<ArrayList<String>>();
        currentET = inputAB;
        currentTask = 1;
        motionLayout.addTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
                task1Button.setClickable(false);
                task2Button.setClickable(false);
                task3Button.setClickable(false);

                if((i1 == R.id.set_1_1&&motionLayout.getProgress()<0.5)||(i==R.id.set_1_1&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set1_1");
                    textViewTask1Condition.setVisibility(View.VISIBLE);
                    linearButtonsOfTable.setVisibility(View.VISIBLE);
                    linearTableMaun2.setVisibility(View.VISIBLE);
                    horizontalTableOfX.setVisibility(View.VISIBLE);
                    buttonsOfX.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                }
                else if((i1 == R.id.set_1_2&&motionLayout.getProgress()<0.5)||(i==R.id.set_1_2&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set1_2");
                    textViewTask1Condition.setVisibility(View.VISIBLE);
                    linearButtonsOfTable.setVisibility(View.VISIBLE);
                    linearTableMaun2.setVisibility(View.VISIBLE);
                    horizontalTableOfX.setVisibility(View.VISIBLE);
                    buttonsOfX.setVisibility(View.VISIBLE);

                    textViewTask1Answer.setVisibility(View.VISIBLE);
                    cardGraph.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                } else if((i1 == R.id.set_2_1&&motionLayout.getProgress()<0.5)||(i==R.id.set_2_1&&motionLayout.getProgress()>0.5)){

                    Log.i("MyApp", "Start set2_1");
                    textViewTask2Condition.setVisibility(View.VISIBLE);
                    tableTask2.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    textViewTask2Condition2.setVisibility(View.VISIBLE);
                    edit_text_layout_2.setVisibility(View.VISIBLE);
                    keyboardLayout1.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                }else if((i1 == R.id.set_2_2&&motionLayout.getProgress()<0.5)||(i==R.id.set_2_2&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set2_2");
                    textViewTask2Condition.setVisibility(View.VISIBLE);
                    tableTask2.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    textViewTask2Condition2.setVisibility(View.VISIBLE);
                    edit_text_layout_2.setVisibility(View.VISIBLE);


                    tableTask2Answer.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                } else if((i1 == R.id.set_2_3&&motionLayout.getProgress()<0.5)||(i==R.id.set_2_3&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set2_3");
                    textViewTask2Condition.setVisibility(View.VISIBLE);
                    tableTask2.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    textViewTask2Condition2.setVisibility(View.VISIBLE);
                    edit_text_layout_2.setVisibility(View.VISIBLE);


                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                }else if((i1 == R.id.set_3_1&&motionLayout.getProgress()<0.5)||(i==R.id.set_3_1&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set3_1");


                    textViewTask3Condition.setVisibility(View.VISIBLE);
                    spinner_3.setVisibility(View.VISIBLE);
                    textViewTask3Condition2.setVisibility(View.VISIBLE);
                    textViewTask3fx.setVisibility(View.VISIBLE);
                    edit_text_layout_3.setVisibility(View.VISIBLE);
                    textViewTask3Gap.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_1.setVisibility(View.VISIBLE);
                    textViewTask3Gap2.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_2.setVisibility(View.VISIBLE);
                    textViewTask3Gap3.setVisibility(View.VISIBLE);
                    textViewTask3Accuracy.setVisibility(View.VISIBLE);
                    keyboardLayout2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);


                } else if((i1 == R.id.set_3_2&&motionLayout.getProgress()<0.5)||(i==R.id.set_3_2&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set3_2");
                    textViewTask3Condition.setVisibility(View.VISIBLE);
                    spinner_3.setVisibility(View.VISIBLE);
                    textViewTask3Condition2.setVisibility(View.VISIBLE);
                    textViewTask3fx.setVisibility(View.VISIBLE);
                    edit_text_layout_3.setVisibility(View.VISIBLE);
                    textViewTask3Gap.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_1.setVisibility(View.VISIBLE);
                    textViewTask3Gap2.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_2.setVisibility(View.VISIBLE);
                    textViewTask3Gap3.setVisibility(View.VISIBLE);
                    textViewTask3Accuracy.setVisibility(View.VISIBLE);


                    textViewTask3Answer.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                }else if((i1 == R.id.set_3_3&&motionLayout.getProgress()<0.5)||(i==R.id.set_3_3&&motionLayout.getProgress()>0.5)){
                    Log.i("MyApp", "Start set3_1");
                    textViewTask3Condition.setVisibility(View.VISIBLE);
                    spinner_3.setVisibility(View.VISIBLE);
                    textViewTask3Condition2.setVisibility(View.VISIBLE);
                    textViewTask3fx.setVisibility(View.VISIBLE);
                    edit_text_layout_3.setVisibility(View.VISIBLE);
                    textViewTask3Gap.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_1.setVisibility(View.VISIBLE);
                    textViewTask3Gap2.setVisibility(View.VISIBLE);
                    edit_text_layout_3_gap_2.setVisibility(View.VISIBLE);
                    textViewTask3Gap3.setVisibility(View.VISIBLE);
                    textViewTask3Accuracy.setVisibility(View.VISIBLE);

                    button3.setVisibility(View.VISIBLE);

                    task1Button.setAlpha(1.0f);
                    task2Button.setAlpha(1.0f);
                    task3Button.setAlpha(1.0f);
                }
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                Log.i("tra", String.valueOf(textViewTask3Answer.getVisibility()));

            }


            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                task1Button.setClickable(true);
                task2Button.setClickable(true);
                task3Button.setClickable(true);
                if(motionLayout.getCurrentState() == R.id.set_1_1){
                    currentTask = 1;
                    Log.i("MyApp", "End set1_1");
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);


                    textViewTask2Condition.setVisibility(View.GONE);
                    tableTask2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    textViewTask2Condition2.setVisibility(View.GONE);
                    edit_text_layout_2.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);
                    tableTask2Answer.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);



                    textViewTask3Condition.setVisibility(View.GONE);
                    spinner_3.setVisibility(View.GONE);
                    textViewTask3Condition2.setVisibility(View.GONE);
                    textViewTask3fx.setVisibility(View.GONE);
                    edit_text_layout_3.setVisibility(View.GONE);
                    textViewTask3Gap.setVisibility(View.GONE);
                    edit_text_layout_3_gap_1.setVisibility(View.GONE);
                    textViewTask3Gap2.setVisibility(View.GONE);
                    edit_text_layout_3_gap_2.setVisibility(View.GONE);
                    textViewTask3Gap3.setVisibility(View.GONE);
                    textViewTask3Accuracy.setVisibility(View.GONE);
                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                } else if(motionLayout.getCurrentState() == R.id.set_1_2){
                    currentTask = 1;
                    Log.i("MyApp", "End set1_2");
                    button1.setVisibility(View.GONE);


                    textViewTask2Condition.setVisibility(View.GONE);
                    tableTask2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    textViewTask2Condition2.setVisibility(View.GONE);
                    edit_text_layout_2.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);
                    tableTask2Answer.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);



                    textViewTask3Condition.setVisibility(View.GONE);
                    spinner_3.setVisibility(View.GONE);
                    textViewTask3Condition2.setVisibility(View.GONE);
                    textViewTask3fx.setVisibility(View.GONE);
                    edit_text_layout_3.setVisibility(View.GONE);
                    textViewTask3Gap.setVisibility(View.GONE);
                    edit_text_layout_3_gap_1.setVisibility(View.GONE);
                    textViewTask3Gap2.setVisibility(View.GONE);
                    edit_text_layout_3_gap_2.setVisibility(View.GONE);
                    textViewTask3Gap3.setVisibility(View.GONE);
                    textViewTask3Accuracy.setVisibility(View.GONE);
                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                }
                else if(motionLayout.getCurrentState() == R.id.set_2_1){
                    currentTask = 2;
                    Log.i("MyApp", "End set2_1");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    tableTask2Answer.setVisibility(View.GONE);


                    textViewTask3Condition.setVisibility(View.GONE);
                    spinner_3.setVisibility(View.GONE);
                    textViewTask3Condition2.setVisibility(View.GONE);
                    textViewTask3fx.setVisibility(View.GONE);
                    edit_text_layout_3.setVisibility(View.GONE);
                    textViewTask3Gap.setVisibility(View.GONE);
                    edit_text_layout_3_gap_1.setVisibility(View.GONE);
                    textViewTask3Gap2.setVisibility(View.GONE);
                    edit_text_layout_3_gap_2.setVisibility(View.GONE);
                    textViewTask3Gap3.setVisibility(View.GONE);
                    textViewTask3Accuracy.setVisibility(View.GONE);
                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    if(currentET!=inputBC&&currentET!=inputCD&&currentET!=inputDA&&currentET!=input_2_step){
                        inputAB.requestFocus();
                    }
                    //motionLayout.transitionToState(R.id.set_1_1);
                } else if(motionLayout.getCurrentState() == R.id.set_2_2){
                    currentTask = 2;
                    Log.i("MyApp", "End set2_2");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    keyboardLayout1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);


                    textViewTask3Condition.setVisibility(View.GONE);
                    spinner_3.setVisibility(View.GONE);
                    textViewTask3Condition2.setVisibility(View.GONE);
                    textViewTask3fx.setVisibility(View.GONE);
                    edit_text_layout_3.setVisibility(View.GONE);
                    textViewTask3Gap.setVisibility(View.GONE);
                    edit_text_layout_3_gap_1.setVisibility(View.GONE);
                    textViewTask3Gap2.setVisibility(View.GONE);
                    edit_text_layout_3_gap_2.setVisibility(View.GONE);
                    textViewTask3Gap3.setVisibility(View.GONE);
                    textViewTask3Accuracy.setVisibility(View.GONE);
                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);
                }else if(motionLayout.getCurrentState() == R.id.set_2_3){
                    currentTask = 2;
                    Log.i("MyApp", "End set2_1");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    tableTask2Answer.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);

                    textViewTask3Condition.setVisibility(View.GONE);
                    spinner_3.setVisibility(View.GONE);
                    textViewTask3Condition2.setVisibility(View.GONE);
                    textViewTask3fx.setVisibility(View.GONE);
                    edit_text_layout_3.setVisibility(View.GONE);
                    textViewTask3Gap.setVisibility(View.GONE);
                    edit_text_layout_3_gap_1.setVisibility(View.GONE);
                    textViewTask3Gap2.setVisibility(View.GONE);
                    edit_text_layout_3_gap_2.setVisibility(View.GONE);
                    textViewTask3Gap3.setVisibility(View.GONE);
                    textViewTask3Accuracy.setVisibility(View.GONE);
                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);
                }else if(motionLayout.getCurrentState() == R.id.set_3_1){
                    currentTask = 3;

                    Log.i("MyApp", "End set3_1");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    textViewTask2Condition.setVisibility(View.GONE);
                    tableTask2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    textViewTask2Condition2.setVisibility(View.GONE);
                    edit_text_layout_2.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);
                    tableTask2Answer.setVisibility(View.GONE);



                    textViewTask3Answer.setVisibility(View.GONE);
                    if(currentET!=input_3_gap_1&&currentET!=input_3_gap_2){
                        input_3_fx.requestFocus();
                    }
                    //motionLayout.transitionToState(R.id.set_1_1);
                } else if(motionLayout.getCurrentState() == R.id.set_3_2){
                    currentTask = 3;
                    Log.i("MyApp", "End set3_2");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    textViewTask2Condition.setVisibility(View.GONE);
                    tableTask2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    textViewTask2Condition2.setVisibility(View.GONE);
                    edit_text_layout_2.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);
                    tableTask2Answer.setVisibility(View.GONE);



                    keyboardLayout2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);
                }else if(motionLayout.getCurrentState() == R.id.set_3_3){
                    currentTask = 3;
                    Log.i("MyApp", "End set3_1");
                    textViewTask1Condition.setVisibility(View.GONE);
                    linearButtonsOfTable.setVisibility(View.GONE);
                    linearTableMaun2.setVisibility(View.GONE);
                    horizontalTableOfX.setVisibility(View.GONE);
                    buttonsOfX.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    textViewTask1Answer.setVisibility(View.GONE);
                    cardGraph.setVisibility(View.GONE);

                    textViewTask2Condition.setVisibility(View.GONE);
                    tableTask2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    textViewTask2Condition2.setVisibility(View.GONE);
                    edit_text_layout_2.setVisibility(View.GONE);
                    keyboardLayout1.setVisibility(View.GONE);
                    tableTask2Answer.setVisibility(View.GONE);



                    textViewTask3Answer.setVisibility(View.GONE);
                    keyboardLayout2.setVisibility(View.GONE);
                    //motionLayout.transitionToState(R.id.set_1_1);
                }

            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
        input_3_fx.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
Log.i("APP", Html.toHtml(input_3_fx.getText()));
            }
        });

        inputAB.setShowSoftInputOnFocus(false);
        inputBC.setShowSoftInputOnFocus(false);
        inputCD.setShowSoftInputOnFocus(false);
        inputDA.setShowSoftInputOnFocus(false);
        input_3_fx.setShowSoftInputOnFocus(false);
        input_2_step.setShowSoftInputOnFocus(false);
        input_3_gap_1.setShowSoftInputOnFocus(false);
        input_3_gap_2.setShowSoftInputOnFocus(false);
        inputAB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = inputAB;
                    if(motionLayout.getCurrentState()!=R.id.set_2_1){
                        motionLayout.transitionToState(R.id.set_2_1);
                    }
                                    }
            }
        });
        inputBC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = inputBC;
                    if(motionLayout.getCurrentState()!=R.id.set_2_1){
                        motionLayout.transitionToState(R.id.set_2_1);
                    }
                }
            }
        });
        inputCD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = inputCD;
                    if(motionLayout.getCurrentState()!=R.id.set_2_1){
                        motionLayout.transitionToState(R.id.set_2_1);
                    }
                }
            }
        });
        inputDA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = inputDA;
                    if(motionLayout.getCurrentState()!=R.id.set_2_1){
                        motionLayout.transitionToState(R.id.set_2_1);
                    }
                }
            }
        });
        input_3_fx.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = input_3_fx;
                    if(motionLayout.getCurrentState()!=R.id.set_3_1){
                        motionLayout.transitionToState(R.id.set_3_1);
                    }
                }
            }
        });
        input_2_step.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = input_2_step;
                    if(motionLayout.getCurrentState()!=R.id.set_2_1){
                        motionLayout.transitionToState(R.id.set_2_1);
                    }
                }
            }
        });
        input_3_gap_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = input_3_gap_1;
                    if(motionLayout.getCurrentState()!=R.id.set_3_1){
                        motionLayout.transitionToState(R.id.set_3_1);
                    }
                }
            }
        });
        input_3_gap_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    hideKeyboard();
                    currentET = input_3_gap_2;
                    if(motionLayout.getCurrentState()!=R.id.set_3_1){
                        motionLayout.transitionToState(R.id.set_3_1);
                    }
                }
            }
        });
        return v;
    }
    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }
    @OnClick(R.id.textViewTask1)
    void onClickTask1(){

        if(!(motionLayout.getCurrentState() == R.id.set_1_1 ||motionLayout.getCurrentState() == R.id.set_1_2)){
            motionLayout.transitionToState(R.id.set_1_1);
        }
    }

    @OnClick(R.id.textViewTask2)
    void onClickTask2(){
        //motionLayout.transitionToState(R.id.set_1_1);
        if(!(motionLayout.getCurrentState() == R.id.set_2_1 /*||motionLayout.getCurrentState() == R.id.set_2_2*/)){
            motionLayout.transitionToState(R.id.set_2_1);
        }
    }

    @OnClick(R.id.textViewTask3)
    void onClickTask3(){
        //motionLayout.transitionToState(R.id.set_1_1);
        if(!(motionLayout.getCurrentState() == R.id.set_3_1 /*||motionLayout.getCurrentState() == R.id.set_2_2*/)){
            motionLayout.transitionToState(R.id.set_3_1);
        }
    }

    @OnClick(R.id.button1)
    void onClickButton1(){
        try {
            xarray  = new ArrayList<Double>();
            yarray  = new ArrayList<Double>();
            xarray2  = new ArrayList<Double>();
            deltas = new ArrayList<ArrayList<Double>>();
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
            deltas.add(yarray);
            for (int j = 1; j < xarray.size(); j++){
                ArrayList<Double> arrayList = new ArrayList<Double>();
                for (int k = 0; k < deltas.get(j-1).size()-1; k++){
                    arrayList.add(deltas.get(j-1).get(k+1)-deltas.get(j-1).get(k));
                }
                deltas.add(arrayList);
            }
            String text1 = "";

            ArrayList<Double> yarrayNew  = new ArrayList<Double>();
            for (int k = 0; k < xarray2.size(); k++){
                int n = -1;
                int deltasLineCounter = 1;
                ArrayList<Double> deltasLine = new ArrayList<>();
                for (int l = 0; l < yarray.size(); l ++){
                    double myX = xarray2.get(k);
                    if (l<yarray.size()/2){
                        if (!(myX>xarray.get(l))&&!(myX<xarray.get(l))){
                            n = l;
                            break;
                        } else
                        if (myX<xarray.get(l)){
                            n = l-1;
                            break;
                        }
                    } else {

                        if (!(myX>(xarray.get(xarray.size()+(xarray.size()/2)-l-1)))&&!(myX<(xarray.get(xarray.size()+(xarray.size()/2)-l-1)))){
                            n = xarray.size()+(xarray.size()/2)-l;
                            System.out.println("var 3");

                            break;
                        } else
                        if (myX>xarray.get(xarray.size()+(xarray.size()/2)-l-1)){
                            n = xarray.size()+(xarray.size()/2)-l;
                            System.out.println("var 4");
                            break;
                        }
                    }
                }
                if (n==-1){
                    n = xarray.size()/2;
                }

                double h = xarray.get(1)-xarray.get(0);
                double q = (xarray2.get(k)-xarray.get(n))/h;
                if (n <yarray.size()/2) {
                    System.out.println("less, h="+h+" q="+ q+" x="+xarray.get(n)+" n="+n);
                    while (deltas.get(deltasLineCounter).size() > n) {
                        deltasLine.add(deltas.get(deltasLineCounter).get(n));
                        if (deltas.size()-1>deltasLineCounter){
                            deltasLineCounter += 1;
                        } else {
                            break;
                        }
                    }

                    double result = yarray.get(n);

                    for (int i = 1; i < deltasLine.size()+1; i++){
                        double partOfResult = 1.0;
                        System.out.println("res="+result);
                        for(int j = 0; j < i; j++){
                            partOfResult*=(q-j);
                        }
                        partOfResult/=getFactorial(i);
                        partOfResult*=deltasLine.get(i-1);
                        System.out.println("resPart="+partOfResult);
                        result+=partOfResult;
                    }
                    System.out.println("result" +result);
                    Double resDouble = Double.parseDouble(round(result, 4));
                    yarrayNew.add(resDouble);
                    text1 += "f(" + xarray2.get(k) +") ≈ " + round(result, 4) +"\n";
                } else {

                    for (int g = 0; g < n; g++){
                        deltasLine.add(deltas.get(g+1).get(n-g-1));
                    }
                    System.out.println("more, h="+h+" q="+ q+" x="+xarray.get(n)+" n="+n);

                    double result = yarray.get(n);

                    for (int i = 1; i < deltasLine.size()+1; i++){
                        double partOfResult = 1.0;
                        System.out.println("res="+result);
                        for(int j = 0; j < i; j++){
                            partOfResult*=(q+j);
                        }
                        partOfResult/=getFactorial(i);
                        partOfResult*=deltasLine.get(i-1);
                        System.out.println("resPart="+partOfResult);
                        result+=partOfResult;
                    }
                    System.out.println("result" +result);
                    Double resDouble = Double.parseDouble(round(result, 4));
                    yarrayNew.add(resDouble);
                    text1 += "f(" + xarray2.get(k) +") ≈ " + round(result, 4) +"\n";
                }
                textViewTask1Answer.setText(text1);
                if (xarray2.size()==yarrayNew.size()){
                    for(int i = 0; i < xarray2.size(); i++){
                        xarray.add(xarray2.get(i));
                        yarray.add(yarrayNew.get(i));
                    }
                    Collections.sort(xarray);
                    Collections.sort(yarray);
                }
                DataPoint[] dataPoints = new DataPoint[xarray.size()]; // declare an array of DataPoint objects with the same size as your list
                for (int i = 0; i < xarray.size(); i++) {
                    // add new DataPoint object to the array for each of your list entries
                    dataPoints[i] = new DataPoint(xarray.get(i), yarray.get(i)); // not sure but I think the second argument should be of type double
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
                double minY = 0.0;
                double maxY = 0.0;
                if(yarray.get(0) > yarray.get(yarray.size()-1)){
                    maxY = yarray.get(0);
                    minY = yarray.get(yarray.size()-1);
                } else {
                    minY = yarray.get(0);
                    maxY = yarray.get(yarray.size()-1);
                }
                PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(dataPoints);
                graph.removeAllSeries();
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setMinY(minY - 2);
                graph.getViewport().setMaxY(maxY+1);
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(xarray.get(0) - 1);
                graph.getViewport().setMaxX(xarray.get(xarray.size() - 1) + 1);
                series.setColor(getResources().getColor(R.color.colorAccent));
                series1.setColor(getResources().getColor(R.color.colorAccent));
                graph.addSeries(series);
                graph.addSeries(series1);
                series1.setShape(PointsGraphSeries.Shape.POINT);
                double finalMinY = minY-2;
                double finalMaxY = maxY+1;
                motionLayout.transitionToState(R.id.set_1_2);
                graph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(getActivity(), GraphActivity.class);
                            intent.putExtra("xarray", xarray);
                            intent.putExtra("yarray", yarray);
                            intent.putExtra("xarrayNew", xarray);
                            intent.putExtra("yarrayNew", yarray);
                            intent.putExtra("minY", finalMinY );
                            intent.putExtra("maxY", finalMaxY);
                            intent.putExtra("minX", xarray.get(0) - 1 );
                            intent.putExtra("maxX", xarray.get(xarray.size() - 1) + 1 );
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(getActivity(), (View) graph, "profile");
                            startActivity(intent, options.toBundle());
                        } catch (NullPointerException e) {
                            vibro();
                            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
/*
               

 */
            }
        } catch (NumberFormatException e){
            vibro();
            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.button2)
    void onClickButton2(){
        try {

            tableTask2Double = new ArrayList<ArrayList<Double>>();
            double step = Double.parseDouble(input_2_step.getText().toString());


            if((Math.abs((int) Math.round(1/step) - 1/step) <0.001)&&step<=1&&step>0){
                int rows = (int) Math.round(1/step)+1;
                for (int i = 0; i < rows; i++){
                    ArrayList<Double> row = new ArrayList<>();
                    for ( int j = 0; j < rows; j++){
                        row.add(0.0);
                    }
                    tableTask2Double.add(row);
                }
                String AB = textToFormula(inputAB.getText().toString());
                String BC = textToFormula(inputBC.getText().toString());
                String CD = textToFormula(inputCD.getText().toString());
                String DA = textToFormula(inputDA.getText().toString());

                double x = 0;
                double y = 0;
                for (int j = 0; j < rows; j++){
                    String temp = AB;
                    temp = temp.replaceAll("X", String.valueOf(x));
                    temp = temp.replaceAll("Y", String.valueOf(y));

                    Expression expressionCheck = new Expression(temp);
                    expressionCheck.checkSyntax();
                    mXparser.consolePrint(expressionCheck.getErrorMessage());
                    if (expressionCheck.checkSyntax()&&expressionCheck.checkLexSyntax()) {
                        Expression expression = new Expression(temp);

                        Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                        tableTask2Double.get(j).set(0, result);
                        y+=step;
                        Log.i("GGGG", String.valueOf(result));
                    }
                    else {
                        vibro();
                        int open = 0;
                        int close = 0;
                        for (int i = 0; i < temp.length(); i++) {
                            String letter = String.valueOf(temp.charAt(i));
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
                y=1;
                x+=step;
                for (int j = 1; j < rows; j++){
                    String temp = BC;
                    temp = temp.replaceAll("X", String.valueOf(x));
                    temp = temp.replaceAll("Y", String.valueOf(y));

                    Expression expressionCheck = new Expression(temp);
                    expressionCheck.checkSyntax();
                    mXparser.consolePrint(expressionCheck.getErrorMessage());
                    if (expressionCheck.checkSyntax()&&expressionCheck.checkLexSyntax()) {
                        Expression expression = new Expression(temp);

                        Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                        tableTask2Double.get(rows-1).set(j, result);
                        x+=step;
                        Log.i("GGGG", String.valueOf(result));
                    }
                    else {
                        vibro();
                        int open = 0;
                        int close = 0;
                        for (int i = 0; i < temp.length(); i++) {
                            String letter = String.valueOf(temp.charAt(i));
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
                y=0;
                x=1;
                for (int j = 0; j < rows-1; j++){
                    String temp = CD;
                    temp = temp.replaceAll("X", String.valueOf(x));
                    temp = temp.replaceAll("Y", String.valueOf(y));

                    Expression expressionCheck = new Expression(temp);
                    expressionCheck.checkSyntax();
                    mXparser.consolePrint(expressionCheck.getErrorMessage());
                    if (expressionCheck.checkSyntax()&&expressionCheck.checkLexSyntax()) {
                        Expression expression = new Expression(temp);

                        Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                        tableTask2Double.get(j).set(rows-1, result);
                        y+=step;
                        Log.i("GGGG", String.valueOf(result));
                    }
                    else {
                        vibro();
                        int open = 0;
                        int close = 0;
                        for (int i = 0; i < temp.length(); i++) {
                            String letter = String.valueOf(temp.charAt(i));
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
                y=0;
                x=0 + step;
                for (int j = 1; j < rows-1; j++){
                    String temp = DA;
                    temp = temp.replaceAll("X", String.valueOf(x));
                    temp = temp.replaceAll("Y", String.valueOf(y));

                    Expression expressionCheck = new Expression(temp);
                    expressionCheck.checkSyntax();

                    if (expressionCheck.checkSyntax()&&expressionCheck.checkLexSyntax()) {
                        Expression expression = new Expression(temp);

                        Double result = Double.parseDouble(String.valueOf(expression.calculate()));
                        tableTask2Double.get(0).set(j, result);
                        x+=step;
                        Log.i("GGGG", String.valueOf(x));
                        Log.i("GGGG", String.valueOf(y));
                    }
                    else {
                        vibro();
                        int open = 0;
                        int close = 0;
                        for (int i = 0; i < temp.length(); i++) {
                            String letter = String.valueOf(temp.charAt(i));
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
                for (int j = 1; j < rows-1; j++){
                    double start = tableTask2Double.get(j).get(0);
                    double end = tableTask2Double.get(j).get(tableTask2Double.get(j).size()-1);
                    double lineStep = (end - start)/(rows-1);
                    double lineX = start;
                    for (int l = 1; l < rows-1; l++){
                        lineX+=lineStep;
                        tableTask2Double.get(j).set(l, lineX);
                    }
                }
                double oldValue = 0.0;
                double leftValue = 0.0;
                double rightValue = 0.0;
                double topValue = 0.0;
                double bottomValue = 0.0;
                double newValue = 0.0;
                boolean returnFlag = true;
                while (returnFlag) {
                    returnFlag = false;
                    for (int j = 1; j < rows - 1; j++) {

                        for (int l = 1; l < rows - 1; l++) {
                            oldValue = tableTask2Double.get(j).get(l);
                            leftValue = tableTask2Double.get(j).get(l - 1);
                            rightValue = tableTask2Double.get(j).get(l + 1);
                            topValue = tableTask2Double.get(j + 1).get(l);
                            bottomValue = tableTask2Double.get(j - 1).get(l);
                            newValue = (leftValue + rightValue + topValue + bottomValue) / 4;
                            tableTask2Double.get(j).set(l, newValue);
                            if (Math.abs(newValue - oldValue) > 0.1) {
                                returnFlag = true;
                            }
                            Log.i("FFFF", String.valueOf(Math.abs(newValue - oldValue)));
                        }
                    }
                    for (int i = 0; i < rows; i++){
                        Log.i("FFFF", String.valueOf(tableTask2Double.get(rows-1-i)));
                    }
                    Log.i("FFFF", "---------------------");
                }
                editTextParams= new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0, 1);
                editTextParams2= new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
                editTextParams2.setMargins(3, 3, 3, 3);

                linearTableTask2Answer.removeAllViews();
                for (int i = 0; i < rows; i++){
                    LinearLayout linearLayout = new LinearLayout(getContext());
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.grey));
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    linearLayout.setLayoutParams(editTextParams);

                    for (int j = 0; j < rows; j++){
                        TextView textView = new TextView(getContext());
                        textView.setText(round(tableTask2Double.get(rows - 1 -i).get(j), 1));



                        textView.setGravity(Gravity.CENTER);
                        textView.setLayoutParams(editTextParams2);
                        textView.setBackgroundColor(getResources().getColor(R.color.white));
                        linearLayout.addView(textView);
                    }
                    linearTableTask2Answer.addView(linearLayout);
                    currentET.clearFocus();
                    motionLayout.transitionToState(R.id.set_2_2);
                }
                for (int i = 0; i < rows; i++){
                    Log.i("Last", String.valueOf(tableTask2Double.get(rows-1-i)));
                }
            } else {
                vibro();
                Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException e){
            vibro();
            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.button3)
    void onClickButton3(){
        try {
            StringBuilder fx = new StringBuilder();
            for(int i = 0; i < fx_text_array.size(); i ++){
                if(fx_text_array.get(i).get(0).equals("0")){
                    fx.append(fx_text_array.get(i).get(1));
                } else {
                    if(i!=0&&fx_text_array.get(i-1).get(0).equals("0")){
                        fx.append("^(").append(fx_text_array.get(i).get(1)).append(")");
                    } else {
                        fx.deleteCharAt(fx.length()-1);
                        fx.append(fx_text_array.get(i).get(1)).append(")");
                    }
                }
            }
            String fxFormula = textToFormula(String.valueOf(fx));
            boolean exit = true;
            double f = (1+Math.sqrt(5))/2;

            double a = Double.parseDouble(input_3_gap_1.getText().toString());
            double b = Double.parseDouble(input_3_gap_2.getText().toString());
            double x1 = b-((b-a)/f);
            double x2 = a+((b-a)/f);
            while (Math.abs(a-b) >= 0.01) {

                String temp1 = fxFormula.replaceAll("X", String.valueOf(x1));
                String temp2 = fxFormula.replaceAll("X", String.valueOf(x2));

                Expression expressionCheck = new Expression(temp1);
                expressionCheck.checkSyntax();

                if (expressionCheck.checkSyntax() && expressionCheck.checkLexSyntax()) {
                    Expression expression1 = new Expression(temp1);
                    Expression expression2 = new Expression(temp2);
                    double result1 = Double.parseDouble(String.valueOf(expression1.calculate()));
                    double result2 = Double.parseDouble(String.valueOf(expression2.calculate()));
                    Log.i("qwe", "a="+a+", b="+b+", x1="+x1+", x2="+x2+", y1="+result1+", y2="+result2);
                    if(spinner_3.getSelectedItemPosition()==0) {
                        if (result1 < result2) {
                            double x2Temp = x2;
                            x2 = x1;

                            b = x2Temp;
                            x1 = b - ((b - a) / f);
                        } else {
                            double x1Temp = x1;
                            x1 = x2;

                            a = x1Temp;
                            x2 = a + ((b - a) / f);
                        }
                    } else if(spinner_3.getSelectedItemPosition()==1) {
                        if (result1 > result2) {
                            double x2Temp = x2;
                            x2 = x1;

                            b = x2Temp;
                            x1 = b - ((b - a) / f);
                        } else {
                            double x1Temp = x1;
                            x1 = x2;

                            a = x1Temp;
                            x2 = a + ((b - a) / f);
                        }
                    }

                } else {
                    vibro();
                    int open = 0;
                    int close = 0;
                    for (int i = 0; i < temp1.length(); i++) {
                        String letter = String.valueOf(temp1.charAt(i));
                        if (letter.equals("(")) {
                            open += 1;
                        }
                        if (letter.equals(")")) {
                            close += 1;
                        }
                    }
                    System.out.println("open=" + open);
                    System.out.println("close=" + close);
                    if (open < close) {
                        Toast.makeText(getActivity(), R.string.open_parentheses, Toast.LENGTH_SHORT).show();
                    } else if (open > close) {
                        Toast.makeText(getActivity(), R.string.close_parentheses, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                    }
                    return;
                }


            }
            double lastX = (a+b)/2;
            String lastFormula = fxFormula.replaceAll("X", String.valueOf(lastX));
            Expression expression = new Expression(lastFormula);

            double result = Double.parseDouble(String.valueOf(expression.calculate()));
            String answer = "";
            Log.i("sdada", "LastX="+lastX+"lastY="+result);
            if (spinner_3.getSelectedItemPosition()==0){
                 answer = "x<sub><small>min</small></sub>≈"+round(lastX, 2) + ", y<sub><small>min</small></sub>≈"+round(result, 2);
            } else if (spinner_3.getSelectedItemPosition()==1){
                answer = "x<sub><small>max</small></sub>≈"+round(lastX, 2) + ", y<sub><small>max</small></sub>≈"+round(result, 2);
            }

            textViewTask3Answer.setText(Html.fromHtml(answer), TextView.BufferType.SPANNABLE);
            //textViewTask3Answer.setText(Html.fromHtml(answer));
            currentET.clearFocus();

            motionLayout.transitionToState(R.id.set_3_2);
        } catch (NumberFormatException e){
            vibro();
            Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }

    }
    private static String round(double value, int pow) {
        long factor = (long) Math.pow(10, pow);
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
public String textToFormula(String conditionLine){
    conditionLine = conditionLine.replaceAll("×", "*");
    conditionLine = conditionLine.replaceAll("²", "^2");
    conditionLine = conditionLine.replaceAll("√", "sqrt");
    conditionLine = conditionLine.replaceAll("X", "(X)");
    conditionLine = conditionLine.replaceAll("Y", "(Y)");
    conditionLine = conditionLine.replaceAll("π", "pi");
    conditionLine = conditionLine.replaceAll("arctg", "arctan");
    for (int i = 0; i < conditionLine.length()-1; i++) {
        String letter1 = String.valueOf(conditionLine.charAt(i));
        String letter2 = String.valueOf(conditionLine.charAt(i+1));
        if ((letter2.equals("("))&&((!letter1.equals("+"))&&(!letter1.equals("-"))&&(!letter1.equals("/"))&&(!letter1.equals("*"))&&(!letter1.equals("("))&&(!letter1.equals("n"))&&(!letter1.equals("s"))&&(!letter1.equals("g"))&&(!letter1.equals("t"))&&(!letter1.equals("^")))){
            conditionLine = conditionLine.substring(0, i+1) + "*" + conditionLine.substring(i+1, conditionLine.length());
        }
        if ((letter2.equals("a")||letter2.equals("s")||letter2.equals("c")||letter2.equals("")||letter2.equals("l")||letter2.equals("e"))&&((!letter1.equals("+"))&&(!letter1.equals("-"))&&(!letter1.equals("/"))&&(!letter1.equals("*"))&&(!letter1.equals("("))&&(!letter1.equals("o"))&&(!letter1.equals("r"))&&(!letter1.equals("t")))){
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
    return conditionLine;
}
    public void vibro(){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(200);
        }
    }

    private void updateText(String strToAdd){

        String oldStr = currentET.getText().toString();
        int cursorPos = currentET.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (currentET == input_3_fx){
            ArrayList<String> newSymbol = new ArrayList<>();
            if(isApper){

                newSymbol.add("1");
                newSymbol.add(strToAdd);


            } else {
                newSymbol.add("0");
                newSymbol.add(strToAdd);
            }
            fx_text_array.add(cursorPos, newSymbol);
            StringBuilder newText = new StringBuilder();
            for(int i = 0; i < fx_text_array.size(); i++){
                if(fx_text_array.get(i).get(0).equals("0")){
                    newText.append(fx_text_array.get(i).get(1));
                } else {
                    newText.append("<sup><small>");
                    newText.append(fx_text_array.get(i).get(1));
                    newText.append("</sup></small>");
                }
            }
            if ((!strToAdd.equals(")"))&&strToAdd.endsWith(")")){
                cursorPos-=1;
            }
            currentET.setText(Html.fromHtml(String.valueOf(newText)));
            Log.i("FDFDF", Html.toHtml(new SpannableString(currentET.getText())));
            currentET.setSelection(cursorPos + strToAdd.length());
        } else {
            if ((!strToAdd.equals(")"))&&strToAdd.endsWith(")")){
                cursorPos-=1;
            }
            currentET.setText(Html.fromHtml(String.format("%s%s%s", leftStr, strToAdd, rightStr)));
            Log.i("FDFDF", Html.toHtml(new SpannableString(currentET.getText())));
            currentET.setSelection(cursorPos + strToAdd.length());
        }



    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("currentProfileRGR", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    public Profile getData(Profile currentProfile){
        ArrayList<String> xarray = new ArrayList<>();
        ArrayList<String> xarray2 = new ArrayList<>();
        ArrayList<String> yarray = new ArrayList<>();

        for (int i = 0; i < xarrayEditText.size(); i++){
            xarray.add(xarrayEditText.get(i).getText().toString());
            yarray.add(yarrayEditText.get(i).getText().toString());
        }
        for (int i = 0; i < x2arrayEditText.size(); i++){
            xarray2.add(x2arrayEditText.get(i).getText().toString());
        }
        currentProfile.xarray_rgr = xarray;
        currentProfile.xarray_rgr_2 = xarray2;
        currentProfile.yarray_rgr = yarray;

        currentProfile.rgr_ab = inputAB.getText().toString();
        currentProfile.rgr_bc = inputBC.getText().toString();
        currentProfile.rgr_cd = inputCD.getText().toString();
        currentProfile.rgr_da = inputDA.getText().toString();
        currentProfile.rgr_2_step = input_2_step.getText().toString();

        currentProfile.rgr_fx_array = fx_text_array;
        currentProfile.rgr_3_gep_1 = input_3_gap_1.getText().toString();
        currentProfile.rgr_3_gep_2 = input_3_gap_2.getText().toString();
        currentProfile.rgr_less_more = spinner_3.getSelectedItemPosition() == 0;
        currentProfile.rgr_task = currentTask;
        return currentProfile;
    }
    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();
        if (currentProfile.xarray_rgr!=null) {
            createTablePoints(currentProfile.xarray_rgr.size(), xarrayEditText, linearX, 0, 0);
            createTablePoints(currentProfile.xarray_rgr.size(), yarrayEditText, linearY, 0, 1);
            for (int i = 0; i < currentProfile.xarray_rgr.size(); i++){
                xarrayEditText.get(i).setText(currentProfile.xarray_rgr.get(i));
                yarrayEditText.get(i).setText(currentProfile.yarray_rgr.get(i));
            }
        } else {
            createTablePoints(11, xarrayEditText, linearX, 0, 0);
            createTablePoints(11, yarrayEditText, linearY, 0, 1);
        }
        if (currentProfile.xarray_rgr_2!= null){
            createTablePoints(currentProfile.xarray_rgr_2.size(), x2arrayEditText, linearX2, 1, 0);
            for (int i = 0; i < currentProfile.xarray_rgr_2.size(); i++){
                x2arrayEditText.get(i).setText(currentProfile.xarray_rgr_2.get(i));
            }
        } else {
            createTablePoints(2, x2arrayEditText, linearX2, 1, 0);
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
        inputAB.setText(currentProfile.rgr_ab);
        inputBC.setText(currentProfile.rgr_bc);
        inputCD.setText(currentProfile.rgr_cd);
        inputDA.setText(currentProfile.rgr_da);
        input_2_step.setText(currentProfile.rgr_2_step);
        StringBuilder newText = new StringBuilder();
        if (currentProfile.rgr_fx_array != null) {

            for (int i = 0; i < currentProfile.rgr_fx_array.size(); i++) {
                if (currentProfile.rgr_fx_array.get(i).get(0).equals("0")) {
                    newText.append(currentProfile.rgr_fx_array.get(i).get(1));
                } else {
                    newText.append("<sup><small>");
                    newText.append(currentProfile.rgr_fx_array.get(i).get(1));
                    newText.append("</sup></small>");
                }
            }
            fx_text_array = currentProfile.rgr_fx_array;
        } else {
            fx_text_array = new ArrayList<ArrayList<String>>();
        }

        input_3_fx.setText(Html.fromHtml(String.valueOf(newText)));

        input_3_gap_1.setText(currentProfile.rgr_3_gep_1);
        input_3_gap_2.setText(currentProfile.rgr_3_gep_2);
        if (currentProfile.rgr_less_more){
            spinner_3.setSelection(0);
        } else {
            spinner_3.setSelection(1);
        }
        currentTask = currentProfile.rgr_task;
        if((currentProfile.rgr_task == 1 && motionLayout.getCurrentState()!=R.id.set_1_1)||(currentProfile.rgr_task == 1 && motionLayout.getCurrentState()!=R.id.set_1_2)){
            Log.i("MYAPP", String.valueOf(task1Button.getAlpha()));
            motionLayout.transitionToState(R.id.set_1_1);
            // motionLayout.setProgress(1f);
        } else if((currentProfile.rgr_task == 2 && motionLayout.getCurrentState()!=R.id.set_2_1)||(currentProfile.rgr_task == 2 && motionLayout.getCurrentState()!=R.id.set_2_2)){
            motionLayout.transitionToState(R.id.set_2_1);
            //motionLayout.setProgress(1f);
            Log.i("MYAPP", String.valueOf(task1Button.getAlpha()));
        } else if((currentProfile.rgr_task == 3 && motionLayout.getCurrentState()!=R.id.set_3_1)||(currentProfile.rgr_task == 3 && motionLayout.getCurrentState()!=R.id.set_3_2)){
            motionLayout.transitionToState(R.id.set_3_1);
            //motionLayout.setProgress(1f);
            Log.i("MYAPP", String.valueOf(task1Button.getAlpha()));
        } else {
            motionLayout.transitionToState(R.id.set_1_1);
            //motionLayout.setProgress(1f);
        }
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
        for (int i = 0; i < x2arrayEditText.size(); i++){
            xarray2.add(x2arrayEditText.get(i).getText().toString());
        }
        currentProfile.xarray_rgr = xarray;
        currentProfile.xarray_rgr_2 = xarray2;
        currentProfile.yarray_rgr = yarray;

        currentProfile.rgr_ab = inputAB.getText().toString();
        currentProfile.rgr_bc = inputBC.getText().toString();
        currentProfile.rgr_cd = inputCD.getText().toString();
        currentProfile.rgr_da = inputDA.getText().toString();
        currentProfile.rgr_2_step = input_2_step.getText().toString();

        currentProfile.rgr_fx_array = fx_text_array;
        currentProfile.rgr_3_gep_1 = input_3_gap_1.getText().toString();
        currentProfile.rgr_3_gep_2 = input_3_gap_2.getText().toString();
        currentProfile.rgr_less_more = spinner_3.getSelectedItemPosition() == 0;
        currentProfile.rgr_task = currentTask;


        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson2 = new Gson();
        String json2 = gson2.toJson(currentProfile);
        editor.putString("currentProfileRGR", json2);
        editor.apply();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
    @OnClick(R.id.buttonMinus)
    void onButtonMinusClick(){
        if(motionLayout.getCurrentState() == R.id.set_1_2){
            motionLayout.transitionToState(R.id.set_1_1);
        }
        String textN = textViewN.getText().toString().substring(2);
        int n = Integer.parseInt(textN)-1;
        if (n==2){
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus.setClickable(false);
        }
        int index = linearX.getChildCount()-1;
        deleteTablePoint(xarrayEditText, linearX, 1, 0);
        deleteTablePoint(yarrayEditText, linearY, 1, 1);
        textViewN.setText("n="+n);
    }
    @OnClick(R.id.buttonPlus)
    void onButtonPlusClick(){
        if(motionLayout.getCurrentState() == R.id.set_1_2){
            motionLayout.transitionToState(R.id.set_1_1);
        }
        String textN = textViewN.getText().toString().substring(2);
        int n = Integer.parseInt(textN)+1;
        if (n==3){
            buttonMinus.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus.setClickable(true);
        }
        createTablePoint(xarrayEditText, linearX, 0, 0);
        createTablePoint(yarrayEditText, linearY, 0, 1);
        textViewN.setText("n="+n);
        motionLayout.transitionToState(R.id.set_1_1);
    }
    @OnClick(R.id.buttonPlus2)
    void onButtonPlus2Click(){
        if(motionLayout.getCurrentState() == R.id.set_1_2){
            motionLayout.transitionToState(R.id.set_1_1);
        }
        String textN = textViewN2.getText().toString().substring(2);
        int n = Integer.parseInt(textN)+1;
        if (n==2){
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            buttonMinus2.setClickable(true);
        }
        createTablePoint(x2arrayEditText, linearX2, 1, 1);
        textViewN2.setText("i="+n);
    }
    @OnClick(R.id.buttonMinus2)
    void onButtonMinus2Click(){
        if(motionLayout.getCurrentState() == R.id.set_1_2){
            motionLayout.transitionToState(R.id.set_1_1);
        }
        String textN = textViewN2.getText().toString().substring(2);
        int n = Integer.parseInt(textN)-1;
        if (n==1){
            buttonMinus2.setBackgroundColor(getResources().getColor(R.color.grey));
            buttonMinus2.setClickable(false);
        }
        deleteTablePoint(x2arrayEditText, linearX2, 0, 0);
        textViewN2.setText("i="+n);
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
    @OnClick(R.id.keyboardButton1)
    void OnClick1(){
        updateText("e");
    }

    @OnClick(R.id.keyboardButton2)
    void OnClick2(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != 0 && textLen != 0) {

            currentET.setSelection(cursorPos - 1);
        }
        else if (currentET == inputBC){
            inputAB.requestFocus();
            inputAB.setSelection(inputAB.getText().length());
        } else if (currentET == inputCD){
            inputBC.requestFocus();
            inputBC.setSelection(inputBC.getText().length());
        } else if (currentET == inputDA){
            inputCD.requestFocus();
            inputCD.setSelection(inputCD.getText().length());
        } else if (currentET == input_2_step){
            inputDA.requestFocus();
            inputDA.setSelection(inputDA.getText().length());
        }
    }

    @OnClick(R.id.keyboardButton3)
    void OnClick3(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != textLen) {

            currentET.setSelection(cursorPos + 1);
        }else if (currentET == inputAB){
            inputBC.requestFocus();
            inputBC.setSelection(0);
        }
        else if (currentET == inputBC){
            inputCD.requestFocus();
            inputCD.setSelection(0);
        } else if (currentET == inputCD){
            inputDA.requestFocus();
            inputDA.setSelection(0);
        } else if (currentET == inputDA){
            input_2_step.requestFocus();
            input_2_step.setSelection(0);
        }
    }

    @OnClick(R.id.keyboardButton0)
    void OnClick0(){

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
        updateText("(");
    }

    @OnClick(R.id.keyboardButton5)
    void OnClick5(){
        updateText(")");
    }

    @OnClick(R.id.keyboardButton6)
    void OnClick6(){
        updateText("√()");
    }

    @OnClick(R.id.keyboardButton7)
    void OnClick7(){
        SpannableStringBuilder selection = (SpannableStringBuilder) currentET.getText();
        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
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
        updateText("sin()");
    }

    @OnClick(R.id.keyboardButton9)
    void OnClick9(){
        updateText("cos()");
    }

    @OnClick(R.id.keyboardButton10)
    void OnClick10(){
        updateText("X");
    }

    @OnClick(R.id.keyboardButton11)
    void OnClick11(){
        updateText("Y");
    }
    @OnClick(R.id.keyboardButton12)
    void OnClick12(){
        updateText("7");
    }

    @OnClick(R.id.keyboardButton13)
    void OnClick13(){
        updateText("8");
    }

    @OnClick(R.id.keyboardButton14)
    void OnClick14(){
        updateText("9");
    }

    @OnClick(R.id.keyboardButton15)
    void OnClick15(){
        updateText("/");
    }

    @OnClick(R.id.keyboardButton16)
    void OnClick16(){
        updateText("4");
    }

    @OnClick(R.id.keyboardButton17)
    void OnClick17(){
        updateText("5");
    }

    @OnClick(R.id.keyboardButton18)
    void OnClick18(){
        updateText("6");
    }

    @OnClick(R.id.keyboardButton19)
    void OnClick19(){
        updateText("×");
    }

    @OnClick(R.id.keyboardButton20)
    void OnClick20(){
        updateText("1");
    }

    @OnClick(R.id.keyboardButton21)
    void OnClick21(){
        updateText("2");
    }

    @OnClick(R.id.keyboardButton22)
    void OnClick22(){
        updateText("3");
    }

    @OnClick(R.id.keyboardButton23)
    void OnClick23(){
        updateText("-");
    }

    @OnClick(R.id.keyboardButton24)
    void OnClick24(){
        updateText("π");
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


    //-----------------------------------------------------------------
    @OnClick(R.id.keyboard2Button1)
    void OnClick2_1(){
        updateText("e");
    }

    @OnClick(R.id.keyboard2Button2)
    void OnClick2_2(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != 0 && textLen != 0) {

            currentET.setSelection(cursorPos - 1);
        }
        else if (currentET == input_3_gap_1){
            input_3_fx.requestFocus();
            input_3_fx.setSelection(input_3_fx.getText().length());
        } else if (currentET == input_3_gap_2){
            input_3_gap_1.requestFocus();
            input_3_gap_1.setSelection(input_3_gap_1.getText().length());
        }
    }

    @OnClick(R.id.keyboard2Button3)
    void OnClick2_3(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();
        if (cursorPos != textLen) {

            currentET.setSelection(cursorPos + 1);
        }else if (currentET == input_3_fx){
            input_3_gap_1.requestFocus();
            input_3_gap_1.setSelection(0);
        }
        else if (currentET == input_3_gap_1){
            input_3_gap_2.requestFocus();
            input_3_gap_2.setSelection(0);
        }
    }

    @OnClick(R.id.keyboard2Button0)
    void OnClick2_0(){

        int cursorPos = currentET.getSelectionStart();
        int textLen = currentET.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) currentET.getText();


            selection.replace(cursorPos - 1, cursorPos, "");
            currentET.setText(selection);
            currentET.setSelection(cursorPos - 1);
            if(currentET==input_3_fx){
                fx_text_array.remove(cursorPos - 1);
            }
            return;

        }
    }


    @OnClick(R.id.keyboard2Button8)
    void OnClick2_8(){
        updateText("a");
        updateText("r");
        updateText("c");
        updateText("t");
        updateText("g");
        updateText("(");
        updateText(")");
    }

    @OnClick(R.id.keyboard2Button9)
    void OnClick2_9(){
        updateText("(");
    }

    @OnClick(R.id.keyboard2Button10)
    void OnClick2_10(){
        updateText(")");
    }

    @OnClick(R.id.keyboard2Button11)
    void OnClick2_11(){
        updateText("X");
    }
    @OnClick(R.id.keyboard2Button12)
    void OnClick2_12(){
        updateText("7");
    }

    @OnClick(R.id.keyboard2Button13)
    void OnClick2_13(){
        updateText("8");
    }

    @OnClick(R.id.keyboard2Button14)
    void OnClick2_14(){
        updateText("9");
    }

    @OnClick(R.id.keyboard2Button15)
    void OnClick2_15(){
        updateText("/");
    }

    @OnClick(R.id.keyboard2Button16)
    void OnClick2_16(){
        updateText("4");
    }

    @OnClick(R.id.keyboard2Button17)
    void OnClick2_17(){
        updateText("5");
    }

    @OnClick(R.id.keyboard2Button18)
    void OnClick2_18(){
        updateText("6");
    }

    @OnClick(R.id.keyboard2Button19)
    void OnClick2_19(){
        updateText("×");
    }

    @OnClick(R.id.keyboard2Button20)
    void OnClick2_20(){
        updateText("1");
    }

    @OnClick(R.id.keyboard2Button21)
    void OnClick2_21(){
        updateText("2");
    }

    @OnClick(R.id.keyboard2Button22)
    void OnClick2_22(){
        updateText("3");
    }

    @OnClick(R.id.keyboard2Button23)
    void OnClick2_23(){
        updateText("-");
    }

    @OnClick(R.id.keyboard2Button24)
    void OnClick2_24(){
        if(isApper){
            changeApperButtonColor(1);
            isApper = false;
        } else {
            changeApperButtonColor(2);
            isApper = true;
        }
        /*
        String oldStr = currentET.getText().toString();

        int cursorPos = currentET.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(isApper) {

            if (!isInsideUpper(leftStr, rightStr)){
                Log.i("FFF", "change");
                currentET.setText(Html.fromHtml(String.format("%s%s%s", leftStr, "<sup>6</sup>", rightStr)));
                currentET.setSelection(cursorPos );
            }

        }

         */


    }

    @OnClick(R.id.keyboard2Button25)
    void OnClick2_25(){
        updateText("0");
    }

    @OnClick(R.id.keyboard2Button26)
    void OnClick2_26(){
        updateText(".");
    }

    @OnClick(R.id.keyboard2Button27)
    void OnClick2_27(){
        updateText("+");
    }

    public void changeApperButtonColor(int i){

        int colorFrom = keyboardButtonApper.getBackgroundTintList().getDefaultColor();
        int colorTo = getResources().getColor(R.color.colorPrimary);
        if (i == 2){
            colorTo = getResources().getColor(R.color.colorYellow);
        }
        @SuppressLint("ObjectAnimatorBinding") final ObjectAnimator animator = ObjectAnimator.ofInt(keyboardButtonApper, "backgroundTint", colorFrom, colorTo);
        animator.setDuration(500L);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setInterpolator(new DecelerateInterpolator(2));
        animator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                keyboardButtonApper.setBackgroundTintList(ColorStateList.valueOf(animatedValue));
            }
        });
        animator.start();

    }

    public boolean isInsideUpper(String left, String right){
        int leftOpen = 0;
        int leftClose = 0;
        int rightOpen = 0;
        int rightClose = 0;
        boolean leftOpenBool = false;
        boolean leftCloseBool = false;
        boolean rightOpenBool = false;
        boolean rightCloseBool = false;
        String text = ";";
        text+=1;
        text+=1;

        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;
        text+=1;

        while (leftCloseBool&&leftOpenBool){
            if (left.contains("<sup>")){
                left = left.replaceFirst("<sup>", "");
                leftOpen+=1;
            } else {
                leftOpenBool = true;
            }
            if (left.contains("</sup>")){
                left = left.replaceFirst("</sup>", "");
                leftClose+=1;
            } else {
                leftCloseBool = true;
            }
        }
        while (rightCloseBool&&rightOpenBool){
            if (right.contains("<sup>")){
                right = right.replaceFirst("<sup>", "");
                rightOpen+=1;
            } else {
                rightOpenBool = true;
            }
            if (right.contains("</sup>")){
                right = right.replaceFirst("</sup>", "");
                rightClose+=1;
            } else {
                rightCloseBool = true;
            }
        }
        return leftOpen - leftClose != 0 && rightOpen - rightClose != 0;

    }

}