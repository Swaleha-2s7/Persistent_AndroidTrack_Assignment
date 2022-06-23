package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText username, password;
    Boolean validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate = validateUser(username.getText().toString(), password.getText().toString());
                if(validate){
                    openNewActivity();
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public Boolean validateUser(String username, String password){
        if (username.equals("admin@123") && password.equals("admin")){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
    private void openNewActivity(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}