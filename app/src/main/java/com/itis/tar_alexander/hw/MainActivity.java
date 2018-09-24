package com.itis.tar_alexander.hw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME = "com.itis.hw.USER_NAME";
    public static final String USER_MAIL = "com.itis.hw.USER_MAIL";
    public static final String USER_PHONE = "com.itis.hw.USER_PHONE";
    public static final String FLAG = "com.itis.hw.FLAG";

    public static String Name;
    public static String Mail;
    public static String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intent
        Intent intent = getIntent();
        if (!intent.hasExtra(FLAG))
        {
            Name = intent.getStringExtra(USER_NAME);
            Mail = intent.getStringExtra(USER_MAIL);
            Phone = intent.getStringExtra(USER_PHONE);
        }

        //text
        TextView text = findViewById(R.id.textName);
        text.setText(Name);
        text = findViewById(R.id.textMail);
        text.setText(Mail);
        text = findViewById(R.id.textPhone);
        text.setText(Phone);
    }

    /** Called when user tap the Button */
    public void edit(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

    public void send(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Name);
        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Скопировано", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
