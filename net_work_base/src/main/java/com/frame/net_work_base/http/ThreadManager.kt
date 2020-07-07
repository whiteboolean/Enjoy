package com.frame.net_work_base.http

import android.util.LruCache
import java.lang.Exception
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * 整体的运作机制
 */
class ThreadManager//参数：
//1.核心线程池
//2.最大线程池
//3.存活时间
//4.单位
//5.阻塞队列
//6.拒绝策略，失败的消息返回
 {

    companion object {
        private val threadManager = ThreadManager()

        public fun getInstance(): ThreadManager {
            return threadManager
        }
    }

    //队列要有阻塞功能
    //定义一个阻塞队列

    private val mQueue: LinkedBlockingDeque<Runnable> = LinkedBlockingDeque()
    private lateinit var threadPoolExecutor: ThreadPoolExecutor

    public fun addTask(runnable: Runnable) {
        mQueue.add(runnable)
    }


    /**
     * 核心线程
     */

    private val runnable: Runnable = Runnable {
        while (true) {

            try {
                val runnable = mQueue.take()//如果取不到就停在这里
                threadPoolExecutor.execute(runnable)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    init {
        threadPoolExecutor = ThreadPoolExecutor(3,
                10,
                10, TimeUnit.SECONDS,
                ArrayBlockingQueue<Runnable>(4),
                RejectedExecutionHandler { r, executor ->
                    addTask(r)
                }
        )
        threadPoolExecutor.execute(runnable)
    }


}