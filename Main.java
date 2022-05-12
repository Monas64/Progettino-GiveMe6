package com.example.giveme6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button map = (Button) findViewById(R.id.mappa);
        Button list= (Button) findViewById(R.id.list);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Main.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Main.this, List.class);
                startActivity(intent);
            }
        });
        /*
        try {
            list.setOnClickListener((View.OnClickListener) this);
        } catch (Exception e) {
            System.out.println(e);
        }

        map.setOnClickListener((View.OnClickListener) this);

         */
    }
}