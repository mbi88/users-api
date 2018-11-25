package com.mbi.api.services;

import com.mbi.api.dtos.users.UsersDto;
import com.mbi.api.entities.users.UsersEntity;
import com.mbi.api.exceptions.NotFoundException;
import com.mbi.api.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<UsersEntity> createUser(UsersDto usersDto) {
        UsersEntity usersEntity = new ModelMapper().map(usersDto, UsersEntity.class);

        return new ResponseEntity<>(usersRepository.save(usersEntity), HttpStatus.CREATED);
    }

    public ResponseEntity<UsersEntity> getById(Long id) throws NotFoundException {
        if (!usersRepository.findById(id).isPresent()) {
            throw new NotFoundException(UsersEntity.class);
        }

        return new ResponseEntity<>(usersRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<List<UsersEntity>> getList(String name) {
        List<UsersEntity> users = (name == null || name.isEmpty())
                ? (List<UsersEntity>) usersRepository.findAll()
                : usersRepository.findByName(name);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity delete(long id) throws NotFoundException {
        if (!usersRepository.findById(id).isPresent()) {
            throw new NotFoundException(UsersEntity.class);
        }
        usersRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity updateUser(long id, UsersDto usersDto) throws NotFoundException {
        if (!usersRepository.findById(id).isPresent()) {
            throw new NotFoundException(UsersEntity.class);
        }
        UsersEntity usersEntity = new ModelMapper().map(usersDto, UsersEntity.class);
        usersEntity.setId(id);
        usersRepository.save(usersEntity);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
