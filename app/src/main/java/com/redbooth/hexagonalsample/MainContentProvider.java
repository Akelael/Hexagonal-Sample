package com.redbooth.hexagonalsample;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MainContentProvider extends ContentProvider {
    private final static String AUTHORITY = "com.redbooth.hexagonalsample";
    private final static String PATH = "names";
    private final static String URI_STRING = "content://" + AUTHORITY + "/" + PATH;
    private final static int NAMES = 0;

    public final static Uri URI = Uri.parse(URI_STRING);

    private static UriMatcher matcher;
    {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, PATH, NAMES);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        Cursor result = null;
        switch (matcher.match(uri)) {
            case NAMES:
                result = FakeDatabase.getNames();
                break;
        }
        return result;
    }

    @Override
    public String getType(Uri uri) {
        String type;
        switch (matcher.match(uri)) {
            case NAMES:
                type = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.redbooth.names";
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        return type;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
