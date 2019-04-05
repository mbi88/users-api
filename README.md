# Spring learning 

### Preconditions

Install [docker](https://docs.docker.com/install/)

### Run

```sh
$ touch .env
$ echo POSTGRES_DB=postgres >> .env
$ echo POSTGRES_USER=postgres >> .env
$ echo POSTGRES_PASSWORD=password >> .env
$ echo POSTGRES_HOST=db >> .env
$ docker-compose up --build
```

### API docs

[http://127.0.0.1:8080/api/swagger](http://127.0.0.1:8080/api/swagger)
