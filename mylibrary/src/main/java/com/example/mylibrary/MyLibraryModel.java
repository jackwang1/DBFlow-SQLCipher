package com.example.mylibrary;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyLibraryDatabase.class)
public class MyLibraryModel extends BaseModel {
    @PrimaryKey
    long id;
}
