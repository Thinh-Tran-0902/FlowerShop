package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flowershop.models.DBHelper;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin , btnSignUpF;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUpF = findViewById(R.id.btnSignUpF);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.insertData(new Users("admin","123","adminThuan","HaNoi","Nam",1));
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "All fields Required ", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUserPass = DB.checkUsernamePasswordForUser(user, pass);
                    if( checkUserPass == false){
                        Boolean checkUserPassForAdmin = DB.checkUsernamePasswordForAdmin(user,pass);
                        if(checkUserPassForAdmin == false){
                            Toast.makeText(LoginActivity.this, "Username or Password incorrect", Toast.LENGTH_SHORT).show();
                        } else if(checkUserPassForAdmin == true){
                            Toast.makeText(LoginActivity.this, "Admin Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                            startActivity(intent);
                        }

                    } else if(checkUserPass == true){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, ShopPageActivity.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                    }
                }
            }
        });

        btnSignUpF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}