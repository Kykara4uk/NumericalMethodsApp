package com.kykara4a.metod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog.Builder;
import androidx.preference.MultiSelectListPreference;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class myMultiSelectListPreference extends MultiSelectListPreference implements MaterialPickerOnPositiveButtonClickListener {
    private int mClickedDialogEntryIndex;
    public myMultiSelectListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);


    }


    @Override
    protected boolean[] getSelectedItems() {
        return super.getSelectedItems();
    }

    @Override
    public void onPositiveButtonClick(Object selection) {
        Toast.makeText(getContext(), "toast2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean callChangeListener(Object newValue) {
        String[] labs;
        String newValueStr = newValue.toString();
        newValueStr = newValueStr.substring(1, newValueStr.length()-1);
        labs = newValueStr.split(", ");

        System.out.println(labs[0]);
        if (labs[0].equals("")){
            Toast.makeText(getContext(), R.string.choose_at_least_1_lab, Toast.LENGTH_LONG).show();
            return !super.callChangeListener(newValue);
        } else {
            Toast.makeText(getContext(), R.string.recreate_app_to_see_changes, Toast.LENGTH_LONG).show();
            return super.callChangeListener(newValue);
        }

    }
}
