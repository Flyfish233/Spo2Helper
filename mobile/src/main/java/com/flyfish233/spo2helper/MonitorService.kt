package com.flyfish233.spo2helper


import android.app.*
import android.content.Context
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.chenhe.lib.wearmsger.MessageHub
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class MonitorService : Service() {
    private lateinit var scheduledExecutor: ScheduledExecutorService

    override fun onCreate() {
        super.onCreate()
        // Init scheduled executor
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
    }

    @OptIn(DelicateCoroutinesApi::class)
    // Start the service in the foreground
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val notification = Notification.Builder(this, "Monitor")
            .setContentTitle(getString(R.string.monitor_service_title))
            .setContentText(getString(R.string.monitor_service_text))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        startForeground(12, notification)

        // Get check per minutes from shared preferences
        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("checktime", "10")
        val checktime = text?.toLong() ?: 10
        //Toast.makeText(baseContext, checktime.toString(), Toast.LENGTH_SHORT).show()

        // Schedule a task to send message to watch
        scheduledExecutor.scheduleAtFixedRate({
            GlobalScope.launch {
                // Receive message from watch
                MessageHub.sendMessage(context = baseContext, "/msg/main", "start")
            }
        }, 0, checktime, TimeUnit.MINUTES)
        return START_STICKY
    }


    // CreateNotificationChannel
    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            "Monitor",
            getString(R.string.monitor_service_info),
            //Minimum level for notifications to be shown
            NotificationManager.IMPORTANCE_NONE
        )
        val manager = getSystemService(
            NotificationManager::class.java
        )
        manager.createNotificationChannel(serviceChannel)
    }


    override fun onDestroy() {
        scheduledExecutor.shutdown()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
