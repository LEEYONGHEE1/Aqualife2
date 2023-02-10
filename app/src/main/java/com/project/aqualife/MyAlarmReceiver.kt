package com.project.aqualife


import android.R.id
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.project.aqualife.viewModel.AuthViewModel
import kotlin.properties.ReadOnlyProperty


class MyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent?.action == "MyBroadcastReceiverAction") {
            Log.d("알람","RECEIVED")


        }
    }


}