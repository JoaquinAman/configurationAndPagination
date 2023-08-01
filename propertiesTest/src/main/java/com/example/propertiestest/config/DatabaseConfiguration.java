//package com.example.propertiestest.config;
//
//import jdk.jfr.Name;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import javax.sql.DataSource;
//
//@Configuration
//public class DatabaseConfiguration {
//    @Bean(name="datasource")
////    @Qualifier("datasource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="datasource2")
////    @Qualifier("datasource2")
//    @ConfigurationProperties(prefix="spring.datasource2")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
