package com.termux.gui;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Admin on 17/03/2017.
 */

public class ConfigScoreCard extends Activity{

    private static final String INSERT_URL = "http://210.212.188.165/android-mysql/score2.php";
    private static String score="0";
    private static int flag = 0;

    public int insertScore(String score1) {
        Log.i("Call to ConfigScore","Call to Config Score");
        this.score = score1 ;
       String username =Config.KEY_USERNAME1 ;
        Log.i("user",username);
        String urlSuffix = "?score="+score+"&username="+username;
        Log.i("Insert Score","Inside insert()/Username = "+username);
        Log.i("Insert Score","Inside insert()/score="+score);

        Log.i("Insert Score","Inside insert()");

        class InsertData extends AsyncTask<String, Void, String> {
           //ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s.equalsIgnoreCase("Connected Successfully")) {
                    String Score_String = "Score Inserted in db :" + score;
                    Log.i("SCORE INSERT :", Score_String);
                    Log.i("SCORE INSERT - USER :", Config.USERNAME_SHARED_PREF);

                    flag = 0 ;
                }
            }
            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(INSERT_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferedReader.readLine();
                    return result;
                }catch(Exception e){
                    flag = 1;
                    return null;
                }
            }
        }
        InsertData insertData = new InsertData();
        insertData.execute(urlSuffix);
        return flag ;
    }
}
