package com.example.nonotify;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import static java.sql.Types.NULL;


public class dndHandler {

    public boolean dndPermission = false;
    private Context mainContext;
    private Activity mainActivity;


    //Constructor
    public dndHandler(Context context, Activity activity){
        mainContext = context;
        mainActivity = activity;
    }



    //Checks if app has access to Do not disturb
    //If no access then prompts user to give permission
    public void checkDndPermission(){
        NotificationManager nManager = (NotificationManager) mainActivity.getSystemService(Context.NOTIFICATION_SERVICE);

        if (!nManager.isNotificationPolicyAccessGranted()) {

            dndPermission = false;
            //Ask for permission
            dndPermissionDialog();
        }
         else {
            dndPermission = true;
        }

    }



    public void dndPermissionDialog(){

        //Dialog box to prompt user for permission
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setMessage(R.string.dnd_dialog_message).setTitle(R.string.dnd_dialog_title);

        //If user agrees to grant access then move to notification settings
        builder.setPositiveButton(R.string.dnd_dialog_allow, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                mainActivity.startActivity(intent);
                mainActivity.overridePendingTransition(NULL, NULL);
            }
        });

        //If user doesn't allow access
        builder.setNegativeButton(R.string.dnd_dialog_cancel, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }





    //Will turn ON Do Not Disturb
    public void turnOnDnd(){
        NotificationManager nManager = (NotificationManager) mainActivity.getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
    }


    //Will turn OFF Do Not Disturb
    public void turnOffDnd(){
        NotificationManager nManager = (NotificationManager) mainActivity.getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
    }

}
