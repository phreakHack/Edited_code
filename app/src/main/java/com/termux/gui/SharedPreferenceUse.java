package com.termux.gui;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Admin on 19/03/2017.
 */

public class SharedPreferenceUse{

    public static SharedPreferences GLOBAL_SHARED_PREFERENCE_EDIT ;

    public void changeLevelCleared(String levelNo,Context context){

        GLOBAL_SHARED_PREFERENCE_EDIT = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor deditor = GLOBAL_SHARED_PREFERENCE_EDIT.edit();
        deditor.putString("level_cleared", levelNo);
        deditor.commit();
    }
    public int checkLevel(String levelNoPassed,Context context){
        int flag = 0;
        GLOBAL_SHARED_PREFERENCE_EDIT =PreferenceManager.getDefaultSharedPreferences(context) ;

        String sharedPreferenceGetString = GLOBAL_SHARED_PREFERENCE_EDIT.getString("level_cleared","");
        Log.i("Level Accessed", sharedPreferenceGetString);
        if(sharedPreferenceGetString.equalsIgnoreCase(levelNoPassed)){
            flag=0;
        }
        else{
            flag = 1;
        }
        return flag;
    }
}
