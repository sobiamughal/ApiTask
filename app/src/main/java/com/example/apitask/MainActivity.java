package com.example.apitask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView data;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data=(TextView)findViewById(R.id.data);
        click=(Button)findViewById(R.id.btn);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //fetch data k ya object create kara hai .
                FetchData process= new FetchData();
                process.execute();
            }
        });


    }
}
