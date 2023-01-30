package com.project.aqualife
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.project.aqualife.viewModel.AuthViewModel

class MyAlarmReceiver : BroadcastReceiver() {

    private lateinit var authViewModel : AuthViewModel

    override fun onReceive(context: Context, intent: Intent) {

        if (intent?.action == "MyBroadcastReceiverAction") {
            Log.d("알람", "RECEIVED")
            authViewModel.changeAlarmState((acti))

        }
    }
}