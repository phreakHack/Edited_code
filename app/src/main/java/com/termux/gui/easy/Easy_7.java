package com.termux.gui.easy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.termux.R;
import com.termux.app.TermuxActivity;
import com.termux.gui.ConfigScoreCard;
import com.termux.gui.OpenEasyLevel;
import com.termux.gui.SharedPreferenceUse;

import static com.termux.gui.OpenEasyLevel.changeImageIcon7E;

public class Easy_7 extends Activity {
    private static int count = 0;
    private static int count1 = 0;
    private static SharedPreferences Counter_Medium1;
    private static SharedPreferences Counter_Medium2;
    private static int flag = 0 ;
    private static String password;
    private static EditText editTextAns ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_7);
        editTextAns = (EditText)findViewById(R.id.editText2);

        int levelCleared = 0;
        SharedPreferenceUse sharedpreferenceuse = new SharedPreferenceUse();
        levelCleared = sharedpreferenceuse.checkLevel("E6",this);
        if (levelCleared == 0) {
            flag = 0;
        }else {
            flag=1;
        }
        Counter_Medium1 = getSharedPreferences("Counter1", Context.MODE_PRIVATE) ;
        Counter_Medium2 = getSharedPreferences("Counter2",Context.MODE_PRIVATE) ;
        SharedPreferences.Editor ed = Counter_Medium1.edit();
        ed.putString("count","0");
        ed.commit();
        SharedPreferences.Editor ed1 = Counter_Medium2.edit();
        ed1.putString("count","0");
        ed1.commit();
    }
    public void openTerminal(View arg0){
        if(flag==0) {
            Intent intent = new Intent(this, TermuxActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Previous Level is Not Cleared",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, OpenEasyLevel.class);
            startActivity(intent);
        }
    }
    public void submitEasy_7(View view){
        password = editTextAns.getText().toString();
        if (flag == 0) {
            do {
                String countfromSP = Counter_Medium1.getString("count", "");
                count = Integer.parseInt(countfromSP);
                String countfromSP1 = Counter_Medium2.getString("count", "");
                count1 = Integer.parseInt(countfromSP1);

                if (new String("doritos").equals(password)) {
                    if ((count != 0) && (count1 != 0)) {
                        //For Rest of the time
                        //if answer is correct
                        Log.i("Password_easy_7_1", password);
                        //Answer Check
                        Toast.makeText(this, "Level Cleared..Redirecting to Next Level", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(this, Easy_8.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                    } else {
                        //For First Time
                        //if answer is correct-------Check answer then add this code
                        Log.i("Password_easy_7_1", password);
                        //Answer Check
                        //Set Score
                        String score = "Easy_7";
                        Log.i("Easy7", "Entered submit");
                        ConfigScoreCard configScoreCard = new ConfigScoreCard();
                        int flag1 = configScoreCard.insertScore(score);
                        if (flag1 == 0) {
                            Toast.makeText(this, "Score Updated....", Toast.LENGTH_LONG).show();
                            SharedPreferenceUse sh = new SharedPreferenceUse();
                            //Change Level Cleared
                            sh.changeLevelCleared("E7", this);
                            Toast.makeText(this, "Level Cleared....Redirecting to Next Level", Toast.LENGTH_LONG).show();
                            SharedPreferences.Editor ed0 = Counter_Medium2.edit();
                            ed0.putString("count", "1");
                            ed0.commit();

                            //Change icon of level 7 -> lock to key
                            changeImageIcon7E();

                            Intent intent3 = new Intent(this, Easy_8.class);
                            intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent3);
                        } else {
                            //if answer is wrong
                            Toast.makeText(this, "Score Not Updated....", Toast.LENGTH_LONG).show();
                        }
                    }
                    SharedPreferences.Editor ed1 = Counter_Medium1.edit();
                    ed1.putString("count", "1");
                    ed1.commit();
                } else {
                    Toast.makeText(this, "Answer Wrong...Try Again", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor ed1 = Counter_Medium1.edit();
                    ed1.putString("count", "1");
                    ed1.commit();
                }
            } while (count == 0);
        }
        else {
            Toast.makeText(this, "Previous Level is Not Cleared", Toast.LENGTH_LONG).show();
            Intent intent4 = new Intent(this, OpenEasyLevel.class);
            intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent4);
        }
    }
}
