package com.itis.tar_alexander.hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName;
    EditText editMail;
    EditText editPhone;
    Button btnOK;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName = (EditText) findViewById(R.id.name_edit);
        editMail = (EditText) findViewById(R.id.mail_edit);
        editPhone = (EditText) findViewById(R.id.phone_edit);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_ok:
                intent.putExtra("name", editName.getText().toString());
                intent.putExtra("mail", editMail.getText().toString());
                intent.putExtra("phone", editPhone.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            case  R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
        }
    }
}
