package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        TextView mTxtSensor;
        SensorManager sensorManager;
        List<Sensor> sensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtSensor = findViewById(R.id.txtsenors);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        mTxtSensor.append("(# sensor:" + sensorList.size()+")\n\n");
        for(Sensor sensor : sensorList){
            mTxtSensor.append("sensor name:" + sensor.getName()+"\n");
            mTxtSensor.append("sensor name:" + sensor.getType()+"\n\n");
        }


    }
}