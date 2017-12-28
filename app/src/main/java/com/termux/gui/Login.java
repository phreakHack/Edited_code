package com.termux.gui;

        import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.termux.R;

import java.util.HashMap;
import java.util.Map;
public class Login extends Activity {


    //Defining views
    public static EditText editTextUsername;
    private EditText editTextPassword;
    TextView newUser ;

    private Button buttonLogin;
    //boolean variable to check user is logged in or not
    //initially it is false
    private boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initializing views
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.loginbutton);
        newUser = (TextView)findViewById(R.id.newUser_textView);

        //Register Form after clicking New User ?
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

        //Login method call after clicking login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login1();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //In onresume fetching value from sharedpreference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.LOGGEDIN_SHARED_PREF, false);

        //If we will get true
        if (loggedIn) {
            //We will start the Profile Activity
            Intent intent = new Intent(Login.this, LoginSuccess.class);
            startActivity(intent);
        }
    }

    public void login1() {
        //Getting values from edit texts
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        Config.KEY_USERNAME1 = username ;

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //If we are getting success from server
                    if (response.equalsIgnoreCase(Config.LOGIN_SUCCESS)) {
                        //Creating a shared preference
                        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                        //Creating editor to store values to shared preferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        //Adding values to editor
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                        editor.putString(Config.USERNAME_SHARED_PREF, username);

                        //Saving values to editor
                        editor.commit();

                        Toast.makeText(Login.this,"Redirecting...",Toast.LENGTH_LONG).show() ;
                        Log.i("LOGIN", "User : " + username + " : has LoggedIn");

                        //Starting profile activity
                        Intent intent = new Intent(Login.this, LoginSuccess.class);
                        startActivity(intent);
                    } else {
                        //If the server response is not success
                        //Displaying an error message on toast
                        Toast.makeText(Login.this,"Invalid username or password", Toast.LENGTH_LONG).show();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //You can handle error here if you want
                }
            }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_USERNAME, username);
                params.put(Config.KEY_PASSWORD, password);

                //returning parameter
                return params;
            }
        };
        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
