package com.frame.july_myview.what_is_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.frame.july_myview.R

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//        Log.d(TAG, "dispatchTouchEvent: ")
//        Log.d(TAG,"event.x:${event.x}")
//        Log.d(TAG,"event.y:${event.y}")
//
//        Log.d(TAG,"event:RawX:${event.rawX}")
//        Log.d(TAG,"event:RawY:${event.rawY}")
        return super.dispatchTouchEvent(event)
    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{

                Log.d(TAG,"event.x:${event.x}")
                Log.d(TAG,"event.y:${event.y}")
                Log.d(TAG,"event:RawX:${event.rawX}")
                Log.d(TAG,"event:RawY:${event.rawY}")
            }

            MotionEvent.ACTION_UP->{
                val intent = Intent()
//                intent.addFlags()

            }

            MotionEvent.ACTION_MOVE ->{

//
                Log.d(TAG,"event.x:${event.x}")
                Log.d(TAG,"event.y:${event.y}")

                Log.d(TAG,"event:RawX:${event.rawX}")
                Log.d(TAG,"event:RawY:${event.rawY}")
            }


        }

        return super.onTouchEvent(event)
    }
}