package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//jpa DataSource Configuration

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo",
//        basePackageClasses = Teacher.class,
//        repositoryBaseClass = TeacherRepostory.class,
        //指定實體管理工廠的名稱為entityManagerFactory
        entityManagerFactoryRef = "entityManagerFactory",
        //指定事務管理器的名稱為transactionManager
        transactionManagerRef = "transactionManager"
)
@EnableTransactionManagement
@EntityScan("com.example.demo")
public class JpaConfiguration {
    @Bean("myjpa")
    @Primary//表示這是主要的資料源，當有多個資料源時，它將被優先選擇
    @ConfigurationProperties("spring.datasource.myjpa")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("myjpa") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder //
                .dataSource(dataSource) //
                .packages("com.example.demo") //
                .persistenceUnit("myjpa_pU") //
                .build();
    }

    @Bean("transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
