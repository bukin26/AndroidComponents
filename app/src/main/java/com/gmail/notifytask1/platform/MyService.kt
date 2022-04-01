package com.gmail.notifytask1.platform

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import com.gmail.notifytask1.R
import com.gmail.notifytask1.utils.Constants

class MyService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val broadcastIntent = Intent()
        broadcastIntent.action = Constants.MY_BROADCAST
        val pendingIntent =
            PendingIntent.getBroadcast(
                this,
                0,
                broadcastIntent, PendingIntent.FLAG_IMMUTABLE
            )
        val notification =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Notification.Builder(this, Constants.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(resources.getString(R.string.service_title))
                    .setContentText(resources.getString(R.string.service_text))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build()
            } else {
                Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(resources.getString(R.string.service_title))
                    .setContentText(resources.getString(R.string.service_text))
                    .setPriority(Notification.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build()
            }
        startForeground(Constants.ONGOING_NOTIFICATION_ID, notification)
        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.CHANNEL_ID,
                resources.getString(R.string.service_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

