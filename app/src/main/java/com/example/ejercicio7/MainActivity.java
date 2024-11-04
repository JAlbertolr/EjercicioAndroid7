package com.example.ejercicio7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
private Button url;
private Button mail;
private Button phone;

private TextView textoUrl;
private EditText textoMail;
    private EditText textoPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url=findViewById(R.id.btnUrl);
        mail=findViewById(R.id.btnMail);
        phone=findViewById(R.id.btnPhone);
        textoUrl=findViewById(R.id.tUrl);
        textoMail=findViewById(R.id.tMail);
        textoPhone=findViewById(R.id.tPhone);
    //Intent permite lanzar otras activities o lanzar otras aplicaciones
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent urlIntent=new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(textoUrl.getText().toString()));
        startActivity(urlIntent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent mailIntent=new Intent(Intent.ACTION_SENDTO);
        mailIntent.setData(Uri.parse("mailto: "+textoMail.getText()));
        startActivity(mailIntent);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent tlfIntent= new Intent(Intent.ACTION_DIAL);
        tlfIntent.setData(Uri.parse("tel:"+textoPhone.getText()));
        startActivity(tlfIntent);

            }
        });

    }
}