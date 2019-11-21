package com.nice.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfiguration  {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource dataSourceMaster(){
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave1")
    public DataSource dataSourceSlave1(){
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSource routingDatasource(@Qualifier("dataSourceMaster") DataSource dataSourceMaster,
                                        @Qualifier("dataSourceSlave1") DataSource dataSourceSlave1){
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceEnum.MASTER, dataSourceMaster);
        map.put(DataSourceEnum.SLAVE1,dataSourceSlave1);
        DynamicSwitch dynamicSwitch = new DynamicSwitch();
        dynamicSwitch.setDefaultTargetDataSource(dataSourceMaster);
        dynamicSwitch.setTargetDataSources(map);
        return  dynamicSwitch;
    }




}
