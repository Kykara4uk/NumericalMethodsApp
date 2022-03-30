package com.kykara4a.metod;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.VibrationEffect;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.SharedPreferences;

import org.telegram.passport.PassportScope;
import org.telegram.passport.PassportScopeElementOne;
import org.telegram.passport.PassportScopeElementOneOfSeveral;
import org.telegram.passport.TelegramLoginButton;
import org.telegram.passport.TelegramPassport;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstLabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int TG_PASSPORT_RESULT = 351;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Vibrator vibrator;
    TextInputEditText input1, input2, input3, input4, input5, input6, input7, input8;
    Button button1, button2, button3;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView21, textView22;
    View.OnClickListener onClickListener1;
    SharedPreferences mSettings;
    TelegramLoginButton telegramLoginButton;
    public static final String APP_PREFERENCES = "mysettings";
    RadioButton radioButton2A, radioButton2B, radioButton3A, radioButton3B;
    View v;
    public FirstLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstLabFragment newInstance(String param1, String param2) {
        FirstLabFragment fragment = new FirstLabFragment();
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
        //initialization
        v = inflater.inflate(R.layout.fragment_first_lab, container, false);

        mSettings =  PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        input1 = (TextInputEditText) v.findViewById(R.id.input1);
        input2 = (TextInputEditText) v.findViewById(R.id.input2);
        input3 = (TextInputEditText) v.findViewById(R.id.input3);
        input4 = (TextInputEditText) v.findViewById(R.id.input4);
        input5 = (TextInputEditText) v.findViewById(R.id.input5);
        input6 = (TextInputEditText) v.findViewById(R.id.input6);
        input7 = (TextInputEditText) v.findViewById(R.id.input7);
        input8 = (TextInputEditText) v.findViewById(R.id.input8);
        textView1 = (TextView) v.findViewById(R.id.textView1);
        textView2 = (TextView) v.findViewById(R.id.textView2);
        textView3 = (TextView) v.findViewById(R.id.textView3);
        textView4 = (TextView) v.findViewById(R.id.textView4);
        textView5 = (TextView) v.findViewById(R.id.textView5);
        textView6 = (TextView) v.findViewById(R.id.textView6);
        textView21 = (TextView) v.findViewById(R.id.textView21);
        textView22 = (TextView) v.findViewById(R.id.textView22);
        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);
        button3 = (Button) v.findViewById(R.id.button3);
        radioButton2A = (RadioButton) v.findViewById(R.id.radio2A);
        radioButton2B = (RadioButton) v.findViewById(R.id.radio2B);
        radioButton3A = (RadioButton) v.findViewById(R.id.radio3A);
        radioButton3B = (RadioButton) v.findViewById(R.id.radio3B);
    
    telegramLoginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TelegramPassport.AuthRequest req=new TelegramPassport.AuthRequest();
            req.botID=1624933438/* your bot ID here */;
            req.publicKey="1624933438:AAHKUcz5YBVyUIFd0WffZozLcpMqHV4F8Lw"/* your bot public key here */;
            req.nonce="1"/* a unique nonce to pass to the bot server */;
            // Request either a passport or an ID card with selfie, a driver license, personal details with
            // name as it appears in the documents, address with any address document, and a phone number.
            // You could also pass a raw JSON object here if that's what works better for you
            // (for example, if you already get it from your server in the correct format).
            req.scope=new PassportScope(
                    new PassportScopeElementOneOfSeveral(PassportScope.PASSPORT, PassportScope.IDENTITY_CARD).withSelfie(),
                    new PassportScopeElementOne(PassportScope.PERSONAL_DETAILS).withNativeNames(),
                    PassportScope.DRIVER_LICENSE,
                    PassportScope.ADDRESS,
                    PassportScope.ADDRESS_DOCUMENT,
                    PassportScope.PHONE_NUMBER);
            TelegramPassport.request(getActivity(), req, TG_PASSPORT_RESULT);
        }
    });
        //1 exercise
        onClickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String input1Str = input1.getText().toString();
                    double input1Db = Double.parseDouble(input1Str);

                    String input2Str = input2.getText().toString();
                    double input2Db = Double.parseDouble(input2Str);

                    String input3Str = input3.getText().toString();
                    double input3Db = Double.parseDouble(input3Str);

                    String input4Str = input4.getText().toString();
                    double input4Db = Double.parseDouble(input4Str);

                    String input5Str = input5.getText().toString();
                    double input5Db = Double.parseDouble(input5Str);

                    double sqrt = Math.sqrt(input1Db);

                    double dx1 = countDX(sqrt, input2Db);
                    String text1 = "dx1 = " + round2(dx1, 10) + " "+getResources().getString(R.string.or)+" " + round2(dx1*100, 8) + "%";
                    textView1.setText(text1);

                    double drob = input3Db / input4Db;

                    double dx2 = countDX(drob, input5Db);
                    String text2 = "dx2 = " + round2(dx2, 10) + " "+getResources().getString(R.string.or)+" " + round2(dx2*100, 8) + "%";
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView2.setText(text2);
                    if (dx1 < dx2) {
                        String text3 = getResources().getString(R.string.equality) +" √" + input1Str + " = " + input2Str + " "+getResources().getString(R.string.is_more_accurate)+".";
                        textView3.setText(text3);
                    } else {
                        String text3 = getResources().getString(R.string.equality) +" " + input3Str + "/" + input4Str + " = " + input5Str + " "+getResources().getString(R.string.is_more_accurate)+".";
                        textView3.setText(text3);
                    }
                } catch (NumberFormatException e) {
                    vibro();
                    Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        };
        button1.setOnClickListener(onClickListener1);
        //2 exercise
        radioButton2A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    textView21.setText("(±");
                    textView22.setText(" )");
                }
            }
        });
        radioButton2B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    textView21.setText("δ=");
                    textView22.setText(" %");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input6Str = input6.getText().toString();
                    double input6Db = Double.parseDouble(input6Str);

                    String input7Str = input7.getText().toString();
                    double input7Db = Double.parseDouble(input7Str);

                    double dxCompare = 5;
                    int dxCount = -1;
                    double dx = 0.1234;
                    if (radioButton2A.isChecked()){
                        while (dxCompare>input7Db*10){
                            dxCompare=dxCompare/10;
                            dxCount+=1;
                        }
                    } else {
                        dxCompare = 1;
                        dxCount = 0;
                        dx = input6Db * input7Db * 0.01;
                        while (dxCompare>dx*10){
                            dxCompare=dxCompare/10;
                            dxCount+=1;
                        }
                    }
                    double x = round(input6Db, dxCount);
                    if (radioButton2A.isChecked()){
                        dx = input7Db + Math.abs(x-input6Db);
                    } else {
                        dx = dx + Math.abs(x-input6Db);
                    }
                    while (dx>dxCompare){
                        dxCount-=1;
                        x = round(x, dxCount);
                        dxCompare*=10;
                        dx = input7Db + Math.abs(x-input6Db);
                    }
                    String text = getResources().getString(R.string.answer) +": " + round2(x, 5);
                    textView4.setText(text);
                    textView4.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    vibro();
                    Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //3 exercise
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input8Str = input8.getText().toString();
                    double input8Db = Double.parseDouble(input8Str);

                    double dxCompare = 5;
                    String[] splitter = input8Str.split("\\.");
                    int i = splitter[1].length() + 1;
                    if (radioButton3B.isChecked()){
                        i-=1;
                        dxCompare = 1;
                    }
                    for (int j = 0; j < i; j++){
                        dxCompare/=10;
                    }
                    String fff = "%."+i+"f";
                    double x = dxCompare/input8Db;
                    String text1 = getResources().getString(R.string.absolute_error)+": " + String.format(fff, dxCompare, i);
                    String text2 = getResources().getString(R.string.relative_error)+": " + String.format("%.10f", x) + " "+getResources().getString(R.string.or)+" " + String.format("%.8f", x*100)+ "%";
                    textView5.setText(text1);
                    textView5.setVisibility(View.VISIBLE);
                    textView6.setText(text2);
                    textView6.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    vibro();
                    Toast.makeText(getActivity(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    public double countDX(double x, double y){
        return (Math.abs(x-y))/x;
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public Profile getData(Profile profile){
        profile.input1_1_1 = input1.getText().toString();
        profile.input1_1_2 = input2.getText().toString();
        profile.input1_1_3 = input3.getText().toString();
        profile.input1_1_4 = input4.getText().toString();
        profile.input1_1_5 = input5.getText().toString();
        profile.input1_2_1 = input6.getText().toString();
        profile.input1_2_2 = input7.getText().toString();
        profile.input1_3_1 = input8.getText().toString();
        profile.radio1_2_1 = radioButton2A.isChecked();
        profile.radio1_3_1 = radioButton3A.isChecked();
        return profile;
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile currentProfile = loadData();
        input1.setText(currentProfile.input1_1_1);
        input2.setText(currentProfile.input1_1_2);
        input3.setText(currentProfile.input1_1_3);
        input4.setText(currentProfile.input1_1_4);
        input5.setText(currentProfile.input1_1_5);
        input6.setText(currentProfile.input1_2_1);
        input7.setText(currentProfile.input1_2_2);
        input8.setText(currentProfile.input1_3_1);
        if (currentProfile.radio1_2_1){
            radioButton2A.setChecked(true);
        } else {
            radioButton2B.setChecked(true);
        }
        if (currentProfile.radio1_3_1){
            radioButton3A.setChecked(true);
        } else {
            radioButton3B.setChecked(true);
        }
    }
    public Profile loadData(){
        Gson gson = new Gson();
        String json = mSettings.getString("currentProfileFirst", null);
        Type type = new TypeToken<Profile>() {}.getType();
        Profile profile = gson.fromJson(json, type);
        if (profile == null){
            profile = new Profile();
        }
        return profile;
    }
    private static String round2(double value, int num) {
        long factor = (long) Math.pow(10, num);
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

    @Override
    public void onPause() {
        super.onPause();
        Profile currentProfile = new Profile();
        currentProfile.input1_1_1 = input1.getText().toString();
        currentProfile.input1_1_2 = input2.getText().toString();
        currentProfile.input1_1_3 = input3.getText().toString();
        currentProfile.input1_1_4 = input4.getText().toString();
        currentProfile.input1_1_5 = input5.getText().toString();
        currentProfile.input1_2_1 = input6.getText().toString();
        currentProfile.input1_2_2 = input7.getText().toString();
        currentProfile.input1_3_1 = input8.getText().toString();
        currentProfile.radio1_2_1 = radioButton2A.isChecked();
        currentProfile.radio1_3_1 = radioButton3A.isChecked();
        SharedPreferences.Editor editor = mSettings.edit();
        Gson gson1 = new Gson();
        String json1 = gson1.toJson(currentProfile);
        editor.putString("currentProfileFirst", json1);
        editor.apply();
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