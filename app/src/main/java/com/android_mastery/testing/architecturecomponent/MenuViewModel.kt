/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.architecturecomponent

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


interface MenuPresenter {
    fun getState(): LiveData<MenuState>;
    fun inputPersegi(sisi: String)
    fun hitungPersegi(sisi: Double)
}

class MenuViewModel : ViewModel(), MenuPresenter {
    val state: MutableLiveData<MenuState> = MutableLiveData();

    override fun getState(): LiveData<MenuState> {
        return state
    }

    override fun inputPersegi(sisi: String) {
        when {
            sisi.isEmpty() -> state.value = MenuState.inputKosong
            else -> state.value = MenuState.inputSukses(sisi.toDouble())
        }
    }

    override fun hitungPersegi(sisi: Double) {
        state.value = MenuState.hitungSukses(sisi * sisi)
    }
}

sealed class MenuState {
    object inputKosong : MenuState()
    data class inputSukses(val value: Double) : MenuState()
    data class hitungSukses(val result: Double) : MenuState()
}