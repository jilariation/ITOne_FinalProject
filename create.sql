create table if not exists employee(
                                       id uuid primary key,
                                       desk_id uuid not null,
                                       task_id uuid not null,
                                       employee_name varchar(100) not null,
                                       employee_email varchar(150) not null,
                                       employee_password varchar(250) not null,
                                       created date not null,
                                       updated date,

                                       foreign key (desk_id) references desk(id),
                                       foreign key (task_id) references task(id),

                                       unique (employee_email, employee_name)
);

create table if not exists task(
                                   id uuid primary key,
                                   card_id uuid not null,
                                   kind_of_task varchar(30) not null,
                                   task_name varchar(100) not null,
                                   created date not null,
                                   updated date,

                                   foreign key (card_id) references card(id)
);

create table if not exists card(
                                   id uuid primary key,
                                   desk_id uuid not null,
                                   card_name varchar(100),
                                   created date not null,
                                   updated date,

                                   foreign key (desk_id) references desk(id)
);

create table if not exists desk (
    id uuid primary key,
    employee_id uuid,
    desk_name varchar(100),
    created date not null,
    updated date,

    foreign key (employee_id) references employee(id)
);

insert into employee(id, desk_id, employee_name, employee_email, employee_password, created, updated)
values ('570b06eb-9a03-4ad0-8e45-a25bdba578ac', '647918e5-0517-481c-a588-51f51c4269b2', 'Alex', 'alex@gmail.com', '123456789', '2024-05-20', null)