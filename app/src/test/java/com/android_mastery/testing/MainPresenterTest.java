/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing;

import com.android_mastery.testing.mvp.MainPresenter;
import com.android_mastery.testing.mvp.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MainPresenterTest {


    @Mock
    private MainPresenter mainPresenter;
    private MainView mainView;

    @Before
    public void setUp(){
        mainView = Mockito.mock(MainView.class);
        mainPresenter = new MainPresenter(mainView);
    }

    @Test
    public void inputPersegiFailed() {
        String sisi = "";
        mainPresenter.inputPersegi(sisi);
        String message = "Masih Kosong";
        Mockito.verify(mainView).inputKosong(message);
    }

    @Test
    public void inputPersegi() {
        String sisi = "3";
        mainPresenter.inputPersegi(sisi);
        Mockito.verify(mainView).inputSukses(Double.parseDouble(sisi));
    }

    @Test
    public void hitungPersegi() {
        Double sisi = 3.0;
        mainPresenter.hitungPersegi(sisi);
        Double result = sisi * sisi;
        Mockito.verify(mainView).hitungSukses(result);
    }
}