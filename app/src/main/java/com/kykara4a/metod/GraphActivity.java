package com.kykara4a.metod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GraphActivity extends AppCompatActivity {
    GraphView graph;
    ArrayList<Double> yarray, xarray, xarrayNew, yarrayNew, yarraySort;
    double minY, maxY, minX, maxX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Bundle bundle = getIntent().getExtras();


            xarray = (ArrayList<Double>) getIntent().getSerializableExtra("xarray");


            yarray = (ArrayList<Double>) getIntent().getSerializableExtra("yarray");
        xarrayNew = (ArrayList<Double>) getIntent().getSerializableExtra("xarrayNew");


        yarrayNew = (ArrayList<Double>) getIntent().getSerializableExtra("yarrayNew");

            minY = bundle.getDouble("minY");
            maxY = bundle.getDouble("maxY");
        minX = bundle.getDouble("minX");
        maxX = bundle.getDouble("maxX");
        graph = (GraphView) findViewById(R.id.graph);
        try {
            DataPoint[] dataPoints = new DataPoint[xarray.size()]; // declare an array of DataPoint objects with the same size as your list
            for (int i = 0; i < xarray.size(); i++) {
                // add new DataPoint object to the array for each of your list entries
                dataPoints[i] = new DataPoint(xarray.get(i), yarray.get(i)); // not sure but I think the second argument should be of type double
            }
            DataPoint[] dataPoints2 = new DataPoint[xarrayNew.size()]; // declare an array of DataPoint objects with the same size as your list
            for (int i = 0; i < xarrayNew.size(); i++) {
                // add new DataPoint object to the array for each of your list entries
                dataPoints2[i] = new DataPoint(xarrayNew.get(i), yarrayNew.get(i)); // not sure but I think the second argument should be of type double
            }
            PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(dataPoints2);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
            yarraySort = new ArrayList<>(yarrayNew);
            Collections.sort(yarraySort);
            graph.removeAllSeries();
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(minY);
            graph.getViewport().setMaxY(maxY);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(minX);
            graph.getViewport().setMaxX(maxX);
            graph.getViewport().setScrollable(true); // enables horizontal scrolling
            graph.getViewport().setScrollableY(true); // enables vertical scrolling
            graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
            graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
            series.setColor(getResources().getColor(R.color.colorAccent));
            series1.setColor(getResources().getColor(R.color.colorAccent));
            graph.addSeries(series);
            graph.addSeries(series1);
            series1.setOnDataPointTapListener(new OnDataPointTapListener() {
                @Override
                public void onTap(Series series, DataPointInterface dataPoint) {
                    Toast.makeText(GraphActivity.this, ""+round(dataPoint.getX())+"; "+round(dataPoint.getY()), Toast.LENGTH_SHORT).show();
                }
            });
            series1.setShape(PointsGraphSeries.Shape.POINT);
        } catch (RuntimeException e){

        }




    }
    private static String round(double value) {

        long factor = (long) Math.pow(10, 3);
        value = value * factor;
        long tmp = Math.round(value);
        String newValue = String.valueOf((double) tmp / factor);
        while (newValue.endsWith("0")||newValue.endsWith(".")){
            if (newValue.length()!=1){
                newValue = newValue.substring(0, newValue.length()-1);
            } else {
                break;
            }
System.out.println(newValue);

        }
        return newValue;
    }
}