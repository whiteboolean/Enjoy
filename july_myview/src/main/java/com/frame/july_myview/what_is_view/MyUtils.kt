package com.frame.july_myview.what_is_view

import android.app.ActivityManager
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import java.io.Closeable
import java.io.IOException


object MyUtils {



        fun getProcessName(cxt: Context, pid: Int): String? {
            val am = cxt
                    .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val runningApps = am.runningAppProcesses ?: return null
            for (procInfo in runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName
                }
            }
            return null
        }

        fun close(closeable: Closeable?) {
            try {
                closeable?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        fun getScreenMetrics(context: Context): DisplayMetrics? {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm
        }

        fun executeInThread(runnable: Runnable?) {
            Thread(runnable).start()
        }

}
