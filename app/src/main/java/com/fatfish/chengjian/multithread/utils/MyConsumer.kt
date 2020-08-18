package com.fatfish.chengjian.multithread.utils

import android.util.Log
import java.util.concurrent.BlockingDeque
import java.util.concurrent.TimeUnit

class MyConsumer(var name: String, var blockingDeque: BlockingDeque<String>) : Runnable {
    var flag: Boolean = true
    override fun run() {
        while (flag) {
            // it will keep polling tasks, if it cannot get valid task within 3s, it will break
            var task = blockingDeque.poll(3000, TimeUnit.MILLISECONDS)
            Log.d("MyConsumer", "$name is processing $task");
            Thread.sleep(300)
            if (task == null)
                flag = false
        }
    }
}