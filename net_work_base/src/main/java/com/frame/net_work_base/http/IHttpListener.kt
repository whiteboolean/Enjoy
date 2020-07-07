package com.frame.net_work_base.http

import java.io.InputStream

interface IHttpListener{

    fun onSuccess(inputStream:InputStream)

    fun onFailure()

}