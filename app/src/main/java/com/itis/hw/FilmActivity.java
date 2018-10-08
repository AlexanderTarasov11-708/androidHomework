package com.itis.hw;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmActivity extends AppCompatActivity {
    String name;
    String year;
    String description;
    int id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        year = intent.getStringExtra("year");
        id = intent.getIntExtra("id", 0);
        description = intent.getStringExtra("description");

        TextView filmTitle = findViewById(R.id.f_title);
        TextView filmYear = findViewById(R.id.f_year);
        TextView filmDescription = findViewById(R.id.f_description);
        ImageView filmPhoto = findViewById(R.id.f_poster);

        setTitle(name);
        filmTitle.setText("Name: " + name);
        filmYear.setText("Year: " + year);
        filmDescription.setText("Description: " + description);

        String uri = "android.resource://com.itis.hw/drawable/film" + id;
        filmPhoto.setImageURI(Uri.parse(uri));
    }
}
