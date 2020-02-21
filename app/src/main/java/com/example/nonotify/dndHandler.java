package com.example.nonotify;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;






public class dndHandler {

    public boolean dndPermission = false;
    private Context mainContext;
    private Activity mainActivity;
    private NotificationManager nManager;

    //Constructor
    public dndHandler(Context context, Activity activity){
        mainContext = context;
        mainActivity = activity;
        nManager = (NotificationManager) mainActivity.getSystemService(Context.NOTIFICATION_SERVICE);
    }



    //Checks if app has access to Do not disturb
    //If no access then prompts user to give permission
    public void checkDndPermission(){

        //TO-DO : Add Dialog Box to prompt user to to give access


        if (!nManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            mainActivity.startActivity(intent);
            mainActivity.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.fade_out);
        }
        else{
            dndPermission = true;
        }


    }

    //Will turn ON Do Not Disturb
    public void turnOnDnd(){
        nManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
    }


    //Will turn OFF Do Not Disturb
    public void turnOffDnd(){
        nManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
    }

}
