package com.cllstarter.enums;



public enum DatabaseDrivers {
    Oracle("oracle.jdbc.driver.OracleDriver"),
    MySQL("com.mysql.jdbc.Driver"),
    PostgreSQL("org.postgresql.Driver");

    private String driver;

    DatabaseDrivers(String driver) {
        this.driver=driver;
    }

    public String getDriver() {
        return driver;
    }
}
