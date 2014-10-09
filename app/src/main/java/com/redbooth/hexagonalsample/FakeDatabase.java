package com.redbooth.hexagonalsample;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;

public class FakeDatabase {
    public static final String COLUMN_NAME = "name";

    public static Cursor getNames() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{BaseColumns._ID, COLUMN_NAME}, 10);
        matrixCursor.addRow(new String[] {"0", "Cupcake"});
        matrixCursor.addRow(new String[] {"1", "Donut"});
        matrixCursor.addRow(new String[] {"2", "Eclair"});
        matrixCursor.addRow(new String[] {"3", "Froyo"});
        matrixCursor.addRow(new String[] {"4", "Gingerbread"});
        matrixCursor.addRow(new String[] {"5", "HoneyComb"});
        matrixCursor.addRow(new String[] {"6", "Ice Cream Sandwich"});
        matrixCursor.addRow(new String[] {"7", "Jelly Bean"});
        matrixCursor.addRow(new String[] {"8", "KitKat"});
        matrixCursor.addRow(new String[] {"9", "Lollipop?"});
        return matrixCursor;
    }
}
