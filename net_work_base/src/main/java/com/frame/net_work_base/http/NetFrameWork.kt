package com.frame.net_work_base.http

class NetFrameWork {

    companion object {


        /**
         * T:请求参数的类型
         * M：接收数据的javaBean的类型
         */
        fun <T, M> rendJsonRequest(url: String, requestParam: T, response: Class<M>, iDataListener: IDataListener<M>) {

            val iHttpRequest = JsonHttpRequest()
            val iHttpListener = JsonHttpListener(response, iDataListener)

            val httpTask = HttpTask(url, requestParam, iHttpListener, iHttpRequest)
            ThreadManager.getInstance().addTask(httpTask)

        }

    }
}