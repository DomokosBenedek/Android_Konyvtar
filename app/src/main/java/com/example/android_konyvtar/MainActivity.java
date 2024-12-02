package com.example.android_konyvtar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText konyvcim, konyszerzo, oldalszam;
    private Button hozzaad;
    private ListView list;
    private static List<Book> books;
    private LinearLayout valami;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        hozzaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (konyvcim.getText().toString().isEmpty() || konyszerzo.getText().toString().isEmpty() || oldalszam.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nem lehetnek üresek a mezők!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Integer.parseInt(oldalszam.getText().toString()) < 50) {
                    Toast.makeText(MainActivity.this, "Nem lehet 50 oldalnál rövidebb a könyv!", Toast.LENGTH_SHORT).show();
                    return;
                }

                books.add(new Book(konyvcim.getText().toString(), konyszerzo.getText().toString(), Integer.parseInt(oldalszam.getText().toString())));
                konyvcim.setText("");
                konyszerzo.setText("");
                oldalszam.setText("");
                list.setAdapter(new bookAdapter(books, MainActivity.this));
            }
        });

    }

    public void init() {
        konyvcim = findViewById(R.id.konyvcim);
        konyszerzo = findViewById(R.id.konyszerzo);
        oldalszam = findViewById(R.id.oldalszam);
        hozzaad = findViewById(R.id.hozzaad);
        list = findViewById(R.id.list);
        books = new ArrayList<>();
        bookAdapter adapter = new bookAdapter(books, this);
        list.setAdapter(adapter);
    }
}