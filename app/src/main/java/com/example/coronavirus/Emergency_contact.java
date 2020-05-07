package com.example.coronavirus;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.Manifest.permission.CALL_PHONE;

public class Emergency_contact extends AppCompatActivity implements View.OnClickListener {
    Button call1,call2,call3,call4,call5,call6,call7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);

       call1=findViewById(R.id.callnow1);
        call2=findViewById(R.id.callnow2);
        call3=findViewById(R.id.callnow3);
        call4=findViewById(R.id.callnow4);
        call5=findViewById(R.id.callnow5);
        call6=findViewById(R.id.callnow6);
        call7=findViewById(R.id.callnow7);



        call1.setOnClickListener(this);
        call2.setOnClickListener(this);
        call3.setOnClickListener(this);
        call4.setOnClickListener(this);
        call5.setOnClickListener(this);
        call6.setOnClickListener(this);
        call7.setOnClickListener(this);




    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.callnow1:

                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:+8801944333222"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
            case R.id.callnow2:

                Intent i2 = new Intent(Intent.ACTION_CALL);
                i2.setData(Uri.parse("tel:333"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i2);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;

            case R.id.callnow3:

                Intent i3 = new Intent(Intent.ACTION_CALL);
                i3.setData(Uri.parse("tel:+8801769045739"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i3);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
            case R.id.callnow4:

                Intent i4 = new Intent(Intent.ACTION_CALL);
                i4.setData(Uri.parse("tel:+8801811458541"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i4);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
            case R.id.callnow5:

                Intent i5 = new Intent(Intent.ACTION_CALL);
                i5.setData(Uri.parse("tel:+9512264"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i5);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
            case R.id.callnow6:

                Intent i6 = new Intent(Intent.ACTION_CALL);
                i6.setData(Uri.parse("tel:+8801778080983"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i6);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
            case R.id.callnow7:

                Intent i7 = new Intent(Intent.ACTION_CALL);
                i7.setData(Uri.parse("tel:+8801711136362"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i7);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
        }

    }
}
