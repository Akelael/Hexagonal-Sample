package com.redbooth.hexagonalsample;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class MainModelBoundary implements MainModelPort {
    private MainLogic logic;
    private MainRepository repository;

    public static MainModelBoundary newInstance() {
        MainModelBoundary modelBoundary = new MainModelBoundary();
        modelBoundary.initialize();
        return modelBoundary;
    }

    private void initialize() {
        this.repository = new MainRepository();
    }

    private MainModelBoundary() {}

    @Override
    public void setLogic(MainLogic logic) {
        this.logic = logic;
    }

    @Override
    public void startLoadingData() {
        repository.startLoadingData(new MainRepository.OnDataLoadedListener() {
            @Override
            public void onDataLodaded(Cursor cursor) {
                notifyDataLoaded(cursor);
            }
        });
    }

    private void notifyDataLoaded(Cursor cursor) {
        List<String> names = mapCursorToList(cursor);
        logic.notifiyLoadedDataAvailable(names);
    }

    private List<String> mapCursorToList(Cursor cursor) {
        List<String> names = new ArrayList<String>();
        while (cursor.moveToNext()) {
            int nameColumnIndex = cursor.getColumnIndex(FakeDatabase.COLUMN_NAME);
            String name = cursor.getString(nameColumnIndex);
            names.add(name);
        }
        return names;
    }
}
