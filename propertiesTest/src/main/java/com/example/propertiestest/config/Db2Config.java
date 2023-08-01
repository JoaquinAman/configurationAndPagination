package com.example.propertiestest.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.SecondaryTable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.propertiestest.repository2"},
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager"
)
public class Db2Config {
    @Bean(name="datasource2")
    @ConfigurationProperties(prefix="spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder builder,
        @Qualifier("datasource2") DataSource dataSource2) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder
                .dataSource(dataSource2)
                .properties(properties)
                .packages("com.example.propertiestest.model2")
                .persistenceUnit("datasource2")
                .build();
    }

    @Bean(name="transactionManager2")
    public PlatformTransactionManager transactionManager2(@Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory2) {
        return new JpaTransactionManager(entityManagerFactory2);
    }
}
