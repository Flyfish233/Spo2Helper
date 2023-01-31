package com.flyfish233.spo2helper.presentation

import android.content.Intent
import androidx.core.content.ContextCompat
import com.google.android.gms.wearable.MessageEvent
import me.chenhe.lib.wearmsger.service.WMListenerService

class ListenerService : WMListenerService() {

    override fun onMessageReceived(messageEvent: MessageEvent) {
        super.onMessageReceived(messageEvent)
        val packageName = "com.samsung.android.wear.shealth"
        val activityName =
            "com.samsung.android.wear.shealth.app.spo2.view.measure.Spo2MeasuringActivity"
        val intent = Intent().apply {
            setClassName(packageName, activityName)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        ContextCompat.startActivity(baseContext, intent, null)
    }
}