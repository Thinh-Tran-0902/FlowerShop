package com.example.flowershop.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseFlowerShop  {  //extends SQLiteOpenHelper
    public static final String DATABASE_NAME = "FlowerShop";

    public static final String TABLE_User = "User";
    public static final String TABLE_User_col_username = "username";
    public static final String TABLE_User_col_password = "password";
    public static final String TABLE_User_col_name = "name";
    public static final String TABLE_User_col_address = "address";
    public static final String TABLE_User_col_gender = "gender";
   // public static final String TABLE_User_col_avatar = "avatar";
    public static final String TABLE_User_col_role = "roleId";

    public static final String TABLE_Flower = "Flower";
    public static final String TABLE_Flower_col_id = "id";
    public static final String TABLE_Flower_col_adminId = "adminId";
    public static final String TABLE_Flower_col_categoryID = "categoryID";
    public static final String TABLE_Flower_col_name = "name";
    public static final String TABLE_Flower_col_avatar = "avatar";
    public static final String TABLE_Flower_col_price = "price";
    public static final String TABLE_Flower_col_color = "color";
    public static final String TABLE_Flower_col_description = "description";

    public static final String TABLE_Category = "Category";
    public static final String TABLE_Category_col_id = "id";
    public static final String TABLE_Category_col_name = "name";

    public static final String TABLE_Order = "Order";
    public static final String TABLE_Order_col_id = "id";
    public static final String TABLE_Order_col_customerId = "customerId";
    public static final String TABLE_Order_col_date = "date";
    public static final String TABLE_Order_col_price = "price";
    public static final String TABLE_Order_col_status = "status";

    public static final String TABLE_OrderDetail = "OrderDetail";
    public static final String TABLE_OrderDetail_col_id = "id";
    public static final String TABLE_OrderDetail_col_flowerId = "flowerId";
    public static final String TABLE_OrderDetail_col_orderId = "orderId";
    public static final String TABLE_OrderDetail_col_quantity = "quantity";

    public static final String TABLE_Cart = "Cart";
    public static final String TABLE_Cart_col_cartid = "id";
    public static final String TABLE_Cart_col_floweridquantity = "floweridquantity";


    //---------------------------------------------------------------------------

    public static final String CREATE_TABLE_Cart = "CREATE TABLE " + TABLE_Cart
            + " ( "
            + TABLE_Cart_col_cartid + " TEXT NOT NULL, "
            + TABLE_Cart_col_floweridquantity + " TEXT NOT NULL"
            + " );";
    public static final String CREATE_TABLE_Category = "CREATE TABLE " + TABLE_Category
                    + " ( "
                    + TABLE_Category_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TABLE_Category_col_name + " TEXT NOT NULL"
                    + " );";

    public static final String CREATE_TABLE_Flower = "CREATE TABLE " + TABLE_Flower
                    + " ( "
                    + TABLE_Flower_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TABLE_Flower_col_adminId + " INTEGER NOT NULL, "
                    + TABLE_Flower_col_categoryID + " INTEGER NOT NULL, "
                    + TABLE_Flower_col_name + " TEXT NOT NULL, "
                    + TABLE_Flower_col_avatar + " INTEGER NULL, "
                    + TABLE_Flower_col_price + " INTEGER NOT NULL, "
                    + TABLE_Flower_col_color + " TEXT NOT NULL, "
                    + TABLE_Flower_col_description + " TEXT NOT NULL"
                    + " );";

    public static final String CREATE_TABLE_User = "CREATE TABLE " + TABLE_User
                    + " ( "
                    + TABLE_User_col_username + " TEXT PRIMARY KEY, "
                    + TABLE_User_col_password + " TEXT NOT NULL, "
                    + TABLE_User_col_name + " TEXT NOT NULL, "
                    + TABLE_User_col_address + " TEXT NOT NULL, "
                    + TABLE_User_col_gender + " TEXT NOT NULL, "
                    + TABLE_User_col_role + " INTEGER NOT NULL"
                    + " );";

    public static final String CREATE_TABLE_Order = "CREATE TABLE [" + TABLE_Order + "] "
                    + " ( "
                    + TABLE_Order_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TABLE_Order_col_customerId + " INTEGER NOT NULL, "
                    + TABLE_Order_col_date + " TEXT NOT NULL, "
                    + TABLE_Order_col_price + " INTEGER NOT NULL, "
                    + TABLE_Order_col_status + " INTEGER NOT NULL "
                    + " );";

    public static final String CREATE_TABLE_OrderDetail = "CREATE TABLE " + TABLE_OrderDetail
                    + " ( "
                    + TABLE_OrderDetail_col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TABLE_OrderDetail_col_flowerId + " INTEGER NOT NULL, "
                    + TABLE_OrderDetail_col_orderId + " INTEGER NOT NULL, "
                    + TABLE_OrderDetail_col_quantity + " INTEGER NOT NULL"
                    + " );";


//    private SQLiteDatabase db;
//
//    DataBaseFlowerShop(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_Category);
//        System.out.println("=====> [Category] create success");
//
//        db.execSQL(CREATE_TABLE_Flower);
//        System.out.println("=====> [Flower] create success");
//
//        db.execSQL(CREATE_TABLE_Order);
//        System.out.println("=====> [Order] create success");
//
//        db.execSQL(CREATE_TABLE_User);
//        System.out.println("=====> [User] create success");
//
//        db.execSQL(CREATE_TABLE_OrderDetail);
//        System.out.println("=====> [OrderDetail] create success");
//    }

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Category);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Flower);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Order);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_User);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OrderDetail);
//        onCreate(db);
//    }
}


