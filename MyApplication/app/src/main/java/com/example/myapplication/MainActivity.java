package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText account;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account = findViewById(R.id.accountId);
        password = findViewById(R.id.passwordId);
    }

    public void loginAction (View view) {

        String accountString = account.getText().toString();
        String passwordString = password.getText().toString();

        if (TextUtils.isEmpty(accountString) || TextUtils.isEmpty(passwordString)) {

            Toast.makeText(this,"请填写完整信息",Toast.LENGTH_SHORT).show();

            return;
        }
        //填写的信息保存到本地

    }
}
