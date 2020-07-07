package com.frame.net_work_base.http

import com.frame.net_work_base.http.IHttpListener
import com.frame.net_work_base.http.IHttpRequest
import java.io.BufferedOutputStream
import java.lang.Exception
import java.lang.RuntimeException
import java.net.HttpURLConnection
import java.net.URL

class JsonHttpRequest : IHttpRequest {

    lateinit var mUrl: String
    lateinit var mParams: ByteArray
    lateinit var mListener: IHttpListener
    lateinit var httpUrlConnection: HttpURLConnection

    override fun setUrl(url: String) {
        this.mUrl = url
    }

    override fun setParams(params: ByteArray) {
        this.mParams = params
    }


    override fun setListener(iHttpListener: IHttpListener) {
        this.mListener = iHttpListener
    }


    /**
     * 真实的网络操作
     *
     * HttpUrlConnection
     * socket
     * okhttp
     */
    override fun execute() {
        val url: URL
        try {
            url = URL(this.mUrl)
            httpUrlConnection = url.openConnection() as HttpURLConnection
            httpUrlConnection.connectTimeout = 6000
            httpUrlConnection.useCaches = false //不使用缓存
            httpUrlConnection.instanceFollowRedirects = true
            httpUrlConnection.readTimeout = 3000
            httpUrlConnection.doInput = true
            httpUrlConnection.doOutput = true
            httpUrlConnection.requestMethod = "POST"
            httpUrlConnection.setRequestProperty("Content_Type", "application/json;charset=utf-8")
            httpUrlConnection.connect()

            //使用字节流发送数据
            val out = httpUrlConnection.outputStream
            val bos = BufferedOutputStream(out)
            bos.write(mParams)
            bos.flush()
            bos.close()
            out.close()

            //判断响应码
            if (httpUrlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = httpUrlConnection.inputStream
                mListener.onSuccess(inputStream)
            }else{
                throw RuntimeException("请求失败")
            }
            httpUrlConnection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("请求失败")
        }


    }
}