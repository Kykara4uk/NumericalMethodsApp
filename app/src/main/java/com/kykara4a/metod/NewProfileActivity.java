package com.kykara4a.metod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewProfileActivity extends AppCompatActivity {
    @BindView(R.id.inputName)
    TextInputEditText editText;
    @BindView(R.id.buttonAdd)
    Button buttonAdd;
    @BindView(R.id.inputLayout)
    TextInputLayout inputLayout;
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "mysettings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_new_profile);
        ButterKnife.bind(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (inputLayout.getError()!=null){
                    inputLayout.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSettings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    }

    @OnClick(R.id.buttonAdd)
    void onButtonAddClick(){
        String name = editText.getText().toString();
        if (name.equals("")){
            inputLayout.setError(getResources().getString(R.string.enter_profile_name));
        } else {
            Profile profile = new Profile();
            profile.name = name;
            Gson gson = new Gson();
            String json = mSettings.getString("profiles", null);
            Type type = new TypeToken<ArrayList<Profile>>() {}.getType();
            ArrayList<Profile> profiles = gson.fromJson(json, type);
            if (profiles == null){
                profiles = new ArrayList<>();
            }
            profiles.add(profile);
            SharedPreferences.Editor editor = mSettings.edit();
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(profiles);
            editor.putString("profiles", json1);
            editor.apply();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
            finish();
        }
    }
}