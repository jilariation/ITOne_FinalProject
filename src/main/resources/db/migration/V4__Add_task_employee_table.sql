create table if not exists task_employee(
    id uuid primary key,
    employee_id uuid not null ,
    task_id uuid not null ,

    foreign key (employee_id) references employee(id),
    foreign key (task_id) references task(id)
);