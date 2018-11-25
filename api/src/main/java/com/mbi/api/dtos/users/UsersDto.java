package com.mbi.api.dtos.users;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UsersDto {

    @NotNull
    @Length(min = 2, max = 30)
    private String name;
    @NotNull
    @Length(min = 2, max = 30)
    private String email;
    private Object data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
