package com.itis.tar_alexander.hw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FLAG = "com.itis.hw.FLAG";

    TextView Name;
    TextView Mail;
    TextView Phone;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (TextView) findViewById(R.id.name_txt);
        Mail = (TextView) findViewById(R.id.mail_txt);
        Phone = (TextView) findViewById(R.id.phone_txt);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String name = data.getStringExtra("name");
        String mail = data.getStringExtra("mail");
        String phone = data.getStringExtra("phone");
        Name.setText(name);
        Mail.setText(mail);
        Phone.setText(phone);
    }
}
