package com.example.android_pillars

import android.bluetooth.BluetoothAdapter
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.android_pillars.broadcast_receiver.BluetoothBroadcastReceiver
import com.example.android_pillars.broadcast_receiver.BroadcastReceiverHomeScreen
import com.example.android_pillars.broadcast_receiver.WifiBroadcastReceiver
import com.example.android_pillars.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    private lateinit var bluetoothReceiver: BluetoothBroadcastReceiver
    private lateinit var wifiReceiver: WifiBroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                BroadcastReceiverHomeScreen()
            }
        }

        // Initialize and register the Bluetooth BroadcastReceiver
        bluetoothReceiver = BluetoothBroadcastReceiver()
        val bluetoothFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(bluetoothReceiver, bluetoothFilter)


        wifiReceiver = WifiBroadcastReceiver()
        val wifiFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(wifiReceiver, wifiFilter)
    }
    override fun onDestroy() {
        super.onDestroy()

        // Unregister the Bluetooth BroadcastReceiver to avoid memory leaks
        unregisterReceiver(bluetoothReceiver)
        unregisterReceiver(wifiReceiver)
    }
}
