package com.redbooth.hexagonalsample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;

public class MainRepository {
    public interface OnDataLoadedListener {
        public void onDataLodaded(Cursor cursor);
    }

    public MainRepository() {}

    public void startLoadingData(OnDataLoadedListener listener) {
        new LoadDataAsyncTask(listener).execute();
    }

    private class LoadDataAsyncTask extends AsyncTask<Void, Void, Cursor > {
        private final OnDataLoadedListener listener;

        LoadDataAsyncTask(OnDataLoadedListener listener) {
            this.listener = listener;
        }

        @Override
        protected Cursor doInBackground(Void... params) {
            ContentResolver resolver = MyApplication.getContext().getContentResolver();
            return resolver.query(MainContentProvider.URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor result) {
            super.onPostExecute(result);
            listener.onDataLodaded(result);
        }
    }
}
