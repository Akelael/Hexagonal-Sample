package com.redbooth.hexagonalsample;

public class PresenterFactory {
    public static MainPresenter getMainPresenter(MainView view) {
        MainModel model = new MainCursorModel();
        return MainPresenter.newInstance(view, model);
    }
}
