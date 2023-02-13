package org.pa.mathisfun.menu

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

import android.os.Build

class Notification : Application(){

    companion object{
        const val CHANNEL1 = "channel1"
    }

    override fun onCreate() {
        super.onCreate()
        createNotification()
    }

    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channer1 = NotificationChannel(
                CHANNEL1,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channer1.description = "Seseorang baru saja mengirim saran materi baru"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channer1 = NotificationChannel(
                CHANNEL1,
                "Channel 1",
                NotificationManager.IMPORTANCE_LOW
            )
            channer1.description = "Seseorang baru saja mengirim saran materi baru"

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channer1)
        }
    }
    }
