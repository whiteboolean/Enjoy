package com.frame.net_work_base.http


/**
 * 给用户的接口
 */
interface IDataListener<T> {
    fun onSuccess(t:T)
    fun onFailure()
}