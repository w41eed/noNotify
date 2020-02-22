package com.example.nonotify;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

    //Pass Context and Activity to dndHandler
    dndHandler dnd = new dndHandler(this,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dnd.checkDndPermission();
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results){

        super.onRequestPermissionsResult(requestCode, permissions, results);

        if(requestCode == dnd.MY_PERMISSION_NOTIFICATION_POLICY && results[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

        }
    }
    */


    //Clicking this will turn OFF notifications by turning ON Do not disturb
    public void noNotify(View view){
        //Changes text to show notifications turned off
        TextView status = findViewById(R.id.currStat);
        status.setText("Notifications are turned OFF");

        dnd.checkDndPermission();
        if(dnd.dndPermission){
            dnd.turnOnDnd();
        }


        /*if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NOTIFICATION_POLICY}, dnd.MY_PERMISSION_NOTIFICATION_POLICY);

        } else {
            Toast.makeText(this, "permission already granted", Toast.LENGTH_SHORT).show();
        }*/

    }

    //Clicking this will turn ON notifications by turning OFF Do not disturb
    public void yesNotify(View view){
        //Changes text to show notifications turned on
        TextView status = findViewById(R.id.currStat);
        status.setText("Notifications are turned ON");

        dnd.checkDndPermission();
        if(dnd.dndPermission){
            dnd.turnOffDnd();
        }

    }


}
