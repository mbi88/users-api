package com.mbi.api.controllers;

import com.mbi.api.dtos.users.UsersDto;
import com.mbi.api.entities.users.UsersEntity;
import com.mbi.api.exceptions.NotFoundException;
import com.mbi.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UsersController {

    @Autowired
    private UsersService service;

    @RequestMapping(method = POST, path = "/users", produces = "application/json")
    public ResponseEntity<UsersEntity> create(@Valid @RequestBody UsersDto usersDto) {
        return service.createUser(usersDto);
    }

    @RequestMapping(method = GET, path = "/users/{id}", produces = "application/json")
    public ResponseEntity<UsersEntity> getById(@PathVariable(value = "id") long id) throws NotFoundException {
        return service.getById(id);
    }

    @RequestMapping(method = GET, path = "/users", produces = "application/json")
    public ResponseEntity<List<UsersEntity>> getList(@RequestParam(value = "name", required = false) String name) {
        return service.getList(name);
    }

    @RequestMapping(method = DELETE, path = "/users/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable(value = "id") long id) throws NotFoundException {
        return service.delete(id);
    }

    @RequestMapping(method = PATCH, path = "/users/{id}", produces = "application/json")
    public ResponseEntity update(
            @PathVariable(value = "id") long id,
            @Valid @RequestBody UsersDto usersDto) throws NotFoundException {
        return service.updateUser(id, usersDto);
    }
}
