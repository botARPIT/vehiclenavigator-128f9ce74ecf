package com.example.gatenavigator;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//
//import com.example.gatenavigator.Models.bankModel;
//import com.example.qrcodescanner.Models.dataModel;
//import com.example.qrcodescanner.Models.driverModel;

import com.example.gatenavigator.Models.Customer;
import com.example.gatenavigator.Models.LoadingPoint;
import com.example.gatenavigator.Models.VehicleTransaction;
import com.example.gatenavigator.Models.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "VehicleNavigator";

    //Table names
    private static final String TABLE_CUSTOMER_DATA="customer_data";
    private static final String TABLE_VEHICLE_TYPE_DATA="vehicle_type";
    private static final String TABLE_LOAD_POINT_DATA="loading_point";

    // Column
    private static final String KEY_CUSTOMER_ID="id";
    private static final String KEY_CUSTOMER_NAME ="customer_name";
//    private static final String KEY_RECORD_SYNC_STATUS="is_sync";
//    private static final String KEY_RECORD_GATE ="gate";


    // Vehicle Type
    private static final String KEY_VEHICLE_ID="id";
    private static final String KEY_VEHICLE_TYPE="vehicle_type";

    // Loading Point

    private static final String KEY_LOAD_POINT_ID="id";
    private static final String KEY_LOAD_POINT="load_point";
    private static final String  TABLE_VEHICLE_NAVIGATOR_TRANSACTION="vehicle_transaction";

    // Vehicle Navigator Transaction
    private static final String KEY_TRANS_ID="id";
    private static final String KEY_TRANS_DATE="date";
    private static final String KEY_TRANS_VEHICLE_NO="vehicle_no";
    private static final String KEY_TRANS_VEHICLE_TYPE="vehicle_type";
    private static final String KEY_TRANS_CUSTOMER="customer_name";
    private static final String KEY_TRANS_TRANSPORTER="transporter_name";
    private static final String KEY_TRANS_GATE="gate";
    private static final String KEY_TRANS_KANTA="kanta";
    private static final String KEY_TRANS_LOADING="loading";
    private static final String KEY_TRANS_APPROVAL_STATUS="approval_status";
    private static final String KEY_TRANS_UNIQUE_KEY="usercode";
    private static final String KEY_TRANS_SYNC_STATUS="is_sync";


    public DBHelper(Context context) {
        super(context, context.getFilesDir()+"/"+DATABASE_NAME+".db", null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create Table - CUSTOMER DATA
        String CREATE_TABLE_CUSTOMER_DATA ="CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMER_DATA+ "("
                + KEY_CUSTOMER_ID +" TEXT,"
                + KEY_CUSTOMER_NAME +" TEXT" + ")";
        db.execSQL(CREATE_TABLE_CUSTOMER_DATA);


        // Create Table - VEHICLE TYPE DATA
        String CREATE_TABLE_VEHICLE_TYPE_DATA ="CREATE TABLE IF NOT EXISTS " + TABLE_VEHICLE_TYPE_DATA+ "("
                + KEY_VEHICLE_ID +" TEXT,"
                + KEY_VEHICLE_TYPE +" TEXT" + ")";
        db.execSQL(CREATE_TABLE_VEHICLE_TYPE_DATA);


        // Create Table - LOADING POINT DATA
        String CREATE_LOAD_POINT_DATA ="CREATE TABLE IF NOT EXISTS " + TABLE_LOAD_POINT_DATA+ "("
                + KEY_LOAD_POINT_ID +" TEXT,"
                + KEY_LOAD_POINT +" TEXT" + ")";
        db.execSQL(CREATE_LOAD_POINT_DATA);

        // Create Table - VEHICLE NAVIGATOR TRANSACTION
        String CREATE_VEHICLE_NAVIGATOR_TRANSACTION = "CREATE TABLE IF NOT EXISTS " + TABLE_VEHICLE_NAVIGATOR_TRANSACTION + " ("
                + KEY_TRANS_ID + " TEXT , " //  ID
                + KEY_TRANS_DATE + " TEXT, "                          // Date of transaction
                + KEY_TRANS_VEHICLE_NO + " TEXT, "                   // Vehicle number
                + KEY_TRANS_VEHICLE_TYPE + " TEXT, "                 // Vehicle type
                + KEY_TRANS_CUSTOMER + " TEXT, "                     // Customer name
                + KEY_TRANS_TRANSPORTER + " TEXT, "                  // Transporter name
                + KEY_TRANS_GATE + " TEXT, "                  // Gate JSON
                + KEY_TRANS_KANTA + " TEXT, "                  // Kanta JSON
                + KEY_TRANS_LOADING + " TEXT, "                  // Loading JSON
                + KEY_TRANS_APPROVAL_STATUS + " TEXT, "              // Approval status
                + KEY_TRANS_UNIQUE_KEY + " TEXT, "                   // Unique user code
                + KEY_TRANS_SYNC_STATUS + " INTEGER DEFAULT 0"       // Sync status (0 = not synced, 1 = synced)

                + ")";
        db.execSQL(CREATE_VEHICLE_NAVIGATOR_TRANSACTION);

//        + KEY_TRANS_SYNC_STATUS + " INTEGER DEFAULT 0"       // Sync status (0 = not synced, 1 = synced)

//        + KEY_TRANS_SYNC_STATUS + " TEXT "       // Sync status (0 = not synced, 1 = synced)

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if(oldVersion < 4) {
//            final String alter_record_data="ALTER TABLE "+TABLE_RECORD_DATA+" ADD COLUMN "+ KEY_RECORD_GATE +" TEXT ";
//            db.execSQL(alter_record_data);
//        }
        onCreate(db);
    }

//     Insert Queries

// Add customer data in customer table
    public void add_customer_data( String id,String customer_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_CUSTOMER_ID, id);
        values.put(KEY_CUSTOMER_NAME, customer_name);

        db.insertWithOnConflict(TABLE_CUSTOMER_DATA, null, values,SQLiteDatabase.CONFLICT_IGNORE);
    }

    // Add vehicle type data in vehicle type table
    public void add_vehicle_type_data( String id,String vehicle_type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_VEHICLE_ID, id);
        values.put(KEY_VEHICLE_TYPE, vehicle_type);
        db.insertWithOnConflict(TABLE_VEHICLE_TYPE_DATA, null, values,SQLiteDatabase.CONFLICT_IGNORE);
    }



    // Add Loading Point in Loading Point table
    public void add_loading_point_data( String id,String loading_point){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_LOAD_POINT_ID, id);
        values.put(KEY_LOAD_POINT, KEY_LOAD_POINT);
        db.insertWithOnConflict(TABLE_LOAD_POINT_DATA, null, values,SQLiteDatabase.CONFLICT_IGNORE);
    }

    // Add a new transaction to the Vehicle Navigator Transaction table
    public void addVehicleTransaction(String id, String date, String vehicleNo, String vehicleType, String customerName,
                                      String transporterName, String gateJson, String kantaJson, String loadingJson,
                                      String approvalStatus, String uniqueKey, int syncStatus) {
        SQLiteDatabase db = this.getWritableDatabase(); // Open the database for writing
        ContentValues values = new ContentValues();

        // Insert values into the ContentValues object
        values.put(KEY_TRANS_ID, id); // ID
        values.put(KEY_TRANS_DATE, date); // Date of transaction
        values.put(KEY_TRANS_VEHICLE_NO, vehicleNo); // Vehicle number
        values.put(KEY_TRANS_VEHICLE_TYPE, vehicleType); // Vehicle type
        values.put(KEY_TRANS_CUSTOMER, customerName); // Customer name
        values.put(KEY_TRANS_TRANSPORTER, transporterName); // Transporter name
        values.put(KEY_TRANS_GATE, gateJson); // Gate JSON
        values.put(KEY_TRANS_KANTA, kantaJson); // Kanta JSON
        values.put(KEY_TRANS_LOADING, loadingJson); // Loading JSON
        values.put(KEY_TRANS_APPROVAL_STATUS, approvalStatus); // Approval status
        values.put(KEY_TRANS_UNIQUE_KEY, uniqueKey); // Unique user code
        values.put(KEY_TRANS_SYNC_STATUS, syncStatus); // Sync status (0 = not synced, 1 = synced)

        // Insert the data into the database
        db.insertWithOnConflict(TABLE_VEHICLE_NAVIGATOR_TRANSACTION, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        db.close(); // Close the database connection
    }


// FETCH DETAILS


    // Fetch all customer data from the table
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase(); // Open the database for reading

        // Define the query to fetch all rows from the customer table
        String selectQuery = "SELECT * FROM " + TABLE_CUSTOMER_DATA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                // Create a Customer object
                Customer customer = new Customer();
                customer.setId(cursor.getString(cursor.getColumnIndexOrThrow(KEY_CUSTOMER_ID)));
                customer.setName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_CUSTOMER_NAME)));

                // Add the customer to the list
                customerList.add(customer);
            } while (cursor.moveToNext());
        }

        cursor.close(); // Close the cursor
        db.close(); // Close the database

        return customerList; // Return the list of customers
    }

    // Fetch all vehicle types
    public List<VehicleType> getAllVehicleTypes() {
        List<VehicleType> vehicleTypeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to fetch all rows from the Vehicle Type table
        String selectQuery = "SELECT * FROM " + TABLE_VEHICLE_TYPE_DATA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                // Create a VehicleType object
                VehicleType vehicleType = new VehicleType();
                vehicleType.setId(cursor.getString(cursor.getColumnIndexOrThrow(KEY_VEHICLE_ID)));
                vehicleType.setType(cursor.getString(cursor.getColumnIndexOrThrow(KEY_VEHICLE_TYPE)));

                // Add the vehicle type to the list
                vehicleTypeList.add(vehicleType);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return vehicleTypeList;
    }


    // Fetch all loading points
    public List<LoadingPoint> getAllLoadingPoints() {
        List<LoadingPoint> loadingPointList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to fetch all rows from the Loading Point table
        String selectQuery = "SELECT * FROM " + TABLE_LOAD_POINT_DATA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                // Create a LoadingPoint object
                LoadingPoint loadingPoint = new LoadingPoint();
                loadingPoint.setId(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOAD_POINT_ID)));
                loadingPoint.setPoint(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOAD_POINT)));

                // Add the loading point to the list
                loadingPointList.add(loadingPoint);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return loadingPointList;
    }

    // Fetch all vehicle navigator transactions
    public List<VehicleTransaction> getAllVehicleTransactions() {
        List<VehicleTransaction> transactionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to fetch all rows from the Vehicle Navigator Transaction table
        String selectQuery = "SELECT * FROM " + TABLE_VEHICLE_NAVIGATOR_TRANSACTION;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                // Create a VehicleTransaction object
                VehicleTransaction transaction = new VehicleTransaction();
                transaction.setId(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_ID)));
                transaction.setDate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_DATE)));
                transaction.setVehicleNo(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_VEHICLE_NO)));
                transaction.setVehicleType(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_VEHICLE_TYPE)));
                transaction.setCustomerName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_CUSTOMER)));
                transaction.setTransporterName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_TRANSPORTER)));
                transaction.setGateJson(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_GATE)));
                transaction.setKantaJson(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_KANTA)));
                transaction.setLoadingJson(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_LOADING)));
                transaction.setApprovalStatus(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_APPROVAL_STATUS)));
                transaction.setUniqueKey(cursor.getString(cursor.getColumnIndexOrThrow(KEY_TRANS_UNIQUE_KEY)));
                transaction.setSyncStatus(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_TRANS_SYNC_STATUS)));

                // Add the transaction to the list
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return transactionList;
    }






