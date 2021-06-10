package com.example.ejemplo1seminarios;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.util.Log;
public class ContactnfoActivity extends AppCompatActivity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);
        int image=(int) getIntent().getSerializableExtra("EXTRA_IMG");
        String name=(String) getIntent().getSerializableExtra("EXTRA_NAME");
        String phone=(String) getIntent().getSerializableExtra("EXTRA_PHONE");
        String address=(String) getIntent().getSerializableExtra("EXTRA_ADDRESS");


        ImageView imagen = findViewById(R.id.imagenViewRC);
        imagen.setImageResource(image);
        TextView textView = findViewById(R.id.textViewRCName);
        textView.setText(name);
        TextView textViewPhone = findViewById(R.id.textViewRCPhone);
        textViewPhone.setText(phone);
        TextView textViewAddress = findViewById(R.id.textViewRCAddress);
        textViewAddress.setText(address);

    }
}
