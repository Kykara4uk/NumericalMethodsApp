package com.kykara4a.metod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MySpinner  extends ArrayAdapter<String> {
    LayoutInflater inflater;
    List<String> spinnerItems;

    public MySpinner(Context applicationContext, int resource, List<String> spinnerItems) {
        super(applicationContext, resource, spinnerItems);
        this.spinnerItems = spinnerItems;
        inflater = (LayoutInflater.from(applicationContext));
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.spinner_bg, null);
        TextView type = (TextView) view.findViewById(R.id.spinner_item_text);
        type.setText(spinnerItems.get(i));
        return view;
    }
}
