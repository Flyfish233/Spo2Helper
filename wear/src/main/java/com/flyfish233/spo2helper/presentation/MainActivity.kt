package com.flyfish233.spo2helper.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main(context = this)
        }
    }
}


@Composable
fun Main(context: Context) {
    // Start the activity and gone
    val packageName = "com.samsung.android.wear.shealth"
    val activityName =
        "com.samsung.android.wear.shealth.app.spo2.view.measure.Spo2MeasuringActivity"
    val intent = Intent().apply {
        setClassName(packageName, activityName)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(context, intent, null)

    // Finish the activity and remove it from the task
    (context as Activity).finishAndRemoveTask()

}