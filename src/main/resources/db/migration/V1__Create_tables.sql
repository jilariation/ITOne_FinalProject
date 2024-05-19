create table if not exists desk (
                                    id uuid primary key,
                                    desk_name varchar(100),
                                    created date not null,
                                    updated date
);

create table if not exists employee(
                                       id uuid primary key,
                                       desk_id uuid,
                                       employee_name varchar(100) not null,
                                       employee_email varchar(150) not null,
                                       employee_password varchar(250) not null,
                                       created date not null,
                                       updated date,

                                       foreign key (desk_id) references desk(id)
);

create table if not exists card(
                                   id uuid primary key,
                                   desk_id uuid not null,
                                   card_name varchar(100),
                                   created date not null,
                                   updated date,

                                   foreign key (desk_id) references desk(id)
);

create table if not exists task(
                                   id uuid primary key,
                                   card_id uuid not null,
                                   employee_id uuid,
                                   kind_of_task varchar(30) not null,
                                   task_name varchar(100) not null,
                                   created date not null,
                                   updated date,

                                   foreign key (employee_id) references employee(id),
                                   foreign key (card_id) references card(id)
);