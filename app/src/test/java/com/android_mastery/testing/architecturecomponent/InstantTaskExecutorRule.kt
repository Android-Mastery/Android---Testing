/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.architecturecomponent

import android.arch.core.executor.ArchTaskExecutor
import android.arch.core.executor.TaskExecutor

object InstantTaskExecutorRule{
    fun  start(){
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor(){
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean = true

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }
        })
    }

    fun tearDown(){
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}