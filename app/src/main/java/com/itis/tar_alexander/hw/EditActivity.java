package com.itis.tar_alexander.hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    /** Called when the user taps Accept button */
    public void accept(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        EditText editName = (EditText) findViewById(R.id.editName);
        String message1 = editName.getText().toString();
        intent.putExtra(MainActivity.USER_NAME, message1);

        EditText editMail = (EditText) findViewById(R.id.editMail);
        String message2 = editMail.getText().toString();
        intent.putExtra(MainActivity.USER_MAIL, message2);

        EditText editPhone = (EditText) findViewById(R.id.editPhone);
        String message3 = editPhone.getText().toString();
        intent.putExtra(MainActivity.USER_PHONE, message3);

        startActivity(intent);
    }

    /** Called when user tap Cancel button */
    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.FLAG,0);
        startActivity(intent);
    }
}
