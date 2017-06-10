package com.example.mylibrary;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = MyLibraryDatabase.NAME, version = MyLibraryDatabase.VERSION)
public class MyLibraryDatabase {

    public static final String NAME = "MyLibraryDatabase";

    public static final int VERSION = 1;
}
