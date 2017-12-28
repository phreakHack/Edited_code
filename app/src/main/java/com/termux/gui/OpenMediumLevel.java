package com.termux.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.termux.R;
import com.termux.gui.medium.Medium_1;
import com.termux.gui.medium.Medium_2;
import com.termux.gui.medium.Medium_3;
import com.termux.gui.medium.Medium_4;
import com.termux.gui.medium.Medium_5;

public class OpenMediumLevel extends Activity {

    public static ImageView vM1,vM2,vM3,vM4,vM5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_medium_level);
        vM1 = (ImageView) findViewById(R.id.levelM_1_imageview);
        vM2 = (ImageView) findViewById(R.id.levelM_2_imageview);
        vM3 = (ImageView) findViewById(R.id.levelM_3_imageview);
        vM4 = (ImageView) findViewById(R.id.levelM_4_imageview);
        vM5 = (ImageView) findViewById(R.id.levelM_5_imageview);


    }
    public void openMedium_1(View view){
        Intent intent1 = new Intent(this, Medium_1.class);
        startActivity(intent1);
    }
    public void openMedium_2(View view){
        Intent intent2 = new Intent(this,Medium_2.class);
        startActivity(intent2);
    }
    public void openMedium_3(View view){
        Intent intent3 = new Intent(this,Medium_3.class);
        startActivity(intent3);
    }
    public void openMedium_4(View view){
        Intent intent4 = new Intent(this, Medium_4.class);
        startActivity(intent4);
    }
    public void openMedium_5(View view){
        Intent intent4 = new Intent(this, Medium_5.class);
        startActivity(intent4);
    }

    public static  void  changeImageIcon1M(){
        vM1.setImageResource(R.drawable.keyf5);
    }
    public static  void  changeImageIcon2M(){
        vM2.setImageResource(R.drawable.keyf5);
    }
    public static  void  changeImageIcon3M(){
        vM3.setImageResource(R.drawable.keyf5);
    }
    public static  void  changeImageIcon4M(){
        vM4.setImageResource(R.drawable.keyf5);
    }
    public static  void  changeImageIcon5M(){
        vM5.setImageResource(R.drawable.keyf5);
    }


//    public void openMedium_6(View view){
//
//    }
//    public void openMedium_7(View view){
//
//    }
//    public void openMedium_8(View view){
//
//    }
//    public void openMedium_9(View view){
//
//    }
}
