package com.termux.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.termux.R;
import com.termux.gui.hard.Hard_1;
import com.termux.gui.hard.Hard_2;
import com.termux.gui.hard.Hard_3;

public class OpenHardLevel extends Activity {
    public static ImageView vH1,vH2,vH3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_hard_level);
        vH1 = (ImageView) findViewById(R.id.levelH_1_imageview);
        vH2 = (ImageView) findViewById(R.id.levelH_2_imageview);
        vH3 = (ImageView) findViewById(R.id.levelH_3_imageview);
    }
    public void openHard_1(View view){
        Intent intent1 = new Intent(this,Hard_1.class);
        startActivity(intent1);
    }
    public void openHard_2(View view){
        Intent intent2 = new Intent(this,Hard_2.class);
        startActivity(intent2);
    }
    public void openHard_3(View view){
        Intent intent3 = new Intent(this,Hard_3.class);
        startActivity(intent3);
    }

    public static  void  changeImageIcon1H(){
        vH1.setImageResource(R.drawable.keyf6);
    }
    public static  void  changeImageIcon2H(){
        vH2.setImageResource(R.drawable.keyf6);
    }
    public static  void  changeImageIcon3H(){
        vH3.setImageResource(R.drawable.keyf6);
    }

//    public void openHard_4(View view){
////        Intent intent4 = new Intent(this,Easy_4.class);
////        startActivity(intent4);
//    }
//    public void openHard_5(View view){
////        Intent intent5 = new Intent(this,Easy_5.class);
////        startActivity(intent5);
//    }
//    public void openHard_6(View view){
//
//    }
//    public void openHard_7(View view){
//
//    }
//    public void openHard_8(View view){
//
//    }
//    public void openHard_9(View view){
//
//    }
}
