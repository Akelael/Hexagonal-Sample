package com.redbooth.hexagonalsample;

import android.content.Context;

public interface MainModel {
    public void setPresenter(MainPresenter presenter);
    public void startLoadingData(Context context);
}
