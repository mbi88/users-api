package com.mbi;

import java.util.Properties;

class AppConfig {

    private final String url;
    private final String user;
    private final String password;
    private final String dbHost;
    private final String database;

    AppConfig() {
        this.user = "mbi";
        this.password = "password";
        this.dbHost = "db";
        this.database = "mbi";
        this.url = String.format("jdbc:postgresql://%s:5432/%s?createDatabaseIfNotExist=true", dbHost, database);
    }

    Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.datasource.url", url);
        props.put("spring.datasource.username", user);
        props.put("spring.datasource.password", password);

        return props;
    }
}
