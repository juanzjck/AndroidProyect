package com.example.ejemplo1seminarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Pantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
         final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        try {
            Intent intent = new Intent(getApplicationContext(), SiguientePantalla.class);
            startActivity(intent);
        }catch (Error e){
            throw new Error(e);
        }

    }
}
