package com.example.flowershop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowershop.models.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword, gender, address, name;
    Button signUp, signIn , btnSignInF;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        gender = findViewById(R.id.tv_gender);
        address = findViewById(R.id.tv_address);
        name = findViewById(R.id.tv_name);
        signIn = findViewById(R.id.btnAccount);
        signUp = findViewById(R.id.btnRegister);
        btnSignInF = findViewById(R.id.btnLoginF);
        DB = new DBHelper(this);

        //createDBFlowerShop();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass= repassword.getText().toString();
                String genderTemp = gender.getText().toString();
                String addressTemp = address.getText().toString();
                String nameTemp = name.getText().toString();
                int roleId = 2;
                Users users = new Users(user,pass,nameTemp,addressTemp,genderTemp,roleId);
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) ||
                        TextUtils.isEmpty(genderTemp) || TextUtils.isEmpty(addressTemp) || TextUtils.isEmpty(nameTemp)){
                    Toast.makeText(MainActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                } else{
                    if(pass.equals(repass)){
                        Boolean checkUser = DB.checkUsername(user);
                        if(checkUser == false){
                            Boolean insert = DB.insertData(users);
                            if(insert == true){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,ShopPageActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Registered failed",Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this,"Username already existed!!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Passowrd are not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnSignInF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    /*void createDBFlowerShop(){
        try {
            //deleteDatabase(DataBaseFlowerShop.DATABASE_NAME);

            SQLiteDatabase db = openOrCreateDatabase(DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);
            System.out.println("==> create or open DB "+ DataBaseFlowerShop.DATABASE_NAME +" success");
            System.out.println("db: " +db);

            db.execSQL(DataBaseFlowerShop.CREATE_TABLE_Category);
            System.out.println("=====> [Category] create success");

            db.execSQL(DataBaseFlowerShop.CREATE_TABLE_Flower);
            System.out.println("=====> [Flower] create success");

            db.execSQL(DataBaseFlowerShop.CREATE_TABLE_Order);
            System.out.println("=====> [Order] create success");

            //db.execSQL(DataBaseFlowerShop.CREATE_TABLE_User);
            //System.out.println("=====> [User] create success");

            db.execSQL(DataBaseFlowerShop.CREATE_TABLE_OrderDetail);
            System.out.println("=====> [OrderDetail] create success");

        }catch (Exception ex){
            System.out.println("error: " + ex.getMessage());
        }
    }*/



//    public void login(View v){
//        String useremail = email.getText().toString();
//        String userpass = pass.getText().toString();
//
//        if(useremail.equals("tranthinh") && userpass.equals("12345")){
//            Intent in = new Intent(this, ShopPageActivity.class);
//            in.putExtra("username", useremail);
//            startActivity(in);
//        }else{
//            Toast.makeText(getBaseContext(), "Wrong email and password", Toast.LENGTH_SHORT).show();
//        }
//    }

}