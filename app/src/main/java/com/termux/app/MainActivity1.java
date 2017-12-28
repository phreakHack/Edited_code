package com.termux.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.termux.R;
import com.termux.gui.Login;
import com.termux.gui.Register;

public class MainActivity1 extends Activity {

    // Used to load the 'native-lib' library on application startup.
    /*static {
        System.loadLibrary("native-lib");
    }*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public  void openLoginActivity(View view){
        Intent intentLogin = new Intent(this,Login.class);
        startActivity(intentLogin);
    }
    public  void openRegisterActivity(View view){
        Intent intentRegister = new Intent(this,Register.class);
        startActivity(intentRegister);
    }
}
