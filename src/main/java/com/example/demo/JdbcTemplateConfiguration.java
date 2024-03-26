package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//JdbcTemplate DataSource Configuration
@Configuration
public class JdbcTemplateConfiguration {

    //建立DataSource
    @Bean("myjdbcDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.myjdbc")
    public DataSource myjdbcDataSource() {
        DataSource ds = DataSourceBuilder.create().build();
git        return ds;

    }
    //建立JdbcTemplate
    @Bean
    public NamedParameterJdbcTemplate myjdbcJdbcTemplate(
            @Qualifier("myjdbcDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }





}
