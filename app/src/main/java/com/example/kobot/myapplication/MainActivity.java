package com.example.kobot.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


abstract class General
{
    static int arr[] = {4,7,9,1,2,3};
    abstract String getResult();
}
class GetMin extends General
{
    @Override
    public String getResult() {
        Arrays.sort(arr);
        int min = arr[0];
        return ""+min;
    }
}
class GetAvg extends General
{
    @Override
    public String getResult() {
        double average = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        average = sum / arr.length;

        return ""+average;
    }
}




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        General set = new General() {
            @Override
            public String getResult() {
                return null;
            }
        };
        TextView text = (TextView)findViewById(R.id.array02);

        text.setText(java.util.Arrays.toString(set.arr));

        Button btn01 = (Button)findViewById(R.id.btn01);
        Button btn02 = (Button)findViewById(R.id.btn02);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetMin min = new GetMin();
                Toast.makeText(getApplicationContext(), min.getResult(), Toast.LENGTH_SHORT).show();

            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GetAvg avg = new GetAvg();
                Toast.makeText(getApplicationContext(), avg.getResult(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
