package com.redbooth.hexagonalsample;

import android.content.Context;
import android.database.Cursor;

public class MainPresenter {
    private MainView mainView;
    private MainModel mainModel;

    public static MainPresenter newInstance(MainView mainView, MainModel mainModel) {
        MainPresenter presenter = new MainPresenter(mainView, mainModel);
        presenter.initialize();
        return presenter;
    }

    private MainPresenter(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    private void initialize() {
        mainModel.setPresenter(this);
    }

    public void notifyOnCreate(Context context) {
        mainModel.startLoadingData(context);
    }

    public void notifiyLoadedDataAvailable(Cursor cursor) {
        mainView.swaplListData(cursor);
    }
}
