package com.iothouse.surfaceviewtest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    SurfaceView msfv = null;
    SurfaceHolder msfh = null;
    Surface msf = null;
    Paint mPaint = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        msfv =  findViewById(R.id.surfaceView);
        msfh = msfv.getHolder();

        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);// 画笔为绿色
        mPaint.setTextSize(40);
        mPaint.setStrokeWidth(2);// 设置画笔粗细

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawAidLine();

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    public  void drawAidLine()
    {
        Canvas canvas = msfh.lockCanvas();
        float x = getWindowManager().getDefaultDisplay().getWidth();
        //虚拟按键的显示与隐藏会影响这个值 显示时：1776  隐藏时：1920
        float y = getWindowManager().getDefaultDisplay().getHeight();
//        canvas.drawLine(0,0,x,y,mPaint);
        canvas.drawLine(0,120,120,120,mPaint);
        canvas.drawLine(120,0,120,120,mPaint);
        canvas.drawText(""+x+","+y,120,120,mPaint);
        float sfv_x = msfv.getWidth();
        float sfv_y = msfv.getHeight();
//        msfh.setFixedSize(2200,2300);//改变surface大小，但是会被缩放显示到surfaceview上，可以用于图片缩放
        canvas.drawText(""+sfv_x+","+sfv_y,120,320,mPaint);
        canvas.drawLine(0,0,sfv_x,sfv_y,mPaint);
        canvas.drawLine(sfv_x,0,0,sfv_y,mPaint);
        canvas.drawLine(0,sfv_y/2,sfv_x,sfv_y/2,mPaint);
        msfh.unlockCanvasAndPost(canvas);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
