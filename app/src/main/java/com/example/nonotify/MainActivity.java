package com.example.nonotify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.service.notification.NotificationListenerService;

public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Clicking this will turn on notifications
    public void yesNotify(View view){
        TextView status = findViewById(R.id.currStat);



        NotificationManager nM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nM.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);


        status.setText("Notifications are turned ON");
    }

    //Clicking this will turn off notifications
    public void noNotify(View view){
        TextView status = findViewById(R.id.currStat);

        NotificationManager nM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        
        nM.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
        status.setText("Notifications are turned OFF");
    }




}
