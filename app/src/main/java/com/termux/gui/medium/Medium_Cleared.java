package com.termux.gui.medium;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.termux.R;
import com.termux.gui.OpenHardLevel;

/**
 * Created by Admin on 20/03/2017.
 */

public class Medium_Cleared extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_cleared);
    }

    public void openNextMediumCleared(View view){
        Intent intent = new Intent(this,OpenHardLevel.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
