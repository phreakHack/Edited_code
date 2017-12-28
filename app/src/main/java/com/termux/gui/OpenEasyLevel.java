package com.termux.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.termux.R;
import com.termux.gui.easy.Easy_1;
import com.termux.gui.easy.Easy_10;
import com.termux.gui.easy.Easy_2;
import com.termux.gui.easy.Easy_3;
import com.termux.gui.easy.Easy_4;
import com.termux.gui.easy.Easy_5;
import com.termux.gui.easy.Easy_6;
import com.termux.gui.easy.Easy_7;
import com.termux.gui.easy.Easy_8;
import com.termux.gui.easy.Easy_9;

public class OpenEasyLevel extends Activity {
    static int flag  = 0;
    public static ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9,v10 ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_easy_level_1);
        v1 = (ImageView) findViewById(R.id.levelE_1_imageview);
        v2 = (ImageView) findViewById(R.id.levelE_2_imageview);
        v3 = (ImageView) findViewById(R.id.levelE_3_imageview);
        v4 = (ImageView) findViewById(R.id.levelE_4_imageview);
        v5 = (ImageView) findViewById(R.id.levelE_5_imageview);
        v6 = (ImageView) findViewById(R.id.levelE_6_imageview);
        v7 = (ImageView) findViewById(R.id.levelE_7_imageview);
        v8 = (ImageView) findViewById(R.id.levelE_8_imageview);
        v9 = (ImageView) findViewById(R.id.levelE_9_imageview);
        v10 = (ImageView) findViewById(R.id.levelE_10_imageview);
    }
    public void openEasy_1(View view){
        Intent intent1 = new Intent(this,Easy_1.class);
        startActivity(intent1);
    }
    public void openEasy_2(View view){
            Intent intent2 = new Intent(this,Easy_2.class);
            startActivity(intent2);
    }
    public void openEasy_3(View view){
        Intent intent3 = new Intent(this,Easy_3.class);
        startActivity(intent3);
    }
    public void openEasy_4(View view){
        Intent intent4 = new Intent(this,Easy_4.class);
        startActivity(intent4);
    }
    public void openEasy_5(View view){
        Intent intent5 = new Intent(this,Easy_5.class);
        startActivity(intent5);
    }
    public void openEasy_6(View view){
        Intent intent5 = new Intent(this,Easy_6.class);
        startActivity(intent5);
    }
    public void openEasy_7(View view){
        Intent intent5 = new Intent(this,Easy_7.class);
        startActivity(intent5);

    }
    public void openEasy_8(View view){
        Intent intent5 = new Intent(this,Easy_8.class);
        startActivity(intent5);

    }
    public void openEasy_9(View view){
        Intent intent5 = new Intent(this,Easy_9.class);
        startActivity(intent5);

    }
    public void openEasy_10(View view){
        Intent intent5 = new Intent(this,Easy_10.class);
        startActivity(intent5);
    }
    public static  void  changeImageIcon1E(){
        v1.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon2E(){
        v2.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon3E(){
        v3.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon4E(){
        v4.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon5E(){
        v5.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon6E(){
        v6.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon7E(){
        v7.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon8E(){
        v8.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon9E(){
        v9.setImageResource(R.drawable.keyf3);
    }
    public static  void  changeImageIcon10E(){
        v10.setImageResource(R.drawable.keyf3);
    }
}
