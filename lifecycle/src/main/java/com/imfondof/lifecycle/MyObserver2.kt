package com.imfondof.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver2(private val lifecycle: Lifecycle) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.d("shuoshuo", "create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.d("shuoshuo", "start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.d("shuoshuo", "resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.d("shuoshuo", "destroy")
    }

    fun method() {
        Log.d("shuoshuo", "current is ${lifecycle.currentState }")
        if (lifecycle.currentState == Lifecycle.State.RESUMED) {
            Log.d("shuoshuo", "current is RESUMED")
        }
    }
}