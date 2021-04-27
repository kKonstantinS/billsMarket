package com.cllstarter.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class CustomLoginLibrary {

    private static final Logger logger = LoggerFactory.getLogger(CustomLoginLibrary.class);

    @Autowired
    private CLLConfigurationProperties configurationProperties;

    @PostConstruct
    public void postInit() {
        logger.debug("Starter launched with following settings:");
        logger.debug("Database connection url:" + configurationProperties.getDatasourceUrl());
        logger.debug("Database username:" + configurationProperties.getDatabaseUsername());
        logger.debug("Database user password:" + configurationProperties.getDatabaseUserPassword());
        logger.debug("Database driver:" + configurationProperties.getDatabaseDriver());
        logger.debug("Logging level:" + configurationProperties.getLogLevel());
    }
}
