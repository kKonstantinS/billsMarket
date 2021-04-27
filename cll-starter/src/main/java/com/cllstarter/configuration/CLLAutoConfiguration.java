package com.cllstarter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties(CLLConfigurationProperties.class)
@ConditionalOnBean(CustomLoginLibrary.class)
public class CLLAutoConfiguration {

    @Autowired
    private CLLConfigurationProperties cllConfigurationProperties;

    @PostConstruct
    public void AfterInit() {
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(cllConfigurationProperties.getDatabaseDriver().getDriver());
        dataSource.setUsername(cllConfigurationProperties.getDatabaseUsername());
        dataSource.setPassword(cllConfigurationProperties.getDatabaseUserPassword());
        dataSource.setUrl(cllConfigurationProperties.getDatasourceUrl());

        return dataSource;
    }
}
