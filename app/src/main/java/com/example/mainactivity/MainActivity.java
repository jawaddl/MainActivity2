package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        final EditText editTextA = findViewById(R.id.editTextA);
        final EditText editTextB = findViewById(R.id.editTextB);
        final EditText editTextC = findViewById(R.id.editTextC);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(editTextA.getText().toString());
                double b = Double.parseDouble(editTextB.getText().toString());
                double c = Double.parseDouble(editTextC.getText().toString());

                GraphView graph = findViewById(R.id.graph);
                graph.removeAllSeries();

                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (double i = -10; i <= 10; i += 0.1) {
                    double y = a * i * i + b * i + c;
                    series.appendData(new DataPoint(i, y), true, 200);
                }

                graph.addSeries(series);
            }
        });
    }
}