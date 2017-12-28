package com.termux.gui.easy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.termux.R;
import com.termux.gui.OpenMediumLevel;

/**
 * Created by Admin on 20/03/2017.
 */

public class Easy_Cleared extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_cleared);
    }

    public void openNextEasyCleared(View view){
        Intent intent = new Intent(this, OpenMediumLevel.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
