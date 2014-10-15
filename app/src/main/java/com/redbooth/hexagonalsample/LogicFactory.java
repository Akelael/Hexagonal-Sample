package com.redbooth.hexagonalsample;

public class LogicFactory {
    public static MainLogic getMainPresenter(MainViewPort view) {
        MainModelPort model = MainModelBoundary.newInstance();
        return MainLogic.newInstance(view, model);
    }
}
