package com.redbooth.hexagonalsample;

import java.util.List;

public class MainLogic {
    private MainViewPort viewBoundary;
    private MainModelPort modelBoundary;

    public static MainLogic newInstance(MainViewPort viewBoundary,
                                        MainModelPort modelBoundary) {
        MainLogic presenter = new MainLogic(viewBoundary, modelBoundary);
        presenter.initialize();
        return presenter;
    }

    private MainLogic(MainViewPort viewBoundary, MainModelPort mainModelBoundary) {
        this.viewBoundary = viewBoundary;
        this.modelBoundary = mainModelBoundary;
    }

    private void initialize() {
        modelBoundary.setLogic(this);
    }

    public void notifyOnCreate() {
        modelBoundary.startLoadingData();
    }

    public void notifiyLoadedDataAvailable(List<String> names) {
        viewBoundary.swaplListData(names);
    }
}
