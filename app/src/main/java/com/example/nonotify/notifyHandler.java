package com.example.nonotify;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


public class notifyHandler extends NotificationListenerService {

    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }



    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        String pack = sbn.getPackageName();
        String ticker = sbn.getNotification().tickerText.toString();
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString("android.title");
        String text = extras.getCharSequence("android.text").toString();

        Log.i("Package",pack);
        Log.i("Ticker",ticker);
        Log.i("Title",title);
        Log.i("Text",text);

        Intent msgrcv = new Intent("Msg");
        msgrcv.putExtra("package", pack);
        msgrcv.putExtra("ticker", ticker);
        msgrcv.putExtra("title", title);
        msgrcv.putExtra("text", text);

        LocalBroadcastManager.getInstance(context).sendBroadcast(msgrcv);

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        //here is where we disable the notifications
        NotificationManager notification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        StatusBarNotification[] n = notification.getActiveNotifications();
        Log.d("MainActivity.java", Integer.toString(n.length));
//                        TextView check2 = (TextView) findViewById(R.id.didPackagework);
//                            check2.setText(n.toString());
        for(int i = 0; i < n.length; i++) {
            Log.d("MainActivity.java", n[i].toString() );
            //                           TextView mylist = (TextView) findViewById(R.id.didPackagework);
//                            mylist.setText(n[i].toString());
        }
        Log.d("MyNLS.java", "in here");

        StatusBarNotification[] notifications = getActiveNotifications();
//        notifications.getPackageName();
    }


}
