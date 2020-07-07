package com.frame.net_work_base.http

/**
 * 请求的顶层接口
 */
interface IHttpRequest{

    fun setUrl(url:String)

    fun setParams(params:ByteArray)

    fun execute()

    //两个接口拼接在一起
    fun setListener(iHttpListener: IHttpListener)
}