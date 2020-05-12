package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.cLayout);

        Button button2 = new Button(this);
        button2.setText("第二个按钮");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("zzz","点击了第二个按钮");

                Intent intent = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout.LayoutParams params2 = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        params2.topToBottom = R.id.btn1;
        params2.leftToLeft = R.id.cLayout;
//        button2.setLayoutParams(params2);

        constraintLayout.addView(button2,params2);
    }

    public void nextPage1(View view){

        Intent intent = new Intent(this,RecyclerActivity.class);

        startActivity(intent);
    }

}