//
//
//    public void add_data( String id,String entry_timestamp,String is_sync,String gate){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values=new ContentValues();
//
//        values.put(KEY_RECORD_ID, id);
//        values.put(KEY_RECORD_DATETIME,entry_timestamp);
//        values.put(KEY_RECORD_GATE,gate);
//        values.put(KEY_RECORD_SYNC_STATUS,is_sync);
//        db.insertWithOnConflict(TABLE_RECORD_DATA, null, values,SQLiteDatabase.CONFLICT_IGNORE);
//    }
//
//    // Add data in record data table
//    public void add_driver_data( String timestamp,String agent_id,String driver_name,String mobile_no,String vehicle_type,String vehicle_no,String is_sync){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values=new ContentValues();
//
//        values.put(KEY_DATETIME, timestamp);
//        values.put(KEY_AGENT_ID,agent_id);
//        values.put(KEY_DRIVER_NAME,driver_name);
//        values.put(KEY_DRIVER_MOBILE_NO,mobile_no);
//        values.put(KEY_DRIVER_VEHICLE_TYPE,vehicle_type);
//        values.put(KEY_DRIVER_VEHICLE_NO,vehicle_no);
//        values.put(KEY_DRIVER_SYNC_STATUS,is_sync);
//        db.insert(TABLE_DRIVER_DATA, null, values);
////        db.insertWithOnConflict(TABLE_DRIVER_DATA, null, values,SQLiteDatabase.CONFLICT_IGNORE);
//    }
//
//
//    // Fetch record data
//    @SuppressLint("SuspiciousIndentation")
//    public ArrayList<dataModel> fetch_data_list(String start_date, String end_date){
//      ArrayList<dataModel> data_list=new ArrayList<>();
//
//        String  selectQuery="";
//        if(start_date.equalsIgnoreCase(end_date))
//         selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA+" WHERE "+ KEY_RECORD_DATETIME +" LIKE '"+start_date+"%' ORDER BY "+ KEY_RECORD_DATETIME +" DESC" ;
//
//        else
//        selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA+" WHERE "+ KEY_RECORD_DATETIME +" BETWEEN '"+start_date+"' AND '"+end_date+"' OR "+ KEY_RECORD_DATETIME +" LIKE '"+end_date+"%'  ORDER BY "+ KEY_RECORD_DATETIME +" DESC" ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all data list
//
//                data_list.add(new dataModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
//
//
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return data_list;
//
//    }
//
//
//    // Fetch record data
//    public ArrayList<dataModel> fetch_not_sync_list(){
//        ArrayList<dataModel> data_list=new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA+" WHERE "+KEY_RECORD_SYNC_STATUS+"='false'" ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all worker master list
//                data_list.add(new dataModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return data_list;
//
//    }
//
//
//    // Fetch Records for current date
//    public HashMap<String,dataModel> fetch_general_list(){
//        HashMap<String,dataModel> data_list= new HashMap<>();
//
////        String selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA+" WHERE "+KEY_RECORD_EXIT_DATETIME+"" ;
//        String selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all worker master list
//                data_list.put(cursor.getString(0),new dataModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return data_list;
//
//    }
//
//
//
//    // Fetch Driver Data List
//    public ArrayList<bankModel> fetch_bank_data_list(){
//        ArrayList<bankModel> bank_list=new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_BANK_DATA ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all driver list
//                bank_list.add(new bankModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return bank_list;
//
//    }
//
//
//
//    // Fetch Driver Data List
//    public ArrayList<driverModel> fetch_driver_data_list(){
//        ArrayList<driverModel> driver_list=new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_DRIVER_DATA+" ORDER BY "+KEY_DATETIME+" DESC " ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all driver list
//                driver_list.add(new driverModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return driver_list;
//
//    }
//
//    // Fetch Driver Data Not Sync List
//    public ArrayList<driverModel> fetch_driver_not_sync_list(){
//        ArrayList<driverModel> driver_list=new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_DRIVER_DATA+" WHERE "+KEY_DRIVER_SYNC_STATUS+"='false'" ;
//
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all driver list
//                driver_list.add(new driverModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return driver_list;
//
//    }
//
//
//
//    // Fetch Driver Bank Data Not Sync List
//    public String fetch_driver_name_mobile(String agent_id){
//
//        String driver_name="";
//
//        String db_query = "SELECT "+KEY_DRIVER_BANK_ACC_HOLDER_NAME+","+KEY_DRIVER_BANK_MOBILE_NO+" FROM " + TABLE_BANK_DATA+" WHERE "+KEY_DRIVER_AGENT_ID+"='"+agent_id+"'" ;
//
//        Log.i("TAG", "fetch_agent_id_mobile_list: "+db_query);
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(db_query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                driver_name=cursor.getString(0)+"_"+cursor.getString(1);
//            } while (cursor.moveToNext());
//
//        }
//
//        return driver_name;
//
//    }
//
//
//    // Fetch Driver Bank Data Not Sync List
//    public ArrayList<bankModel> fetch_agent_id_mobile_list(String clause_constraint,String clause_value){
//
//        ArrayList<bankModel> agent_id_mobile_list=new ArrayList<>();
//
//        String db_query = "SELECT * FROM " + TABLE_BANK_DATA+" WHERE "+clause_constraint+"='"+clause_value+"'" ;
//
//        Log.i("TAG", "fetch_agent_id_mobile_list: "+db_query);
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(db_query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                agent_id_mobile_list.add(new bankModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
//            } while (cursor.moveToNext());
//
//        }
//
//        return  agent_id_mobile_list;
//
//    }
//
//
//    // Fetch Driver Bank Data Not Sync List
//    public ArrayList<bankModel> fetch_driver_bank_not_sync_list(){
//        ArrayList<bankModel> bank_not_sync_list=new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_BANK_DATA+" WHERE "+KEY_DRIVER_BANK_SYNC_STATUS+"='false'" ;
//
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all bank list
//                bank_not_sync_list.add(new bankModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
//
//            } while (cursor.moveToNext());
//
//        }
//
//
//        return bank_not_sync_list;
//
//    }
//
//
//
//    public boolean is_id_exists(String id){
//        boolean is_id_exists=false;
//        HashMap<String,String> data_list=new HashMap<>();
//        String  selectQuery = "SELECT  * FROM " + TABLE_RECORD_DATA+" WHERE "+KEY_RECORD_ID+"='"+id+"'";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //fetch all worker master list
//                data_list.put(cursor.getString(0),cursor.getString(1));
//
//            } while (cursor.moveToNext());
//
//        }
//        if(data_list.size()>0)
//            is_id_exists=true;
//
//        return  is_id_exists;
//    }
//
//
//    // Update Queries
//
////    public void update_marked_data_exit_time(  String exit_timestamp ,String booking_id ){
////        SQLiteDatabase db = this.getWritableDatabase();
////        ContentValues values=new ContentValues();
////
////        values.put(KEY_RECORD_GATE, exit_timestamp);
////
////
////        db.update(TABLE_RECORD_DATA, values,"id= ?",new String[]{booking_id});
////
////    }
//
//
//    public void update_marked_data_list(String sync_status,ArrayList<dataModel> dataList){
//
//        for(dataModel item : dataList) {
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues values = new ContentValues();
//
//            values.put(KEY_RECORD_SYNC_STATUS, sync_status);
//
//
//            db.update(TABLE_RECORD_DATA, values, "id= ?", new String[]{item.getId()});
//        }
//    }
//    public void update_marked_driver_list(String sync_status,ArrayList<driverModel> driverList){
//
//        for(driverModel item : driverList) {
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues values = new ContentValues();
//
//            values.put(KEY_DRIVER_SYNC_STATUS, sync_status);
//
//
//            db.update(TABLE_DRIVER_DATA, values, "datetime= ?", new String[]{item.getDate_time()});
//        }
//    }
//
//
//    public void update_marked_bank_list(String sync_status,ArrayList<bankModel> bankList){
//
//        for(bankModel item : bankList) {
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues values = new ContentValues();
//
//            values.put(KEY_DRIVER_BANK_SYNC_STATUS, sync_status);
//
//
//            db.update(TABLE_BANK_DATA, values, "agent_id= ?", new String[]{item.getAgent_id()});
//        }
//    }
//
//
//    public void delete_bank_data(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String DELETE_TABLE_BANK_DATA="DELETE FROM "+TABLE_BANK_DATA;
//        db.execSQL(DELETE_TABLE_BANK_DATA);
//    }
//




}
