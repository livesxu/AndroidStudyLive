package com.example.myapplication3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircleView extends View {

    private Paint paint;
    private RectF rectF;

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

//    public MyCircleView(Context context) {
//        super(context);
//
//        paint = new Paint();
//        paint.setFlags(Paint.ANTI_ALIAS_FLAG);//抗锯齿
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(200,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(new RectF(10,10,100,100),0,90,false,paint);
    }
}
