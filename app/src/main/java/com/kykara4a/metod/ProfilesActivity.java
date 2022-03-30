package com.kykara4a.metod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.kykara4a.metod.MainActivity.APP_PREFERENCES;

public class ProfilesActivity extends AppCompatActivity implements ProfilesAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    ArrayList<Profile> profiles;
    Profile myProfile;
    TextView textView;
    int currentTab;
    int type;
    Button buttonAddProfile;
    ProfilesAdapter profilesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_profiles);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        textView = (TextView) findViewById(R.id.textViewHeader);
        recyclerView.setLayoutManager(linearLayoutManager);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        type = getIntent().getIntExtra("TYPE", -1);
        currentTab = getIntent().getIntExtra("currentTab", -1);
        String jsonProfile = getIntent().getStringExtra("profile");
        Gson gson2 = new Gson();
        Type type2 = new TypeToken<Profile>() {}.getType();
        myProfile = gson2.fromJson(jsonProfile, type2);
        profiles = loadData();
        if (type==0){
            textView.setText(getResources().getString(R.string.save));
            Profile profile = new Profile();
            profile.name = getResources().getString(R.string.create_new_profile);
            profiles.add(profile);
        } else {
            Profile profile2 = new Profile();
            profile2.name = getResources().getString(R.string.clear_all_fields);
            profiles.add(profile2);
        }
        profilesAdapter = new ProfilesAdapter(profiles, this);
        recyclerView.setAdapter(profilesAdapter);

    }
    public ArrayList<Profile> loadData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("profiles", null);
        Type type = new TypeToken<ArrayList<Profile>>() {}.getType();
        ArrayList<Profile> profiles = gson.fromJson(json, type);
        if (profiles == null){
            profiles = new ArrayList<>();
        }
        return profiles;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                profiles.remove(item.getGroupId());
                profilesAdapter.notifyItemRemoved(item.getGroupId());
                ArrayList<Profile> newProfiles = new ArrayList<>();
                for (int i = 0; i < profiles.size(); i++){
                    if (profiles.get(i).id!=-1){
                        newProfiles.add(profiles.get(i));
                    }
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(newProfiles);
                editor.putString("profiles", json1);
                editor.apply();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        if (type==0&&position==profiles.size()-1){
            Intent intent = new Intent(ProfilesActivity.this, NewProfileActivity.class);
            startActivity(intent);
        } else if (type==0){
            Profile tempProfile = profiles.get(position);
            switch (currentTab){
                case 0:
                    tempProfile.input1_1_1=myProfile.input1_1_1;
                    tempProfile.input1_1_2=myProfile.input1_1_2;
                    tempProfile.input1_1_3=myProfile.input1_1_3;
                    tempProfile.input1_1_4=myProfile.input1_1_4;
                    tempProfile.input1_1_5=myProfile.input1_1_5;
                    tempProfile.input1_2_1=myProfile.input1_2_1;
                    tempProfile.input1_2_2=myProfile.input1_2_2;
                    tempProfile.input1_3_1=myProfile.input1_3_1;
                    tempProfile.radio1_2_1=myProfile.radio1_2_1;
                    tempProfile.radio1_3_1=myProfile.radio1_3_1;
                    break;
                case 1:
                    tempProfile.xarray2_1=myProfile.xarray2_1;
                    tempProfile.xarray2_2=myProfile.xarray2_2;
                    tempProfile.yarray2_1=myProfile.yarray2_1;
                    break;
                case 2:
                    tempProfile.xarray3_1=myProfile.xarray3_1;
                    tempProfile.xarray3_2=myProfile.xarray3_2;
                    tempProfile.yarray3_1=myProfile.yarray3_1;
                    tempProfile.radio3_1_1=myProfile.radio3_1_1;
                    tempProfile.input3_1_1=myProfile.input3_1_1;
                    break;
                case 3:
                    tempProfile.radio4_1 = myProfile.radio4_1;
                    tempProfile.n4_1 = myProfile.n4_1;
                    tempProfile.n4_2 = myProfile.n4_2;
                    tempProfile.n4_3 = myProfile.n4_3;
                    tempProfile.lowerBound4_1 = myProfile.lowerBound4_1;
                    tempProfile.lowerBound4_2 = myProfile.lowerBound4_2;
                    tempProfile.lowerBound4_3 = myProfile.lowerBound4_3;
                    tempProfile.upperBound4_1 = myProfile.upperBound4_1;
                    tempProfile.upperBound4_2 = myProfile.upperBound4_2;
                    tempProfile.upperBound4_3 = myProfile.upperBound4_3;
                    tempProfile.integral4_1 = myProfile.integral4_1;
                    tempProfile.integral4_2 = myProfile.integral4_2;
                    tempProfile.integral4_3 = myProfile.integral4_3;
                    break;
                case 4:
                    tempProfile.input5_1 = myProfile.input5_1;
                    break;
                case 5:
                    tempProfile.input6_1 = myProfile.input6_1;
                    tempProfile.input6_2 = myProfile.input6_2;
                    tempProfile.input6_3 = myProfile.input6_3;
                    tempProfile.input6_4 = myProfile.input6_4;
                    tempProfile.input6_5 = myProfile.input6_5;
                    tempProfile.input6_6 = myProfile.input6_6;
                    tempProfile.input6_7 = myProfile.input6_7;
                    tempProfile.input6_8 = myProfile.input6_8;
                    tempProfile.input6_9 = myProfile.input6_9;
                    tempProfile.input6_10 = myProfile.input6_10;
                    tempProfile.radio6 = myProfile.radio6;
                    tempProfile.spinner6_1 = myProfile.spinner6_1;
                    tempProfile.spinner6_2 = myProfile.spinner6_2;
                    break;
                case 6:
                    tempProfile.yarray_rgr = myProfile.yarray_rgr;
                    tempProfile.xarray_rgr = myProfile.xarray_rgr;
                    tempProfile.xarray_rgr_2 = myProfile.xarray_rgr_2;
                    tempProfile.rgr_ab = myProfile.rgr_ab;
                    tempProfile.rgr_bc = myProfile.rgr_bc;
                    tempProfile.rgr_cd = myProfile.rgr_cd;
                    tempProfile.rgr_da = myProfile.rgr_da;
                    tempProfile.rgr_2_step = myProfile.rgr_2_step;
                    tempProfile.rgr_less_more = myProfile.rgr_less_more;
                    tempProfile.rgr_fx_array = myProfile.rgr_fx_array;
                    tempProfile.rgr_3_gep_1 = myProfile.rgr_3_gep_1;
                    tempProfile.rgr_3_gep_2 = myProfile.rgr_3_gep_2;
                    tempProfile.rgr_task = myProfile.rgr_task;

            }

            profiles.set(position, tempProfile);
            profiles.remove(profiles.size()-1);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(profiles);
            editor.putString("profiles", json1);
            editor.apply();
            finish();
        } else if (type==1&&profiles.get(position).id==-1){
            switch (currentTab){
                case 0:
                    myProfile.input1_1_1="";
                    myProfile.input1_1_2="";
                    myProfile.input1_1_3="";
                    myProfile.input1_1_4="";
                    myProfile.input1_1_5="";
                    myProfile.input1_2_1="";
                    myProfile.input1_2_2="";
                    myProfile.input1_3_1="";

                    break;
                case 1:
                    for (int i = 0; i < myProfile.yarray2_1.size(); i++){
                        myProfile.xarray2_1.set(i, "");
                        myProfile.yarray2_1.set(i, "");
                    }
                    for (int i = 0; i < myProfile.xarray2_2.size(); i++){
                        myProfile.xarray2_2.set(i, "");

                    }
                    break;
                case 2:
                    for (int i = 0; i < myProfile.yarray3_1.size(); i++){
                        myProfile.xarray3_1.set(i, "");
                        myProfile.yarray3_1.set(i, "");
                    }
                    for (int i = 0; i < myProfile.xarray3_2.size(); i++){
                        myProfile.xarray3_2.set(i, "");

                    }
                    myProfile.input3_1_1="";
                    break;
                case 3:
                    if (myProfile.radio4_1==1){
                        myProfile.n4_1="";
                        myProfile.lowerBound4_1="";
                        myProfile.upperBound4_1="";
                        clearArray(myProfile.integral4_1);
                    } else if (myProfile.radio4_1==2){
                        myProfile.n4_2="";
                        myProfile.lowerBound4_2="";
                        myProfile.upperBound4_2="";
                        clearArray(myProfile.integral4_2);
                    } else if (myProfile.radio4_1==3){
                        myProfile.n4_3="";
                        myProfile.lowerBound4_3="";
                        myProfile.upperBound4_3="";
                        clearArray(myProfile.integral4_3);
                    } else
                        break;
                case 4:
                    myProfile.input5_1="";
                    break;
                case 5:
                    if (myProfile.radio6) {
                        myProfile.input6_1 = "";
                        myProfile.input6_2 = "";
                        myProfile.input6_3 = "";
                        myProfile.input6_4 = "";
                        myProfile.input6_5 = "";
                    } else {
                        myProfile.input6_6 = "";
                        myProfile.input6_7 = "";
                        myProfile.input6_8 = "";
                        myProfile.input6_9 = "";
                        myProfile.input6_10 = "";
                    }
                    break;
                case 6:
                    if(myProfile.rgr_task==1) {
                        for (int i = 0; i < myProfile.xarray_rgr.size(); i++) {
                            myProfile.xarray_rgr.set(i, "");
                            myProfile.yarray_rgr.set(i, "");
                        }
                        for (int i = 0; i < myProfile.xarray_rgr_2.size(); i++) {
                            myProfile.xarray_rgr_2.set(i, "");
                        }
                    } else if(myProfile.rgr_task == 2) {
                        myProfile.rgr_ab = "";
                        myProfile.rgr_bc = "";
                        myProfile.rgr_cd = "";
                        myProfile.rgr_da = "";
                        myProfile.rgr_2_step = "";
                    } else if(myProfile.rgr_task==3) {
                        myProfile.rgr_fx_array = new ArrayList<ArrayList<String>>();
                        myProfile.rgr_3_gep_1 = "";
                        myProfile.rgr_3_gep_2 = "";
                    }
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(myProfile);
            switch (currentTab){
                case 0:
                    editor.putString("currentProfileFirst", json1);
                    break;
                case 1:
                    editor.putString("currentProfileSecond", json1);
                    break;
                case 2:
                    editor.putString("currentProfileThird", json1);
                    break;
                case 3:
                    editor.putString("currentProfileForth", json1);
                    break;
                case 4:
                    editor.putString("currentProfileFifth", json1);
                    break;
                case 5:
                    editor.putString("currentProfileSixth", json1);
                    break;
                case 6:
                    editor.putString("currentProfileRGR", json1);
                    break;
            }
            editor.apply();
            finish();
        }else {
            Profile currentProfile = profiles.get(position);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(currentProfile);
            switch (currentTab){
                case 0:
                    editor.putString("currentProfileFirst", json1);
                    break;
                case 1:
                    editor.putString("currentProfileSecond", json1);
                    break;
                case 2:
                    editor.putString("currentProfileThird", json1);
                    break;
                case 3:
                    editor.putString("currentProfileForth", json1);
                    break;
                case 4:
                    editor.putString("currentProfileFifth", json1);
                    break;
                case 5:
                    editor.putString("currentProfileSixth", json1);
                    break;
                case 6:
                    editor.putString("currentProfileRGR", json1);
                    break;
            }
            editor.apply();
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        profiles = loadData();
        if (type==0){
            Profile profile = new Profile();
            profile.name = getResources().getString(R.string.create_new_profile);
            profile.id = -1;
            profiles.add(profile);
        } else {
            Profile profile = new Profile();
            profile.name = getResources().getString(R.string.clear_all_fields);
            profile.id = -1;
            profiles.add(0, profile);
        }
        profilesAdapter.setItems(profiles);
        profilesAdapter.notifyDataSetChanged();
    }
    void clearArray(ArrayList<Object> tempArray){
        if (tempArray.get(0) instanceof String){
            tempArray.set(0, "");
        } else {
            clearArray((ArrayList<Object>) tempArray.get(0));
        }
        if (tempArray.size()>1){
            if (tempArray.get(1) instanceof String){
                tempArray.set(1, "");
            } else {
                clearArray((ArrayList<Object>) tempArray.get(1));
            }
        }
    }
}