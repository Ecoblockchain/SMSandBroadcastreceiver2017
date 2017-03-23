package com.example.teaching.smsandbroadcastreceiver2017;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionState = checkSelfPermission(Manifest.permission.RECEIVE_SMS);
        if(permissionState != PackageManager.PERMISSION_GRANTED){
            //in this case, permission has not been granted, so request the permission
            System.out.println("We do not have RECEIVE_SMS permission; requesting permission...");
            String [] requestedPermissions = new String[] {Manifest.permission.RECEIVE_SMS};
            int requestCode = 1234;
            requestPermissions(requestedPermissions, requestCode);
        } else{
            System.out.println("RECEIVE_SMS permission was already granted");
        }

        permissionState = checkSelfPermission(Manifest.permission.SEND_SMS);
        if(permissionState != PackageManager.PERMISSION_GRANTED){
            //in this case, permission has not been granted, so request the permission
            System.out.println("We do not have SEND_SMS permission; requesting permission...");
            String [] requestedPermissions = new String[] {Manifest.permission.SEND_SMS};
            int requestCode = 12345;
            requestPermissions(requestedPermissions, requestCode);
        }else{
            System.out.println("SEND_SMS permission was already granted");
        }
    }

}
