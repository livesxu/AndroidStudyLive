package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText account;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account = findViewById(R.id.accountId);
        password = findViewById(R.id.passwordId);

        try {
            File file = new File(getFilesDir(),"/qqinfo.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String info = reader.readLine();
            if (info.contains("#")){
                String[] datas = info.split("#");

                account.setText(datas[0]);
                password.setText(datas[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginAction (View view) {

        String accountString = account.getText().toString();
        String passwordString = password.getText().toString();

        if (TextUtils.isEmpty(accountString) || TextUtils.isEmpty(passwordString)) {
//            getApplicationContext()
            Toast.makeText(this,"请填写完整信息",Toast.LENGTH_SHORT).show();

            return;
        }
        //填写的信息保存到本地
        try {
            //缓存目录 getCacheDir() file目录 getFilesDir()
            File file = new File(getFilesDir(),"/qqinfo.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(accountString + "#" + passwordString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
