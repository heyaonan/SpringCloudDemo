package com.nice.config.datasource;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicSwitch extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
