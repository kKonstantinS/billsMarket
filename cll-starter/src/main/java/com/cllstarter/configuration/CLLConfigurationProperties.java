package com.cllstarter.configuration;

import com.cllstarter.enums.DatabaseDrivers;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties("cll.settings")
public class CLLConfigurationProperties {

    private String logLevel;
    private String pattern;
    private String databaseUsername;
    private String databaseUserPassword;
    private String datasourceUrl;
    private DatabaseDrivers databaseDriver;

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabaseUserPassword() {
        return databaseUserPassword;
    }

    public void setDatabaseUserPassword(String databaseUserPassword) {
        this.databaseUserPassword = databaseUserPassword;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public DatabaseDrivers getDatabaseDriver() {
        return databaseDriver;
    }

    public void setDatabaseDriver(DatabaseDrivers databaseDriver) {
        this.databaseDriver = databaseDriver;
    }
}
