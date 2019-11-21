package com.nice.config.datasource;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<DataSourceEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DataSourceEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DataSourceEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DataSourceEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
    set(DataSourceEnum.SLAVE1);

    }

}
