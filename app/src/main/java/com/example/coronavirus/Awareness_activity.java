package com.example.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Awareness_activity extends AppCompatActivity {
PDFView pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness_activity);

        pdf=(PDFView) findViewById(R.id.pdfBook1);
        pdf.fromAsset("cv2.pdf").load();



    }
}
