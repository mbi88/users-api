package com.mbi;

import java.util.Properties;

class AppConfig {

    private String url = String.format("jdbc:postgresql://%s:5432/%s",
            "db",
            "mbi");
    private String user = "mbi";
    private String pass = "password";

    Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.datasource.url", url);
        props.put("spring.datasource.username", user);
        props.put("spring.datasource.password", pass);

        return props;
    }
}
