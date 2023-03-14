package com.project.aqualife

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.project.aqualife.viewModel.AuthViewModel

//43ㅐ 컴포넌트
class MyAlarmReceiver : BroadcastReceiver() {

    private lateinit var authViewModel : AuthViewModel

    override fun onReceive(context: Context, intent: Intent) {
        if (intent?.action == "MyBroadcastReceiverAction") {
            Log.d("알람","RECEIVED")

            authViewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
            authViewModel.changeFiltSetting( (activity as MainActivity).getSpinnerData().first, daycode, filtTime, chargeCount)

        }
    }


    private fun cancelAlarm() {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        // cancel the alarm
        alarmManager.cancel(pendingIntent);
        // delete the PendingIntent
        pendingIntent.cancel()
    }

}