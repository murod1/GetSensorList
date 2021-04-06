package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        TextView mTxtSensor;
        Button button;
        SensorManager sensorManager;
        List<Sensor> sensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mTxtSensor.setMovementMethod(new ScrollingMovementMethod());
        button = findViewById(R.id.retrieve_sensorsBtn);
        mTxtSensor = findViewById(R.id.txtsenors);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        // sensorManager = new SensorManager();
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        mTxtSensor.append("(# sensor:" + sensorList.size()+")\n\n");
        for(Sensor sensor : sensorList){
            mTxtSensor.append("sensor name:" + sensor.getName()+"\n");
            mTxtSensor.append("sensor name:" + sensor.getType()+"\n\n");
        }
    }
}