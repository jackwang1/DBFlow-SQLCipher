package com.example.jack.myapplication;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class MyModel extends BaseModel {
    @PrimaryKey
    String id;
}
