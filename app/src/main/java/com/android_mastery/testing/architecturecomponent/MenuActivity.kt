/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.architecturecomponent

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import com.android_mastery.testing.R
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {

     lateinit var menuViewModel: MenuViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)

        btnSubmit.setOnClickListener {
            menuViewModel.inputPersegi(edtInput.text.toString())
        }

        menuViewModel.getState().observe(this, Observer { state->
            when(state){
                is MenuState.inputKosong -> edtInput.error = "Masih Kosong"
                is MenuState.inputSukses -> menuViewModel.hitungPersegi(state.value)
                is MenuState.hitungSukses -> result.text = state.result.toString()
            }
        })
    }
}
