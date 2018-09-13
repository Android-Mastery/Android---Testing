/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.architecturecomponent

import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
class MenuViewModelTest : Spek({

    beforeEachTest {
        InstantTaskExecutorRule.start()
    }

    afterEachTest {
        InstantTaskExecutorRule.tearDown()
    }

    given("Test untuk MenuViewModel") {
        val viewModel = MenuViewModel()
        val input = "3"
        val kosong = ""
        val sisi = input.toDouble()
        val inputSukses = MenuState.inputSukses(sisi)
        val inputKosong = MenuState.inputKosong
        val hitungSukses = MenuState.hitungSukses(sisi * sisi)

        val observer = mock<Observer<MenuState>>()

        on("Input value kosong"){
            viewModel.getState().observeForever(observer)
            viewModel.inputPersegi(kosong)

            it("Input Gagal"){
                Mockito.verify(observer).onChanged(inputKosong)
            }
        }

        on("Input value"){
            viewModel.getState().observeForever(observer)
            viewModel.inputPersegi(input)

            it("Input Sukses"){
                Mockito.verify(observer).onChanged(inputSukses)
            }
        }

        on("Hitung sisi"){
            viewModel.getState().observeForever(observer)
            viewModel.hitungPersegi(sisi)

            it("Hitung Sukses"){
                Mockito.verify(observer).onChanged(hitungSukses)
            }
        }
    }
})