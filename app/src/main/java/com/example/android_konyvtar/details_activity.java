package com.example.android_konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;

public class details_activity extends AppCompatActivity {
    private Button backbutton;
    private TextView cim,szerzo,oldalszam,evszam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((R.layout.details_activity));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void init(){
        Random rand = new Random();
        backbutton=findViewById(R.id.backButton);
        cim=findViewById(R.id.cim);
        szerzo=findViewById(R.id.szerzo);
        oldalszam=findViewById(R.id.oldalszam);
        evszam=findViewById(R.id.evszam);

        Intent intent=getIntent();
        cim.setText("Cím: "+intent.getStringExtra("booktitle"));
        szerzo.setText("Szerő "+intent.getStringExtra("bookauthor"));
        oldalszam.setText("Oldalok száma: "+intent.getIntExtra("bookpages",0));
        int randomYear = rand.nextInt(2024 - 1500 + 1) + 1500;
        evszam.setText("Megjelenés évszáma:"+rand.nextInt(randomYear));
    }


}