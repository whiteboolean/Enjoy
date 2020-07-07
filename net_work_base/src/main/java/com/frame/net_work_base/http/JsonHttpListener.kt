package com.frame.net_work_base.http

import android.os.Handler
import android.os.Looper
import com.alibaba.fastjson.JSON
import java.io.IOException
import java.io.InputStream
import java.lang.Exception

class JsonHttpListener<T>  : IHttpListener {



    lateinit var response:Class<T>
    lateinit var iDataListener: IDataListener<T>

    constructor(response:Class<T>,iDataListener: IDataListener<T>){
        this.response = response
        this.iDataListener = iDataListener
    }


    private  var handler: Handler = Handler(Looper.getMainLooper())


    override fun onSuccess(inputStream: InputStream) {
        //数据已经进来了

        //1.先把inputStream变成字符串
        val content = inputStream2String(inputStream)
        //2.按用户的要求转化成对应的javaBean
        val responseObject: T = JSON.parseObject(content, response)
        //3.把结果交给用户
        handler.post {
            this.iDataListener.onSuccess(responseObject)
        }

    }

    override fun onFailure() {
    }



    @Throws(IOException::class)
    fun inputStream2String(`in`: InputStream): String? {
        val out = StringBuffer()
        try {
            val b = ByteArray(4096)
            var n: Int
            while (`in`.read(b).also { n = it } != -1) {
                out.append(String(b, 0, n))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return out.toString()
        }
    }

}