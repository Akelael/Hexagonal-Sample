package com.redbooth.hexagonalsample;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

public class MainCursorModel implements MainModel {
    private MainPresenter presenter;


    @Override
    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void startLoadingData(Context context) {
        new LoadDataAsyncTask().execute(context);
    }

    private class LoadDataAsyncTask extends AsyncTask<Context, Void, Cursor > {
        @Override
        protected Cursor doInBackground(Context... params) {
            ContentResolver resolver = params[0].getContentResolver();
            return resolver.query(MainContentProvider.URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor result) {
            super.onPostExecute(result);
            presenter.notifiyLoadedDataAvailable(result);
        }
    }
}
