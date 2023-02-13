package com.project.aqualife

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent?.action == "MyBroadcastReceiverAction") {
            Log.d("알람","RECEIVED")


        }
    }

}