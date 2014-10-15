package com.redbooth.hexagonalsample;

import java.util.List;

public class MainFragmentBoundary implements MainViewPort {
    private MainFragment mainFragment;
    private MainLogic logic;

    public static MainFragmentBoundary newInstance(MainFragment mainFragment) {
        MainFragmentBoundary viewBoundary = new MainFragmentBoundary(mainFragment);
        MainLogic logic = LogicFactory.getMainPresenter(viewBoundary);
        viewBoundary.setLogic(logic);
        return viewBoundary;
    }

    private MainFragmentBoundary(MainFragment mainFragment) {
        this.mainFragment = mainFragment;
    }

    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    @Override
    public void swaplListData(List<String> names) {
        mainFragment.setListAdapter(names);
    }

    public void notifyOnCreate() {
        logic.notifyOnCreate();
    }
}
