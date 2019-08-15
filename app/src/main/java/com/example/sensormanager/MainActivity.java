package com.example.sensormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sm;
    TextView sensorcount ;
    ListView jlv;
    List<Sensor> jlsr;
    ArrayList<String> liststring ;
    ArrayAdapter<String> adapter ;
    Button jbt ;
    Button jbt_hw;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            sm=(SensorManager) getSystemService(SENSOR_SERVICE);


            jlv = (ListView)findViewById(R.id.xlv);
            jbt = (Button) findViewById(R.id.xbt);
            jbt_hw = ( Button) findViewById(R.id.x_hw_btn);
            sensorcount = (TextView)findViewById(R.id.x_tv_sensorcount);
            liststring = new ArrayList<String>();

            jlsr = sm.getSensorList(Sensor.TYPE_ALL);
            sensorcount.setText("Total Sensor(s) found : "+ jlsr.size());

            adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1, liststring);
            jlv.setAdapter(adapter);

                for(int i=0; i<jlsr.size(); i++){

                    liststring.add(jlsr.get(i).getName());
                    Log.d("liststrnig",jlsr.get(i).getName());
                }

                jbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, accelerom.class);
                    startActivity(intent);

                        }
                    });

            jbt_hw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    Intent intent_hw = new Intent(MainActivity.this, hw.class);
                    startActivity(intent_hw);

                }
            });




        }


}
