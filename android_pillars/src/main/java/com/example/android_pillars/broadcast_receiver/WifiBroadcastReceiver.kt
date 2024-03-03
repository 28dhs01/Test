package com.example.android_pillars.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.android_pillars.utils.debugLog

class WifiBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val connectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

            if (networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                if (networkInfo.isConnected) {
                    handleWifiConnected(context)
                } else {
                    handleWifiDisconnected(context)
                }
            }
        }
    }
    private fun handleWifiConnected(context: Context?) {
        debugLog("wifi connected")
    }

    private fun handleWifiDisconnected(context: Context?) {
        debugLog("wifi disconnected")
    }
}