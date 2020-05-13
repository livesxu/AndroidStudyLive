package com.example.myapplication3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    private String par;
    private Activity mActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity)context;
        par = getArguments().getString("key");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);
        TextView textView = view.findViewById(R.id.text1);
        textView.setText(par);

        Button button = view.findViewById(R.id.button1);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.v("zzz","f1里面的点击");

                ((FragmentActivity)mActivity).f1ButtonAction();
                return true;
            }
        });

        return view;
    }

    public interface CallBack{

        public void getResult(String string);
    }

    public void onData(CallBack callBack){
        Button button = getView().findViewById(R.id.button1);
        Log.v("zzz",button.getText().toString());
        callBack.getResult("回传的某个值");
    }

}
