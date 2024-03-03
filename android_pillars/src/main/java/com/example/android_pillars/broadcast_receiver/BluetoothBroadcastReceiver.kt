package com.example.android_pillars.broadcast_receiver

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.android_pillars.utils.debugLog

class BluetoothBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action: String? = intent?.action

        if (action != null) {
            when (action) {
                BluetoothAdapter.ACTION_STATE_CHANGED -> {
                    val state: Int = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                    handleBluetoothStateChanged(context, state)
                }
            }
        }
    }

    private fun handleBluetoothStateChanged(context: Context?, state: Int) {
        when (state) {
            BluetoothAdapter.STATE_OFF -> {
                debugLog("Bluetooth turned off")
            }

            BluetoothAdapter.STATE_ON -> {
                debugLog("Bluetooth turned on")
            }

            // You can handle other states as needed

            else -> {
                // Handle other states
            }
        }
    }

}