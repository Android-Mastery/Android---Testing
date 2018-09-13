/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.testing.mvp;

public class MainPresenter implements MainPreseneterImpl{

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void inputPersegi(String sisi) {
        if (sisi.isEmpty()){
            mainView.inputKosong("Masih Kosong");
        }else{
            mainView.inputSukses(Double.parseDouble(sisi));
        }
    }

    @Override
    public void hitungPersegi(Double sisi) {
        Double result = sisi * sisi;
        mainView.hitungSukses(result);

    }
}
