package com.example.jack.myapplication;

import android.app.Application;

import com.example.mylibrary.MyLibraryDatabase;
import com.raizlabs.android.dbflow.config.AppGeneratedDatabaseHolder;
import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.MyLibraryGeneratedDatabaseHolder;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this)
                .addDatabaseHolder(AppGeneratedDatabaseHolder.class)
                .addDatabaseHolder(MyLibraryGeneratedDatabaseHolder.class)
                .addDatabaseConfig(getConfig(MyDatabase.class))
                .addDatabaseConfig(getConfig(MyLibraryDatabase.class))
                .openDatabasesOnInit(true)
                .build());
    }

    private <T> DatabaseConfig getConfig(Class<T> databaseClazz) {
        return new DatabaseConfig.Builder(databaseClazz)
                .openHelper(new DatabaseConfig.OpenHelperCreator() {
                    @Override
                    public OpenHelper createHelper(DatabaseDefinition databaseDefinition, DatabaseHelperListener helperListener) {
                        return new SQLCipherHelperImpl(databaseDefinition, helperListener);
                    }
                }).build();
    }
}
