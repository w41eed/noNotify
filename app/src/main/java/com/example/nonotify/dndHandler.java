package com.example.nonotify;

import android.app.NotificationManager;
import android.content.Context;




public class dndHandler {

    //Constructor
    public dndHandler(){}


    public void turnOnDnd(Context myContext){
        //Will turn on Do Not Disturb
        NotificationManager nM = (NotificationManager) myContext.getSystemService(Context.NOTIFICATION_SERVICE);
        nM.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);

    }


    public void turnOffDnd(Context myContext){
        //Will turn off Do Not Disturb
        NotificationManager nM = (NotificationManager) myContext.getSystemService(Context.NOTIFICATION_SERVICE);
        nM.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
    }

}
