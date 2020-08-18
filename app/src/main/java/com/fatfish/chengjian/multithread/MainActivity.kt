package com.fatfish.chengjian.multithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fatfish.chengjian.multithread.utils.MyConsumer
import com.fatfish.chengjian.multithread.utils.MyProducer
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingDeque

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun testProducerConsumer() {
        val linkedBlockingDeque = LinkedBlockingDeque<String>()
        val producerAA = MyProducer("Producer_AA", linkedBlockingDeque)
        val producerBB = MyProducer("Producer_BB", linkedBlockingDeque)
        val producerCC = MyProducer("Producer_CC", linkedBlockingDeque)

        val consumer = MyConsumer("Consumer_X", linkedBlockingDeque)

        //create threadPool
        val threadPool = Executors.newFixedThreadPool(4)
        threadPool.execute(producerAA)
        threadPool.execute(producerBB)
        threadPool.execute(producerCC)
        threadPool.execute(consumer)
    }

    fun click(view: View) {
        var idx = view.id
        if (idx == R.id.btn_multiThread) {
            Toast.makeText(this, "testing...", Toast.LENGTH_LONG).show()
            testProducerConsumer()
        }
    }
}