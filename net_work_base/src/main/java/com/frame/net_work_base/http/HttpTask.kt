package com.frame.net_work_base.http

import com.alibaba.fastjson.JSON
import java.lang.Exception
//将请求对象转成对应格式的字符串//这里可以写一个模板方法给子类用
class HttpTask<T>(url: String,
                  requestData: T,
                  iHttpListener: IHttpListener,
                  var iHttpRequest: IHttpRequest) : Runnable {

    init {
        this.iHttpRequest.setUrl(url)
        this.iHttpRequest.setListener(iHttpListener)
        if (requestData != null) {
            //将请求对象转成对应格式的字符串
            val dataStr: String = JSON.toJSONString(requestData)
            try {
                this.iHttpRequest.setParams(dataStr.toByteArray())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun run() {
        iHttpRequest.execute()
    }
}