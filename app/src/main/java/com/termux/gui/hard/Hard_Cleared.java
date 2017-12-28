package com.termux.gui.hard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.termux.R;

/**
 * Created by Admin on 20/03/2017.
 */

public class Hard_Cleared extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_cleared);
    }

    public void openNext(View view){
//        Intent intent = new Intent(this, OpenMediumLevel.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
    }
}
