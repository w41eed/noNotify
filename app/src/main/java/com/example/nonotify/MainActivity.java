package com.example.nonotify;



import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.service.notification.NotificationListenerService;

public class MainActivity extends Activity {

    dndHandler dnd = new dndHandler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Clicking this will turn on notifications
    public void yesNotify(View view){
        TextView status = findViewById(R.id.currStat);
        status.setText("Notifications are turned ON");

        dnd.turnOffDnd(this);
    }

    //Clicking this will turn off notifications
    public void noNotify(View view){
        TextView status = findViewById(R.id.currStat);
        status.setText("Notifications are turned OFF");

        dnd.turnOnDnd(this);
    }




}
