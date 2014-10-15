package com.redbooth.hexagonalsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private MainFragmentBoundary viewBoundary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBoundary = MainFragmentBoundary.newInstance(this);
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
        viewBoundary.notifyOnCreate();
    }

    public void setListAdapter(List<String> names) {
        listAdapter = new ArrayAdapter<String>(getActivity(),
                                               android.R.layout.simple_list_item_1,
                                               android.R.id.text1,
                                               names);
        listView.setAdapter(listAdapter);
    }
}
