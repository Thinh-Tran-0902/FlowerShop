package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;
    Button signinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.textEmail);
        pass = (EditText) findViewById(R.id.textPassword);
        signinbutton = (Button) findViewById(R.id.buttonLogin);
    }

    public void login(View v){
        String useremail = email.getText().toString();
        String userpass = pass.getText().toString();

        if(useremail.equals("tranthinh") && userpass.equals("12345")){
            Intent in = new Intent(this, ShopPageActivity.class);
            in.putExtra("username", useremail);
            startActivity(in);
        }else{
            Toast.makeText(getBaseContext(), "Wrong email and password", Toast.LENGTH_SHORT).show();
        }
    }

}