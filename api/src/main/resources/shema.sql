CREATE SEQUENCE users_id_seq START 1;

CREATE TABLE public.users
(
    id int DEFAULT NEXTVAL('users_id_seq')PRIMARY KEY NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    data json,
    created_at timestamp(0) without time zone DEFAULT (now())::timestamp(0) without time zone
);

CREATE UNIQUE INDEX users_id_uindex ON public.users (id);
