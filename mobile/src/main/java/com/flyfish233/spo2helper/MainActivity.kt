package com.flyfish233.spo2helper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.chenhe.lib.wearmsger.MessageHub

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button3 = findViewById<Button>(R.id.button3)
        button3.isEnabled = false
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun onSendButtonClick(view: View) {
        // Send message to watch
        GlobalScope.launch {
            MessageHub.sendMessage(context = baseContext, "/msg/main", "start")
            //val result = MessageHub.sendMessage(context = baseContext, "/msg/main", "start")
            //Log.i("SendMsg", result.toString())
        }
    }


    fun onServiceButtonClick(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val text = editText.text.toString()
        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("checktime", text)
        editor.apply()


        val button2 = findViewById<Button>(R.id.button2)
        button2.isEnabled = false
        val button3 = findViewById<Button>(R.id.button3)
        button3.isEnabled = true
        val intent = Intent(this, MonitorService::class.java)
        startService(intent)
    }

    fun onDisableButtonClick(view: View) {
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        button3.isEnabled = false
        button2.isEnabled = true
        val intent = Intent(this, MonitorService::class.java)
        stopService(intent)
    }

}