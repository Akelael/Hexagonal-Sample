package com.redbooth.hexagonalsample;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainFragment extends Fragment implements MainView {
    private ListView listView;
    private CursorAdapter listAdapter;
    private MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = PresenterFactory.getMainPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureList();
        presenter.notifyOnCreate(getActivity());
    }

    private void configureList() {
        listAdapter =
                new SimpleCursorAdapter(getActivity(),
                                        android.R.layout.simple_list_item_1,
                                        null,
                                        new String[]{FakeDatabase.COLUMN_NAME},
                                        new int[]{android.R.id.text1},
                                        0);
        listView.setAdapter(listAdapter);
    }

    @Override
    public void swaplListData(Cursor cursor) {
        listAdapter.swapCursor(cursor);
    }
}
