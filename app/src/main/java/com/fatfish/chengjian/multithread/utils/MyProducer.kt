package com.fatfish.chengjian.multithread.utils

import java.util.concurrent.BlockingDeque

//it will publish task to the queue
class MyProducer(var name: String, var blockingDeque: BlockingDeque<String>) : Runnable {
    var flag: Boolean = true
    override fun run() {
        while (flag) {
            for (index in 1..10) {
                blockingDeque.offer("$name is adding $index task...")
                //wait for a while
                Thread.sleep(100)
            }
            //stop adding new tasks
            flag = false
        }
    }
}