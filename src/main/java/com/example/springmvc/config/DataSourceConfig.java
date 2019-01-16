package com.example.springmvc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    public DataSourceConfig() {
    }

    @Value("classpath:schema-h2.sql")
    private Resource h2SchemaScript;

    @Bean
    public DataSourceInitializer h2DataSourceInitializer() {
        return create(h2SchemaScript);
    }

    private DataSourceInitializer create(Resource resource) {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(resource);

        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
