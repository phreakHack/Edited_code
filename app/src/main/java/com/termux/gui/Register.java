package com.termux.gui;

        import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.termux.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends Activity {
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private Button buttonRegister;
    private static  int flag = 0 ;
    private static EditText editTextConfirmPassword ;
    // private EditText editUrl;
    //private String enteredUrl;
    //private String REGISTER_URL;
//    AutoCompleteTextView autoCompleteTextView ;
//    String [] emailOptions ;

    private static final String REGISTER_URL = "http://210.212.188.165/android-mysql/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword =(EditText) findViewById(R.id.editTextConfirmPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        //  editUrl = (EditText)findViewById(R.id.editUrl) ;

        //To Complete Email Text View Automatically
//        emailOptions=getResources().getStringArray(R.array.email_options);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,emailOptions);
//        autoCompleteTextView.setAdapter(adapter);

    }
    public void registerClickedinRegister(View v) {
        int checkConstrain = 0 ;
        if(v == buttonRegister){
            checkConstrain = checkConstraints() ;
            if(checkConstrain==0) {
                registerUser();
            }
        }
    }
    public int checkConstraints(){
         String confirmPassword = editTextConfirmPassword.getText().toString();
        String name = editTextName.getText().toString().trim().toLowerCase();
        String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();
        int check = 0 ;

        if(name.isEmpty() || username.isEmpty()||password.isEmpty() || email.isEmpty() || confirmPassword.isEmpty()){
            Toast.makeText(this,"Please Enter Valid Data",Toast.LENGTH_LONG).show();
            check=1;
        }else {
            if (!password.equals(confirmPassword)) {
                //Check Password and Confirm Password Constraint
                Toast.makeText(this, "Please Enter correct Password", Toast.LENGTH_LONG).show();
                check = 1;
            } else {
                check = 0;
            }
          check = 0 ;
        }
        return check ;
    }

    //    public void sendurl(View view){
//        enteredUrl =editUrl.getText().toString();
//        REGISTER_URL = "http://"+enteredUrl+":8080/android-mysql/register.php";
//        Log.i("registerd url",REGISTER_URL);
//    }
    private void registerUser() {
        String name = editTextName.getText().toString().trim().toLowerCase();
        String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();
        register(name,username,password,email);
    }

    private void register(String name, String username, String password, String email) {
        String urlSuffix = "?name="+name+"&username="+username+"&password="+password+"&email="+email;

          class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Register.this, "Please Wait",null, true, true);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                if(s.equalsIgnoreCase("successfully registered")){
                    flag = 0;
                }
                else{
                    flag =1 ;
                }
                //    Toast.makeText(getApplicationContext(),"Try Again...",Toast.LENGTH_LONG).show();
                //}
            }
            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferedReader.readLine();
                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }
        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
        if(flag==0) {
            Toast.makeText(getApplicationContext(),"Successfully Registered...",Toast.LENGTH_LONG).show();
            Intent regSuccessful = new Intent(this, Login.class);
            regSuccessful.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(regSuccessful);
        }else{
            Toast.makeText(getApplicationContext(),"Try Again...",Toast.LENGTH_LONG).show();
        }
    }
}
