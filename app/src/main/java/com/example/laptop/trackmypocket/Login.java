package com.example.laptop.trackmypocket;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.*;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editMobileNumber,editPassword;
    Button btnLogin,btnSignup;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editMobileNumber=(EditText)findViewById(R.id.editMobileNumber);
        editPassword=(EditText)findViewById(R.id.editPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignUp);
        database=new Database(this);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UserId=database.LoginSelect(editMobileNumber.getText().toString(),editPassword.getText().toString());
                if(UserId!="-1") {
                    Intent i = new Intent(getApplicationContext(), Index.class);
                    i.putExtra("UserId",UserId);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please check mobile number or password.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });

    }
}
