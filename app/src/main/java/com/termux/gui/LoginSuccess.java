package com.termux.gui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.termux.R;

public class LoginSuccess extends AppCompatActivity {

    private TextView textView;
    public static String username ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        //Textview to show currently logged in user
        //Initializing textview
       // textView = (TextView) findViewById(R.id.textViewUser);

        //Fetching email from shared preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String abc = Config.KEY_USERNAME1 ;
        Log.i("Login_user",abc) ;
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString(Config.USERNAME_SHARED_PREF,abc);
        username = sharedPreferences.getString(Config.USERNAME_SHARED_PREF," ");

        //Showing the current logged in email to textview
       // textView.setText("WELCOME " + username);
    }
    public void openEasyLevel(View view){
        Intent intentEasy = new Intent(this,OpenEasyLevel.class);
        startActivity(intentEasy);
    }
    public void openMediumLevel(View view){
        Intent intentMedium = new Intent(this,OpenMediumLevel.class);
        startActivity(intentMedium);
    }
    public void openHardLevel(View view){
        Intent intentHard = new Intent(this,OpenHardLevel.class);
        startActivity(intentHard);
    }
    //Logout function
    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                //Getting out sharedpreferences
                SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME,Context.MODE_PRIVATE);
                //Getting editor
                SharedPreferences.Editor editor = preferences.edit();

                //Puting the value false for loggedin
                editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                //Putting blank value to email
                editor.putString(Config.USERNAME_SHARED_PREF, "");

                //Saving the sharedpreferences
                editor.commit();

                Log.i("LOG OUT","User : "+ username +" has Logged Out") ;
                //Starting login activity
                Intent intent = new Intent(LoginSuccess.this,Login.class);
                startActivity(intent);
            }
        });

        alertDialogBuilder.setNegativeButton("No",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adding our menu to toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuLogout) {
            //calling logout method when the logout button is clicked
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

}
